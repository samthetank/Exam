/*
 * Utilitaire
 */
package util;

/**
 * Classe utilitaire contenant des fonctions utiles.
 *
 * @author Benoit Jeunehomme
 */
public final class UtilitaireDouble {

    /**
     * Constructeur privé afin d'éviter la création d'un objet UtilitaireDouble.
     */
    private UtilitaireDouble() {
    }

    /**
     * Permet de déterminer si un nombre réel est plus petit qu'un autre.
     *
     * @param reel Nombre réel
     * @param reelCompare Nombre réel à comparer
     * @return Booléen indiquant si le premier nombre réel est plus petit que le
     * second.
     */
    public static boolean reelPlusPetit(final double reel, final double reelCompare) {
        return reel < reelCompare;
    }

    /**
     * Permet de déterminer si un nombre réel est plus grand qu'un autre.
     *
     * @param reel Nombre réel
     * @param reelCompare Nombre réel à comparer
     * @return Booléen indiquant si le premier nombre réel est plus grand que le
     * second.
     */
    public static boolean reelPlusGrand(final double reel, final double reelCompare) {
        return reelCompare < reel;
    }

    /**
     * Permet de déterminer si la valeur d'un nombre réel se situe entre celle
     * de deux autres.
     *
     * @param reel Nombre réel
     * @param reelMin Nombre réel minimum à comparer
     * @param reelMax Nombre réel maximum à comparer
     * @return Booléen indiquant si le nombre réel se situe entre les deux
     * autres.
     */
    public static boolean reelDansIntervalle(final double reel, final double reelMin, final double reelMax) {
        return reelMin <= reel && reel <= reelMax;
    }

    /**
     * Obtient un nombre réel à partir d'une chaîne de caractères.
     *
     * @param pchaine Chaîne de caractères représentant un nombre réel
     * @return Nombre réel
     */
    public static double obtenirReelAvecString(final String pchaine) {
        double reel;

        try {
            reel = Double.parseDouble(pchaine);
        } catch (NumberFormatException nfe) {
            reel = -1;
        }

        return reel;
    }
}
