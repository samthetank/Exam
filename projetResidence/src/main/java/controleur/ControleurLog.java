package controleur;

import affaire.Log;

/**
 * Implémentation d'un controleur pour les logs. Date: Feb 7, 2013 Time:
 * 10:46:17 AM.
 *
 * @author sam
 */
public class ControleurLog extends AbstractControleurFormulaire {

    /**
     * Constante champs valeur.
     */
    private static final String VALEUR = "valeur";
    /**
     * Constante champs acienneValeur.
     */
    private static final String ANCIENNE_VALEUR = "ancienneValeur";
    /**
     * Constante message non supporté.
     */
    private static final String NOT_SUPPORTED_YET = "Not supported yet.";

    @Override
    protected final void initialiserControleur() {
        setPageRetourForm("app/ListeLogs/Log");
        setPageRetourListe("ListeLogs");
        setOnglet("ListeLogs");
        setActionAlternative1("voir");
        setActionAlternative2("null");
    }

    @Override
    protected final boolean executeAjouter() {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
    }

    @Override
    protected final void executeRemplirForm(final String pid) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET);

    }

    @Override
    protected final boolean executeMettreAJour(final String pid) {


        throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
    }

    /**
     * Assigne les attributs de la getRequete() selon le id passé en paramètres.
     *
     * @param pid Le id de l'oibjet dont les attributs peuplerons le formulaire
     */
    private void remplirAttributs(final int pid) {

        final Log log = Log.getLog(pid);

        // Peuple les champs du formulaire
        getRequete().setAttribute(VALEUR, log.getValeur());
        getRequete().setAttribute(ANCIENNE_VALEUR, log.getAncienneValeur());
    }

    @Override
    protected final void executeActionAlternative1() {
        // On set le titre
        getRequete().setAttribute("titre",
                "Liste Logs - Voir");

        final int idLog;
        idLog = Integer.parseInt(this.getRequete().getSession().getAttribute("id").toString());
        remplirAttributs(idLog);
        getRequete().getSession().removeAttribute("id");
        getRequete().getSession().removeAttribute("action");
        setPageRetour("app/ListeLogs/Log");
    }

    @Override
    protected final void executeActionAlternative2() {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
    }
}
