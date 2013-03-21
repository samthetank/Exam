/*
 * Utilitaire
 */
package util;

/**
 * Classe utilitaire contenant des fonctions utiles.
 *
 * @author Benoit Jeunehomme
 */
public final class UtilitaireTexte {

    /**
     *
     */
    public static final String EXPRESSION_0_9 = "(?=[^A-Za-z]+$).*[0-9].*";
    /**
     *
     */
    public static final String EXPRESSION_TEXT = "^[A-Za-z-éëèÉÈËÏïçÇöÖ].[A-Za-z-éëèÉÈËÏïçÇöÖ\\-\\.\\ ]*"
            + "[A-Za-z-éëèÉÈËÏïçÇöÖ]$";
    /**
     *
     */
    public static final String EXPRESSION_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+"
            + "(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{1,})$";
    /**
     *
     */
    public static final String EXPRESSION_TELEPHONE =
            "(^[0-9]{3})+([\\-]{0,1})+([0-9]{3}+[\\-]{0,1})+([0-9]{4})*[0-9]$";
    /**
     *
     */
    public static final String EXP_DECIMAL = "\\d{0,4}\\.\\d{1,2}";
    /**
     *
     */
    public static final String EXPRESSION_MDP = "((?=[\\S]+$).{5,10})";

    /**
     * Constructeur privé afin d'éviter la création d'un objet UtilitaireTexte.
     */
    private UtilitaireTexte() {
    }

    /**
     * Vérifie une chaîne pour déterminer qu'elle n'est pas vide.
     *
     * @param chaine Chaîne à vérifier.
     * @return Booléen indiquant si la chaîne n'est pas vide.
     */
    public static boolean chaineNonVide(final String chaine) {
        return !chaine.isEmpty();
    }

    /**
     * Vérifie une chaîne pour déterminer qu'elle est vide.
     *
     * @param chaine Chaîne à vérifier.
     * @return Booléen indiquant si la chaîne est vide.
     */
    public static boolean chaineVide(final String chaine) {
        return chaine.isEmpty();
    }

    /**
     * Vérifie si une chaîne de caractères contient la chaîne recherchée.
     *
     * @param chaine Chaîne de caractères
     * @param recherche Chaîne à rechercher
     * @return Booléen indiquant si la chaîne contient la chaîne recherchée.
     */
    public static boolean chaineContenant(final String chaine, final String recherche) {
        return chaine.contains(recherche) && !"".equals(recherche);
    }

    /**
     * Vérifie si une chaîne de caractères ne contient pas la chaîne recherchée.
     *
     * @param chaine Chaîne de caractères
     * @param recherche Chaîne à rechercher
     * @return Booléen indiquant si la chaîne ne contient pas la chaîne
     * recherchée.
     */
    public static boolean chaineNeContenantPas(final String chaine, final String recherche) {
        return !chaine.contains(recherche) && !"".equals(chaine);
    }

    /**
     * Vérifie si la longueur de la chaîne correspond au minimum fournie.
     *
     * @param chaine Chaîne de caractères
     * @param longueurMin Longueur minimum de la chaîne
     * @return Booléen indiquant si la chaîne est d'une longueur minimum.
     */
    public static boolean longueurChaineMin(final String chaine, final int longueurMin) {
        return longueurMin <= chaine.length();
    }

    /**
     * Vérifie si la longueur de la chaîne correspond au maximum fournie.
     *
     * @param chaine Chaîne de caractères
     * @param longueurMax Longueur maximum de la chaîne
     * @return Booléen indiquant si la chaîne est d'une longueur maximum.
     */
    public static boolean longueurChaineMax(final String chaine, final int longueurMax) {
        return chaine.length() <= longueurMax;
    }

    /**
     * Vérifie si la longueur de la chaîne correspond au minimum et au maximum
     * fournie.
     *
     * @param chaine Chaîne de caractères
     * @param longueurMin Longueur minimum de la chaîne
     * @param longueurMax Longueur maximum de la chaîne
     * @return Booléen indiquant si la chaîne est d'une longueur respectant un
     * minimum et un maximum donnés.
     */
    public static boolean longueurChaineIntervalle(final String chaine, final int longueurMin, final int longueurMax) {
        return longueurMin <= chaine.length() && chaine.length() <= longueurMax;
    }

    /**
     * Extrait une chaîne de caractères qui se trouve après une chaîne et avant
     * une autre dans une chaîne de recherche.
     *
     * @param chaine Chaîne de caractère pour la recherche
     * @param avant Chaîne se trouvant avant la chaîne recherché
     * @param apres Chaîne se trouvant après la chaîne recherché
     * @return Chaîne recherché
     */
    public static String extraireTexte(final String chaine, final String avant, final String apres) {
        int indexDebut;
        int indexFin;
        final boolean invalide = "".equals(chaine) || "".equals(avant) || "".equals(apres);
        if (invalide || !chaine.contains(avant) || !chaine.contains(apres)) {
            indexDebut = 0;
            indexFin = 0;
        } else {
            indexDebut = chaine.indexOf(avant);
            indexDebut += avant.length();
            indexFin = chaine.indexOf(apres, indexDebut);
        }
        return chaine.substring(indexDebut, indexFin);
    }

    /**
     * Transforme une chaîne de caractères représentant un entier en entier.
     *
     * @param chaine Chaîne de caractères représentant un entier
     * @return Entier correspondant à la chaîne.
     */
    public static int texteAEntier(final String chaine) {
        return Integer.parseInt(chaine);
    }
}
