/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import affaire.Appartement;
import affaire.Bail;
import affaire.Log;
import affaire.Resident;
import affaire.Utilisateur;
import donnees.SqlObjectProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.UtilitaireDate;

/**
 *
 * @author Vincent
 */
public class ControleurListeBaux extends AbstractControleurListe {

    @Override
    protected boolean aAccesPage() {
        return true;
    }

    @Override
    protected void initialiserControleur() {
        // Le titre de la page.
        setTitrePage("Liste des baux");

        // L'onglet actif.
        setOnglet("listeBaux");

        // Les pages de retour.
        setPageRetourForm("BailPaiement");
        setPageRetourListe("app/ListeBaux");

        // Les noms des actions alternatives.
        // Liste tout les baux de la base de données.
        setActionAlternative1("historique");
        setActionAlternative2("null");
    }

    @Override
    protected void initialiserListeDroits() {
        final String nomUtil = getSession().getAttribute("usager").toString();
        int nbControles = 0;
        // Les boutons de bases
        getRequete().setAttribute("btnAjouter", Utilisateur.aDroitsUtilisateur(nomUtil, "baux_Ajout"));

        getRequete().setAttribute("btnEffacer", Utilisateur.aDroitsUtilisateur(nomUtil, "baux_Effacer"));
        if (Utilisateur.aDroitsUtilisateur(nomUtil,
                "baux_Effacer")) {
            nbControles++;
        }

        getRequete().setAttribute("nbControles", nbControles);
    }

    @Override
    protected void executeSuppression(final int pidSuppression) {
        String valeur = SqlObjectProvider.getInstance().objetEnString(Bail.getBail(pidSuppression));
        if (Bail.supprimerBail(pidSuppression)) {
            Log.insererLog(new Log(0, "supression", "Bail",
                    getRequete().getSession().getAttribute("usager").toString(),
                    UtilitaireDate.timeNowEnString(), valeur, "aucune"));
        }
    }

    @Override
    protected void attribuerListe() {
        // On attribue la liste sans l'historique.
        attribuerListe(false);
    }

    /**
     * Affiche tout les baux dans la base de données.
     */
    @Override
    protected void executeActionAlternative1() {
        // Attribue la liste avec historique.
        attribuerListe(true);

        // On retourne à la liste.
        setPageRetour(getPageRetourListe());
    }

    @Override
    protected void executeActionAlternative2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Remplir la liste.
     *
     * @param avecHistorique Option
     */
    private void attribuerListe(final boolean avecHistorique) {
        // La liste que nous allons attribuer en attribut
        final List<Map<String, Object>> donnees = new ArrayList<Map<String, Object>>();

        Map<String, Object> ligne;

        // On obtient tout les baux.
        final List<Bail> baux = Bail.getBails();

        for (Bail bail : baux) {
            if (avecHistorique || UtilitaireDate.dateAnterieure(UtilitaireDate.greorianToString(
                    UtilitaireDate.dateDuJour()), bail.getDateFin())) {
                ligne = new HashMap<String, Object>();
                ligne.put("idBail", bail.getIdBail());
                ligne.put("noAppartement", Appartement.getAppartement(bail.getIdAppartement()).getNoAppartement());
                ligne.put("dateDebut", bail.getDateDebut());
                ligne.put("dateFin", bail.getDateFin());
                ligne.put("montantLoyer", bail.getMontantLoyer());

                String nom = Resident.getResident(bail.getIdLocataire()).getNom().toString() + ", "
                        + Resident.getResident(bail.getIdLocataire()).getPrenom().toString();
                ligne.put("locataire1", nom);

                if (bail.getIdLocataireSecondaire() == -1) {
                    nom = "";
                } else {
                    nom = Resident.getResident(bail.getIdLocataireSecondaire()).getNom().toString() + ", "
                            + Resident.getResident(bail.getIdLocataireSecondaire()).getPrenom().toString();
                }

                ligne.put("locataire2", nom);
                ligne.put("dernierMois", bail.getDernierMois());
                donnees.add(ligne);
            }
        }

        getRequete().setAttribute("liste", donnees);

    }
}
