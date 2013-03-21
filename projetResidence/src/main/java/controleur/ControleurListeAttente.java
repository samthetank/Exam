package controleur;

import affaire.Inscription;
import affaire.Log;
import affaire.Utilisateur;
import donnees.SqlObjectProvider;
import util.UtilitaireDate;

/**
 * Controleur pour les pages de liste d'attente (app/ListeAttente/). Date: Feb
 * 5, 2013 Time: 9:03:20 PM
 *
 * @author francisbeauchamps Comment: Description goes here ...
 */
public class ControleurListeAttente extends AbstractControleurListe {

    /**
     * Attribut script.
     */
    private static final String ATT_SCRIPT = "script";

    @Override
    protected final boolean aAccesPage() {
        return Utilisateur.aDroitsUtilisateur(
                getSession().getAttribute("usager").toString(),
                "inscriptions_Afficher");
    }

    @Override
    protected final void initialiserControleur() {
        setPageRetourForm("Inscription");
        setPageRetourListe("app/ListeAttente");

        // L'onglet actif.
        setOnglet("listeAttente");

        setTitrePage("Liste d'attente");

        setActionAlternative1("transferer");
        setActionAlternative2("null");
    }
    /**
     * Droit pour l'ajout d'inscription.
     */
    public static final String DROIT_INSCRIPTION_AJOUT = "inscriptions_Ajout";

    @Override
    protected final void initialiserListeDroits() {
        final String nomUtil = getSession().getAttribute("usager").toString();
        int nbControles = 0;
        getRequete().setAttribute("btnAjouter",
                Utilisateur.aDroitsUtilisateur(nomUtil,
                DROIT_INSCRIPTION_AJOUT).toString());

        if (Utilisateur.aDroitsUtilisateur(nomUtil,
                DROIT_INSCRIPTION_AJOUT)) {
            nbControles++;
        }

        getRequete().setAttribute("btnModifier",
                Utilisateur.aDroitsUtilisateur(nomUtil,
                "inscriptions_Mettre_A_Jour").toString());

        if (Utilisateur.aDroitsUtilisateur(nomUtil,
                "inscriptions_Mettre_A_Jour")) {
            nbControles++;
        }

        getRequete().setAttribute("btnEffacer",
                Utilisateur.aDroitsUtilisateur(nomUtil,
                "inscriptions_Effacer").toString());

        if (Utilisateur.aDroitsUtilisateur(nomUtil,
                "inscriptions_Effacer")) {
            nbControles++;
        }

        // Changer pour un droit de transfert
        getRequete().setAttribute("btnTransferer",
                Utilisateur.aDroitsUtilisateur(nomUtil,
                DROIT_INSCRIPTION_AJOUT).toString());
        // Changer pour un droit de transfert
        if (Utilisateur.aDroitsUtilisateur(nomUtil,
                DROIT_INSCRIPTION_AJOUT)) {
            nbControles++;
        }

        getRequete().setAttribute("nbControles", nbControles);
    }

    @Override
    protected final void executeSuppression(final int pidSuppression) {
        Inscription inscription = Inscription.getInscription(pidSuppression);
        if (Inscription.supprimerInscription(pidSuppression)) {
            Log.insererLog(new Log(0, "supression", "Inscription",
                    getRequete().getSession().getAttribute("usager").toString(),
                    UtilitaireDate.timeNowEnString(), SqlObjectProvider.getInstance().objetEnString(inscription),
                    "aucune"));
        }
        String script =
                "<script>$(function(){"
                + "humane.log(\"" + inscription.getPrenom() + " " + inscription.getNom()
                + " a été supprimé de la  liste d'attente !\"); });</script>";
        getRequete().setAttribute(ATT_SCRIPT, script);
    }

    @Override
    protected final void attribuerListe() {
        getRequete().setAttribute("liste", Inscription.getInscriptions());
        String script = (String) getRequete().getSession().getAttribute(ATT_SCRIPT);
        getRequete().setAttribute(ATT_SCRIPT, script);
        getRequete().getSession().removeAttribute(ATT_SCRIPT);
    }

    @Override
    protected final void executeActionAlternative1() {
        // Setter les params de la requete qui va dans les residents
        getRequete().getSession().setAttribute("action", "viewTransfer");
        getRequete().getSession().setAttribute("id", this.getRequete().getParameter("id"));
        setPageRetour("Resident");
    }

    @Override
    protected final void executeActionAlternative2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
