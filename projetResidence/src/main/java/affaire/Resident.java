package affaire;

import donnees.SqlObjectProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.UtilitaireDate;
import util.UtilitaireTexte;

/**
 * Classe représentant l'objet d'affaire résident dans le système.
 *
 * @author 1399017
 */
public class Resident extends AbstractObjetAffaire {

    /**
     * Nombre de caractères maximum pour le champ nom.
     */
    private static final int NBR_CHAR_NOM = 50;
    /**
     * Nombre de caractères maximum pour le champ prénom.
     */
    private static final int NBR_CHAR_PRENOM = 50;
    /**
     * Nombre de caractères maximum pour les champs téléphones.
     */
    private static final int NBR_CHAR_TEL = 15;
    /**
     * Nombre de caractères maximum pour les champs commentaires.
     */
    private static final int NBR_CHAR_COMM = 2500;
    /**
     * Nombre de caractères maximum pour le champ nom véhicule.
     */
    private static final int NBR_CHAR_VEHICULE = 50;
    /**
     * Nombre de caractères maximum pour le champ plaque d'immatriculation.
     */
    private static final int NBR_CHAR_PLAQUE = 10;
    /**
     * Fin de ligne pour les erreurs de nombres de caractères.
     */
    private static final String FIN_LGN_NBR_CHAR = " caractères<br>";
    /**
     * Identifiant unique du résident.
     */
    private transient int idResident;
    /**
     * Nom du résident.
     */
    private final transient String nom;
    /**
     * Prénom du résident.
     */
    private final transient String prenom;
    /**
     * Numéro de téléphone du résident.
     */
    private final transient String telephone;
    /**
     * Numéro de téléphone secondaire du résident.
     */
    private final transient String telephoneSec;
    /**
     * Titre du résident. M. ou Mme.
     */
    private final transient String titreResident;
    /**
     * Date de naissance du résident.
     */
    private final transient String dateNaissance;
    /**
     * Date d'arrivée du résident à la résidence.
     */
    private final transient String dateArrivee;
    /**
     * Commentaire à propos du résident.
     */
    private final transient String commentaire;
    /**
     * Code d'intervention en trois couleurs.
     */
    private final transient String couleurInterv;
    /**
     * Commentaire à propos du code d'intervention.
     */
    private final transient String commentaireInterv;
    /**
     * Commentaire à propos de plaintes.
     */
    private final transient String commentPlainte;
    /**
     * Modèle du véhicule du résident.
     */
    private final transient String nomVehicule;
    /**
     * Immatriculation du véhicule du résident.
     */
    private final transient String plaqueImmatricul;

    /**
     * Constructeur de l'objet résident.
     *
     * @param pidResident Identifiant du résident
     * @param pnomResident Nom du résident
     * @param pprenomResident Prénom du résident
     * @param ptelephone Numéro de téléphone du résident
     * @param ptelephoneSec Numéro de téléphone secondaire du résident
     * @param ptitreResident Titre du résident
     * @param pdateNaissance Date de naissance du résident
     * @param pdateArrivee Date d'arrivée du résident à la résidence.
     * @param pcommentaire Commentaire à propos du résident.
     * @param pcouleurInterv Code d'intervention en trois couleur.
     * @param pcommentInterv Commentaire à propos du code d'intervention.
     * @param pcommentPlainte Commentaire à propos de plaintes.
     * @param pnomVehicule Modèle du véhicule du résident.
     * @param pplaqueImmatricul Immatriculation du véhicule du résident.
     */
    public Resident(final int pidResident, final String pnomResident,
            final String pprenomResident, final String ptelephone,
            final String ptelephoneSec,
            final String ptitreResident, final String pdateNaissance,
            final String pdateArrivee,
            final String pcommentaire,
            final String pcouleurInterv,
            final String pcommentInterv,
            final String pcommentPlainte, final String pnomVehicule,
            final String pplaqueImmatricul) {
        super();
        this.idResident = pidResident;
        this.nom = pnomResident;
        this.prenom = pprenomResident;
        this.telephone = ptelephone;
        this.telephoneSec = ptelephoneSec;
        this.titreResident = ptitreResident;
        this.dateNaissance = pdateNaissance;
        this.dateArrivee = pdateArrivee;
        this.commentaire = pcommentaire;
        this.couleurInterv = pcouleurInterv;
        this.commentaireInterv = pcommentInterv;
        this.commentPlainte = pcommentPlainte;
        this.nomVehicule = pnomVehicule;
        this.plaqueImmatricul = pplaqueImmatricul;
    }

    /**
     * Accesseur de la variable idResident.
     *
     * @return Identifiant du résident
     */
    public final int getIdResident() {
        return this.idResident;
    }

    /**
     * Accesseur de la variable nom.
     *
     * @return Nom du résident
     */
    public final String getNom() {
        return this.nom;
    }

    /**
     * Accesseur de la variable prenom.
     *
     * @return Prénom du résident
     */
    public final String getPrenom() {
        return this.prenom;
    }

    /**
     * Accesseur de la variable telephone.
     *
     * @return Numéro de téléphone du résident
     */
    public final String getTelephone() {
        return this.telephone;
    }

    /**
     * Accesseur de la variable telephoneSecondaire.
     *
     * @return Numéro de téléphone secondaire du résident
     */
    public final String getTelephoneSecondaire() {
        return this.telephoneSec;
    }

    /**
     * Accesseur de la variable titre.
     *
     * @return Titre du résident
     */
    public final String getTitreResident() {
        return this.titreResident;
    }

    /**
     * Accesseur de la variable dateNaissance.
     *
     * @return Date de naissance du résident
     */
    public final String getDateNaissance() {
        return this.dateNaissance;
    }

    /**
     * Accesseur de la variable dateArrivee.
     *
     * @return Date d'arrivée du résident à la résidence
     */
    public final String getDateArrivee() {
        return this.dateArrivee;
    }

    /**
     * Accesseur de la variable commentaire.
     *
     * @return Commentaire à propos du résident.
     */
    public final String getCommentaire() {
        return this.commentaire;
    }

    /**
     * Accesseur de la variable couleurIntervention.
     *
     * @return Code d'intervention en trois couleur.
     */
    public final String getCouleurIntervention() {
        return this.couleurInterv;
    }

    /**
     * Accesseur de la variable commentaireIntervention.
     *
     * @return Commentaire à propos du code d'intervention.
     */
    public final String getCommentaireIntervention() {
        return this.commentaireInterv;
    }

    /**
     * Accesseur de la variable commentairePlainte.
     *
     * @return Commentaire à propos de plaintes.
     */
    public final String getCommentairePlainte() {
        return this.commentPlainte;
    }

    /**
     * Accesseur de la variable nomVehicule.
     *
     * @return Modèle du véhicule du résident.
     */
    public final String getNomVehicule() {
        return this.nomVehicule;
    }

    /**
     * Accesseur de la variable plaqueImmatriculation.
     *
     * @return Immatriculation du véhicule du résident.
     */
    public final String getPlaqueImmatriculation() {
        return this.plaqueImmatricul;
    }

    // <editor-fold defaultstate="collapsed" desc="Méthodes publics">
    /**
     * Suppression du résident.
     *
     * @return Suppression réussi
     */
    @Override
    public final boolean supprimer() {
        final boolean supprime = Resident.supprimerResident(this.getIdResident());
        if (supprime) {
            this.idResident = 0;
        }
        return supprime;
    }

    /**
     * Modification du résident.
     *
     * @return Modification réussi
     */
    @Override
    public final boolean modifier() {
        return Resident.modifierResident(this);
    }

    /**
     * Vérifie si ce résident est égale à un autre.
     *
     * @param president Autre résident
     * @return Égalité des deux résident
     */
    public final boolean egale(final Resident president) {
        return (this.idResident == president.idResident
                && this.nom.equals(president.nom)
                && this.prenom.equals(president.prenom)
                && this.telephone.equals(president.telephone)
                && this.telephoneSec.equals(president.telephoneSec)
                && this.titreResident.equals(president.titreResident)
                && this.dateNaissance.equals(president.dateNaissance)
                && this.dateArrivee.equals(president.dateArrivee)
                && this.commentaire.equals(president.commentaire)
                && this.couleurInterv.equals(president.couleurInterv)
                && this.commentaireInterv.equals(president.commentaireInterv)
                && this.commentPlainte.equals(president.commentPlainte)
                && this.nomVehicule.equals(president.nomVehicule)
                && this.plaqueImmatricul.equals(president.plaqueImmatricul));
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Méthodes statics">
    /**
     * Insertion d'un résident dans la bd.
     *
     * @param president résident à insérer
     * @return Insertion réussi
     */
    public static boolean insererResident(final Resident president) {
        return SqlObjectProvider.getInstance().insererResident(president);
    }

    /**
     * Obtient la liste des résidents.
     *
     * @return Liste des résidents
     */
    public static List<Resident> getResidents() {
        return SqlObjectProvider.getInstance().getResidents();
    }

    /**
     * Obtenir un résident spécifique.
     *
     * @param pid Identifiant du résidant
     * @return Résident
     */
    public static Resident getResident(final int pid) {
        return SqlObjectProvider.getInstance().getResident(pid);
    }

    /**
     * Modification d'un résident.
     *
     * @param president Résident à modifier
     * @return Modification réussi
     */
    public static boolean modifierResident(final Resident president) {
        return SqlObjectProvider.getInstance().modifierResident(president);
    }

    /**
     * Suppression d'un résident.
     *
     * @param pid Identifiant du résident à supprimer
     * @return Suppression réussi
     */
    public static boolean supprimerResident(final int pid) {
        return SqlObjectProvider.getInstance().supprimerResident(pid);
    }

    /**
     * Recoit un resident afin de valider les attributs le composant et
     * rattacher une erreur pour chacun des attributs trouvé invalide.
     *
     * @param resident L'objet resident à valider.
     *
     * @return Un map vide si le resident est valide et un map contenant les
     * erreurs rattachées dans le cas contraire.
     */
    public static Map<String, Object> valide(final Resident resident) {
        final Map<String, Object> map = new HashMap<String, Object>();

        mapErreur(map,
                resident.nom == null
                || "".equals(resident.nom),
                "errorNom", "- Un résident doit avoir un nom.<br/>");

        mapErreur(map,
                resident.nom != null
                && NBR_CHAR_NOM < resident.nom.length(),
                "errorNom", "- Le nom du résident ne doit pas dépasser " + NBR_CHAR_NOM + FIN_LGN_NBR_CHAR);

        mapErreur(map,
                resident.nom != null
                && !resident.nom.matches(UtilitaireTexte.EXPRESSION_TEXT),
                "errorNom", "- Le nom doit être formé de 4 à "
                + NBR_CHAR_NOM + " caractères alphabétiques sans espaces.");

        mapErreur(map,
                resident.prenom == null
                || "".equals(resident.prenom),
                "errorPrenom", "- Un résident doit avoir un prénom.<br/>");

        mapErreur(map,
                resident.prenom != null
                && NBR_CHAR_PRENOM < resident.prenom.length(),
                "errorPrenom",
                "- Le prénom du résident ne doit pas dépasser " + NBR_CHAR_PRENOM + FIN_LGN_NBR_CHAR);

        mapErreur(map,
                resident.prenom != null
                && !resident.prenom.matches(UtilitaireTexte.EXPRESSION_TEXT),
                "errorPrenom", "- Le prénom doit être formé de 4 à "
                + NBR_CHAR_PRENOM + " caractères alphabétiques sans espaces.");

        mapErreur(map,
                resident.telephone == null
                || "".equals(resident.telephone),
                "errorTelephone", "- Un résident doit avoir un numéro de téléphone.<br/>");

        mapErreur(map,
                resident.telephone != null
                && NBR_CHAR_TEL < resident.telephone.length(),
                "errorTelephone",
                "- Le numéro de téléphone du résident ne doit pas dépasser " + NBR_CHAR_TEL + FIN_LGN_NBR_CHAR);

        mapErreur(map,
                resident.telephone != null
                && !resident.telephone.matches(UtilitaireTexte.EXPRESSION_TELEPHONE),
                "errorTelephone",
                "- le numéro de téléphone doit être formé de 10 à 15 caractères (sans espaces)");

        mapErreur(map,
                NBR_CHAR_TEL < resident.telephoneSec.length(),
                "errorTelephoneSecondaire",
                "- Le numéro de téléphone secondaire du résident ne doit pas dépasser "
                + NBR_CHAR_TEL + FIN_LGN_NBR_CHAR);

        mapErreur(map,
                !"".equals(resident.telephoneSec)
                && !resident.telephoneSec.matches(UtilitaireTexte.EXPRESSION_TELEPHONE),
                "errorTelephoneSecondaire",
                "- le numéro de téléphone secondaire doit être formé de 10 à 15 caractères (sans espaces)");

        mapErreur(map,
                !("M.".equals(resident.titreResident)
                || "Mme.".equals(resident.titreResident)),
                "errorTitre", "- Un résident doit avoir un titre.<br>");

        mapErreur(map,
                resident.dateArrivee == null
                || "".equals(resident.dateArrivee),
                "errorDateArrivee", "- Un résident doit avoir une date d'arrivée.<br/>");

        mapErreur(map,
                resident.dateArrivee != null
                && 0 < resident.dateArrivee.length()
                && !UtilitaireDate.dateValide(resident.dateArrivee),
                "errorDateArrivee",
                "- Un résident doit avoir une date d'arrivée valide selon le format AAAA-MM-JJ.<br>");

        mapErreur(map,
                resident.dateNaissance == null
                || "".equals(resident.dateNaissance),
                "errorDateNaissance", "- Un résident doit avoir une date de naissance.<br/>");

        mapErreur(map,
                resident.dateNaissance != null
                && 0 < resident.dateNaissance.length()
                && !UtilitaireDate.dateValide(resident.dateNaissance),
                "errorDateNaissance",
                "- Un résident doit avoir une date de naissance valide selon le format AAAA-MM-JJ.<br>");

        mapErreur(map,
                NBR_CHAR_COMM < resident.commentaire.length(),
                "errorCommentaire",
                "- La longueur du commentaire ne doit pas dépasser " + NBR_CHAR_COMM + FIN_LGN_NBR_CHAR);

        mapErreur(map,
                !("V".equals(resident.couleurInterv)
                || "J".equals(resident.couleurInterv)
                || "R".equals(resident.couleurInterv)),
                "errorCouleurIntervention", "- Un résident doit avoir une couleur d'intervention.<br/>");

        mapErreur(map,
                NBR_CHAR_COMM < resident.commentaireInterv.length(),
                "errorCommentaireIntervention",
                "- La longueur du commentaire d'intervention ne doit pas dépasser "
                + NBR_CHAR_COMM + FIN_LGN_NBR_CHAR);

        mapErreur(map,
                NBR_CHAR_COMM < resident.commentPlainte.length(),
                "errorCommentairePlainte",
                "- La longueur du commentaire de plainte ne doit pas dépasser " + NBR_CHAR_COMM + FIN_LGN_NBR_CHAR);

        mapErreur(map,
                resident.nomVehicule != null
                && NBR_CHAR_VEHICULE < resident.nomVehicule.length(),
                "errorNomVehicule",
                "- Le nom du véhicule ne doit pas dépasser " + NBR_CHAR_VEHICULE + FIN_LGN_NBR_CHAR);

        mapErreur(map,
                resident.nomVehicule != null && !"".contains(resident.nomVehicule)
                && !resident.nomVehicule.matches(UtilitaireTexte.EXPRESSION_TEXT),
                "errorNomVehicule", "- Le nom du véhicule doit être formé de 4 à "
                + NBR_CHAR_VEHICULE + " caractères alphabétiques sans espaces.");

        mapErreur(map,
                NBR_CHAR_PLAQUE < resident.plaqueImmatricul.length(),
                "errorPlaqueImmatriculation",
                "- La plaque d'immatriculation ne doit pas dépasser " + NBR_CHAR_PLAQUE + FIN_LGN_NBR_CHAR);

        return map;
    }
    // </editor-fold>
}
