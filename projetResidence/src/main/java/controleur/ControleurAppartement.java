package controleur;

import affaire.Appartement;
import donnees.SqlObjectProvider;
import java.util.Map;
import util.UtilitaireTexte;

/**
 * Implémentation d'un controleur pour les appartements. Date: Feb 7, 2013 Time:
 * 10:46:17 AM.
 *
 * @author francisbeauchamps Comment: Description goes here ...
 */
public class ControleurAppartement extends AbstractControleurFormulaire {

    /**
     * Constante champs noApparterment.
     */
    private static final String NO_APPARTEMENT = "noAppartement";
    /**
     * Constante champs etage.
     */
    private static final String ETAGE = "etage";
    /**
     * Constante champs phase.
     */
    private static final String PHASE = "phase";
    /**
     * Constante du nom de champ dimension.
     */
    private static final String DIMENSION = "dimension";
    /**
     * Constante du nom de champ nbPieces.
     */
    private static final String NB_PIECES = "nbPieces";
    /**
     * Constante du nom de champ description.
     */
    private static final String DESCRIPTION = "description";

    @Override
    protected final void initialiserControleur() {
        setPageRetourForm("app/ListeAppartements/Appartement");
        setPageRetourListe("ListeAppartements");
        setOnglet("listeAppartements");
        setNomTable(Appartement.class.getSimpleName());
    }

    @Override
    protected final boolean executeAjouter() {
        // Set le titre
        getRequete().setAttribute("titre",
                "Liste utilisateur - Ajout d'un utilisateur");
        this.getRequete().setAttribute("page", "listeAppartement");
        // Peuple les champs du formulaire
        getRequete().setAttribute(NO_APPARTEMENT, getRequete().getParameter(
                NO_APPARTEMENT));
        getRequete().setAttribute(ETAGE, getRequete().getParameter(ETAGE));
        getRequete().setAttribute(PHASE, getRequete().getParameter(PHASE));
        getRequete().setAttribute(DIMENSION,
                getRequete().getParameter(DIMENSION));
        getRequete().setAttribute(NB_PIECES,
                getRequete().getParameter(NB_PIECES));
        getRequete().setAttribute(DESCRIPTION,
                getRequete().getParameter(DESCRIPTION));

        int noAppartement;
        if (getRequete().getParameter(NO_APPARTEMENT) != null
                && getRequete().getParameter(NO_APPARTEMENT)
                .matches(UtilitaireTexte.EXPRESSION_0_9)) {
            noAppartement = Integer.parseInt(
                    getRequete().getParameter(NO_APPARTEMENT));
        } else {
            noAppartement = Appartement.SENTINELLE_VIDE;
        }

        final Appartement appartement = new Appartement(
                0,
                noAppartement,
                getRequete().getParameter(ETAGE),
                getRequete().getParameter(PHASE),
                getRequete().getParameter(DIMENSION),
                getRequete().getParameter(NB_PIECES),
                getRequete().getParameter(DESCRIPTION));

        final Map<String, Object> erreur = Appartement.valide(appartement);

        boolean estValide = erreur.isEmpty();
        // Si l'inscription est non nulle, donc valide
        if (estValide) {
            estValide = Appartement.insererAppartement(appartement);
            if (estValide) {
                setValeur(SqlObjectProvider.getInstance().objetEnString(appartement));
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
        // Set le titre
        getRequete().setAttribute(
                "titre", "Liste appartement - Mise à jour d'un appartement");

        // Get l'inscription pour fill le formulaire
        remplirAttributs(Integer.parseInt(pid));

    }

    @Override
    protected final boolean executeMettreAJour(final String pid) {
        // On set le titre
        getRequete().setAttribute("titre",
                "Liste appartements - Mise à jour d'un appartement");

        // Get l'inscription pour fill le formulaire
        remplirAttributs(Integer.parseInt(pid));

        final Appartement appartement = new Appartement(
                Integer.parseInt(pid),
                Appartement.getAppartement(Integer.parseInt(pid)).
                getNoAppartement(),
                getRequete().getParameter(ETAGE),
                getRequete().getParameter(PHASE),
                getRequete().getParameter(DIMENSION),
                getRequete().getParameter(NB_PIECES),
                getRequete().getParameter(DESCRIPTION));

        final Map<String, Object> erreur = Appartement.valide(appartement);

        boolean estValide = erreur.isEmpty();
        // Si l'inscription est non nulle, donc valide
        if (estValide) {
            estValide = Appartement.modifierAppartement(appartement);
            if (estValide) {
                setValeur(SqlObjectProvider.getInstance().objetEnString(appartement));
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
     * @param pid Le id de l'oibjet dont les attributs peuplerons le formulaire
     */
    private void remplirAttributs(final int pid) {

        final Appartement appartement = Appartement.getAppartement(pid);

        setAncienneValeur(SqlObjectProvider.getInstance().objetEnString(appartement));
        // Peuple les champs du formulaire
        getRequete().setAttribute(NO_APPARTEMENT,
                appartement.getNoAppartement());
        getRequete().setAttribute(ETAGE, appartement.getEtage());
        getRequete().setAttribute(PHASE, appartement.getPhase());
        getRequete().setAttribute(DIMENSION, appartement.getDimension());
        getRequete().setAttribute(NB_PIECES, appartement.getNbPieces());
        getRequete().setAttribute(DESCRIPTION, appartement.getDescription());
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
