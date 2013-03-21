package controleur;

import javax.servlet.http.HttpServletRequest;

/**
 * AbstractControleur: Fournit les fonctions essentielle aux controleurs afin
 * qu'ils puissent rediriger des requêtes contenant des données.
 *
 * Date: Jan 31, 2013 Time: 3:07:25 PM
 *
 * @author francisbeauchamps Comment: Description goes here ...
 */
public abstract class AbstractControleur implements Controleur {

    /**
     * La requete faisant l'appel au controleur.
     */
    private HttpServletRequest requete;
    /**
     * La prochaine vue pour la navigation de la requete http.
     */
    private String pageRetour;

    /**
     * Initialise le controleur avec la requete http.
     *
     * @param prequete La requete http.
     */
    @Override
    public final void init(final HttpServletRequest prequete) {
        this.setRequete(prequete);
    }

    /**
     * Setter pour la page de retour.
     *
     * @param page La valeur assignée à la variable membre pageRetour.
     */
    public final void setPageRetour(final String page) {
        pageRetour = page;
    }

    /**
     * Getter pour la page de retour.
     *
     * @return La prochaine page pour la requête htpp.
     */
    @Override
    public String getPageRetour() {
        return pageRetour;
    }

    /**
     * Getter pour la requête http.
     *
     * @return La requête http.
     */
    public HttpServletRequest getRequete() {
        return requete;
    }

    /**
     * Setter pour la requête http.
     *
     * @param prequete La requête à attribuer au controleur.
     */
    public final void setRequete(final HttpServletRequest prequete) {
        this.requete = prequete;
    }
    /**
     * Onglet actif.
     */
    private String onglet;

    /**
     * Set l'onglet actuel dans le menu.
     *
     * @param ponglet le nom de l'onglet actif
     */
    public final void setOnglet(final String ponglet) {
        this.onglet = ponglet;
    }

    /**
     * Get l'onglet actuel dans le menu.
     *
     * @return le nom de l'onglet actif
     */
    public final String getOnglet() {
        return this.onglet;
    }
}
