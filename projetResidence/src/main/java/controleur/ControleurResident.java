package controleur;

import affaire.Inscription;
import affaire.Resident;
import donnees.SqlObjectProvider;
import java.util.Map;

/**
 * ControleurAppartement: Description de la classe ... Date: Feb 7, 2013 Time:
 * 10:46:17 AM
 *
 * @author francisbeauchamps Comment: Description goes here ...
 */
public class ControleurResident extends AbstractControleurFormulaire {

    /**
     * Attribut action.
     */
    private static final String ATT_ACTION = "action";
    /**
     * Paramètre nom.
     */
    private static final String NOM = "nom";
    /**
     * Paramètre prénom.
     */
    private static final String PRENOM = "prenom";
    /**
     * Paramètre téléphone.
     */
    private static final String TELEPHONE = "telephone";
    /**
     * Paramètre téléphone secondaire.
     */
    private static final String TELEPHONE_SECONDAIRE = "telephoneSecondaire";
    /**
     * Paramètre titre.
     */
    private static final String TITRE = "titreResident";
    /**
     * Paramètre date de naissance.
     */
    private static final String DATE_NAISSANCE = "dateNaissance";
    /**
     * Paramètre date d'arrivée.
     */
    private static final String DATE_ARRIVEE = "dateArrivee";
    /**
     * Paramètre commentaire.
     */
    private static final String COMMENTAIRE = "commentaire";
    /**
     * Paramètre couleur d'intervention.
     */
    private static final String COULEUR_INTERVENTION = "couleurIntervention";
    /**
     * Paramètre commentaire d'intervention.
     */
    private static final String COMMENTAIRE_INTERVENTION = "commentaireIntervention";
    /**
     * Paramètre commentaire plainte.
     */
    private static final String COMMENTAIRE_PLAINTE = "commentairePlainte";
    /**
     * Paramètre nom du véhicule.
     */
    private static final String NOM_VEHICULE = "nomVehicule";
    /**
     * Paramètre plaque d'immatriculation.
     */
    private static final String PLAQUE_IMMATRICULATION = "plaqueImmatriculation";

    @Override
    protected final void initialiserControleur() {
        setPageRetourForm("app/ListeResidents/Resident");
        setPageRetourListe("ListeResidents");
        setNomTable(Resident.class.getSimpleName());

        if (getRequete().getSession().getAttribute("language").toString().contains("fr")) {
            if ("Ajouter".equals(getRequete().getSession().getAttribute(ATT_ACTION).toString())) {
                setTitrePage("Liste des résidents - Ajout d'un résident");
            } else if ("Mettre a jour".equals(getRequete().getSession().getAttribute(ATT_ACTION).toString())) {
                setTitrePage("Liste des résidents - Mise à jour d'un résident");
            } else if ("viewTransfer".equals(getRequete().getSession().getAttribute(ATT_ACTION).toString())) {
                setTitrePage("Liste des résidents - Transférer");
            }
        } else {
            if ("Add".equals(getRequete().getSession().getAttribute(ATT_ACTION).toString())) {
                setTitrePage("Residents list - Adding a resident");
            } else if ("Update".equals(getRequete().getSession().getAttribute(ATT_ACTION).toString())) {
                setTitrePage("Residents list - Update a resident");
            } else if ("viewTransfer".equals(getRequete().getSession().getAttribute(ATT_ACTION).toString())) {
                setTitrePage("Residents list - Transfer");
            }
        }

        setOnglet("listeResidents");

        // On initialise les actions alternatives.
        setActionAlternative1("viewTransfer");
        setActionAlternative2("null");
    }

    @Override
    protected final boolean executeAjouter() {
        // Peuple les champs du formulaire
        getRequete().setAttribute(NOM, getRequete().getParameter(NOM));
        getRequete().setAttribute(PRENOM, getRequete().getParameter(PRENOM));
        getRequete().setAttribute(TELEPHONE, getRequete().getParameter(TELEPHONE));
        getRequete().setAttribute(TELEPHONE_SECONDAIRE, getRequete().getParameter(TELEPHONE_SECONDAIRE));
        getRequete().setAttribute(TITRE, getRequete().getParameter(TITRE));
        getRequete().setAttribute(DATE_NAISSANCE, getRequete().getParameter(DATE_NAISSANCE));
        getRequete().setAttribute(DATE_ARRIVEE, getRequete().getParameter(DATE_ARRIVEE));
        getRequete().setAttribute(COMMENTAIRE, getRequete().getParameter(COMMENTAIRE));
        getRequete().setAttribute(COULEUR_INTERVENTION, getRequete().getParameter(COULEUR_INTERVENTION));
        getRequete().setAttribute(COMMENTAIRE_INTERVENTION, getRequete().getParameter(COMMENTAIRE_INTERVENTION));
        getRequete().setAttribute(COMMENTAIRE_PLAINTE, getRequete().getParameter(COMMENTAIRE_PLAINTE));
        getRequete().setAttribute(NOM_VEHICULE, getRequete().getParameter(NOM_VEHICULE));
        getRequete().setAttribute(PLAQUE_IMMATRICULATION, getRequete().getParameter(PLAQUE_IMMATRICULATION));

        final Resident resident = new Resident(
                0,
                getRequete().getParameter(NOM),
                getRequete().getParameter(PRENOM),
                getRequete().getParameter(TELEPHONE),
                getRequete().getParameter(TELEPHONE_SECONDAIRE),
                getRequete().getParameter(TITRE),
                getRequete().getParameter(DATE_NAISSANCE),
                getRequete().getParameter(DATE_ARRIVEE),
                getRequete().getParameter(COMMENTAIRE),
                getRequete().getParameter(COULEUR_INTERVENTION),
                getRequete().getParameter(COMMENTAIRE_INTERVENTION),
                getRequete().getParameter(COMMENTAIRE_PLAINTE),
                getRequete().getParameter(NOM_VEHICULE),
                getRequete().getParameter(PLAQUE_IMMATRICULATION));

        final Map<String, Object> erreur = Resident.valide(resident);

        boolean estValide = erreur.isEmpty();
        // Si l'inscription est non nulle, donc valide
        if (estValide) {
            estValide = Resident.insererResident(resident);
            if (estValide) {
                setValeur(SqlObjectProvider.getInstance().objetEnString(resident));
            }
            // On en a finit avec l'inscription !
        } else {
            getRequete().setAttribute("erreur", "error");
            getRequete().setAttribute("listeErreur", erreur);
        }

        return estValide;
    }

    @Override
    protected final void executeRemplirForm(final String pid) {
        // Get l'inscription pour fill le formulaire
        remplirAttributs(Integer.parseInt(pid));
    }

    @Override
    protected final boolean executeMettreAJour(final String pid) {
        // Get l'inscription pour fill le formulaire
        remplirAttributs(Integer.parseInt(pid));

        final Resident resident = new Resident(
                Integer.parseInt(pid),
                getRequete().getParameter(NOM),
                getRequete().getParameter(PRENOM),
                getRequete().getParameter(TELEPHONE),
                getRequete().getParameter(TELEPHONE_SECONDAIRE),
                getRequete().getParameter(TITRE),
                getRequete().getParameter(DATE_NAISSANCE),
                getRequete().getParameter(DATE_ARRIVEE),
                getRequete().getParameter(COMMENTAIRE),
                getRequete().getParameter(COULEUR_INTERVENTION),
                getRequete().getParameter(COMMENTAIRE_INTERVENTION),
                getRequete().getParameter(COMMENTAIRE_PLAINTE),
                getRequete().getParameter(NOM_VEHICULE),
                getRequete().getParameter(PLAQUE_IMMATRICULATION));

        final Map<String, Object> erreur = Resident.valide(resident);

        boolean estValide = erreur.isEmpty();
        // Si l'inscription est non nulle, donc valide
        if (estValide) {
            estValide = Resident.modifierResident(resident);
            if (estValide) {
                setValeur(SqlObjectProvider.getInstance().objetEnString(resident));
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
        final Resident resident = Resident.getResident(pid);

        setAncienneValeur(SqlObjectProvider.getInstance().objetEnString(resident));
        // Peuple les champs du formulaire
        getRequete().setAttribute(NOM, resident.getNom());
        getRequete().setAttribute(PRENOM, resident.getPrenom());
        getRequete().setAttribute(TELEPHONE, resident.getTelephone());
        getRequete().setAttribute(TELEPHONE_SECONDAIRE, resident.getTelephoneSecondaire());
        getRequete().setAttribute(TITRE, resident.getTitreResident());
        getRequete().setAttribute(DATE_NAISSANCE, resident.getDateNaissance());
        getRequete().setAttribute(DATE_ARRIVEE, resident.getDateArrivee());
        getRequete().setAttribute(COMMENTAIRE, resident.getCommentaire());
        getRequete().setAttribute(COULEUR_INTERVENTION, resident.getCouleurIntervention());
        getRequete().setAttribute(COMMENTAIRE_INTERVENTION, resident.getCommentaireIntervention());
        getRequete().setAttribute(COMMENTAIRE_PLAINTE, resident.getCommentairePlainte());
        getRequete().setAttribute(NOM_VEHICULE, resident.getNomVehicule());
        getRequete().setAttribute(PLAQUE_IMMATRICULATION, resident.getPlaqueImmatriculation());
    }

    @Override
    protected final void executeActionAlternative1() {
        // Obtenir la personne inscrite pour remplir le formulaire
        final Inscription inscription =
                Inscription.getInscription(Integer.parseInt(getSession().getAttribute("id").toString()));
        final boolean confirme = inscription.isConfirme();
        if (confirme) {
            // Peuple les champs du formulaire
            this.getRequete().setAttribute("nom", inscription.getNom());
            this.getRequete().setAttribute("prenom", inscription.getPrenom());
            this.getRequete().setAttribute("telephone", inscription.getTelephone());

            // Retour vers le formulaire remplit
            getRequete().setAttribute(ATT_ACTION, "Ajouter");
            getRequete().getSession().setAttribute(ATT_ACTION, "Ajouter");
            this.setPageRetour("app/ListeResidents/Resident");
        } else {
            this.setPageRetour("ListeAttente");
        }
    }

    @Override
    protected final void executeActionAlternative2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
