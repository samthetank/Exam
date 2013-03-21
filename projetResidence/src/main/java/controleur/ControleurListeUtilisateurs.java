package controleur;

import affaire.Log;
import affaire.Utilisateur;
import donnees.SqlObjectProvider;
import util.UtilitaireDate;

/**
 * Controleur utilisateur sert à faire la gestion de la page affichant les
 * utilisateur.
 *
 * @author Vincent
 */
public class ControleurListeUtilisateurs extends AbstractControleurListe {

    @Override
    protected boolean aAccesPage() {
        return Utilisateur.aDroitsUtilisateur(
                getSession().getAttribute("usager").toString(),
                "utilisateurs_Afficher");
    }

    @Override
    protected void initialiserControleur() {
        setPageRetourForm("Utilisateur");
        setPageRetourListe("app/ListeUtilisateurs");
        setTitrePage("Liste des utilisateurs");
        setOnglet("listeUtilisateurs");
        setActionAlternative1("null");
        setActionAlternative2("null");
    }

    @Override
    protected void initialiserListeDroits() {
        final String nomUtil = getSession().getAttribute("usager").toString();
        int nbControles = 0;

        getRequete().setAttribute("btnAjouter",
                Utilisateur.aDroitsUtilisateur(nomUtil,
                "utilisateurs_Ajout").toString());

        if (Utilisateur.aDroitsUtilisateur(nomUtil,
                "utilisateurs_Ajout")) {
            nbControles++;
        }

        getRequete().setAttribute("btnModifier",
                Utilisateur.aDroitsUtilisateur(nomUtil,
                "utilisateurs_Mettre_A_Jour").toString());

        if (Utilisateur.aDroitsUtilisateur(nomUtil,
                "utilisateurs_Mettre_A_Jour")) {
            nbControles++;
        }

        getRequete().setAttribute("btnEffacer",
                Utilisateur.aDroitsUtilisateur(nomUtil,
                "utilisateurs_Effacer").toString());

        if (Utilisateur.aDroitsUtilisateur(nomUtil,
                "utilisateurs_Effacer")) {
            nbControles++;
        }

        getRequete().setAttribute("nbControles", nbControles);
    }

    @Override
    protected void executeSuppression(final int pidSuppression) {
        Utilisateur utilisateur = Utilisateur.getUtilisateur(pidSuppression);
        if (utilisateur.getIdRole() != Utilisateur.ID_ADMIN) {
            if (Utilisateur.supprimerUtilisateur(pidSuppression)) {
                Log.insererLog(new Log(0, "supression", "Utilisateur",
                        getRequete().getSession().getAttribute("usager").toString(), UtilitaireDate.timeNowEnString(),
                        SqlObjectProvider.getInstance().objetEnString(utilisateur), "aucune"));
            }
        } else {
            getRequete().setAttribute("erreur", "error");
            getRequete().setAttribute("erreurSuppression", "Un administrateur"
                    + "ne peut être supprimé");
        }

    }

    @Override
    protected void attribuerListe() {
        getRequete().setAttribute("liste", Utilisateur.getUtilisateurs());
    }

    @Override
    protected void executeActionAlternative1() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void executeActionAlternative2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
