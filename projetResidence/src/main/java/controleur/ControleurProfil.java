package controleur;

import affaire.Utilisateur;
import donnees.SqlObjectProvider;
import java.util.Map;

/**
 *
 * Contrôleur pour la page de profil (app/Profil/). Date: Feb 5, 2013 Time:
 * 9:03:20 PM
 *
 * @author francisbeauchamps Comment: Description goes here ...
 */
public class ControleurProfil extends AbstractControleurFormulaire {

    /**
     * Constante action.
     */
    private static final String ACTION = "action";
    /**
     * Constante champs nom_Personne_Inscrite.
     */
    private static final String NOM = "nom";
    /**
     * Constante champs prenom_Personne_Inscrite.
     */
    private static final String PRENOM = "prenom";
    /**
     * Constante champs telephone_Personne_Inscrite.
     */
    private static final String COURRIEL = "courriel";
    /**
     * Constante champs telephone_Personne_Inscrite.
     */
    private static final String MDP = "mdp";

    @Override
    protected final void initialiserControleur() {
        setPageRetourForm("app/Profil");
        setPageRetourListe("Index");
        setOnglet("profil");
        if (getRequete().getSession().getAttribute(ACTION) == null) {
            getRequete().getSession().setAttribute(ACTION, "viewModifier");
        }
        setNomTable("Utilisateur");
    }

    @Override
    protected final boolean executeAjouter() {
        return false;
    }

    @Override
    protected final void executeRemplirForm(final String pid) {
        // Set le titre
        getRequete().setAttribute(
                "titre", "Profil - Mise à jour de votre profil");

        final String nomUser = getRequete().getSession().getAttribute("usager").toString();
        final Utilisateur user = Utilisateur.getUtilisateurString(nomUser);
        final int idUser = user.getIdUtilisateur();

        // Get l'inscription pour fill le formulaire
        remplirAttributs(idUser);

        getRequete().getSession().removeAttribute(ACTION);
    }
    // nom nomutil prenom courriel mdp

    @Override
    protected final boolean executeMettreAJour(final String pid) {
        // On set le titre
        getRequete().setAttribute("titre",
                "Liste d'attente - Mise à jour d'une inscription");

        final String nomUser = getRequete().getSession().getAttribute("usager").toString();
        final Utilisateur user = Utilisateur.getUtilisateurString(nomUser);
        final int idUser = user.getIdUtilisateur();
        final String mdpUser = user.getMotDePasse();

        // Get l'inscription pour fill le formulaire
        remplirAttributs(idUser);

        String mdp;
        String txtErreurMDP = "";
        if (mdpUser.equals(getRequete().getParameter(MDP))) {
            if (getRequete().getParameter("modifmdp1").equals(getRequete().getParameter("modifmdp2"))) {
                mdp = getRequete().getParameter("modifmdp1");
            } else {
                mdp = "erreur mdp";
                txtErreurMDP = "- Mots de passe différents lors de la saisie et de la resaisie "
                        + "du nouveau mot de passe.<br/>";
            }
        } else if ("".equals(getRequete().getParameter(MDP))) {
            mdp = mdpUser;
        } else {
            mdp = "erreur mdp";
            txtErreurMDP = "- Le mot de passe renseigné lors de la saisie du mot de passe actuel est erroné.<br/>";
        }

        final Utilisateur utilisateur = new Utilisateur(
                idUser,
                user.getIdRole(),
                user.getNomUtilisateur(),
                getRequete().getParameter(NOM),
                getRequete().getParameter(PRENOM),
                mdp,
                getRequete().getParameter(COURRIEL));

        final Map<String, Object> erreur = Utilisateur.valide(utilisateur);

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
            erreur.put("erreuMDP", txtErreurMDP);
            getRequete().setAttribute("listeErreur", erreur);
            getRequete().getSession().setAttribute(ACTION, "Mettre a jour");
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
        getRequete().setAttribute(NOM,
                utilisateur.getNom());
        getRequete().setAttribute(PRENOM,
                utilisateur.getPrenom());
        getRequete().setAttribute(COURRIEL,
                utilisateur.getCourriel());
    }

    @Override
    protected final void executeActionAlternative1() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected final void executeActionAlternative2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
