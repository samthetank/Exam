package controleur;

import affaire.Appartement;
import affaire.Log;
import affaire.Utilisateur;
import donnees.SqlObjectProvider;
import util.UtilitaireDate;

/**
 * Description de la classe ControleurListeAppartements.
 *
 * @author Sam
 */
public class ControleurListeAppartements extends AbstractControleurListe {

    @Override
    protected final boolean aAccesPage() {
        return Utilisateur.aDroitsUtilisateur(
                getSession().getAttribute("usager").toString(),
                "appartements_Afficher");
    }

    @Override
    protected final void initialiserControleur() {
        setPageRetourForm("Appartement");
        setPageRetourListe("app/ListeAppartements");
        setOnglet("listeAppartements");
        setTitrePage("Liste des appartements");

        setActionAlternative1("null");
        setActionAlternative2("null");
    }

    @Override
    protected final void initialiserListeDroits() {
        final String nomUtil = getSession().getAttribute("usager").toString();
        int nbControles = 0;
        getRequete().setAttribute("btnAjouter",
                Utilisateur.aDroitsUtilisateur(nomUtil,
                "appartements_Ajout").toString());

        if (Utilisateur.aDroitsUtilisateur(nomUtil,
                "appartements_Ajout")) {
            nbControles++;
        }

        getRequete().setAttribute("btnModifier",
                Utilisateur.aDroitsUtilisateur(nomUtil,
                "appartements_Mettre_A_Jour").toString());

        if (Utilisateur.aDroitsUtilisateur(nomUtil,
                "appartements_Mettre_A_Jour")) {
            nbControles++;
        }

        getRequete().setAttribute("btnEffacer",
                Utilisateur.aDroitsUtilisateur(nomUtil,
                "appartements_Effacer").toString());

        if (Utilisateur.aDroitsUtilisateur(nomUtil,
                "appartements_Effacer")) {
            nbControles++;
        }

        getRequete().setAttribute("nbControles", nbControles);
    }

    @Override
    protected final void executeSuppression(final int pidSuppression) {
        String valeur = SqlObjectProvider.getInstance().objetEnString(Appartement.getAppartement(pidSuppression));
        if (Appartement.supprimerAppartement(pidSuppression)) {
            Log.insererLog(new Log(0, "supression", "Appartement",
                    getRequete().getSession().getAttribute("usager").toString(),
                    UtilitaireDate.timeNowEnString(), valeur, "aucune"));
        }
    }

    @Override
    protected final void attribuerListe() {
        getRequete().setAttribute("liste", Appartement.getAppartements());
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
