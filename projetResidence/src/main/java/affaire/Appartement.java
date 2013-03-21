package affaire;

import donnees.SqlObjectProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.UtilitaireEntier;

/**
 * Classe représentant l'objet d'affaire appartement dans le système.
 *
 * @author 1399017
 */
public class Appartement {

    /**
     * La valeur qui sera attribué dans le cas ou l'entrée d'une donnée
     * numérique serait vide(null).
     */
    public static final int SENTINELLE_VIDE = -1;
    /**
     * Numéro d'appartement maximum.
     */
    private static final int NUMERO_APPARTEMENT_MAX = 400;
    /**
     * Nombre de caractères maximum pour une description.
     */
    private static final int NBR_CHAR_MAX_DESCRIPTION = 250;
    /**
     * Identifiant de l'appartement.
     */
    private transient int idAppartement;
    /**
     * Numéro de l'appartement.
     */
    private final transient int noAppartement;
    /**
     * Étage de l'appartement.
     */
    private final transient String etage;
    /**
     * Phase.
     */
    private final transient String phase;
    /**
     * Dimension.
     */
    private final transient String dimension;
    /**
     * Nombre de pièces.
     */
    private final transient String nbPieces;
    /**
     * Description.
     */
    private final transient String description;

    /**
     * Constructeur de base d'un Appartement.
     *
     * @param pidAppartement Identifiant de l'appartement.
     * @param pnoAppartement Numéro de l'appartement.
     * @param petage Étage de l'appartement.
     * @param pphase Phase.
     * @param pdimension Dimension.
     * @param pnbPieces Nombre de pièces.
     * @param pdescription Description.
     */
    public Appartement(final int pidAppartement, final int pnoAppartement, final String petage, final String pphase,
            final String pdimension, final String pnbPieces, final String pdescription) {
        this.idAppartement = pidAppartement;
        this.noAppartement = pnoAppartement;
        this.etage = petage;
        this.phase = pphase;
        this.dimension = pdimension;
        this.nbPieces = pnbPieces;
        this.description = pdescription;
    }

    // <editor-fold defaultstate="collapsed" desc="Getter">
    /**
     * Getter de idAppartement.
     *
     * @return l'id de l'objet Appartement courant.
     */
    public int getIdAppartement() {
        return idAppartement;
    }

    /**
     * Getter de noAppartement.
     *
     * @return le noAppartement de l'objet Appartement courant.
     */
    public int getNoAppartement() {
        return noAppartement;
    }

    /**
     * Getter de etage.
     *
     * @return l'étage de l'objet Appartement courant.
     */
    public String getEtage() {
        return etage;
    }

    /**
     * Getter de phase.
     *
     * @return la phase de l'objet Appartement courant.
     */
    public String getPhase() {
        return phase;
    }

    /**
     * Getter de dimension.
     *
     * @return la dimension de l'objet Appartement courant.
     */
    public String getDimension() {
        return dimension;
    }

    /**
     * Getter de nbPièces.
     *
     * @return le nombre de pièces de l'objet Appartement courrant.
     */
    public String getNbPieces() {
        return nbPieces;
    }

    /**
     * Getter de description.
     *
     * @return la description de l'objet Appartement courant.
     */
    public String getDescription() {
        return description;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Méthodes publics">
    /**
     * Supprime l'Appartement dans la base de données via la fonction membre
     * static de supression.
     *
     * @return vrai si une suppression a été effectuée dans la base de données.
     */
    public boolean supprimer() {
        final boolean supprime = Appartement.supprimerAppartement(this.getIdAppartement());
        if (supprime) {
            this.idAppartement = 0;
        }
        return supprime;
    }

    /**
     * S'assure que l'Appartement soit modifié dans la base de données via la
     * fonction membre static de modification.
     *
     * @return vrai si une modification a été effectuée dans la base de données.
     */
    public boolean modifier() {
        return Appartement.modifierAppartement(this);
    }

    /**
     * S'assure que l'Appartement passé en paramètre et l'Appartement courant
     * sont identiques.
     *
     * @param pappartement Appartement à comparer.
     * @return vrai si les deux objets sont identiques.
     */
    public boolean egale(final Appartement pappartement) {
        return (this.idAppartement == pappartement.idAppartement
                && this.noAppartement == pappartement.noAppartement
                && this.etage.equals(pappartement.etage)
                && this.phase.equals(pappartement.phase)
                && this.dimension.equals(pappartement.dimension)
                && this.nbPieces.equals(pappartement.nbPieces)
                && this.description.equals(pappartement.description));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Méthodes statics">
    /**
     * S'assure que l'Appartement reçu en paramètre est bien inséré dans la base
     * de données en appelant la fonction adéquate dans le SqlObjectProvider.
     *
     * @param pappartement L'Appartement à insérer dans la base de données.
     * @return vrai si la valeur a été insérée dans la base de données.
     */
    public static boolean insererAppartement(final Appartement pappartement) {
        return SqlObjectProvider.getInstance().insererAppartement(pappartement);
    }

    /**
     * Retourne tous les appartements contenues dans la base de données en
     * appelant la fonction adéquate dans le SqlObjectProvider.
     *
     * @return Toutes les appartements dans la base de données.
     */
    public static List<Appartement> getAppartements() {
        return SqlObjectProvider.getInstance().getAppartements();
    }

    /**
     * Appelle le SqlObjectProvider pour avoir l'Appartement avec l'id spécifié
     * en paramètre.
     *
     * @param pid Le numéro de l'id de l'Appartement désiré.
     * @return l'Appartement ou null si inexistant.
     */
    public static Appartement getAppartement(final int pid) {
        return SqlObjectProvider.getInstance().getAppartement(pid);
    }

    /**
     * S'assure que l'Appartement passé en paramètre soit modifié dans la base
     * de données en appelant la fonction adéquate dans le SqlObjectProvider.
     *
     * @param pappartement Appartement à modifier.
     * @return vrai si une modification à été effectué dans la base de données.
     */
    public static boolean modifierAppartement(final Appartement pappartement) {
        return SqlObjectProvider.getInstance().modifierAppartement(pappartement);
    }

    /**
     * Supprime l'Appartement dans la base de données avec l'id selectionné en
     * appelant la fonction adéquate dans le SqlObjectProvider.
     *
     * @param pid L'id de l'Appartement que l'on veut supprimer.
     * @return vrai si une suppression a été effectuée dans la base de données.
     */
    public static boolean supprimerAppartement(final int pid) {
        return SqlObjectProvider.getInstance().supprimerAppartement(pid);
    }

    /**
     * S'assure que tous les champs ayant certaines contraintes de valeur (ne
     * pouvant pas avoir comme valeur nulle par exemple) et retourne une liste
     * d'erreur.
     *
     * @param pappartement L'appartement à valider.
     * @return La liste des erreurs.
     */
    public static Map<String, Object> valide(final Appartement pappartement) {

        final Map<String, Object> map = new HashMap<String, Object>();

        if (!UtilitaireEntier.entierDansIntervalle(pappartement.noAppartement, 0, NUMERO_APPARTEMENT_MAX)) {
            map.put("errorNoAppart", "- Le numero d'appartement doit se situer entre 0 et 400<br/>");
        }

        if (pappartement.etage == null) {
            map.put("errorEtage", "- un étage doit être selectionné<br/>");
        }

        if (pappartement.phase == null) {
            map.put("errorPhase", "- une phase doit être selectionnée<br/>");
        }

        if (pappartement.dimension == null) {
            map.put("errorDimension", "- une dimension doit être selectionnée<br/>");
        }

        if (pappartement.nbPieces == null) {
            map.put("errorPièces", "- un nombre de pièces doit être selectionné<br/>");
        }

        if (NBR_CHAR_MAX_DESCRIPTION < pappartement.description.length()) {
            map.put("errorDescription",
                    "- La description ne doit pas dépasser 250 caractères.<br/>");
        }

        return map;
    }
    // </editor-fold>
}
