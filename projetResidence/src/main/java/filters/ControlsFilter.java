package filters;

import affaire.Inscription;
import java.util.Iterator;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Filtre les authentifications avec redirection adéquate. Date: Feb 2, 2013
 * Time: 2:34:24 PM
 *
 * @author francisbeauchamps Comment: Description goes here ...
 */
public class ControlsFilter implements Filter {

    /**
     * Initialise le filtre.
     *
     * @param config Configuration spécifiée dans le web.xml
     * @throws ServletException Une exception servlet
     */
    @Override
    public final void init(final FilterConfig config)
            throws ServletException {
        // init the filter
    }

    /**
     * Effectue le filtrage sur la requête.
     *
     * @param request La requête a filtrer
     * @param response La réponse
     * @param chain La chaine de filtre
     * @throws java.io.IOException Exception IO
     * @throws ServletException Exception servlet
     */
    @Override
    public void doFilter(final ServletRequest request,
            final ServletResponse response,
            final FilterChain chain)
            throws java.io.IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;

        initNbNewInscrpition(req);
        chain.doFilter(request, response);
    }

    /**
     * Initialise à chaque requête le nombre de nouvelles inscriptions afin de
     * pouvoir l'afficher dans le menu, par dessus l'onglet de la liste
     * d'attente.
     *
     * @param req La requête vers laquelle on pousse le param du nb de nouvelles
     * inscriptions.
     */
    private void initNbNewInscrpition(final HttpServletRequest req) {
        final List<Inscription> listeAttente = Inscription.getInscriptions();
        int nbNonConfirme = 0;

        if (listeAttente != null) {
            for (Iterator<Inscription> i = listeAttente.iterator(); i.hasNext();) {
                Inscription item = i.next();
                if (!item.isConfirme()) {
                    nbNonConfirme++;
                }
            }
        }
        req.setAttribute("nbNonConfirme", Integer.toString(nbNonConfirme));
    }

    /**
     * Détruit l'objet filtre.
     */
    @Override
    public void destroy() {
        /* Called before the Filter instance is removed
         from service by the web container*/
    }
}
