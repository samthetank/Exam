package controleur;

import affaire.Utilisateur;
import donnees.SqlObjectProvider;
import java.util.concurrent.ConcurrentHashMap;
import util.UtilitaireTexte;

/**
 * Controleur utilisateur.
 *
 * @author Sam
 */
public class ControleurUtilisateur extends AbstractControleurFormulaire {

    /**
     * Constante champs role.
     */
    private static final String ID_ROLE = "role";
    /**
     * Constante champs nomUtilisateur.
     */
    private static final String NOM_UTILISATEUR = "nomUtilisateur";
    /**
     * Constante champs nom.
     */
    private static final String NOM = "nom";
    /**
     * Constante champs prenom.
     */
    private static final String PRENOM = "prenom";
    /**
     * Constante du nom de champ motDePasse.
     */
    private static final String MOT_DE_PASSE = "motDePasse";
    /**
     * Constante du nom de champ courriel.
     */
    private static final String COURRIEL = "courriel";

    @Override
    protected void initialiserControleur() {
        setPageRetourForm("app/ListeUtilisateurs/Utilisateur");
        setPageRetourListe("ListeUtilisateurs");
        setNomTable(Utilisateur.class.getSimpleName());
        setOnglet("listeUtilisateurs");
    }

    @Override
    protected final boolean executeAjouter() {
        // Set le titre
        getRequete().setAttribute("titre",
                "Liste utilisateur - Ajout d'un utilisateur");
        getRequete().setAttribute("page", getOnglet());
        // Peuple les champs du formulaire
        getRequete().setAttribute(ID_ROLE, getRequete().getParameter(ID_ROLE));
        getRequete().setAttribute(NOM_UTILISATEUR, getRequete().getParameter(NOM_UTILISATEUR));
        getRequete().setAttribute(NOM, getRequete().getParameter(NOM));
        getRequete().setAttribute(PRENOM, getRequete().getParameter(PRENOM));
        getRequete().setAttribute(MOT_DE_PASSE, getRequete().getParameter(MOT_DE_PASSE));
        getRequete().setAttribute(COURRIEL, getRequete().getParameter(COURRIEL));

        int idRole;
        if (getRequete().getParameter(ID_ROLE) != null
                && getRequete().getParameter(ID_ROLE).matches(UtilitaireTexte.EXPRESSION_0_9)) {
            idRole = Integer.parseInt(
                    getRequete().getParameter(ID_ROLE));
        } else {
            idRole = Utilisateur.SENTINELLE_VIDE;
        }

        // On essaie de créer l'utilisateur avec les données de la page.
        final Utilisateur utilisateur = new Utilisateur(0,
                idRole,
                getRequete().getParameter(NOM_UTILISATEUR),
                getRequete().getParameter(NOM),
                getRequete().getParameter(PRENOM),
                getRequete().getParameter(MOT_DE_PASSE),
                getRequete().getParameter(COURRIEL));

        final ConcurrentHashMap<String, Object> erreur = Utilisateur.valide(utilisateur);

        boolean estValide = erreur.isEmpty();
        // Si l'inscription est non nulle, donc valide
        if (estValide) {
            estValide = Utilisateur.insererUtilisateur(utilisateur);
            if (estValide) {
                setValeur(SqlObjectProvider.getInstance().objetEnString(utilisateur));
            }
            // On en a finit avec l'inscription !
        } else {
            getRequete().setAttribute("erreur", "error");
            getRequete().setAttribute("listeErreur", erreur);
        }
        return estValide;
    }

    @Override
    protected void executeRemplirForm(final String pid) {
        // Set le titre
        getRequete().setAttribute("titre",
                "Liste utilisateurs - Mise à jour d'un utilisateur");

        // Get l'inscription pour fill le formulaire
        remplirAttributs(Integer.parseInt(pid));
    }

    @Override
    protected boolean executeMettreAJour(final String pid) {
        getRequete().setAttribute("titre",
                "Liste utilisateur - Mise à jour d'un utilisateur");

        // Get l'inscription pour fill le formulaire
        remplirAttributs(Integer.parseInt(pid));

        // Assigne le nom d'utilisateur avec le id si null ou introuvé
        String nomUtilisateur;
        if (getRequete().getParameter(NOM_UTILISATEUR) == null) {
            nomUtilisateur = Utilisateur.getUtilisateur(Integer.parseInt(pid)).getNomUtilisateur();
        } else {
            nomUtilisateur = getRequete().getParameter(NOM_UTILISATEUR);
        }

        int idRole;
        if (getRequete().getParameter(ID_ROLE) != null
                && getRequete().getParameter(ID_ROLE).matches(UtilitaireTexte.EXPRESSION_0_9)) {
            idRole = Integer.parseInt(getRequete().getParameter(ID_ROLE));
        } else {
            idRole = Utilisateur.getUtilisateur(Integer.parseInt(pid)).getIdRole();
        }

        final Utilisateur utilisateur = new Utilisateur(
                Integer.parseInt(pid),
                idRole,
                nomUtilisateur,
                getRequete().getParameter(NOM),
                getRequete().getParameter(PRENOM),
                getRequete().getParameter(MOT_DE_PASSE),
                getRequete().getParameter(COURRIEL));

        final ConcurrentHashMap<String, Object> erreur = Utilisateur.valide(utilisateur);

        boolean estValide = erreur.isEmpty();
        // Si l'inscription est non nulle, donc valide
        if (estValide) {
            estValide = Utilisateur.modifierUtilisateur(utilisateur);
            if (estValide) {
                setValeur(SqlObjectProvider.getInstance().objetEnString(utilisateur));
            }
            // On en a finit avec l'inscription !
        } else {
            getRequete().setAttribute("erreur", "error");
            getRequete().setAttribute("listeErreur", erreur);
        }
        return estValide;
    }

    /**
     * Assigne les attributs de la getRequete() selon le id passé en paramètres.
     *
     * @param pid Le id de l'objet dont les attributs peuplerons le formulaire
     */
    private void remplirAttributs(final int pid) {

        final Utilisateur utilisateur = Utilisateur.getUtilisateur(pid);

        setAncienneValeur(SqlObjectProvider.getInstance().objetEnString(utilisateur));
        // Peuple les champs du formulaire
        getRequete().setAttribute(ID_ROLE, utilisateur.getIdRole());
        getRequete().setAttribute(NOM_UTILISATEUR, utilisateur.
                getNomUtilisateur());
        getRequete().setAttribute(NOM, utilisateur.getNom());
        getRequete().setAttribute(PRENOM, utilisateur.getPrenom());
        getRequete().setAttribute(MOT_DE_PASSE, utilisateur.getMotDePasse());
        getRequete().setAttribute(COURRIEL, utilisateur.getCourriel());
    }

    // <editor-fold defaultstate="collapsed" desc="UnsupportedOperation">
    @Override
    protected final void executeActionAlternative1() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void executeActionAlternative2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    //</editor-fold>
}
