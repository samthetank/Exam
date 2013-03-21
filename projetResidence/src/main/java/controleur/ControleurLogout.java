package controleur;

import javax.servlet.http.HttpSession;

/**
 * Controleur de déconnexion de l'application. En tout temps, lorsque l'on se
 * déconnecte, la page de redirection sera le Login et passera par ce
 * controleur.
 *
 * @author Francis Beauchamp
 */
public class ControleurLogout extends AbstractControleur {

    /**
     * Exécute le controleur.
     */
    @Override
    public final void execute() {
        HttpSession session = this.getRequete().getSession();
        session.invalidate();
        this.getRequete().setAttribute("titre", "Connexion au système");
        this.setPageRetour(this.getRequete().getContextPath() + "/Login");
    }
}
