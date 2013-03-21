package filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Filtre les authentifications avec redirection adéquate. Date: Feb 2, 2013
 * Time: 2:34:24 PM
 *
 * @author francisbeauchamps Comment: Description goes here ...
 */
public class AutentificationFilter implements Filter {

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
        final HttpServletResponse res = (HttpServletResponse) response;
        final HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("usager") == null) {
            res.sendRedirect(req.getContextPath() + "/Login");
        } else {
            req.setAttribute("usager", session.getAttribute("usager"));
            chain.doFilter(request, response);
        }
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
