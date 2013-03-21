package filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Filtre les appels dépendament qu'ils soient pour aller
 * chercher une ressources css/js/jsp ou un servlet.
 * Date: Feb 2, 2013 Time: 2:34:24.
 *
 * @author francisbeauchamps Comment: Description goes here ...
 */
public class SessionFilter implements Filter {

    /**
     * Initialise le filtre de session.
     *
     * @param config Configuration du filtre
     * @throws ServletException Erreur trigger par le servlet appelant.
     */
    @Override
    public void init(final FilterConfig config)
            throws ServletException {
        // init the filter
    }

    /**
     * Effectuer le filtre des requêtes.
     *
     * @param request La requête.
     * @param response La réponse.
     * @param chain La chaine de filtre à appliquer.
     * @throws java.io.IOException Exception java d'écriture / lecture.
     * @throws ServletException Erreur trigger par le servlet appelant.
     */
    public void doFilter(final ServletRequest request,
            final ServletResponse response,
            final FilterChain chain)
            throws java.io.IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI().substring(req.getContextPath().length());

        if (path.startsWith("/resources/")/* || path.equals("/")*/) {
            // Just let container's default servlet do its job.
            chain.doFilter(request, response);
        } else {
            if (path.equals("/")) {
                path += "Login";
            }

            if (path.substring(path.length() - 1).equals("/")) {
                path = path.substring(0, path.length() - 1);
            }


            // Delegate to your front controller.
            request.getRequestDispatcher("/pages" + path).forward(request, response);
        }
    }

    /**
     * Destructeur.
     */
    public void destroy() {
        /* Called before the Filter instance is removed
         from service by the web container*/
    }
}
