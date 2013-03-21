package controleur;

/**
 * ControleurErreur: Description de la classe ... Date: Feb 4, 2013 Time:
 * 12:23:19 PM
 *
 * @author francisbeauchamps
 */
public class ControleurErreur extends AbstractControleur {

    /**
     * Execute le code du controleur des page d'erreur.
     */
    @Override
    public void execute() {
        this.getRequete().setAttribute("contexte", this.getRequete().getContextPath());
        this.getRequete().setAttribute(
                "titre", "Erreur");

        // La page de retour est index.jsp pour ce controleur
        this.setPageRetour("/erreur/Erreur");
    }
}
