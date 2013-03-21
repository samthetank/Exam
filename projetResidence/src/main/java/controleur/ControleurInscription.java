package controleur;

import affaire.Inscription;
import donnees.SqlObjectProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Controleur pour les pages de liste d'attente (app/ListeAttente/). Date: Feb
 * 5, 2013 Time: 9:03:20 PM
 *
 * @author francisbeauchamps Comment: Description goes here ...
 */
public class ControleurInscription extends AbstractControleurFormulaire {

    /**
     * Constante champs nom_Personne_Inscrite.
     */
    private static final String NOM_PERSONNE_INSCRITE = "nom";
    /**
     * Constante champs prenom_Personne_Inscrite.
     */
    private static final String PRENOM_PERSONNE_INSCRITE = "prenom";
    /**
     * Constante champs telephone_Personne_Inscrite.
     */
    private static final String TELEPHONE_PERSONNE_INSCRITE = "telephone";
    /**
     * Constante du nom de champ commentaire_Personne_Inscrite.
     */
    private static final String COMMENTAIRE_PERSONNE_INSCRITE = "comment";
    /**
     * Constante du nom de champ commentaire_Administrateur.
     */
    private static final String COMMENTAIRE_ADMINISTRATEUR = "commentAdmin";
    /**
     * Constante du nom de champ commentaire_refus.
     */
    private static final String COMMENTAIRE_REFUS = "commentRefus";
    /**
     * Constante du nom de champ preference_Appartement.
     */
    private static final String PREFERENCE_APPARTEMENT = "prefApp";
    /**
     * Constante du nom de champ preference_Etage.
     */
    private static final String PREFERENCE_ETAGE = "prefEtage";
    /**
     * Constante du nom de champ est_Confirme.
     */
    private static final String EST_CONFIRME = "confirme";
    /**
     * Constante du nom de champ courriel.
     */
    private static final String COURRIEL = "courriel";

    @Override
    protected final void initialiserControleur() {
        setPageRetourForm("app/ListeAttente/Inscription");
        setPageRetourListe("ListeAttente");
        setNomTable(Inscription.class.getSimpleName());
        setOnglet("listeAttente");
    }

    @Override
    protected final boolean executeAjouter() {
        // Set le titre
        getRequete().setAttribute("titre",
                "Liste d'attente - Ajout dans la liste d'attente");

        // Peuple les champs du formulaire
        getRequete().setAttribute(NOM_PERSONNE_INSCRITE, getRequete().getParameter(
                NOM_PERSONNE_INSCRITE));
        getRequete().setAttribute(PRENOM_PERSONNE_INSCRITE, getRequete().getParameter(
                PRENOM_PERSONNE_INSCRITE));
        getRequete().setAttribute(TELEPHONE_PERSONNE_INSCRITE, getRequete().getParameter(
                TELEPHONE_PERSONNE_INSCRITE));
        getRequete().setAttribute(COMMENTAIRE_PERSONNE_INSCRITE, getRequete().getParameter(
                COMMENTAIRE_PERSONNE_INSCRITE));
        getRequete().setAttribute(COMMENTAIRE_ADMINISTRATEUR, getRequete().getParameter(
                COMMENTAIRE_ADMINISTRATEUR));
        getRequete().setAttribute(COMMENTAIRE_REFUS, getRequete().getParameter(
                COMMENTAIRE_REFUS));
        getRequete().setAttribute(PREFERENCE_APPARTEMENT, getRequete().getParameter(
                PREFERENCE_APPARTEMENT));
        getRequete().setAttribute(PREFERENCE_ETAGE, getRequete().getParameter(
                PREFERENCE_ETAGE));
        getRequete().setAttribute(EST_CONFIRME, getRequete().getParameter(
                EST_CONFIRME));
        getRequete().setAttribute(COURRIEL, getRequete().getParameter(
                COURRIEL));

        final Inscription inscription = new Inscription(
                0,
                getRequete().getParameter(NOM_PERSONNE_INSCRITE),
                getRequete().getParameter(PRENOM_PERSONNE_INSCRITE),
                getRequete().getParameter(TELEPHONE_PERSONNE_INSCRITE),
                util.UtilitaireDate.dateEnString(util.UtilitaireDate.dateDuJour().getGregorianChange()),
                getRequete().getParameter(COMMENTAIRE_PERSONNE_INSCRITE),
                getRequete().getParameter(COMMENTAIRE_ADMINISTRATEUR),
                getRequete().getParameter(COMMENTAIRE_REFUS),
                getRequete().getParameter(PREFERENCE_APPARTEMENT),
                getRequete().getParameter(PREFERENCE_ETAGE),
                Boolean.parseBoolean(getRequete().getParameter(EST_CONFIRME)),
                getRequete().getParameter(COURRIEL));

        final Map<String, Object> erreur = Inscription.valide(inscription);

        boolean estValide = erreur.isEmpty();
        // Si l'inscription est non nulle, donc valide
        if (estValide) {
            estValide = Inscription.insererInscription(inscription);
            if (estValide) {
                setValeur(SqlObjectProvider.getInstance().objetEnString(inscription));
            }
            // On en a finit avec l'inscription !
            String script =
                    "<script>$(function(){"
                    + "humane.log(\"" + inscription.getPrenom() + " " + inscription.getNom()
                    + " a été ajouté à liste d'attente !\"); });</script>";
            getRequete().getSession().setAttribute("script", script);
        } else {
            getRequete().setAttribute("erreur", "error");
            getRequete().setAttribute("listeErreur", erreur);
        }

        return estValide;
    }

    @Override
    protected final void executeRemplirForm(final String pid) {
        // Set le titre
        getRequete().setAttribute(
                "titre", "Liste d'attente - Mise à jour d'une inscription");

        // Get l'inscription pour fill le formulaire
        remplirAttributs(Integer.parseInt(pid));
    }

    @Override
    protected final boolean executeMettreAJour(final String pid) {
        // On set le titre
        getRequete().setAttribute("titre",
                "Liste d'attente - Mise à jour d'une inscription");

        // Get l'inscription pour fill le formulaire
        remplirAttributs(Integer.parseInt(pid));
        boolean check;
        if (getRequete().getParameter(EST_CONFIRME) != null) {
            check = true;
        } else {
            check = false;
        }

        final Inscription inscription = new Inscription(
                Integer.parseInt(pid),
                getRequete().getParameter(NOM_PERSONNE_INSCRITE),
                getRequete().getParameter(PRENOM_PERSONNE_INSCRITE),
                getRequete().getParameter(TELEPHONE_PERSONNE_INSCRITE),
                Inscription.getInscription(Integer.parseInt(pid)).getDate(),
                getRequete().getParameter(COMMENTAIRE_PERSONNE_INSCRITE),
                getRequete().getParameter(COMMENTAIRE_ADMINISTRATEUR),
                getRequete().getParameter(COMMENTAIRE_REFUS),
                getRequete().getParameter(PREFERENCE_APPARTEMENT),
                getRequete().getParameter(PREFERENCE_ETAGE), check,
                getRequete().getParameter(COURRIEL));

        final ConcurrentHashMap<String, Object> erreur = Inscription.valide(inscription);

        boolean estValide = erreur.isEmpty();
        // Si l'inscription est non nulle, donc valide
        if (estValide) {
            estValide = Inscription.modifierInscription(inscription);
            if (estValide) {
                setValeur(SqlObjectProvider.getInstance().objetEnString(inscription));
            }
            // On en a finit avec l'inscription !
        } else {
            getRequete().setAttribute("erreur", "error");
            getRequete().setAttribute("listeErreur", erreur);
        }

        return estValide;
    }

    /**
     * Assigne les attributs de la getRequete() selon le id passé en paramètres.
     *
     * @param pid Le id de l'objet dont les attributs peuplerons le formulaire
     */
    private void remplirAttributs(final int pid) {

        final Inscription inscription = Inscription.getInscription(pid);

        setAncienneValeur(SqlObjectProvider.getInstance().objetEnString(inscription));
        // Peuple les champs du formulaire
        getRequete().setAttribute(NOM_PERSONNE_INSCRITE,
                inscription.getNom());
        getRequete().setAttribute(PRENOM_PERSONNE_INSCRITE,
                inscription.getPrenom());
        getRequete().setAttribute(TELEPHONE_PERSONNE_INSCRITE,
                inscription.getTelephone());
        getRequete().setAttribute(COMMENTAIRE_PERSONNE_INSCRITE,
                inscription.getCommentairePersonne());
        getRequete().setAttribute(COMMENTAIRE_ADMINISTRATEUR,
                inscription.getCommentaireAdministrateur());
        getRequete().setAttribute(COMMENTAIRE_REFUS,
                inscription.getCommentaireRefus());
        getRequete().setAttribute(PREFERENCE_APPARTEMENT,
                inscription.getPreferenceAppartement());
        getRequete().setAttribute(PREFERENCE_ETAGE,
                inscription.getPreferenceEtage());
        getRequete().setAttribute(EST_CONFIRME,
                inscription.isConfirme());
        getRequete().setAttribute(COURRIEL,
                inscription.getCourriel());
    }

    @Override
    protected final void executeActionAlternative1() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected final void executeActionAlternative2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
