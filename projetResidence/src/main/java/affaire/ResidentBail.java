package affaire;

/**
 * Classe représentant l'objet d'affaire résidentBail dans le système.
 *
 * @author 1399017
 */
public class ResidentBail {

    /**
     * L'identifiant du résident.
     */
    private final transient int idResident;
    /**
     * L'identifiant du bail.
     */
    private final transient int idBail;
    /**
     * Si le résident est responsable dans le bail.
     */
    private final transient boolean estResponsable;

    /**
     * Constructeur de base de ResidentBail.
     *
     * @param pidResident Identifiant du résident.
     * @param pidBail Identifiant du bail.
     * @param pestResponsable Si le résident est responsable du bail.
     */
    public ResidentBail(final int pidResident, final int pidBail, final boolean pestResponsable) {
        this.idResident = pidResident;
        this.idBail = pidBail;
        this.estResponsable = pestResponsable;
    }

    /**
     * Constructeur par copie de ResidentBail.
     *
     * @param resb Lien résident à bail.
     */
    public ResidentBail(final ResidentBail resb) {
        this.idResident = resb.idResident;
        this.idBail = resb.idBail;
        this.estResponsable = resb.estResponsable;
    }

    /**
     * Getter de idResident.
     *
     * @return idResident.
     */
    public final int getIdResident() {
        return idResident;
    }

    /**
     * Getter de idBail.
     *
     * @return idBail.
     */
    public final int getIdBail() {
        return idBail;
    }

    /**
     * Getter de estResponsable.
     *
     * @return estResponsable.
     */
    public final boolean getEstResponsable() {
        return estResponsable;
    }
}
