package controleur;

import affaire.Utilisateur;
import donnees.SqlObjectProvider;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

/**
 * Controlleur pour les requête vers la page login. Page de commencement de
 * l'application.
 *
 * @author Vincent Fournier et Thomas Lelièvre
 */
public class ControleurLogin extends AbstractControleur {

    /**
     * Si nous on "by pass" la connexion pour aller à une page directement avec
     * un utilisateur.
     */
    private static final boolean EST_ACCES_DIRECT = false;
    /**
     * L'utilisateur qui sera connecté quand on y va en direct.
     */
    private static final String NOM_UTILISATEUR = "iDube";
    /**
     * La page qui sera accedé quand nous sommes en direct.
     */
    private static final String PAGE_RETOUR = "app/ListeBaux";

    /**
     * Execute le code du controleur de la page login.
     */
    @Override
    public final void execute() {
        this.getRequete().setAttribute("contexte", this.getRequete().getContextPath());

        // Si l'utilisateur envoi son identifiant via le formulaire d'oubli de mot de passe
        if (this.getRequete().getParameter("oubliMdp") != null
                && this.getRequete().getParameter("oubliMdp").equals("mdpOubli")) {
            envoiMdpCourriel();
        }

        // Lorsque l'on accède au servlet avec aucun paramètres, on redirige au JSP rien a valider. On affiche la vue
        if (this.getRequete().getParameter("login") == null || this.getRequete().getParameter("pass") == null) {
            this.setPageRetour("Login");

            if (EST_ACCES_DIRECT) {
                attribuerDroitOnglets(NOM_UTILISATEUR);
                this.setPageRetour(PAGE_RETOUR);
            }
        } else {
            final Utilisateur utilisateur =
                    SqlObjectProvider.getInstance().getUtilisateur(this.getRequete().getParameter("login"));

            if (utilisateur == null || !utilisateur.getMotDePasse().equals(this.getRequete().getParameter("pass"))
                    || !Utilisateur.aDroitsUtilisateur(utilisateur.getNomUtilisateur(), "connexion_Application")) {
                this.getRequete().setAttribute("error", "Le nom d'utilisateur ou le mot de passe est invalide.");
                this.setPageRetour("Login");
            } else {
                attribuerDroitOnglets(utilisateur.getNomUtilisateur());
                this.setPageRetour("app/Index");
            }
        }
    }

    /**
     * Attribue le nom de l'utilisateur à la session et attribue la permission
     * au onglets de l'application.
     *
     * @param pnomUtilisateur Le nom de l'utilisateur.
     */
    private void attribuerDroitOnglets(final String pnomUtilisateur) {
        // Creation de la session
        final HttpSession session = this.getRequete().getSession(true);

        // On insère l'attribut du nom d'usager dans la session
        session.setAttribute("usager", pnomUtilisateur);

        // On assigne les droits pour chacuns des onglets.
        session.setAttribute("ongletAccueil", Boolean.TRUE.toString());
        session.setAttribute("ongletUtilisateurs",
                Utilisateur.aDroitsUtilisateur(pnomUtilisateur, "utilisateurs_Afficher").toString());
        session.setAttribute("ongletLogs",
                Utilisateur.aDroitsUtilisateur(pnomUtilisateur, "logs_Afficher").toString());
        session.setAttribute("ongletListeAttente",
                Utilisateur.aDroitsUtilisateur(pnomUtilisateur, "inscriptions_Afficher").toString());
        session.setAttribute("ongletResidents",
                Utilisateur.aDroitsUtilisateur(pnomUtilisateur, "residents_Afficher").toString());
        session.setAttribute("ongletAppartements",
                Utilisateur.aDroitsUtilisateur(pnomUtilisateur, "appartements_Afficher").toString());
        session.setAttribute("ongletBaux",
                Utilisateur.aDroitsUtilisateur(pnomUtilisateur, "baux_Afficher").toString());
        session.setAttribute("ongletProfil", Boolean.TRUE.toString());
    }

    /**
     * Envoi un courriel contenant le mot de passe de l'utilisateur qui a
     * oublier son mot de passe.
     */
    private void envoiMdpCourriel() {
        // Récuperation du nom d'utilisateur donné dans le formulaire d'oubliMdp (Login.jsp)
        final Utilisateur utilisateur = Utilisateur.getUtilisateurString(this.getRequete().getParameter("username"));

        // Envoi du courriel
        final Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        final javax.mail.Session sessionMail = javax.mail.Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("residence.noreply@gmail.com", "sesame01");
                    }
                });

        try {
            final Message message = new MimeMessage(sessionMail);
            message.setFrom(new InternetAddress("residence.noreply@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(utilisateur.getCourriel()));
            message.setSubject("Residence du carrefour - Oubli de mot de passe");
            message.setText("Bonjour,"
                    + "\n\n Votre mot de passe: " + utilisateur.getMotDePasse()
                    + "\n\n\n\n*** Ne pas répondre à ce courriel automatique ***");

            Transport.send(message);
        } catch (MessagingException e) {
            Logger.getLogger(ControleurLogin.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
