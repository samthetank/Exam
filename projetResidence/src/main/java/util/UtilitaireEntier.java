/*
 * Utilitaire
 */
package util;

/**
 * Classe utilitaire contenant des fonctions utiles.
 *
 * @author Benoit Jeunehomme
 */
public final class UtilitaireEntier {

    /**
     * Nombre indiquant les dizaines.
     */
    public static final int DIZAINE = 10;
    /**
     * Nombre indiquant les dizaines.
     */
    public static final int CENTAINE = 100;
    /**
     * Nombre trois.
     */
    public static final int NOMBRE_TROIS = 3;
    /**
     * Nombre quatre.
     */
    public static final int NOMBRE_QUATRE = 4;
    /**
     * Nombre cinq.
     */
    public static final int NOMBRE_CINQ = 5;
    /**
     * Nombre six.
     */
    public static final int NOMBRE_SIX = 6;
    /**
     * Nombre sept.
     */
    public static final int NOMBRE_SEPT = 7;

    /**
     * Constructeur privé afin d'éviter la création d'un objet UtilitaireEntier.
     */
    private UtilitaireEntier() {
    }

    /**
     * Permet de déterminer si un nombre entier est plus petit qu'un autre.
     *
     * @param entier Nombre entier
     * @param entierCompare Nombre entier à comparer
     * @return Booléen indiquant si le premier nombre entier est plus petit que
     * le second.
     */
    public static boolean entierPlusPetit(final int entier, final int entierCompare) {
        return entier < entierCompare;
    }

    /**
     * Permet de déterminer si un nombre entier est plus grand qu'un autre.
     *
     * @param entier Nombre entier
     * @param entierCompare Nombre entier à comparer
     * @return Booléen indiquant si le premier nombre entier est plus grand que
     * le second.
     */
    public static boolean entierPlusGrand(final int entier, final int entierCompare) {
        return entierCompare < entier;
    }

    /**
     * Permet de déterminer si la valeur d'un nombre entier se situe entre celle
     * de deux autres.
     *
     * @param entier Nombre entier
     * @param entierMin Nombre entier minimum à comparer
     * @param entierMax Nombre entier maximum à comparer
     * @return Booléen indiquant si le nombre entier se situe entre les deux
     * autres.
     */
    public static boolean entierDansIntervalle(final int entier, final int entierMin, final int entierMax) {
        return entierMin <= entier && entier <= entierMax;
    }

    /**
     * Transforme un entier en chaîne de caractères.
     *
     * @param entier Entier à transformer
     * @return Chaîne de caractères représentant un entier.
     */
    public static String entierATexte(final int entier) {
        return String.valueOf(entier);
    }

    /**
     * Transforme un entier en chaîne de caractères avec un minimum de chiffre.
     *
     * @param entier Entier à transformer
     * @param chiffreMin Nombre de chiffre minimum pour représenter l'entier
     * @return Chaîne de caractères représentant un entier.
     */
    public static String entierATexteMin(final int entier, final int chiffreMin) {
        final StringBuffer buf = new StringBuffer();
        if (entier < 0) {
            buf.append('-');
        }
        for (int i = chiffreMin - 1; i > 0; --i) {
            if (Math.abs(entier) < Math.pow(DIZAINE, i)) {
                buf.append('0');
            }
        }
        if (entier < 0) {
            buf.append(entierATexte(entier).substring(1));
        } else {
            buf.append(entierATexte(entier));
        }

        return buf.toString();
    }

    /**
     * Obtient un nombre entier à partir d'une chaîne de caractères.
     *
     * @param pchaine Chaîne de caractères représentant un nombre entier
     * @return Nombre entier
     */
    public static int obtenirEntierAvecString(final String pchaine) {
        int entier;

        try {
            entier = Integer.parseInt(pchaine);
        } catch (NumberFormatException nfe) {
            entier = -1;
        }


        return entier;
    }
}
