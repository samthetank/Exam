/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe qui s'occupe de faire la connection à la base de données et d'executer
 * les requêtes avec et sans retour.
 *
 * @author Samuel et Vincent
 * @version 1.0
 */
public abstract class AbstractDataAccess {

    /**
     * Fonction qui permet d'obtenir la connexion à la base de données.
     *
     * @return La connection.
     */
    protected abstract Connection getConnection();

    /**
     * Libère la connexion recu en paramètre.
     *
     * @param connexion La connexion à libèrer.
     */
    protected abstract void freeConnection(Connection connexion);

    /**
     * Permet d'effectuer une requete avec un retour comme des Select.
     *
     * @param requete La chaine de charactère représentant la requete SQL.
     * @return Le ResultSet contenant les données.
     */
    private List<Map<String, Object>> requeteAvecRetour(final String requete) {
        final List<Map<String, Object>> listeResultats =
                new ArrayList<Map<String, Object>>();
        Connection connexion;
        Statement statement = null;
        ResultSet resultat = null;

        // On récupère une connexion.
        connexion = getConnection();
        try {
            statement = connexion.createStatement();
            resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                final Map map = new HashMap<String, Object>();
                for (int i = 1; i <= resultat.getMetaData().getColumnCount();
                        ++i) {
                    map.put(resultat.getMetaData().getColumnLabel(i),
                            resultat.getObject(i));
                }
                listeResultats.add(map);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AbstractDataAccess.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resultat != null) {
                    resultat.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AbstractDataAccess.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AbstractDataAccess.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
            try {
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AbstractDataAccess.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }

        return listeResultats;
    }

    /**
     * Permet d'effectuer des requêtes sans retour comme des insert, delete ou
     * update.
     *
     * @param requete La requête SQL
     * @return Le nombre de lignes qui à été affecter par la requête.
     */
    private int requeteSansRetour(final String requete) {
        int nbLignes = 0;

        Connection connexion = null;
        Statement statement = null;

        try {
            connexion = getConnection();
            statement = connexion.createStatement();
            nbLignes = statement.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDataAccess.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AbstractDataAccess.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
            try {
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AbstractDataAccess.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }

        return nbLignes;
    }
    /**
     * Apostrophe.
     */
    public static final String APOSTROPHE = "'";
    /**
     * Apostrophe suivit d'une virgule et d'un espace.
     */
    public static final String APOSTROPHE_VIRGULE_ESPACE = "', ";
    /**
     * Indicateur de condition SQL.
     */
    public static final String WHERE = " WHERE ";
    /**
     * Egale suivit d'un espace.
     */
    public static final String EGALE_ESPACE = "= ";
    /**
     * Egale suivit d'un espace et d'un apostrophe.
     */
    public static final String EGALE_ESPACE_APOSTROPHE = "= '";

    //<editor-fold defaultstate="collapsed" desc="Création de requête SQL.">
    /**
     * Crée une requête SQL à partir des champs contenues dans le map ainsi que
     * le nom de table. Execute ensuite la requete.
     *
     * @param nomTable Le nom de la table que nous allons insérer les données
     * @param donnees Les données que nous allons inserer dans la base de
     * données
     * @return Le nombre de lignes affectées.
     */
    public final int insererDonnees(final String nomTable,
            final Map<String, Object> donnees) {
        // On genere la requete Sql.
        final StringBuilder requete = new StringBuilder("INSERT INTO ");
        // La commande INSERT INTO.
        requete.append(nomTable).append(" (");
        for (Map.Entry<String, Object> entre : donnees.entrySet()) {
            // On ajoute les noms de clées
            requete.append(entre.getKey()).append(", ");
        }
        requete.delete(requete.length() - 2, requete.length());
        // On enlève la dernière virgule.

        requete.append(") VALUES (");
        for (Map.Entry<String, Object> entre : donnees.entrySet()) {
            if (entre.getValue() instanceof String) {
                // Les valeurs entre paramètres avec des ' pour les String
                if (entre.getValue().toString().contains(APOSTROPHE)) {
                    final String valeur = Utilitaire.filtrerString(
                            entre.getValue().toString(), APOSTROPHE, "\\\'");
                    requete.append(APOSTROPHE).append(valeur).append(APOSTROPHE_VIRGULE_ESPACE);
                } else {
                    requete.append(APOSTROPHE).append(entre.getValue().toString())
                            .append(APOSTROPHE_VIRGULE_ESPACE);
                }
            } else {
                // Les valeurs qui sont pas String sans apostrophe.
                requete.append(entre.getValue().toString()).append(", ");
            }
        }
        requete.delete(requete.length() - 2, requete.length());
        // On enlève encore une fois la dernière virgule.
        requete.append(");");
        return requeteSansRetour(requete.toString());
    }

    /**
     * Crée une requête SQL de type update qui recoit tout les données modifier
     * ainsi que les clées associées sous formes de map ainsi que la nom et la
     * valeur de la clée à modifier. Execute ensuite la requête.
     *
     * @param nomTable Le nom de la table à modifier.
     * @param donnees Les données avec les valeurs et nom de champs.
     * @param nomClee Le nom de la clée.
     * @param valeurClee La valeur de la clée.
     * @return Le nombre de ligne affecté par la requête.
     */
    public final int modifierDonnees(final String nomTable,
            final Map<String, Object> donnees, final String nomClee,
            final Object valeurClee) {
        final StringBuilder requete = new StringBuilder("UPDATE ");
        requete.append(nomTable).append(" SET ");
        for (Map.Entry<String, Object> entre : donnees.entrySet()) {
            requete.append(entre.getKey()).append(EGALE_ESPACE);
            if (entre.getValue() instanceof String) {
                if (entre.getValue().toString().contains(APOSTROPHE)) {
                    final String valeur = Utilitaire.filtrerString(
                            entre.getValue().toString(), APOSTROPHE, "\\\'");
                    requete.append(APOSTROPHE).append(valeur).append(APOSTROPHE_VIRGULE_ESPACE);
                } else {
                    requete.append(APOSTROPHE).append(entre.getValue()
                            .toString()).append(APOSTROPHE_VIRGULE_ESPACE);
                }
            } else {
                requete.append(entre.getValue().toString()).append(", ");
            }
        }
        requete.delete(requete.length() - 2, requete.length());
        requete.append(WHERE).append(nomClee).append(EGALE_ESPACE)
                .append(valeurClee).append("; ");

        return requeteSansRetour(requete.toString());
    }

    /**
     * Crée une requête SQL de type UPDATE avec plusieurs  données à modifier
     * ainsi que des clées associées sous formes de map ainsi que la nom et la
     * valeur de la clée à modifier. Execute ensuite la requête.
     * @param nomTable Le nom de la table.
     * @param donnees Le map de données à modifieré.
     * @param nomChampId1 Le nom du premier champs de condition.
     * @param valeurId1 La valeur du premier champs.
     * @param nomChampId2 Le nom du second champs de condition.
     * @param valeurId2 La valeur du second champs.
     * @return Le nombre de ligne
     */
    public final int modifierDonneesSelonPlusieurs(final String nomTable,
            final Map<String, Object> donnees, final String nomChampId1, final Object valeurId1,
            final String nomChampId2, final Object valeurId2) {
        final StringBuilder requete = new StringBuilder("UPDATE ");
        requete.append(nomTable).append(" SET ");
        for (Map.Entry<String, Object> entre : donnees.entrySet()) {
            requete.append(entre.getKey()).append(EGALE_ESPACE);
            if (entre.getValue() instanceof String) {
                if (entre.getValue().toString().contains(APOSTROPHE)) {
                    final String valeur = Utilitaire.filtrerString(
                            entre.getValue().toString(), APOSTROPHE, "\\\'");
                    requete.append(APOSTROPHE).append(valeur).append(APOSTROPHE_VIRGULE_ESPACE);
                } else {
                    requete.append(APOSTROPHE).append(entre.getValue()
                            .toString()).append(APOSTROPHE_VIRGULE_ESPACE);
                }
            } else {
                requete.append(entre.getValue().toString()).append(", ");
            }
        }
        requete.delete(requete.length() - 2, requete.length());
        requete.append(WHERE).append(nomChampId1).append(EGALE_ESPACE).append(valeurId1)
                .append(" AND ").append(nomChampId2).append(EGALE_ESPACE).append(valeurId2).append("; ");

        return requeteSansRetour(requete.toString());
    }

    /**
     * Efface les données contenues dans la table spécifié avec le nom du champs
     * et la valeur de l'id.
     *
     * @param nomTable Le nom de la table à effacer
     * @param nomChampId Le nom du champs clée
     * @param valeurId La valeur du champs clée
     * @return Le nombre de ligne affecté
     */
    public final int effacerDonnees(final String nomTable,
            final String nomChampId, final int valeurId) {
        return requeteSansRetour("DELETE FROM " + nomTable + WHERE
                + nomChampId + EGALE_ESPACE + valeurId + ";");
    }

    /**
     * Obtient tout les données contenues dans une table.
     *
     * @param nomTable La table avec les données.
     * @return Une liste de clée valeur avec le résultat de la requête.
     */
    public final List<Map<String, Object>> obtenirToutLesDonnees(
            final String nomTable) {
        return requeteAvecRetour("SELECT * FROM " + nomTable + ";");
    }

    /**
     * Obtient les données selon la table, un champs et une valeur.
     *
     * @param nomTable Le nom de la table contenant les données
     * @param nomChampId Le nom du champs
     * @param valeurId La valeur de la clée
     * @return Le résultat de la requête.
     */
    public final List<Map<String, Object>> obtenirDonneesSelonId(
            final String nomTable, final String nomChampId,
            final Object valeurId) {
        return requeteAvecRetour("SELECT * FROM " + nomTable + WHERE
                + nomChampId + EGALE_ESPACE_APOSTROPHE + valeurId + "';");
    }

    /**
     * Obtient les données selon la table, un champs et une valeur.
     *
     * @param nomTable Le nom de la table contenant les données
     * @param nomChampId1 Le nom du champs 1
     * @param nomChampId2 Le nom du champs 2
     * @param nomChampId3 Le nom du champs 3
     * @param valeurId1 La valeur de la clée 1
     * @param valeurId2 La valeur de la clée 2
     * @param valeurId3 La valeur de la clée 3
     *
     * @return Le résultat de la requête.
     */
    public final List<Map<String, Object>> obtenirDonneesSelonPlusieursId(final String nomTable,
            final String nomChampId1, final Object valeurId1,
            final String nomChampId2, final Object valeurId2,
            final String nomChampId3, final Object valeurId3) {
        return requeteAvecRetour("SELECT * FROM " + nomTable + WHERE
                + nomChampId1 + EGALE_ESPACE_APOSTROPHE + valeurId1 + "' AND "
                + nomChampId2 + EGALE_ESPACE_APOSTROPHE + valeurId2 + "' AND "
                + nomChampId3 + EGALE_ESPACE_APOSTROPHE + valeurId3 + "';");
    }
    //</editor-fold>
}
