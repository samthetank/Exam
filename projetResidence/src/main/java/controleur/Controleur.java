package controleur;

import javax.servlet.http.HttpServletRequest;

/**
 * Interface utilisée par notre controleur abstrait. Date: Jan 31, 2013 Time:
 * 3:06:22 PM
 *
 * @author francisbeauchamps
 */
public interface Controleur {

    /**
     * Exécute les actions du controleur.
     */
    void execute();

    /**
     * Initialise le controleur avec la requete http.
     *
     * @param prequete La requete http.
     */
    void init(HttpServletRequest prequete);

    /**
     * Getter pour la page de retour.
     *
     * @return La prochaine page pour la requête htpp.
     */
    String getPageRetour();
}
