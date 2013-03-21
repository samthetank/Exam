package affaire;

/**
 * Classe représentant l'objet d'affaire résidentBail dans le système.
 *
 * @author 1399017
 */
public class Role {

    /**
     * L'identifiant du rôle.
     */
    private final transient int idRole;
    /**
     * Le nom du rôle.
     */
    private final transient String nomRole;
    /**
     * La description du rôle.
     */
    private final transient String descriptionRole;

    /**
     * Constructeur de base de Role.
     *
     * @param pidRole Identifiant du role.
     * @param pnomRole Nom du role.
     * @param pdescriptionRole Description du role.
     */
    public Role(final int pidRole, final String pnomRole, final String pdescriptionRole) {
        this.idRole = pidRole;
        this.nomRole = pnomRole;
        this.descriptionRole = pdescriptionRole;
    }

    /**
     * Constructeur par copie de Role.
     *
     * @param role Role.
     */
    public Role(final Role role) {
        this.idRole = role.idRole;
        this.nomRole = role.nomRole;
        this.descriptionRole = role.descriptionRole;
    }

    /**
     * Getter de idRole.
     *
     * @return idRole.
     */
    public final int getIdRole() {
        return idRole;
    }

    /**
     * Getter de nomRole.
     *
     * @return nomRole.
     */
    public final String getNomRole() {
        return nomRole;
    }

    /**
     * Getter de descriptionRole.
     *
     * @return descriptionRole.
     */
    public final String getDescriptionRole() {
        return descriptionRole;
    }

    /**
     * Retourne le role avec le id.
     *
     * @param pid Le numero id
     * @return Le role avec le bon id ou null si inexistant.
     */
    public static Role getRole(final int pid) {
        return donnees.SqlObjectProvider.getInstance().getRole(pid);
    }
}
