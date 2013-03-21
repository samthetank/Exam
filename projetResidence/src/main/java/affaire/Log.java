/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package affaire;

import donnees.SqlObjectProvider;
import java.util.List;

/**
 * Classe représentant un log dans le système. Cette classe à seulement un
 * constructeur public et une classe statique ce qui lui permet de gérer la
 * validation.
 *
 * @author Sam
 */
public final class Log {
    // <editor-fold defaultstate="collapsed" desc="Membres">

    /**
     * Le numéro du log dans l'appelle des controlleurs à la base de données.
     */
    private final transient int idLog;
    /**
     * L'action sur un objet de la BD soit : suppression, ajout, modification...
     */
    private final transient String action;
    /**
     * Le nom de la table qui sera affecté par l'action.
     */
    private final transient String nomTable;
    /**
     * Le nom de l'utilisateur qui fait une action.
     */
    private final transient String nomUtilisateur;
    /**
     * Date et temps auquel une action à été fait.
     */
    private final transient String dateLog;
    /**
     * La valeur actuelle de l'objet.
     */
    private final transient String valeur;
    /**
     * La valeur de l'objet avant la dernière modification.
     */
    private final transient String ancienneValeur;
    // </editor-fold>

    /**
     * Constructeur privée de la classe Log permet d'avoir un log avec les
     * champs de base initialisé.
     *
     * @param pidLog Le numéro du log.
     * @param paction L'action du log sur un objet de la BD.
     * @param pnomTable Le nom de la table.
     * @param pnomUtilisateur Le nom de l'usager exécutant l'action.
     * @param pdateLog Date et temps auquel une action à été fait.
     * @param pvaleur La valeur actuelle de l'objet.
     * @param pancienneValeur La valeur de l'objet avant la dernière
     * modification.
     */
    public Log(final int pidLog, final String paction, final String pnomTable,
            final String pnomUtilisateur, final String pdateLog,
            final String pvaleur, final String pancienneValeur) {
        this.idLog = pidLog;
        this.action = paction;
        this.nomTable = pnomTable;
        this.nomUtilisateur = pnomUtilisateur;
        this.dateLog = pdateLog;
        this.valeur = pvaleur;
        this.ancienneValeur = pancienneValeur;
    }

    // <editor-fold defaultstate="collapsed" desc="Getter">
    /**
     * Getter pour le numéro du log.
     *
     * @return idLog.
     */
    public int getIdLog() {
        return idLog;
    }

    /**
     * Getter pour l'action.
     *
     * @return L'action.
     */
    public String getAction() {
        return action;
    }

    /**
     * Getter pour le nom de la table.
     *
     * @return Le nom de la table.
     */
    public String getnomTable() {
        return nomTable;
    }

    /**
     * Getter pour le nom de l'utilisateur.
     *
     * @return Le nom de l'utilisateur.
     */
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    /**
     * Getter pour la date.
     *
     * @return La date et le temps de prise en note du log.
     */
    public String getDateLog() {
        return dateLog;
    }

    /**
     * Getter pour la valeur.
     *
     * @return La valeur de l'objet.
     */
    public String getValeur() {
        return valeur;
    }

    /**
     * Getter pour l'ancienne valeur.
     *
     * @return L'ancienne valeur de l'objet.
     */
    public String getAncienneValeur() {
        return ancienneValeur;
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Méthodes Static">
    /**
     * S'assure que le log reçu en paramètre est bien insérée dans la base de
     * données en appelant la fonction adéquate dans le SqlObjectProvider.
     *
     * @param plog Le log à insérer dans la base de données.
     * @return vrai si la valeur a été insérée dans la base de données.
     */
    public static boolean insererLog(final Log plog) {
        return SqlObjectProvider.getInstance().insererLog(plog);
    }

    /**
     * Retourne la liste de tout les logs.
     *
     * @return List des logs.
     */
    public static List<Log> getLogs() {
        return SqlObjectProvider.getInstance().getLogs();
    }

    /**
     * Retourne le log avec le id.
     *
     * @param pid Le numero id
     * @return Le log ayant ce id ou null si inexistant.
     */
    public static Log getLog(final int pid) {
        return SqlObjectProvider.getInstance().getLog(pid);
    }

    /**
     * Appelle le dal pour qu'il supprimer le log à l'id spécifié dans la base
     * de données.
     *
     * @param pid Le id du log à supprimer
     * @return Si la suppression à été réussi.
     */
    public static boolean supprimerLog(final int pid) {
        return SqlObjectProvider.getInstance().supprimerLog(pid);
    }
    // </editor-fold>
}
