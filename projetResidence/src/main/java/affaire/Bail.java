package affaire;

import donnees.SqlObjectProvider;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import util.UtilitaireDate;

/**
 * Classe représentant l'objet d'affaire bail dans le système.
 *
 * @author Vincent Fournier
 */
public class Bail {

    /**
     * Nombre de jour dans une année bissextile.
     */
    private static final int NBR_JOUR_ANNEE_BIS = 366;
    /**
     * Le numéro du bail.
     */
    private final transient int idBail;
    /**
     * Le numéro de l'appartement.
     */
    private final transient int idAppartement;
    /**
     * Le mois du début du bail.
     */
    private final transient String dateDebut;
    /**
     * Le mois de la fin du bail.
     */
    private final transient String dateFin;
    /**
     * Le dernier mois qui à été acquitté.
     */
    private final transient String dernierMois;
    /**
     * Le montant mensuel du loyer.
     */
    private final transient double montantLoyer;
    /**
     * Identifiant du locataire.
     */
    private final transient int idLocataire;
    /**
     * Identifiant du locataire secondaire.
     */
    private final transient int idLocataireSecondaire;
    /**
     * Indicateur de locataire signataire.
     */
    private final transient boolean estLocataireSignataire;

    /**
     * Getter du idLocataire.
     *
     * @return idLocataire
     */
    public int getIdLocataire() {
        return idLocataire;
    }

    /**
     * Getter du idLocataireSecondaire.
     *
     * @return idLocataireSecondaire
     */
    public int getIdLocataireSecondaire() {
        return idLocataireSecondaire;
    }

    /**
     * Getter de estLocataireSignataire.
     *
     * @return estLocataireSignataire
     */
    public boolean isEstLocataireSignataire() {
        return estLocataireSignataire;
    }
    /**
     * Commentaire quelconque sur le bail.
     */
    private final transient String commentaire;

    /**
     * Constructeur de base d'un bail.
     *
     * @param pidBail Le numéro du bail
     * @param pidAppartement Le numéro de l'appartement relié
     * @param pdateDebut Le mois de début
     * @param pdateFin Le mois de fin
     * @param pdernierMois Le dernier mois
     * @param pmontantLoyer Le montant mensuel
     * @param pcommentaire Commentaire quelconque concernant le bail.
     * @param pidLocataire Identifiant du locataire
     * @param pidLocataireSecondaire Identifiant du locataire secondaire
     * @param pestLocataireSignataire Indique qu'il s'agit de locataire
     * signataire.
     */
    public Bail(final int pidBail, final int pidAppartement,
            final String pdateDebut, final String pdateFin,
            final String pdernierMois, final double pmontantLoyer,
            final String pcommentaire, final int pidLocataire,
            final int pidLocataireSecondaire, final boolean pestLocataireSignataire) {
        this.idBail = pidBail;
        this.idAppartement = pidAppartement;
        this.dateDebut = pdateDebut;
        this.dateFin = pdateFin;
        this.dernierMois = pdernierMois;
        this.montantLoyer = pmontantLoyer;
        this.commentaire = pcommentaire;
        this.idLocataire = pidLocataire;
        this.idLocataireSecondaire = pidLocataireSecondaire;
        this.estLocataireSignataire = pestLocataireSignataire;
    }

    // <editor-fold defaultstate="collapsed" desc="Getter">
    /**
     * Getter de idBail.
     *
     * @return le id de l'objet bail courrant.
     */
    public final int getIdBail() {
        return idBail;
    }

    /**
     * Getter de idAppartement.
     *
     * @return le id de l'appartement de l'objet bail courrant.
     */
    public final int getIdAppartement() {
        return idAppartement;
    }

    /**
     * Getter du mois de départ.
     *
     * @return la date de debut de l'objet bail courrant.
     */
    public final String getDateDebut() {
        return dateDebut;
    }

    /**
     * Getter du mois de fin.
     *
     * @return la date de fin de l'objet bail courrant.
     */
    public final String getDateFin() {
        return dateFin;
    }

    /**
     * Retourne le dernier mois qui a été acquitté.
     *
     * @return Le dernier mois qui a été acquitté.
     */
    public final String getDernierMois() {
        return dernierMois;
    }

    /**
     * Getter de montantLoyer.
     *
     * @return le montant du loyer de l'objet bail courrant.
     */
    public final double getMontantLoyer() {
        return montantLoyer;
    }

    /**
     * Getter du commentaire du bail.
     *
     * @return Le commentaire.
     */
    public final String getCommentaire() {
        return commentaire;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Méthodes publics">
    /**
     * S'assure que le bail passé par parametre et le bail courrant sont
     * identiques.
     *
     * @param pbail Le bail à vérifier.
     * @return Vrai si les deux objets sont identiques.
     */
    public final boolean egale(final Bail pbail) {
        return (this.idBail == pbail.idBail
                && this.idAppartement == pbail.idAppartement
                && this.dateDebut.equals(pbail.dateDebut)
                && this.dateFin.equals(pbail.dateFin)
                && this.dernierMois.equals(pbail.dernierMois)
                && this.montantLoyer == pbail.montantLoyer
                && this.commentaire.equals(pbail.commentaire)
                && this.idLocataire == pbail.idLocataire
                && this.idLocataireSecondaire == pbail.idLocataireSecondaire
                && this.estLocataireSignataire == pbail.estLocataireSignataire);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Méthodes statics">
    /**
     * S'assure que le bail reçu en paramètre dans la base de données en
     * appelant la fonction adéquate dans le SqlObjectProvider.
     *
     * @param pbail Le Bail à insérer dans la base de données.
     * @return Vrai Si la valeur à été insérer dans la base de données.
     */
    public static boolean insererBail(final Bail pbail) {
        return SqlObjectProvider.getInstance().insererBail(pbail);
    }

    /**
     * Retourne toutes les Baux contenues dans la base de données en appelant la
     * fonction adéquate dans le SqlObjectProvider.
     *
     * @return Toutes les baux dans la base de données.
     */
    public static List<Bail> getBails() {
        return SqlObjectProvider.getInstance().getBails();
    }

    /**
     * Appelle le SqlObjectProvider pour avoir le bail avec le id spécifié en
     * paramètre.
     *
     * @param pid Le numéro de l'Id du bail désiré.
     * @return le bail ou null si inexistant.
     */
    public static Bail getBail(final int pid) {
        return SqlObjectProvider.getInstance().getBail(pid);
    }

    /**
     * S'assure que le bail passé en paramètre soit modifier dans la base de
     * données en appelant la fonction adéquate dans le SqlObjectProvider.
     *
     * @param pbail Le bail à modifier
     * @return Vrai si une modification à été effectué dans la base de données.
     */
    public static boolean modifierBail(final Bail pbail) {
        return SqlObjectProvider.getInstance().modifierBail(pbail);
    }

    /**
     * Supprime le bail dans la base de données avec le Id selectionné en
     * appelant la fonction adéquate dans le SqlObjectProvider.
     *
     * @param pid Le Id de le bail que l'on veut supprimer.
     * @return Si une suppression à été effectué dans la base de données.
     */
    public static boolean supprimerBail(final int pid) {
        return SqlObjectProvider.getInstance().supprimerBail(pid);
    }

    /**
     * S'assure que tous les champs ayant certaines contraintes de valeur (ne
     * pouvant pas avoir comme valeur nulle par exemple) est retourne une liste
     * d'erreur.
     *
     * @param pbail Le bail à valider.
     * @param pid Identifiant du bail.
     * @return La liste des erreurs.
     */
    public static ConcurrentHashMap<String, Object> valide(final Bail pbail, final int pid) {
        final ConcurrentHashMap<String, Object> erreur = new ConcurrentHashMap<String, Object>();

        // Le id de l'appartement doit être pas égale à la sentinelle et présent dans la base de données.
        if (pbail.idAppartement == -1) {
            erreur.put("errorNoAppartement", "- Veuillez entrer un numéro d'appartement valide.");
        } else if (Appartement.getAppartement(pbail.idAppartement) == null) {
            erreur.put("errorNoAppartement", "- Le numéro d'appartement spécifié n'existe pas.");
        }

        // Date de début doit être valide.
        if (pbail.dateDebut == null || !UtilitaireDate.dateValide(pbail.dateDebut)) {
            erreur.put("errorDateDebut", "- Veuillez entrer la date de début dans le format MM/JJ/AAAA.");
        }

        // La date de fin doit être valide et après la date de début en plus de ne pas être à plus de 365 jours de
        // la date de commencement du bail.
        if (pbail.dateFin == null || !UtilitaireDate.dateValide(pbail.dateFin)) {
            erreur.put("errorDateFin", "- Veuillez entrer la date de fin dans le format MM/JJ/AAAA.");
        } else if (!UtilitaireDate.dateAnterieure(pbail.dateDebut, pbail.dateFin)) {
            erreur.put("errorDateFin", "- Veuillez entrer une date de fin postérieur à la date de début.");
        } else if (UtilitaireDate.nombreJourEntre(pbail.dateDebut, pbail.dateFin) >= NBR_JOUR_ANNEE_BIS) {
            erreur.put("errorDateFin", "- Il ne peut pas avoir plus d'un ans entre le début et la fin du bail.");
        }

        // Le montant
        if (pbail.montantLoyer <= 0) {
            erreur.put("errorMontantLoyer", "- Le montant du loyer doit être valide.");
        }

        // Le commentaire n'a aucune validation.

        // Le id du premier locataire doit être présent dans la base de données.
        if (pbail.idLocataire == -1) {
            erreur.put("errorLocataire1", "- Le locataire doit être sélectionné.");
        } else if (Resident.getResident(pbail.idLocataire) == null) {
            erreur.put("errorLocataire1", "- Veuillez sélectionner un locataire valide.");
        }

        // Le id du second locataire doit être présent dans la base de données.
        if (pbail.idLocataireSecondaire != -1 && Resident.getResident(pbail.idLocataireSecondaire) == null) {
            erreur.put("errorLocataire2", "- Veuillez sélectionner un colocataire valide.");
        }

        // S'il n'y aucune erreur à la saisie (la date, résidents, appartements sont valide).
        if (erreur.isEmpty()) {
            // On prend tout les baux...
            final List<Bail> baux = getBails();

            for (Bail bail : baux) {
                // Si la date choisi correspond à un bail.
                if (pid != bail.getIdBail()
                        && (UtilitaireDate.dateDansIntervalle(pbail.dateDebut, bail.dateDebut, bail.dateFin)
                        || UtilitaireDate.dateDansIntervalle(pbail.dateFin, bail.dateDebut, bail.dateFin)
                        || UtilitaireDate.dateDansIntervalle(bail.dateDebut, pbail.dateDebut, pbail.dateFin)
                        || UtilitaireDate.dateDansIntervalle(bail.dateFin, pbail.dateDebut, pbail.dateFin))) {
                    if (bail.idAppartement == pbail.idAppartement) {
                        erreur.put("errorNoAppartement",
                                "- L'appartement " + Appartement.getAppartement(pbail.idAppartement).getNoAppartement()
                                + " n'est pas libre du " + bail.getDateDebut() + " au " + bail.getDateFin() + ".");
                    }

                    if (bail.idLocataire == pbail.idLocataire || bail.idLocataireSecondaire == pbail.idLocataire) {
                        erreur.put("errorLocataire1",
                                "- Le locataire " + Resident.getResident(pbail.idLocataire).getPrenom() + " "
                                + Resident.getResident(pbail.idLocataire).getNom() + " à déjà un bail.");
                    }

                    if (bail.idLocataire == pbail.idLocataireSecondaire
                            || bail.idLocataireSecondaire == pbail.idLocataireSecondaire) {
                        erreur.put("errorLocataire2",
                                "- Le locataire " + Resident.getResident(pbail.idLocataireSecondaire).getPrenom() + " "
                                + Resident.getResident(pbail.idLocataireSecondaire).getNom() + " à déjà un bail.");
                    }
                }
            }
        }

        return erreur;
    }
    // </editor-fold>
}
