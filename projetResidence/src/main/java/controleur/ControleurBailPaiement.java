package controleur;

import affaire.Appartement;
import affaire.Bail;
import affaire.Resident;
import donnees.SqlObjectProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import util.UtilitaireDouble;
import util.UtilitaireEntier;

/**
 * Controleur des baux et des paiements va permettre au client de faire la
 * gestion des chèques et argents des loyers.
 *
 * @author Vincent
 */
public class ControleurBailPaiement extends AbstractControleurFormulaire {

    /**
     * La date de début dans le JSP.
     */
    private static final String DATE_DEBUT = "dateDebut";
    /**
     * La date de fin dans le JSP.
     */
    private static final String DATE_FIN = "dateFin";
    /**
     * Le nom du champs montant mensuel dans le JSP.
     */
    private static final String MONTANT_MENSUEL = "montantMensuel";
    /**
     * Le nom du champs appartement.
     */
    private static final String NO_APPARTEMENT = "appartementSelect";
    /**
     * Le nom du champs locataire.
     */
    private static final String LOCATAIRE_1 = "locataire1";
    /**
     * Le nom du champs locataire 2.
     */
    private static final String LOCATAIRE_2 = "locataire2";
    /**
     * Le nom du champ signataire.
     */
    private static final String LOCA_2_SIGNATAIRE = "estSignataire";
    /**
     * Le nom du champs commentaire.
     */
    private static final String COMMENTAIRE = "commentaire";
    /**
     * Le nom du champs sélectionné dans le jsp.
     */
    public static final String APPARTEMENT_SELECT = "appartementSelect";

    @Override
    protected void initialiserControleur() {
        // Initialise les pages de retour.
        setPageRetourForm("app/ListeBaux/BailPaiement");
        setPageRetourListe("app/ListeBaux");

        //Attribut le nom de l'objet courrant
        setNomTable(Bail.class.getSimpleName());

        // Attribut l'onglet courant.
        setOnglet("listeBaux");

        // Attribut les données pour les dropdowns.
        getRequete().setAttribute("residents", Resident.getResidents());
        getRequete().setAttribute("appartements", Appartement.getAppartements());

        // Attribut les nom des actions alternatives.
        setActionAlternative1("null");
        setActionAlternative2("null");
    }

    @Override
    protected boolean executeAjouter() {
        // Set le titre.
        getRequete().setAttribute("titre", "Liste baux - Ajout d'un bail");

        // Peuple les champs lorsque la validation à échoué.
        peuplerChamps();

        // Crée l'objet de bail.
        final Bail bail = new Bail(0,
                UtilitaireEntier.obtenirEntierAvecString(getRequete().getParameter(NO_APPARTEMENT)),
                getRequete().getParameter(DATE_DEBUT),
                getRequete().getParameter(DATE_FIN),
                util.UtilitaireDate.moisATexte(Integer.parseInt(getRequete().getParameter(DATE_FIN).substring(5, 7))),
                UtilitaireDouble.obtenirReelAvecString(getRequete().getParameter(MONTANT_MENSUEL)),
                getRequete().getParameter(COMMENTAIRE),
                UtilitaireEntier.obtenirEntierAvecString(getRequete().getParameter(LOCATAIRE_1)),
                UtilitaireEntier.obtenirEntierAvecString(getRequete().getParameter(LOCATAIRE_2)),
                obtenirColocataireSignataire());

        // Appelle la validation sur le bail.
        final Map<String, Object> erreur = Bail.valide(bail, -1);

        // est valide seulement si aucune erreur.
        boolean estValide = erreur.isEmpty();

        // S'il n'y avait aucune erreur.
        if (estValide) {
            estValide = Bail.insererBail(bail);
            if (estValide) {
                setValeur(SqlObjectProvider.getInstance().objetEnString(bail));
            }
        } else {
            getRequete().setAttribute("erreur", "error");
            getRequete().setAttribute("listeErreur", erreur);
        }

        return estValide;
    }

    @Override
    protected void executeRemplirForm(final String pid) {
        getRequete().setAttribute("titre", "Liste des baux - Mise à jour d'un bail");

        remplirAttributs(Integer.parseInt(pid));
    }

    @Override
    protected boolean executeMettreAJour(final String pid) {
        // On set le titre
        getRequete().setAttribute("titre", "Liste des baux - Mise à jour d'un bail");

        // Get le bail pour remplir le formulaire.
        remplirAttributs(Integer.parseInt(pid));

        final Bail bail = new Bail(
                Integer.parseInt(pid),
                UtilitaireEntier.obtenirEntierAvecString(getRequete().getParameter(NO_APPARTEMENT)),
                getRequete().getParameter(DATE_DEBUT),
                getRequete().getParameter(DATE_FIN),
                getRequete().getParameter("aucun"),
                UtilitaireDouble.obtenirReelAvecString(getRequete().getParameter(MONTANT_MENSUEL)),
                getRequete().getParameter(COMMENTAIRE),
                UtilitaireEntier.obtenirEntierAvecString(getRequete().getParameter(LOCATAIRE_1)),
                UtilitaireEntier.obtenirEntierAvecString(getRequete().getParameter(LOCATAIRE_2)),
                obtenirColocataireSignataire());

        final ConcurrentHashMap<String, Object> erreur = Bail.valide(bail, Integer.parseInt(pid));

        boolean estValide = erreur.isEmpty();

        if (estValide) {
            estValide = Bail.modifierBail(bail);
            if (estValide) {
                setValeur(SqlObjectProvider.getInstance().objetEnString(bail));
            }
        } else {
            getRequete().setAttribute("erreur", "error");
            getRequete().setAttribute("listeErreur", erreur);
        }

        return estValide;
    }

    /**
     * Remplit les attributs.
     *
     * @param pid Le id
     */
    private void remplirAttributs(final int pid) {
        final Bail bail = Bail.getBail(pid);

        setAncienneValeur(SqlObjectProvider.getInstance().objetEnString(bail));
        // Peuple les champs du formulaire
        getRequete().setAttribute(DATE_DEBUT, bail.getDateDebut());
        getRequete().setAttribute(DATE_FIN, bail.getDateFin());
        getRequete().setAttribute(MONTANT_MENSUEL, bail.getMontantLoyer());
        getRequete().setAttribute(COMMENTAIRE, bail.getCommentaire());

        getRequete().setAttribute(APPARTEMENT_SELECT, bail.getIdAppartement());
        getRequete().setAttribute(LOCATAIRE_1, bail.getIdLocataire());
        getRequete().setAttribute(LOCATAIRE_2, bail.getIdLocataireSecondaire());
        getRequete().setAttribute(LOCA_2_SIGNATAIRE, bail.isEstLocataireSignataire());
    }

    @Override
    protected final void executeActionAlternative1() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected final void executeActionAlternative2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Peuple les champs.
     */
    private void peuplerChamps() {
        // Peuple les champs du formulaire
        getRequete().setAttribute(DATE_DEBUT, getRequete().getParameter(DATE_DEBUT));
        getRequete().setAttribute(DATE_FIN, getRequete().getParameter(DATE_FIN));
        getRequete().setAttribute(MONTANT_MENSUEL, getRequete().getParameter(MONTANT_MENSUEL));
        getRequete().setAttribute(NO_APPARTEMENT, getRequete().getParameter(NO_APPARTEMENT));
        getRequete().setAttribute(LOCATAIRE_1, getRequete().getParameter(LOCATAIRE_1));
        getRequete().setAttribute(LOCATAIRE_2, getRequete().getParameter(LOCATAIRE_2));
        getRequete().setAttribute(LOCA_2_SIGNATAIRE, getRequete().getParameter(LOCA_2_SIGNATAIRE));
        getRequete().setAttribute(COMMENTAIRE, getRequete().getParameter(COMMENTAIRE));
    }

    /**
     * Obtient si le colocataire est signataire.
     *
     * @return Si c'est signataire.
     */
    private boolean obtenirColocataireSignataire() {
        boolean estSignataire;

        // Si le checkbox n'est pas coché.
        if (getRequete().getParameter(LOCA_2_SIGNATAIRE) == null) {
            estSignataire = false;
        } else {
            estSignataire = true;
        }

        return estSignataire;
    }
}
