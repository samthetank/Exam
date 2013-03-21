package servlets;

import controleur.Controleur;
import controleur.FabriqueControleur;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Front controleur. Servlet principal du programme.
 *
 * @author Francis Beauchamp
 */
public class ControleurDivin extends HttpServlet {

    /**
     * Initialise le servlet.
     *
     * @throws ServletException Une erreur quelconque.
     */
    @Override
    public final void init() throws ServletException {
        super.init();
    }

    /**
     * Traite toute requête http (POST et GET).
     *
     * @param request La requête http
     * @param response La réponse à la requête
     * @throws ServletException Une exception
     * @throws IOException Une exception
     */
    protected final void traiterRequete(
            final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        // Definition du formatage de caractère
        forbidCachedPages(response);
        response.setContentType("text/html;charset=UTF-8");
        // Pour pouvoir écrire les erreurs dans la page web
        PrintWriter out;
        out = response.getWriter();
        try {
            // On prend la fin de l'url pour
            // pouvoir soutirer le nom de controleur par la suite
            String url;
            // Dernier / et Fin de la chainse
            url = request.getRequestURL().substring(
                    request.getRequestURL().lastIndexOf("/") + 1,
                    request.getRequestURL().length());

            // La requete nous fournit le nom du controleur à obtenir **** BUG
            String controleur;
            controleur = url;

            // On obtient le bon controleur à partir de son nom
            Controleur controle;
            controle = FabriqueControleur.getControleurParNomClasse(controleur);

            // Initialise le controleur avec la requete pour pouvoir l'exécuter
            controle.init(request);

            // On exécute le controleur. Celui-ci va chercher les données
            // qu'il doit obtenir, les insère dans l'attribut de requête
            // et redéfinit la page de redirection. On peut donc utiliser
            // controle.getPageRetour pour dispatcher dans l'url désiré,
            // puis faire forward pour procéder au dispatch
            controle.execute();

            if (controle.getPageRetour().substring(
                    controle.getPageRetour().lastIndexOf("/") + 1,
                    controle.getPageRetour().length()).equals(controleur)) {
                RequestDispatcher requestDispatcher;
                requestDispatcher = request.getRequestDispatcher(
                        "/WEB-INF/" + controle.getPageRetour() + ".jsp");
                requestDispatcher.forward(request, response);
            } else {
                response.sendRedirect(controle.getPageRetour());
            }

        } catch (Exception e) {
            response.sendRedirect("Erreur");
        } finally {
            out.close();
        }
    }

    /**
     * Empêche les pages de se charger dans la cache dans le but de prévenir
     * des comportements farfelus d'ajout fantôme.
     * @param response La reponse http.
     */
    private void forbidCachedPages(final HttpServletResponse response) {
        // Set to expire far in the past.
        response.setHeader("Expires", "-1");

        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");

        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
    }

    /**
     * Requête GET au servlet.
     *
     * @param request La requête
     * @param response La réponse
     * @throws ServletException Erreur de servlet
     * @throws IOException Erreur IO
     */
    @Override
    protected final void doGet(
            final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        traiterRequete(request, response);
    }

    /**
     * Requête POST au servlet.
     *
     * @param request La requpete
     * @param response La réponse
     * @throws ServletException Erreur de servlet
     * @throws IOException Erreur IO
     */
    @Override
    protected final void doPost(
            final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        traiterRequete(request, response);
    }
}
