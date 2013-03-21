package controleur;

/**
 * Controlleur pour la page d'index principale. Date: Jan 31, 2013 Time: 3:16:46
 * PM
 *
 * @author Francis Beauchamp
 */
public class ControleurIndex extends AbstractControleur {

    /**
     * Execute le code du controleur de la page index.
     */
    @Override
    public final void execute() {
        if (getRequete().getSession().getAttribute("language").toString().contains("fr")) {
            this.getRequete().setAttribute("titre", "Accueil - système de gestion");
        } else {
            this.getRequete().setAttribute("titre", "Home - management system");
        }
        this.getRequete().setAttribute("page", "index");
        // Pour l'inclusion des scripts / css
        this.getRequete().setAttribute("contexte", this.getRequete().getContextPath());

        // La page de retour est index.jsp pour ce controleur
        this.setPageRetour("app/Index");


    }
}
