package controleur;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Sert de constructeur à nos objets de controle, lesquels doivent effectuer
 * toute la logique dont aura besoin le JSP appelant. Il est préférable
 * d'utiliser getcontroleurParNomClasse Date: Jan 31, 2013 Time: 3:12:35 PM
 *
 * @author francisbeauchamps
 */
public final class FabriqueControleur {

    /**
     * Pour faire taire le truc d'erreur.
     */
    private FabriqueControleur() {
    }

    /**
     * À Partir d'un objet classe, retourne une instance de cette classe s'il
     * s'agit d'un Controleur.
     *
     * @param classeAction La classe dont on doit retourner l'instance.
     * @return L'instance de la classe du controleur, ou null.
     */
    public static Controleur getControleurParClasse(final Class classeAction) {
        Controleur controleur = null;
        try {
            // Si impossible de créer une instance de la classe
            // pour X raison, on ne retourne rien car "throw"
            // C'est pour cela que l'on ne retourne
            // pas directement la nouvelle instance
            controleur = (Controleur) classeAction.newInstance();

            // S'il est possible d'instancier la classe,
            // on en retourne un nouvelle instance
        } catch (java.lang.InstantiationException e) {
            Logger.getLogger(FabriqueControleur.class.getName()).log(Level.SEVERE, null, e);
        } catch (IllegalAccessException e) {
            Logger.getLogger(FabriqueControleur.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassCastException e) {
            Logger.getLogger(FabriqueControleur.class.getName()).log(Level.SEVERE, null, e);
        }

        return controleur;
    }

    /**
     * À Partir du nom d'une classe, retourne une instance de cette classe si le
     * nom coincide avec l'une des classes de controleur.
     *
     * @param nomClasse Le nom de le classe de controleur.
     * @return L'instance de la classe du controleur, ou null.
     */
    public static Controleur getControleurParNomClasse(final String nomClasse) {
        try {
            // Le nom de classe du controleur
            String nom;
            nom = "controleur.Controleur" + nomClasse;

            // On obtient sa classe pour de vrai
            Class classeAction;
            classeAction = Class.forName(nom);

            // On fournit la classe pour demander à
            // recevoir une instance de cette derniere
            return getControleurParClasse(classeAction);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(FabriqueControleur.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }
}
