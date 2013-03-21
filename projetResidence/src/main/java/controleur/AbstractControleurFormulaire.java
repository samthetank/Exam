package controleur;

import affaire.Log;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import util.UtilitaireDate;

/**
 * Définition d'un controleur de formulaire à partir du controleur abstrait.
 *
 * @author Vincent
 */
public abstract class AbstractControleurFormulaire extends AbstractControleur {

    /**
     * Constante de l'action.
     */
    private static final String ACTION = "action";
    /**
     * Constante de l'action d'ajout française.
     */
    private static final String ACTION_AJOUTER = "Ajouter";
    /**
     * Constante de l'action d'ajout anglaise.
     */
    private static final String ACTION_ADD = "Add";
    /**
     * Constante de l'action de mise à jour française.
     */
    private static final String ACTION_METRRE_A_JOUR = "Mettre a jour";
    /**
     * Constante de l'action de mise à jour anglaise.
     */
    private static final String ACTION_UPDATE = "Update";
    /**
     * Session du controleur.
     */
    private HttpSession session;
    /**
     * La page de retour vers le formulaire.
     */
    private String pageRetourForm;
    /**
     * La page de retour vers la liste.
     */
    private String pageRetourListe;
    /**
     * Le titre de la page utile pour le pattern template.
     */
    private String titrePage;
    /**
     * Le valeur ajouter, supprimer ou modifier qui sera enregistré dans le log.
     */
    private String valeur;
    /**
     * Le valeur ajouter, supprimer ou modifier qui sera enregistré dans le log.
     */
    private String nomTable;
    /**
     * Le valeur d'un objet modifier avant sa modification.
     */
    private String ancienneValeur;
    /**
     * Action alternative 1.
     */
    private String actionAlternative1;
    /**
     * Action alternative 2.
     */
    private String actionAlternative2;

    /**
     * Getter du nom de l'action alternative 1.
     *
     * @return Le nom de l'action.
     */
    public final String getActionAlternative1() {
        return actionAlternative1;
    }

    /**
     * Setter du nom l'action alternative 1.
     *
     * @param pactionAlternative1 Le nouveau nom de l'action.
     */
    public final void setActionAlternative1(final String pactionAlternative1) {
        this.actionAlternative1 = pactionAlternative1;
    }

    /**
     * Getter du nom de l'action alternative 2.
     *
     * @return Le nom de l'action.
     */
    public final String getActionAlternative2() {
        return actionAlternative2;
    }

    /**
     * Setter du nom de l'action alternative 2.
     *
     * @param pactionAlternative2 Le nom de l'action.
     */
    public final void setActionAlternative2(final String pactionAlternative2) {
        this.actionAlternative2 = pactionAlternative2;
    }

    /**
     * Retourne la variable de session.
     *
     * @return La session.
     */
    public final HttpSession getSession() {
        return session;
    }

    /**
     * Attribut le paramètre session à la session.
     *
     * @param psession La session
     */
    public final void setSession(final HttpSession psession) {
        this.session = psession;
    }

    /**
     * Retourne la page de retour pour le formulaire.
     *
     * @return La page du formulaire.
     */
    public final String getPageRetourForm() {
        return pageRetourForm;
    }

    /**
     * Setter du nom de la page de retour vers le formulaire.
     *
     * @param ppageRetourForm Le nom de la page.
     */
    public final void setPageRetourForm(final String ppageRetourForm) {
        this.pageRetourForm = ppageRetourForm;
    }

    /**
     * Getter du nom de la page de retour vers la liste de données.
     *
     * @return Le nom de la page de retour.
     */
    public final String getPageRetourListe() {
        return pageRetourListe;
    }

    /**
     * Setter du nom de la page de retour vers la liste de données.
     *
     * @param ppageRetourListe Le nom de la nouvelle page.
     */
    public final void setPageRetourListe(final String ppageRetourListe) {
        this.pageRetourListe = ppageRetourListe;
    }

    /**
     * Retourne le titre de la page.
     *
     * @return Le titre de la page.
     */
    public final String getTitrePage() {
        return titrePage;
    }

    /**
     * Attribut le paramètre titrePage au titre de la page.
     *
     * @param ptitrePage Le titre de la page qui sera attribuer.
     */
    public final void setTitrePage(final String ptitrePage) {
        this.titrePage = ptitrePage;
    }

    /**
     * Attribut le paramètre pvaleur à la valeur de l'objet manipulé qui sera
     * ensuite utilisé pour la création de log.
     *
     * @param pvaleur La valeur de l'objet qui a soit été ajouté, supprimé ou
     * modifié par un utilisateur.
     */
    public final void setValeur(final String pvaleur) {
        this.valeur = pvaleur;
    }

    /**
     * Attribut l'ancienne valeur d'un objet à l'élément.
     *
     * @param pancienneValeur L'ancienne valeur d'un objet qui a été modifié par
     * l'utilisateur.
     */
    public final void setAncienneValeur(final String pancienneValeur) {
        this.ancienneValeur = pancienneValeur;
    }

    /**
     * Attribut le paramètre pnomTable à la valeur de nomTable pour être en
     * mesure de connaître le type d'objet sur lequel l'utilisateur effectue une
     * action.
     *
     * @param pnomTable Le nom de la table qui sera affecté par l'action de
     * l'utilisateur.
     */
    public final void setNomTable(final String pnomTable) {
        this.nomTable = pnomTable;
    }

    /**
     * Initialise le controleur.
     */
    protected abstract void initialiserControleur();

    /**
     * Exécute l'action d'ajout.
     *
     * @return Boolean représentant la réussite.
     */
    protected abstract boolean executeAjouter();

    /**
     * Exectute l'action de remplir le formulaire à partir de données existante.
     *
     * @param pid Le id de l'objet qui peuplera les champs.
     */
    protected abstract void executeRemplirForm(String pid);

    /**
     * Exectute l'action alternative 2 à partir de données existante.
     */
    protected abstract void executeActionAlternative2();

    /**
     * Execute l'action de mise à jour.
     *
     * @param pid Le id de l'objet qui peuplera les champs.
     * @return Vrai ou faux dépendament s'il y a changement ou non.
     */
    protected abstract boolean executeMettreAJour(String pid);

    /**
     * Exectute l'action alternative 1 à partir de données existante.
     */
    protected abstract void executeActionAlternative1();
    /**
     * Paramètre langue.
     */
    public static final String PARAM_LANGUE = "language";

    /**
     * On override la fonction execute pour afficher le formulaire selon
     * l'action et l'id contenu dans la session.
     */
    @Override
    public final void execute() {
        this.session = getRequete().getSession();
        initialiserControleur();

        try {
            getRequete().setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ControleurAppartement.class.getName()).log(
                    Level.SEVERE, null, ex);
        }

        String action;
        if (getRequete().getParameter(ACTION) == null) {
            if (getRequete().getParameter(PARAM_LANGUE) != null
                    && session.getAttribute(PARAM_LANGUE).toString()
                    != getRequete().getParameter(PARAM_LANGUE).toString()) {
                action = "Changer la langue";
                session.setAttribute(PARAM_LANGUE, getRequete().getParameter(PARAM_LANGUE).toString());
            } else {
                action = session.getAttribute(ACTION).toString();
            }
        } else {
            action = getRequete().getParameter(ACTION).toString();
        }

        // On assigne aux membres la valeur de la requête et de la session.
        getRequete().setAttribute("contexte", getRequete().getContextPath());
        getRequete().setAttribute("titre", titrePage);
        getRequete().setAttribute("page", getOnglet());

        // On va chercher dans la session le id et l'action.
        if ("viewAjout".equals(action)) {
            // Voir le form.
            if (session.getAttribute(PARAM_LANGUE).toString().contains("fr")) {
                getRequete().setAttribute(ACTION, ACTION_AJOUTER);
                session.setAttribute(ACTION, ACTION_AJOUTER);
            } else {
                getRequete().setAttribute(ACTION, ACTION_ADD);
                session.setAttribute(ACTION, ACTION_ADD);
            }
            this.setPageRetour(pageRetourForm);
        } else if ("Annuler".equals(action) || "Cancel".equals(action)) {
            // Retourne vers la liste.
            this.setPageRetour(pageRetourListe);
        } else if (ACTION_AJOUTER.equals(action) || ACTION_ADD.equals(action)) {
            // Ajout dans la bd
            if (executeAjouter()) {
                Log.insererLog(new Log(0, "ajout", nomTable,
                        getRequete().getSession().getAttribute("usager").toString(),
                        UtilitaireDate.timeNowEnString(), valeur, "aucune"));

                session.removeAttribute("id");
                session.removeAttribute(ACTION);
                this.setPageRetour(pageRetourListe);

            } else {
                this.setPageRetour(pageRetourForm);
            }
        } else if ("viewModifier".equals(action)) {
            // Voir pour modifier
            executeRemplirForm(
                    (String) this.getRequete().getSession().getAttribute("id"));
            // Retour vers le formulaire remplit

            if (session.getAttribute(PARAM_LANGUE).toString().contains("fr")) {
                getRequete().setAttribute(ACTION, ACTION_METRRE_A_JOUR);
                session.setAttribute(ACTION, ACTION_METRRE_A_JOUR);
            } else {
                getRequete().setAttribute(ACTION, ACTION_UPDATE);
                session.setAttribute(ACTION, ACTION_UPDATE);
            }
            this.setPageRetour(pageRetourForm);
        } else if (ACTION_METRRE_A_JOUR.equals(action) || ACTION_UPDATE.equals(action)) {
            // Action de mise a jour
            if (executeMettreAJour((String) this.getRequete().getSession().getAttribute("id"))) {
                // Si la mise à jour est effectué
                Log.insererLog(new Log(0, "modification", nomTable,
                        getRequete().getSession().getAttribute("usager").toString(),
                        UtilitaireDate.timeNowEnString(), valeur, ancienneValeur));
                session.removeAttribute("id");
                session.removeAttribute(ACTION);
                this.setPageRetour(pageRetourListe);
            } else {
                this.setPageRetour(pageRetourForm);
            }
        } else if ("Changer la langue".equals(action)) {
            if (ACTION_AJOUTER.equals(session.getAttribute(ACTION).toString())) {
                session.setAttribute(ACTION, ACTION_ADD);
            } else if (ACTION_ADD.equals(session.getAttribute(ACTION).toString())) {
                session.setAttribute(ACTION, ACTION_AJOUTER);
            } else if (ACTION_METRRE_A_JOUR.equals(session.getAttribute(ACTION).toString())) {
                session.setAttribute(ACTION, ACTION_UPDATE);
            } else if (ACTION_UPDATE.equals(session.getAttribute(ACTION).toString())) {
                session.setAttribute(ACTION, ACTION_METRRE_A_JOUR);
            }
            this.setPageRetour(pageRetourForm);
        } else if (actionAlternative2.equals(action)) {
            // Transfere
            executeActionAlternative2();
        } else if (actionAlternative1.equals(action)) {
            // Ajout du transfere
            executeActionAlternative1();
        }
    }
}
