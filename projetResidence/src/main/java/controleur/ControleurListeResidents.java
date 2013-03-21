package controleur;

import affaire.Log;
import affaire.Resident;
import affaire.Utilisateur;
import donnees.SqlObjectProvider;
import util.UtilitaireDate;

/**
 * ControleurAppartement: Description de la classe ... Date: Feb 7, 2013 Time:
 * 10:46:17 AM
 *
 * @author francisbeauchamps Comment: Description goes here ...
 */
public class ControleurListeResidents extends AbstractControleurListe {

    @Override
    protected final boolean aAccesPage() {
        return Utilisateur.aDroitsUtilisateur(
                getSession().getAttribute("usager").toString(),
                "residents_Afficher");
    }

    @Override
    protected final void initialiserControleur() {
        setPageRetourForm("Resident");
        setPageRetourListe("app/ListeResidents");

        setTitrePage("Liste des résidents");
        setOnglet("listeResidents");
        setActionAlternative1("null");
        setActionAlternative2("null");
    }

    @Override
    protected final void initialiserListeDroits() {
        final String nomUtil = getSession().getAttribute("usager").toString();
        int nbControles = 0;
        getRequete().setAttribute("btnAjouter",
                Utilisateur.aDroitsUtilisateur(nomUtil,
                "residents_Ajout").toString());

        if (Utilisateur.aDroitsUtilisateur(nomUtil,
                "residents_Ajout")) {
            nbControles++;
        }

        getRequete().setAttribute("btnModifier",
                Utilisateur.aDroitsUtilisateur(nomUtil,
                "residents_Mettre_A_Jour").toString());

        if (Utilisateur.aDroitsUtilisateur(nomUtil,
                "residents_Mettre_A_Jour")) {
            nbControles++;
        }

        getRequete().setAttribute("btnEffacer",
                Utilisateur.aDroitsUtilisateur(nomUtil,
                "residents_Effacer").toString());

        if (Utilisateur.aDroitsUtilisateur(nomUtil,
                "residents_Effacer")) {
            nbControles++;
        }

        getRequete().setAttribute("nbControles", nbControles);
    }

    @Override
    protected final void executeSuppression(final int pidSuppression) {
        String valeur = SqlObjectProvider.getInstance().objetEnString(Resident.getResident(pidSuppression));
        if (Resident.supprimerResident(pidSuppression)) {
            Log.insererLog(new Log(0, "supression", "Resident",
                    getRequete().getSession().getAttribute("usager").toString(),
                    UtilitaireDate.timeNowEnString(), valeur, "aucune"));
        }
    }

    @Override
    protected final void attribuerListe() {
        getRequete().setAttribute("liste", Resident.getResidents());
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
