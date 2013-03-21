package affaire;

/**
 * Classe représentant l'objet d'affaire droit utilisateur dans le système.
 *
 * @author 1399017
 */
public class DroitUtilisateur {

    /**
     * Identifiant du droit.
     */
    private final transient int idDroitUtilisateur;
    /**
     * Nom du droit.
     */
    private final transient String nomDroitUtilisateur;

    /**
     * Constructeur de base DroitUtilisateur.
     *
     * @param pidDroitUtilisateur Identifiant du droit
     * @param pnomDroitUtilisateur Nom du droit.
     */
    public DroitUtilisateur(final int pidDroitUtilisateur, final String pnomDroitUtilisateur) {
        this.idDroitUtilisateur = pidDroitUtilisateur;
        this.nomDroitUtilisateur = pnomDroitUtilisateur;
    }

    /**
     * Constructeur par copie DroitUtilisateur.
     *
     * @param du Droit utilisateur.
     */
    public DroitUtilisateur(final DroitUtilisateur du) {
        this.idDroitUtilisateur = du.idDroitUtilisateur;
        this.nomDroitUtilisateur = du.nomDroitUtilisateur;
    }

    /**
     * Getter de idDroitUtilisateur.
     *
     * @return idDroitUtilisateur.
     */
    public final int getIdDroitUtilisateur() {
        return idDroitUtilisateur;
    }

    /**
     * Getter nomDroitUtilisateur.
     *
     * @return nomDroitUtilisateur.
     */
    public final String getNomDroitUtilisateur() {
        return nomDroitUtilisateur;
    }
}
