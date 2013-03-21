package affaire;

import donnees.SqlObjectProvider;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import util.UtilitaireTexte;

/**
 * Classe représentant un utilisateur dans le système. Cette classe à seulement
 * un constructeur public et une classe statique ce qui lui permet de gérer la
 * validation.
 *
 * @author Vincent Fournier
 */
public final class Utilisateur {
    // <editor-fold defaultstate="collapsed" desc="Membres">

    /**
     * La valeur qui sera attribué dans le cas ou l'entrée d'une donnée
     * numérique serait vide(null).
     */
    public static final int SENTINELLE_VIDE = -1;
    /**
     * La valeur de l'id du role administrateur.
     */
    public static final int ID_ADMIN = 1;
    /**
     * Le numéro de l'utilisateur utile dans l'appelle des controlleurs à la
     * base de données.
     */
    private final transient int idUtilisateur;
    /**
     * Le numéro du role associée à l'utilisateur utile pour savoir les droits.
     */
    private final transient int idRole;
    /**
     * Le nom de l'utilisateur celui qui est utilisé quand on se connecte.
     */
    private final transient String nomUtilisateur;
    /**
     * Le nom de la personne associée à l'utilisateur.
     */
    private final transient String nom;
    /**
     * Le prénom de la personne associée à l'utilisateur.
     */
    private final transient String prenom;
    /**
     * Le mot de passe de l'utilisateur.
     */
    private final transient String motDePasse;
    /**
     * Le courriel de l'utilisateur.
     */
    private final transient String courriel;
    /**
     * Le nom du rôle de l'utilisateur.
     */
    private final transient String nomRole;
    // </editor-fold>

    /**
     * Constructeur privée de la classe Utilisateur permet d'avoir un
     * utilisateur avec les champs de base initialisé.
     *
     * @param pidUtilisateur Le numéro de l'utilisateur.
     * @param pidRole Le numéro du role de l'utilisateur.
     * @param pnomUtilisateur Le nom de connexions.
     * @param pnom Le nom de la personne associée à l'utilisateur.
     * @param pprenom Le prénom de la personne.
     * @param pmotDePasse Le mot de passe du compte.
     * @param pcourriel Le courriel de l'utilisateur.
     */
    public Utilisateur(final int pidUtilisateur, final int pidRole,
            final String pnomUtilisateur, final String pnom,
            final String pprenom, final String pmotDePasse,
            final String pcourriel) {
        this.idUtilisateur = pidUtilisateur;
        this.idRole = pidRole;
        this.nomRole = Role.getRole(this.idRole).getNomRole();
        this.nomUtilisateur = pnomUtilisateur;
        this.nom = pnom;
        this.prenom = pprenom;
        this.motDePasse = pmotDePasse;
        this.courriel = pcourriel;
    }

    // <editor-fold defaultstate="collapsed" desc="Getter">
    /**
     * Getter pour le numéro d'utilisateur.
     *
     * @return idUtilisateur.
     */
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * Getter pour le numéro du role.
     *
     * @return Le numéro du role.
     */
    public int getIdRole() {
        return idRole;
    }

    /**
     * Getter pour le nom de l'utilisateur.
     *
     * @return Le nom de l'utilisateur.
     */
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    /**
     * Getter pour le nom de la personne.
     *
     * @return Le nom de l'utilisateur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter pour le prénom.
     *
     * @return Le prénom.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Getter pour le mot de passe.
     *
     * @return Le mot de passe.
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * Getter pour le courriel.
     *
     * @return Le courriel.
     */
    public String getCourriel() {
        return courriel;
    }

    /**
     * Getter pour le nomRole.
     *
     * @return Le nom du rôle.
     */
    public String getNomRole() {
        return nomRole;
    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Méthodes Static">

    /**
     * Retourne la liste de tout les utilisateurs.
     *
     * @return List d'utilisateurs.
     */
    public static List<Utilisateur> getUtilisateurs() {
        return SqlObjectProvider.getInstance().getUtilisateurs();
    }

    /**
     * Retourne l'utilisateur avec le nom d'utilisateur.
     *
     * @param pnomUtilisateur Le nom d'utilisateur
     * @return L'utilisateur avec le nom ou null si inexistant.
     */
    public static Utilisateur getUtilisateurString(final String pnomUtilisateur) {
        return SqlObjectProvider.getInstance().getUtilisateur(pnomUtilisateur);
    }

    /**
     * Retourne l'utilisateur avec le id.
     *
     * @param pid Le numero id
     * @return L'utilisateur avec le nom ou null si inexistant.
     */
    public static Utilisateur getUtilisateur(final int pid) {
        return SqlObjectProvider.getInstance().getUtilisateur(pid);
    }

    /**
     * Appelle le dal pour qu'il supprimer l'utilisateur à l'id spécifié dans la
     * base de données.
     *
     * @param pid Le id de l'utilisateur à supprimer
     * @return Si la suppression à été réussi.
     */
    public static boolean supprimerUtilisateur(final int pid) {
        return SqlObjectProvider.getInstance().supprimerUtilisateur(pid);
    }

    /**
     * Appelle le dal pour qu'il modifie l'utilisateur à l'id spécifié avec les
     * informations passé en paramètre.
     *
     * @param putilisateur Les nouvelles informations sur l'utilisateur.
     * @return si la modification à réussit.
     */
    public static boolean modifierUtilisateur(final Utilisateur putilisateur) {
        return SqlObjectProvider.getInstance()
                .modifierUtilisateur(putilisateur);
    }

    /**
     * Appelle le dal pour qu'il insere l'utilisateur passé en paramètre.
     *
     * @param putilisateur L'utilisateur à ajouter dans la base de données.
     * @return Si l'insertion à réussit.
     */
    public static boolean insererUtilisateur(final Utilisateur putilisateur) {
        return SqlObjectProvider.getInstance()
                .insererUtilisateur(putilisateur);
    }

    /**
     * Recoit un nom d'utilisateur et un nom de droits et retourne si
     * l'utilisateur à le droit.
     *
     * @param pnomUtilisateur Le nom d'utilisateur
     * @param pnomDroits Le nom du droits à tester
     * @return Si l'utilisateur à le droits
     */
    public static Boolean aDroitsUtilisateur(final String pnomUtilisateur,
            final String pnomDroits) {
        final List<String> droits = SqlObjectProvider.getInstance().
                getDroitsUtilisateurs(pnomUtilisateur);

        return droits.contains(pnomDroits);
    }

    /**
     * Recoit un utilisateur afin de valider les attributs le composant et
     * rattacher une erreur pour chancun des attributs trouvé invalide.
     *
     * @param utilisateur L'objet utilisateur à valider.
     *
     * @return Un map vide si l'utilisateur est valide et un map contenant les
     * erreurs ratachées dans le cas contraire.
     */
    public static ConcurrentHashMap<String, Object> valide(final Utilisateur utilisateur) {
        final ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();

        if (utilisateur.idRole == SENTINELLE_VIDE) {
            map.put("erreurIdRole", "- Un rôle doit être selectionné");
        }

        verifierChampsTexte(utilisateur, map);

        if (utilisateur.idUtilisateur == 0 && getUtilisateurString(
                utilisateur.nomUtilisateur) != null) {
            map.put("erreurNomUtilisateurPris", "- Ce nom d'utilisateur est déjà utilisé");
        }

        if (utilisateur.idUtilisateur != 0 && !utilisateur.nomUtilisateur.
                isEmpty() && (getUtilisateurString(utilisateur.nomUtilisateur)
                != null && getUtilisateurString(utilisateur.nomUtilisateur).idUtilisateur
                != utilisateur.idUtilisateur)) {
            map.put("erreurNomUtilisateurPris", "- Ce nom d'utilisateur est déjà utilisé");
        }

        return map;
    }

    /**
     * Recoit un utilisateur afin de valider les attributs texte et rattacher
     * une erreur pour chancun des attributs trouvé invalide.
     *
     * @param utilisateur L'objet utilisateur à valider.
     * @param map La liste d'erreur qui sera modifier s'il y a lieu.
     */
    private static void verifierChampsTexte(final Utilisateur utilisateur,
            final ConcurrentHashMap<String, Object> map) {
        if (!utilisateur.nom.matches(UtilitaireTexte.EXPRESSION_TEXT)) {
            map.put("erreurNom", "- Le nom contient un nombre de caractères invalide");
        }

        if (!utilisateur.nomUtilisateur.matches(UtilitaireTexte.EXPRESSION_TEXT)) {
            map.put("erreurNomUtilisateur", "- Le nom d'utilisateur contient un nombre de caractères invalide");
        }

        if (!utilisateur.prenom.matches(UtilitaireTexte.EXPRESSION_TEXT)) {
            map.put("erreurPrenom", "- Le prénom contient un nombre de caractères invalide");
        }

        if (!utilisateur.courriel.matches(UtilitaireTexte.EXPRESSION_EMAIL)) {
            map.put("erreurCourriel", "- Le courriel contient un nombre de caractères invalide");
        }

        if (!utilisateur.motDePasse.matches(UtilitaireTexte.EXPRESSION_MDP)) {
            map.put("erreurMotDePasse", "- Le mot de passe doit être formé de 5 à 10 caractères (sans espaces).");
        }
    }
    // </editor-fold>
}
