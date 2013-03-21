package donnees;

/**
 *
 * @author Vincent
 */
final class Utilitaire {

    /**
     * Constructeur privée.
     */
    private Utilitaire() {
    }

    /**
     * Reçoit une string à filtrer selon la sous-chaîne(String) à rechercher
     * ainsi que le filtre à imposer lorsque la sous-chaine est trouver.
     *
     * @param chaine la chaine de caractère intiale.
     * @param souschaine la chaine à rechercher dans la chaîne initiale.
     * @param filtre la chaine qui remplacera la sous-chaîne lorsque trouver.
     *
     * @return La chaine filtrer.
     */
    public static String filtrerString(final String chaine, final String souschaine, final String filtre) {
        StringBuffer stringBuffer;
        stringBuffer = new StringBuffer();
        String[] string;
        string = chaine.split("");

        for (int i = 0; i <= chaine.length(); ++i) {
            if (string[i].equals(souschaine)) {
                stringBuffer.append(filtre);
            } else {
                stringBuffer.append(string[i]);
            }
        }

        return stringBuffer.toString();
    }
}
