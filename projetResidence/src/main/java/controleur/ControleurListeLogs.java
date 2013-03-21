package controleur;

import affaire.Log;
import affaire.Utilisateur;

/**
 * Controleur lgo sert à faire la gestion de la page affichant les logs.
 *
 * @author Sam
 */
public class ControleurListeLogs extends AbstractControleurListe {

    @Override
    protected boolean aAccesPage() {
        return Utilisateur.aDroitsUtilisateur(
                getSession().getAttribute("usager").toString(),
                "utilisateurs_Afficher");
    }

    @Override
    protected void initialiserControleur() {
        setPageRetourForm("Log");
        setPageRetourListe("app/ListeLogs");
        setTitrePage("Liste des logs");
        setOnglet("listeLogs");
        setActionAlternative1("voir");
        setActionAlternative2("null");
    }

    @Override
    protected void initialiserListeDroits() {
        final String nomUtil = getSession().getAttribute("usager").toString();
        int nbControles = 0;

        getRequete().setAttribute("btnVoir",
                Utilisateur.aDroitsUtilisateur(nomUtil,
                "logs_Afficher").toString());

        if (Utilisateur.aDroitsUtilisateur(nomUtil,
                "logs_Afficher")) {
            nbControles++;
        }

        getRequete().setAttribute("nbControles", nbControles);
    }

    @Override
    protected void executeSuppression(final int pidSuppression) {
        Log.supprimerLog(pidSuppression);

    }

    @Override
    protected void attribuerListe() {
        getRequete().setAttribute("liste", Log.getLogs());
    }

    @Override
    protected void executeActionAlternative1() {
        getRequete().getSession().setAttribute("action", "voir");
        getRequete().getSession().setAttribute("id", this.getRequete().getParameter("id"));
        this.setPageRetour("Log");
    }

    @Override
    protected void executeActionAlternative2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
