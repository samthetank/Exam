package affaire;

import java.util.Map;

/**
 * Classe abstraite pour les objets d'affaires.
 *
 * @author Benoit Jeunehomme
 */
public abstract class AbstractObjetAffaire {

    /**
     * Méthode abstraite supprimer. Permet de supprimer un objet d'affaire.
     *
     * @return Un booléen.
     */
    public abstract boolean supprimer();

    /**
     * Méthode abstraite modifier. Permet de modifier un objet d'affaire.
     *
     * @return Un booléen.
     */
    public abstract boolean modifier();

    /**
     * Méthode abstraite mapErreur. Permet de mapper les erreurs avec un message
     * d'erreur.
     *
     * @param map Map qui fait correspondre une erreur à un message d'erreur.
     * @param condition Condition d'erreur.
     * @param nomErreur Nom de l'erreur.
     * @param messageErreur Message de l'erreur.
     */
    public static void mapErreur(final Map<String, Object> map,
            final boolean condition, final String nomErreur,
            final String messageErreur) {
        if (condition) {
            map.put(nomErreur, messageErreur);
        }
    }
}
