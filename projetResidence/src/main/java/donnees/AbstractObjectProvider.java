package donnees;

import affaire.Appartement;
import affaire.Bail;
import affaire.Inscription;
import affaire.Log;
import affaire.Resident;
import affaire.Role;
import affaire.Utilisateur;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * Classe qui s'occupe de fournir une couche d'astraction aux fonctions d'accès
 * aux objets.
 *
 * @author Vincent
 */
public abstract class AbstractObjectProvider extends AbstractDataAccess {

    /**
     * L'instance du provider.
     */
    protected static AbstractObjectProvider instance = null;
    /**
     * La source des données.
     */
    private static DataSource dataSource = null;

    /**
     * Permet d'obtenir le dataSource.
     *
     * @return Instance de dataSource
     */
    public static DataSource getDataSource() {
        synchronized (DataSource.class) {
            if (dataSource == null) {
                try {
                    final InitialContext initialContext = new InitialContext();
                    dataSource = (DataSource) initialContext.lookup(
                            "java:/comp/env/jdbc/residenceCarrefourbd");
                    initialContext.close();
                } catch (Exception e) {
                    Logger.getLogger(AbstractDataAccess.class.getName()).
                            log(Level.SEVERE, null, e);
                }
            }
        }

        return dataSource;
    }

    @Override
    public Connection getConnection() {
        Connection connexion = null;

        try {
            connexion = getDataSource().getConnection();
        } catch (SQLException sqle) {
            Logger.getLogger(AbstractDataAccess.class.getName()).log(Level.SEVERE, null, sqle);
        }

        return connexion;
    }

    @Override
    public void freeConnection(final Connection connexion) {
        if (connexion != null) {
            try {
                connexion.close();
            } catch (SQLException sqle) {
                Logger.getLogger(AbstractDataAccess.class.getName()).log(Level.SEVERE, null, sqle);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Méthodes abstraites des classes affaires">
    // Méthodes reliées à Inscription
    /**
     * Get une inscription.
     *
     * @param pvaleur valeur reçue en paramètre.
     * @return L'inscription désirée.
     */
    public abstract Inscription getInscription(Object pvaleur);

    /**
     * Get toutes les inscriptions.
     *
     * @return Liste de toutes les inscriptions.
     */
    public abstract List<Inscription> getInscriptions();

    /**
     * Supprime une inscription.
     *
     * @param pidInscription Le id de l'inscription à supprimer.
     * @return Un boolean représentant le succès ou l'echec de l'opération.
     */
    public abstract boolean supprimerInscription(int pidInscription);

    /**
     * Met à jour une inscription.
     *
     * @param pinscription Le id de l'inscription à mettre à jour.
     * @return Un boolean représentant le succès ou l'echec de l'opération.
     */
    public abstract boolean modifierInscription(Inscription pinscription);

    /**
     * Insère une inscription.
     *
     * @param pinscription La nouvelle inscription à insérer.
     * @return Un boolean représentant le succès ou l'echec de l'opération.
     */
    public abstract boolean insererInscription(Inscription pinscription);

    // Méthode reliées à Appartement
    /**
     * Get un appartement.
     *
     * @param pvaleur valeur reçue en paramètre.
     * @return L'appartement désiré.
     */
    public abstract Appartement getAppartement(Object pvaleur);

    /**
     * Get tous les appartements.
     *
     * @return Liste de tous les appartements.
     */
    public abstract List<Appartement> getAppartements();

    /**
     * Supprime un appartement.
     *
     * @param pid Le id de l'inscription à supprimer.
     * @return Un boolean représentant le succès ou l'echec de l'opération.
     */
    public abstract boolean supprimerAppartement(int pid);

    /**
     * Met à jour un appartement.
     *
     * @param pappartement Le id de l'inscription à mettre à jour.
     * @return Un boolean représentant le succès ou l'echec de l'opération.
     */
    public abstract boolean modifierAppartement(Appartement pappartement);

    /**
     * Insère un appartement.
     *
     * @param pappartement Le nouvel appartement à insérer.
     * @return Un boolean représentant le succès ou l'echec de l'opération.
     */
    public abstract boolean insererAppartement(Appartement pappartement);

    // Méthode reliées à Bail
    /**
     * Retourne le bail avec le id spécifier en paramètre.
     *
     * @param pid Le id désiré.
     * @return Le bail avec le id.
     */
    public abstract Bail getBail(int pid);

    /**
     * Retourne la liste de tout les baux de la base de données.
     *
     * @return Les baux de la base de données.
     */
    public abstract List<Bail> getBails();

    /**
     * Supprimer le bail à l'id spécifié.
     *
     * @param pid Le id.
     * @return Si la suppression à été effectué.
     */
    public abstract boolean supprimerBail(int pid);

    /**
     * La modification du bail à l'id.
     *
     * @param pbail Le bail.
     * @return Si la modification c'est faite.
     */
    public abstract boolean modifierBail(Bail pbail);

    /**
     * L'insertion du bail dans la base de données.
     *
     * @param pbail Le bail à inserer.
     * @return Si l'insertion est réussit.
     */
    public abstract boolean insererBail(Bail pbail);

    // Méthode reliées à Resident
    /**
     * Get un résident.
     *
     * @param pvaleur valeur reçue en paramètre.
     * @return Le résident désiré.
     */
    public abstract Resident getResident(Object pvaleur);

    /**
     * Get tous les résidents.
     *
     * @return La liste de tous les résidents.
     */
    public abstract List<Resident> getResidents();

    /**
     * Supprime un résident.
     *
     * @param pid Le id du résident à supprimer.
     * @return Un boolean représentant le succès ou l'echec de l'opération.
     */
    public abstract boolean supprimerResident(int pid);

    /**
     * Met à jour un résident.
     *
     * @param president L'objet résident à mettre à jour.
     * @return Un boolean représentant le succès ou l'echec de l'opération.
     */
    public abstract boolean modifierResident(Resident president);

    /**
     * Insère un résident.
     *
     * @param president Le nouveau résident à insérer.
     * @return Un boolean représentant le succès ou l'echec de l'opération.
     */
    public abstract boolean insererResident(Resident president);
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Méthodes Utilisateurs">
    /**
     * Get tous les utilisateurs.
     *
     * @return La liste des utilisateurs.
     */
    public abstract List<Utilisateur> getUtilisateurs();

    /**
     * Get un utilisateur.
     *
     * @param pnomUtlisateur Le nom de l'utilisateur désiré.
     * @return L'utilisateur désiré.
     */
    public abstract Utilisateur getUtilisateur(final String pnomUtlisateur);

    /**
     * Get un utilisateur.
     *
     * @param pid Le id de l'utilisateur désiré.
     * @return L'utilisateur désiré.
     */
    public abstract Utilisateur getUtilisateur(final int pid);

    /**
     * Supprime un utilisateur.
     *
     * @param pid Le id de l'utilisateur à supprimer.
     * @return Un boolean représentant le succès ou l'echec de l'opération.
     */
    public abstract boolean supprimerUtilisateur(int pid);

    /**
     * Met à jour un utilisateur.
     *
     * @param putilisateur Le id de l'utilisateur à mettre à jour.
     * @return Un boolean représentant le succès ou l'echec de l'opération.
     */
    public abstract boolean modifierUtilisateur(Utilisateur putilisateur);

    /**
     * Insère un utilisateur.
     *
     * @param putilisateur Le nouvel utilisateur à insérer.
     * @return Un boolean représentant le succès ou l'echec de l'opération.
     */
    public abstract boolean insererUtilisateur(Utilisateur putilisateur);

    // Méthodes reliées aux roles
    /**
     * Get la liste des droits d'un usager.
     *
     * @param pnomUtilisateur Le nom d'usager dont on veut les droits.
     * @return La liste des droits de l'usager.
     */
    public abstract List<String> getDroitsUtilisateurs(
            final String pnomUtilisateur);

    /**
     * Get la liste des droits d'un usager.
     *
     * @param pidRole Le id de l'usager dont on veut les droits.
     * @return La liste des droits de l'usager.
     */
    public abstract List<String> getDroitsUtilisateurs(final int pidRole);

    /**
     * Get un role.
     *
     * @param pid Le id du role que l'on veut.
     * @return Le role en question.
     */
    public abstract Role getRole(final int pid);
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Méthodes Logs">
    /**
     * Get tous les logs.
     *
     * @return La liste des logs.
     */
    public abstract List<Log> getLogs();

    /**
     * Get un log.
     *
     * @param pid Le id de l'utilisateur désiré.
     * @return L'utilisateur désiré.
     */
    public abstract Log getLog(final Object pid);

    /**
     * Insère un log.
     *
     * @param plog Le nouveau log à insérer.
     * @return Un boolean représentant le succès ou l'echec de l'opération.
     */
    public abstract boolean insererLog(Log plog);

    /**
     * Supprime un log.
     *
     * @param pid Le id du log à supprimer.
     * @return Un boolean représentant le succès ou l'echec de l'opération.
     */
    public abstract boolean supprimerLog(int pid);

    /**
     * Convertion d'un objet en type String.
     *
     * @param donnee L'objet à convertir.
     * @return Un string représentant l'objet.
     */
    public abstract String objetEnString(Object donnee);
    //</editor-fold>
}
