package affaire;

import donnees.SqlObjectProvider;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import util.UtilitaireDate;
import util.UtilitaireTexte;

/**
 * Classe représentant l'objet d'affaire inscription dans le système.
 *
 * @author 1399017
 */
public class Inscription {

    /**
     * Le numéro de l'inscription.
     */
    private transient int idInscription;
    /**
     * Le nom de la personne inscrite.
     */
    private final transient String nom;
    /**
     * Le prenom de la personne inscrite.
     */
    private final transient String prenom;
    /**
     * Le telephone de la personne inscrite.
     */
    private final transient String telephone;
    /**
     * Le date de l'inscription.
     */
    private final transient String date;
    /**
     * Le commentaire de la personne inscrite.
     */
    private final transient String commentairePersonne;
    /**
     * Le commentaire de l'administrateur.
     */
    private final transient String commentaireAdministrateur;
    /**
     * Le commentaire de refus.
     */
    private final transient String commentaireRefus;
    /**
     * La préférence de type d'appartement de la personne inscrite.
     */
    private final transient String preferenceAppartement;
    /**
     * La préférence d'étage de la personne inscrite.
     */
    private final transient String preferenceEtage;
    /**
     * Si la personne est confirmée ou pas.
     */
    private final transient boolean confirme;
    /**
     * Le courriel de la personne inscrite.
     */
    private final transient String courriel;

    /**
     * Constructeur de base de Inscription.
     *
     * @param pidInscription numéro de l'inscription.
     * @param pnom nom de la personne inscrite.
     * @param pprenom prenom de la personne inscrite.
     * @param ptelephone telephone de la personne inscrite.
     * @param pdateInscription date de l'inscription.
     * @param pcommentairePersonne commentaire de la personne inscrite.
     * @param pcommentaireAdministrateur commentaire de l'administrateur.
     * @param pcommentaireRefus commentaire de refus.
     * @param ppreferenceAppartement préférence de type d'appartement de la
     * personne inscrite.
     * @param ppreferenceEtage préférence d'étage de la personne inscrite.
     * @param pestConfirme Si la personne est confirmée ou pas.
     * @param pcourriel courriel de la personne inscrite.
     */
    public Inscription(final int pidInscription, final String pnom, final String pprenom, final String ptelephone,
            final String pdateInscription, final String pcommentairePersonne, final String pcommentaireAdministrateur,
            final String pcommentaireRefus, final String ppreferenceAppartement, final String ppreferenceEtage,
            final boolean pestConfirme, final String pcourriel) {
        this.idInscription = pidInscription;
        this.nom = pnom;
        this.prenom = pprenom;
        this.telephone = ptelephone;
        this.date = pdateInscription;
        this.commentairePersonne = pcommentairePersonne;
        this.commentaireAdministrateur = pcommentaireAdministrateur;
        this.commentaireRefus = pcommentaireRefus;
        this.preferenceAppartement = ppreferenceAppartement;
        this.preferenceEtage = ppreferenceEtage;
        this.confirme = pestConfirme;
        this.courriel = pcourriel;
    }

    /**
     * Constructeur de copie de l'inscription.
     *
     * @param plistatt l'inscription à copier
     */
    public Inscription(final Inscription plistatt) {
        this.idInscription = plistatt.idInscription;
        this.nom = plistatt.nom;
        this.prenom = plistatt.prenom;
        this.telephone = plistatt.telephone;
        this.date = plistatt.date;
        this.commentairePersonne = plistatt.commentairePersonne;
        this.commentaireAdministrateur = plistatt.commentaireAdministrateur;
        this.commentaireRefus = plistatt.commentaireRefus;
        this.preferenceAppartement = plistatt.preferenceAppartement;
        this.preferenceEtage = plistatt.preferenceEtage;
        this.confirme = plistatt.confirme;
        this.courriel = plistatt.courriel;
    }

    // <editor-fold defaultstate="collapsed" desc="Getter">
    /**
     * Getter de idInscription.
     *
     * @return idInscription.
     */
    public final int getIdInscription() {
        return idInscription;
    }

    /**
     * Getter de nom.
     *
     * @return nom.
     */
    public final String getNom() {
        return nom;
    }

    /**
     * Getter de prenom.
     *
     * @return prenom.
     */
    public final String getPrenom() {
        return prenom;
    }

    /**
     * Getter de telephone.
     *
     * @return telephone.
     */
    public final String getTelephone() {
        return telephone;
    }

    /**
     * Getter de date.
     *
     * @return date.
     */
    public final String getDate() {
        return date;
    }

    /**
     * Getter de commentairePersonne.
     *
     * @return commentairePersonne.
     */
    public final String getCommentairePersonne() {
        return commentairePersonne;
    }

    /**
     * Getter de commentaireAdministrateur.
     *
     * @return commentaireAdministrateur.
     */
    public final String getCommentaireAdministrateur() {
        return commentaireAdministrateur;
    }

    /**
     * Getter de commentaireRefus.
     *
     * @return commentaireRefus.
     */
    public final String getCommentaireRefus() {
        return commentaireRefus;
    }

    /**
     * Getter de preferenceAppartement.
     *
     * @return preferenceAppartement.
     */
    public final String getPreferenceAppartement() {
        return preferenceAppartement;
    }

    /**
     * Getter de preferenceEtage.
     *
     * @return preferenceEtage.
     */
    public final String getPreferenceEtage() {
        return preferenceEtage;
    }

    /**
     * Getter de confirme.
     *
     * @return confirme.
     */
    public final boolean isConfirme() {
        return confirme;
    }

    /**
     * Getter de courriel.
     *
     * @return courriel.
     */
    public final String getCourriel() {
        return courriel;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Méthodes publics">
    /**
     * Supprime une inscription.
     *
     * @return vrai si l'inscription est supprimée de la base de données.
     */
    public final boolean supprimer() {
        final boolean supprime = Inscription.supprimerInscription(this.getIdInscription());
        if (supprime) {
            this.idInscription = 0;
        }
        return supprime;
    }

    /**
     * Modifie une inscription.
     *
     * @return vrai si l'inscription a été modifiée dans la base de données.
     */
    public final boolean modifier() {
        return Inscription.modifierInscription(this);
    }

    /**
     * S'assure que l'inscription passée en paramètre et l'inscription courante
     * sont identiques.
     *
     * @param pinscription Inscription à la liste d'attente.
     * @return vrai si les deux objets sont identiques.
     */
    public boolean egale(final Inscription pinscription) {
        return (this.idInscription == pinscription.idInscription
                && this.nom.equals(pinscription.nom) && this.prenom.equals(pinscription.prenom)
                && this.telephone.equals(pinscription.telephone) && this.date.equals(pinscription.date)
                && this.commentairePersonne.equals(pinscription.commentairePersonne)
                && this.commentaireAdministrateur.equals(pinscription.commentaireAdministrateur)
                && this.commentaireRefus.equals(pinscription.commentaireRefus)
                && this.preferenceAppartement.equals(pinscription.preferenceAppartement)
                && this.preferenceEtage.equals(pinscription.preferenceEtage)
                && this.confirme == pinscription.confirme && this.courriel.equals(pinscription.courriel));
    }

    @Override
    public boolean equals(final Object objet) {
        if (objet == null || objet.getClass() != this.getClass()) {
            return false;
        }

        return egale((Inscription) objet);
    }

    @Override
    public int hashCode() {
        return this.idInscription;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Méthodes statics">
    /**
     * S'assure que l'inscription reçu en paramètre est bien insérée dans la
     * base de données en appelant la fonction adéquate dans le
     * SqlObjectProvider.
     *
     * @param pinscription L'inscription à insérer dans la base de données.
     * @return vrai si la valeur a été insérée dans la base de données.
     */
    public static boolean insererInscription(final Inscription pinscription) {
        return SqlObjectProvider.getInstance().insererInscription(pinscription);
    }

    /**
     * Retourne toutes les inscriptions contenues dans la base de données en
     * appelant la fonction adéquate dans le SqlObjectProvider.
     *
     * @return Toutes les inscriptions dans la base de données.
     */
    public static List<Inscription> getInscriptions() {
        return SqlObjectProvider.getInstance().getInscriptions();
    }

    /**
     * Appelle le SqlObjectProvider pour avoir l'inscription avec l'id spécifié
     * en paramètre.
     *
     * @param pid Le numéro de l'id de l'inscription désirée.
     * @return l'inscription ou null si inexistant.
     */
    public static Inscription getInscription(final int pid) {
        return SqlObjectProvider.getInstance().getInscription(pid);
    }

    /**
     * S'assure que l'inscription passée en paramètre soit modifié dans la base
     * de données en appelant la fonction adéquate dans le SqlObjectProvider.
     *
     * @param pinscription Inscription à la liste d'attente.
     * @return vrai si une modification à été effectué dans la base de données.
     */
    public static boolean modifierInscription(final Inscription pinscription) {
        return SqlObjectProvider.getInstance().modifierInscription(pinscription);
    }

    /**
     * Supprime l'inscription dans la base de données avec l'id selectionné en
     * appelant la fonction adéquate dans le SqlObjectProvider.
     *
     * @param pid L'id de l'inscription que l'on veut supprimer.
     * @return vrai si une suppression a été effectuée dans la base de données.
     */
    public static boolean supprimerInscription(final int pid) {
        return SqlObjectProvider.getInstance().supprimerInscription(pid);
    }

    /**
     * Permet d'obtenir une inscription validée.
     *
     * @param pid numéro de l'inscription.
     * @param pnom nom de la personne inscrite.
     * @param pprenom prenom de la personne inscrite.
     * @param ptelephone telephone de la personne inscrite.
     * @param pdate date de l'inscription.
     * @param pcommentairePersonne commentaire de la personne inscrite.
     * @param pcommentaireAdministrateur commentaire de l'administrateur.
     * @param pcommentaireRefus commentaire de refus.
     * @param ppreferenceAppartement préférence de type d'appartement de la
     * personne inscrite.
     * @param ppreferenceEtage préférence d'étage de la personne inscrite.
     * @param pconfirme Si la personne est confirmée ou pas.
     * @param pcourriel courriel de la personne inscrite.
     * @return Inscription valide ou null.
     */
    public static Inscription getInscriptonValide(final int pid,
            final String pnom, final String pprenom, final String ptelephone,
            final String pdate, final String pcommentairePersonne, final String pcommentaireAdministrateur,
            final String pcommentaireRefus, final String ppreferenceAppartement, final String ppreferenceEtage,
            final boolean pconfirme, final String pcourriel) {

        if (pnom == null || pnom.isEmpty() || pprenom == null || pprenom.isEmpty()
                || ptelephone == null || ptelephone.isEmpty() || pdate == null || pdate.isEmpty()) {
            return null;
        }

        return new Inscription(pid, pnom, pprenom, ptelephone, pdate, pcommentairePersonne,
                pcommentaireAdministrateur, pcommentaireRefus, ppreferenceAppartement,
                ppreferenceEtage, pconfirme, pcourriel);
    }
    /**
     * Nombre de caractères maximum pour le champ nom.
     */
    private static final int NBR_CHAR_NOM = 50;
    /**
     * Nombre de caractères maximum pour le champ prénom.
     */
    private static final int NBR_CHAR_PRENOM = 50;
    /**
     * Nombre de caractères maximum pour les champs commentaire.
     */
    private static final int NBR_CHAR_COMMENTAIRE = 2500;
    /**
     * Nombre de caractères maximum pour le champ courriel.
     */
    private static final int NBR_CHAR_COURRIEL = 250;

    /**
     * S'assure que tous les champs ayant certaines contraintes de valeur (ne
     * pouvant pas avoir comme valeur nulle par exemple) et retourne une liste
     * d'erreur.
     *
     * @param pinscription L'inscription à valider.
     * @return La liste des erreurs.
     */
    public static ConcurrentHashMap valide(final Inscription pinscription) {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap();

        if (NBR_CHAR_NOM < pinscription.nom.length()
                || !pinscription.nom.matches(UtilitaireTexte.EXPRESSION_TEXT)) {
            map.put("erreurNom", "- le nom doit être formé de 4 à 50 "
                    + "caractères sans espaces");
        }

        if (NBR_CHAR_PRENOM < pinscription.prenom.length()
                || !pinscription.prenom.matches(UtilitaireTexte.EXPRESSION_TEXT)) {
            map.put("erreurPrénom", "- le prénom doit être "
                    + "formé de 4 à 50 caractères (sans espaces)");
        }

        if (!pinscription.telephone.matches(UtilitaireTexte.EXPRESSION_TELEPHONE)) {
            map.put("erreurTéléphone", "- le numéro de téléphone doit être "
                    + "formé de 10 à 15 caractères (sans espaces)");
        }

        if (!UtilitaireDate.dateValide(pinscription.date)) {
            map.put("erreurDate", "- La date doit être formé de"
                    + " 8 à 10 caractères (sans espaces)");
        }

        if (NBR_CHAR_COMMENTAIRE < pinscription.commentairePersonne.length()) {
            map.put("erreurCommentairePersonne",
                    "- Le commentaire de personne ne doit pas mesurer plus de 2500 caractères.");
        }

        if (NBR_CHAR_COMMENTAIRE < pinscription.commentaireAdministrateur.length()) {
            map.put("erreurCommentairePersonne",
                    "- Le commentaire d'administrateur ne doit pas mesurer plus de 2500 caractères.");
        }

        if (NBR_CHAR_COMMENTAIRE < pinscription.commentaireRefus.length()) {
            map.put("erreurCommentairePersonne",
                    "- Le commentaire de refus ne doit pas mesurer plus de 2500 caractères.");
        }

        if (!pinscription.preferenceAppartement.matches(
                UtilitaireTexte.EXPRESSION_0_9)) {
            map.put("erreurPreferenceAppartement", "- la préference d'"
                    + "appartement doit avoir une des valeurs suivantes:"
                    + "\"aucune\", \"3\", \"4\"");
        }

        if (!pinscription.preferenceEtage.matches(
                UtilitaireTexte.EXPRESSION_0_9)) {
            map.put("erreurPreferenceEtage", "- la préference d'"
                    + "étage doit avoir une des valeurs suivantes:"
                    + "\"aucune\", \"1\", \"2\", \"3\", \"4\", "
                    + "\"RC\"");
        }


        if (NBR_CHAR_COURRIEL < pinscription.courriel.length()) {
            map.put("erreurCourriel", "- le courriel doit contenir au maximum "
                    + "250 caractères");
        } else if (!pinscription.courriel.isEmpty()
                && !pinscription.courriel.matches(UtilitaireTexte.EXPRESSION_EMAIL)) {
            map.put("erreurCourriel", "- le courriel doit avoir la forme abc123@abc123.com");
        }
        return map;
    }
    // </editor-fold>
}
