package controleur;

import javax.servlet.http.HttpSession;

/**
 * Classe controleur abstraite pour les listes.
 *
 * @author Vincent
 */
public abstract class AbstractControleurListe extends AbstractControleur {

    /**
     * Session du contrôleur.
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
     * Première action alternative.
     */
    private String actionAlternative1;
    /**
     * Deuxième action alternative.
     */
    private String actionAlternative2;

    /**
     * Retourne la première action alternative.
     *
     * @return La première action alternative.
     */
    public final String getActionAlternative1() {
        return actionAlternative1;
    }

    /**
     * Attribue le paramètre pactionAlternative1 à la première action
     * alternative.
     *
     * @param pactionAlternative1 L'action alternative qui sera attribuée.
     */
    public final void setActionAlternative1(final String pactionAlternative1) {
        this.actionAlternative1 = pactionAlternative1;
    }

    /**
     * Retourne la deuxième action alternative.
     *
     * @return La deuxième action alternative.
     */
    public final String getActionAlternative2() {
        return actionAlternative2;
    }

    /**
     * Attribue le paramètre pactionAlternative2 à la deuxième action
     * alternative.
     *
     * @param pactionAlternative2 L'action alternative qui sera attribuée.
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
     * Attribue le paramètre psession à la session.
     *
     * @param psession La session qui sera attribuée.
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
     * Attribue le paramètre ppageRetourForm à la pageRetourForm.
     *
     * @param ppageRetourForm Page de retour pour le formulaire qui sera
     * attribuée.
     */
    public final void setPageRetourForm(final String ppageRetourForm) {
        this.pageRetourForm = ppageRetourForm;
    }

    /**
     * Retourne la page de retour pour la liste.
     *
     * @return La page de la liste.
     */
    public final String getPageRetourListe() {
        return pageRetourListe;
    }

    /**
     * Attribue le paramètre ppageRetourListe à la pageRetourListe.
     *
     * @param ppageRetourListe Page de retour pour la liste qui sera attribuée.
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
     * Attribue le paramètre ptitrePage au titre de la page.
     *
     * @param ptitrePage Le titre de la page qui sera attribué.
     */
    public final void setTitrePage(final String ptitrePage) {
        this.titrePage = ptitrePage;
    }

    /**
     * Méthode abstraite aAccesPage. Permet de vérifier si l'utilisateur accès à
     * la page.
     *
     * @return Un booléen.
     */
    protected abstract boolean aAccesPage();

    /**
     * Méthode abstraite initialiserControleur. Permet d'initialiser le
     * contrôleur (setPageRetourForm, setPageRetourListe, setTitrePage,
     * setOnglet, setActionAlternative1, setActionAlternative2).
     */
    protected abstract void initialiserControleur();

    /**
     * Méthode abstraite initialiserListeDroits. Permet d'initialiser la liste
     * des droits.
     */
    protected abstract void initialiserListeDroits();

    /**
     * Méthode abstraite executeSuppression. Permet d'exécuter la suppression.
     *
     * @param pidSuppression Id de l'objet d'affaire à supprimer.
     */
    protected abstract void executeSuppression(int pidSuppression);

    /**
     * Méthode abstraite executeActionAlternative1. Permet d'exécuter l'action
     * alternative 1.
     */
    protected abstract void executeActionAlternative1();

    /**
     * Méthode abstraite executeActionAlternative2. Permet d'exécuter l'action
     * alternative 2.
     */
    protected abstract void executeActionAlternative2();

    /**
     * Méthode abstraite attribuerListe. Permet d'attribuer la liste.
     */
    protected abstract void attribuerListe();

    @Override
    public final void execute() {
        // On initialise le servletRequest ainsi que la session
        this.session = getRequete().getSession();

        // On vérifie si l'utilisateur a droit à la page.
        if (aAccesPage()) {
            // On assigne le contexte
            getRequete().setAttribute("contexte", getRequete().getContextPath());

            // On initialise les champs comme le titre et les pages de retour
            initialiserControleur();
            getRequete().setAttribute("titre", titrePage);
            getRequete().setAttribute("page", getOnglet());
            // On initialise la liste des droits (pour l'affichage des boutons)
            initialiserListeDroits();

            // On regarde le type du submit
            final String sType = getRequete().getParameter("action");

            // On traite la requete
            if ("suppression".equals(sType)) {
                // Si c'est une suppression
                getRequete().setAttribute("recoverScroll", Boolean.TRUE.toString());
                // On execute la suppression (appellera l'objet d'affaire)
                executeSuppression(Integer.parseInt(getRequete().getParameter("id")));

                // On set la page de retour ainsi que la liste.
                this.setPageRetour(pageRetourListe);
                attribuerListe();

            } else if ("modifier".equals(sType)) {
                session.setAttribute("action", "viewModifier");
                session.setAttribute("id", this.getRequete().getParameter("id"));
                this.setPageRetour(pageRetourForm);
            } else if ("ajouter".equals(sType)) {
                session.setAttribute("action", "viewAjout");
                this.setPageRetour(pageRetourForm);
            } else if (actionAlternative1.equals(sType)) {
                executeActionAlternative1();
            } else if (actionAlternative2.equals(sType)) {
                executeActionAlternative2();
            } else {
                // On set la page de retour ainsi que la liste.
                this.setPageRetour(pageRetourListe);
                attribuerListe();
            }
        } else {
            this.setPageRetour("app/Index");
        }
    }
}
