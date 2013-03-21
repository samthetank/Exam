/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

import affaire.Appartement;
import affaire.Bail;
import affaire.Inscription;
import affaire.Log;
import affaire.Resident;
import affaire.Role;
import affaire.Utilisateur;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.UtilitaireDate;

/**
 * Class qui contient toute les méthodes qui accède à la base de données.
 *
 * @author Vincent
 */
public final class SqlObjectProvider extends AbstractObjectProvider {

    /**
     * Constructeur.
     */
    private SqlObjectProvider() {
        super();
    }

    /**
     * Retourne l'instance existante ou la crée si elle n'existe pas.
     *
     * @return Instance de la classe
     */
    public static AbstractObjectProvider getInstance() {
        synchronized (AbstractObjectProvider.class) {
            if (instance == null) {
                instance = new SqlObjectProvider();
            }
        }

        return instance;
    }

    /**
     * Recoit un objet d'affaire qui sera converti en String sous le format de
     * clé-valeur comme par exemple pour un appartement :"id appartement : 1, No
     * appartment : 1, etc...".
     *
     * @param pobjet L'objet à convertir en String formater
     * @return Une String formaté représentant l'objet.
     */
    @Override
    public String objetEnString(final Object pobjet) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            // Récupère la bonne méthode GetMapAvec(nom de la classe de l'objet).
            Method thisMethod = this.getClass().getDeclaredMethod(
                    "getMapAvec" + pobjet.getClass().getSimpleName(), pobjet.getClass());
            thisMethod.setAccessible(true);
            // Appel de la fonction GetMapAvec pour la version (clé:valeur) de l'objet.
            map = ((Map<String, Object>) thisMethod.invoke(this.getClass().newInstance(),
                    new Object[]{pobjet}));
            // <editor-fold defaultstate="collapsed" desc="Catchs...">
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(SqlObjectProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(SqlObjectProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SqlObjectProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(SqlObjectProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SqlObjectProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SqlObjectProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        final StringBuilder objet = new StringBuilder();
        for (Map.Entry<String, Object> entre : map.entrySet()) {
            objet.append(Utilitaire.filtrerString(entre.getKey(), "_", " ")).append(": ");
            objet.append(entre.getValue().toString()).append(", ");
        }
        return objet.delete(objet.length() - 2, objet.length()).toString();
    }
    // <editor-fold defaultstate="collapsed" desc="Constante pour les noms de tables et clée primaire">
    // Insérer les autres constantes
    /**
     * Table inscription.
     */
    private static final String INSCRIPTION_TABLE = "inscriptions";
    /**
     * Clé primaire de la table inscription.
     */
    private static final String INSCRIPTION_PK = "id_Inscription";
    /**
     * Attribut courriel de la table inscription.
     */
    private static final String INSCRIPTION_COURRIEL = "courriel";
    /**
     * Table appartement.
     */
    private static final String APPARTEMENT_TABLE = "appartements";
    /**
     * Clé primaire de la table appartement.
     */
    private static final String APPARTEMENT_PK = "id_Appartement";
    /**
     * Table résidents baux.
     */
    private static final String RESIDENTS_BAUX_TABLE = "residents_baux";
    /**
     * Table bail.
     */
    private static final String BAIL_TABLE = "baux";
    /**
     * Clé primaire de la table bail.
     */
    private static final String BAIL_PK = "id_Bail";
    /**
     * Attribut est_responsable de la table bail.
     */
    private static final String BAIL_EST_RESPONSABLE = "est_Responsable";
    /**
     * Attribut est_locataire de la table bail.
     */
    private static final String BAIL_EST_LOCATAIRE = "est_Locataire";
    /**
     * Table résident.
     */
    private static final String RESIDENT_TABLE = "residents";
    /**
     * Clé primaire de la table résident.
     */
    private static final String RESIDENT_PK = "id_Resident";
    /**
     * Attribut Id rôle de la table utilisateur.
     */
    private static final String UTILISATEUR_ID_ROLE = "id_Role";
    /**
     * Table log.
     */
    private static final String LOG_TABLE = "logs";
    /**
     * Clé primaire de la table log.
     */
    private static final String LOG_PK = "id_log";
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Méthodes reliées aux Inscriptions">
    /**
     * Recoit un map de toutes les données et le convertit en un Inscription
     * c'est ici que le liens entre le nom des champs dans la base de données et
     * les noms des propriétés dans notre Objet du Bl est établit.
     *
     * @param pmap L'objet contenant le retour d'une requete SQL.
     * @return L'inscription qui était dans le map.
     */
    private Inscription getInscriptionAvecMap(final Map<String, Object> pmap) {
        return Inscription.getInscriptonValide(
                (Integer) pmap.get(INSCRIPTION_PK),
                (String) pmap.get("nom_Personne_Inscrite"),
                (String) pmap.get("prenom_Personne_Inscrite"),
                (String) pmap.get("telephone_Personne_Inscrite"),
                UtilitaireDate.dateEnString((Date) pmap.get("date_Inscription")),
                (String) pmap.get("commentaire_Personne_Inscrite"),
                (String) pmap.get("commentaire_Administrateur"),
                (String) pmap.get("commentaire_refus"),
                (String) pmap.get("preference_Appartement"),
                (String) pmap.get("preference_Etage"),
                (Boolean) pmap.get("est_Confirme"),
                (String) pmap.get(INSCRIPTION_COURRIEL));
    }

    /**
     * Crée un dictionnaire avec les valeurs des champs dans la base de données
     * et les valeurs dans l'objet Inscription reçu en paramètre.
     *
     * @param pinscription L'inscription qu'on désire associée au valeurs.
     * @return Un dictionnaire avec comme clée le nom des champs de la base de
     * données et comme valeurs celle contenu. dans l'Inscription. >>>>>>>
     */
    private Map<String, Object> getMapAvecInscription(final Inscription pinscription) {
        Map map;
        map = new HashMap<String, Object>();

        map.put("nom_Personne_Inscrite", pinscription.getNom());
        map.put("prenom_Personne_Inscrite", pinscription.getPrenom());
        map.put("telephone_Personne_Inscrite", pinscription.getTelephone());
        map.put("date_Inscription", pinscription.getDate());
        map.put("commentaire_Personne_Inscrite",
                pinscription.getCommentairePersonne());
        map.put("commentaire_Administrateur",
                pinscription.getCommentaireAdministrateur());
        map.put("commentaire_refus", pinscription.getCommentaireRefus());
        map.put("preference_Appartement",
                pinscription.getPreferenceAppartement());
        map.put("preference_Etage", pinscription.getPreferenceEtage());
        map.put("est_Confirme", pinscription.isConfirme());
        map.put(INSCRIPTION_COURRIEL, pinscription.getCourriel());

        return map;
    }

    /**
     * Recoit une liste de map contenant plusieurs entrées et les convertit en
     * une liste de Inscription.
     *
     * @param plist List<Map<String, Object>> liste de tout les map avec les
     * inscriptions
     * @return Une liste de DetailInscription.
     */
    private List<Inscription> getInscriptionsAvecList(final List<Map<String, Object>> plist) {
        final List<Inscription> inscription = new ArrayList<Inscription>();

        for (int i = 0; i < plist.size(); ++i) {
            inscription.add(getInscriptionAvecMap(plist.get(i)));
        }

        return inscription;
    }

    /**
     * Retourne toutes les inscriptions contenues dans la base de données en
     * appelant la fonction adéquate dans le DataAccess.
     *
     * @return Toute les inscriptions dans la base de données.
     */
    @Override
    public List<Inscription> getInscriptions() {
        return getInscriptionsAvecList(getInstance().obtenirToutLesDonnees(
                INSCRIPTION_TABLE));
    }

    /**
     * Appelle le DataAccess pour avoir l'inscription avec le id spécifié en
     * paramètre.
     *
     * @param pvaleur Le numéro de l'Id de l'Inscription désiré.
     * @return L'inscription ou null si inexistant.
     */
    @Override
    public Inscription getInscription(final Object pvaleur) {
        List<Map<String, Object>> listMapInscription = getInstance().
                obtenirDonneesSelonId(INSCRIPTION_TABLE, INSCRIPTION_PK,
                pvaleur);

        Inscription inscription = null;
        if (!listMapInscription.isEmpty()) {
            // No data found ...
            inscription = getInscriptionAvecMap(listMapInscription.get(0));
        }

        return inscription;
    }

    /**
     * Supprime l'inscription dans la base de données avec le Id selectionné.
     *
     * @param pid Le Id de l'inscription que l'on veut supprimer.
     * @return Vrai si une suppression à été effectué dans la base de données.
     */
    @Override
    public boolean supprimerInscription(final int pid) {
        return (getInstance().effacerDonnees(INSCRIPTION_TABLE,
                INSCRIPTION_PK, pid) == 1);
    }

    /**
     * S'assure que l'inscription passé en paramètre soit modifier dans la base
     * de données.
     *
     * @param pinscription L'inscription à modifier dans la base de données.
     * @return Vrai si une modification à été effectué dans la base de données.
     */
    @Override
    public boolean modifierInscription(final Inscription pinscription) {
        boolean bool = false;
        if (getInstance().modifierDonnees(INSCRIPTION_TABLE,
                getMapAvecInscription(pinscription),
                INSCRIPTION_PK, pinscription.getIdInscription()) == 1) {
            bool = true;
        }

        return bool;
    }

    /**
     * S'assure que l'inscription reçu en paramètre dans la base de données.
     *
     * @param pinscription L'inscription à insérer dans la base de données.
     * @return Si la valeur à été insérer dans la base de données.
     */
    @Override
    public boolean insererInscription(final Inscription pinscription) {
        return (getInstance().insererDonnees(INSCRIPTION_TABLE,
                getMapAvecInscription(pinscription)) == 1);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Méthodes reliées aux Appartements">
    /**
     * Recoit un map de toutes les données et le convertit en un Appartement
     * c'est ici que le liens entre le nom des champs dans la base de données et
     * les noms des propriétés dans notre Objet du Bl est établit.
     *
     * @param pmap Map L'objet contenant le retour d'une requete SQL.
     * @return L'Appartement qui était dans le map.
     */
    private Appartement getAppartementAvecMap(final Map<String, Object> pmap) {
        return new Appartement(
                (Integer) pmap.get(APPARTEMENT_PK),
                (Integer) pmap.get("no_Appartement"),
                (String) pmap.get("etage_appartement"),
                (String) pmap.get("phase_appartement"),
                (String) pmap.get("dimension_Appartement"),
                (String) pmap.get("nb_Pieces_Appartement"),
                (String) pmap.get("description_Appartement"));
    }

    /**
     * Crée un dictionnaire avec les valeurs des champs dans la base de données
     * et les valeurs dans l'objet Appartement reçu en paramètre.
     *
     * @param pappartement La Appartement qu'on désire associée au valeurs.
     * @return Un dictionnaire avec comme clée le nom des champs de la base de
     * données et comme valeurs celle contenu dans l'Appartement.
     */
    private Map<String, Object> getMapAvecAppartement(final Appartement pappartement) {
        Map map;
        map = new HashMap<String, Object>();

        map.put("no_Appartement", pappartement.getNoAppartement());
        map.put("etage_appartement", pappartement.getEtage());
        map.put("phase_appartement", pappartement.getPhase());
        map.put("dimension_Appartement", pappartement.getDimension());
        map.put("nb_Pieces_Appartement", pappartement.getNbPieces());
        map.put("description_Appartement", pappartement.getDescription());

        return map;
    }

    /**
     * Recoit une liste de map contenant plusieurs entrées et les convertit en
     * une liste d'Appartements.
     *
     * @param plist List<Map<String, Object>> liste de tout les map avec les
     * @return Une liste de DetailAppartement.
     */
    private List<Appartement> getAppartementsAvecList(final List<Map<String, Object>> plist) {
        final List<Appartement> pappartements = new ArrayList<Appartement>();

        for (int i = 0; i < plist.size(); ++i) {
            pappartements.add(getAppartementAvecMap(plist.get(i)));
        }

        return pappartements;
    }

    /**
     * Appelle le DataAccess pour avoir l'appartement avec le id spécifié en
     * paramètre.
     *
     * @param pvaleur Le numéro de l'Id de l'Appartement désiré.
     * @return l'Appartement ou null si inexistant.
     */
    @Override
    public Appartement getAppartement(final Object pvaleur) {
        List<Map<String, Object>> listMapAppartement = getInstance().
                obtenirDonneesSelonId(APPARTEMENT_TABLE, APPARTEMENT_PK,
                pvaleur);

        Appartement appartement = null;
        if (!listMapAppartement.isEmpty()) {
            // No data found ...
            appartement = getAppartementAvecMap(listMapAppartement.get(0));
        }

        return appartement;
    }

    /**
     * Retourne toutes les Appartements contenues dans la base de données en
     * appelant la fonction adéquate dans le DataAccess.
     *
     * @return Toute les pappartementts dans la base de données.
     */
    @Override
    public List<Appartement> getAppartements() {
        return getAppartementsAvecList(getInstance().obtenirToutLesDonnees(
                APPARTEMENT_TABLE));
    }

    /**
     * Supprime l'appartement dans la base de données avec le Id selectionné.
     *
     * @param pid Le Id de l'appartement que l'on veut supprimer.
     * @return Vrai si une suppression à été effectué dans la base de données.
     */
    @Override
    public boolean supprimerAppartement(final int pid) {
        return (getInstance().effacerDonnees(APPARTEMENT_TABLE, APPARTEMENT_PK,
                pid) == 1);
    }

    /**
     * S'assure que l'appartement passé en paramètre soit modifier dans la base
     * de données.
     *
     * @param pappartement L'objet à modifier
     * @return Vrai si une modification à été effectué dans la base de données.
     */
    @Override
    public boolean modifierAppartement(final Appartement pappartement) {
        return (getInstance().modifierDonnees(APPARTEMENT_TABLE,
                getMapAvecAppartement(pappartement), APPARTEMENT_PK,
                pappartement.getIdAppartement()) == 1);
    }

    /**
     * S'assure que l'appartement reçu en paramètre dans la base de données.
     *
     * @param pappartement L'Appartement à insérer dans la base de données.
     * @return Vrai Si la valeur à été insérer dans la base de données.
     */
    @Override
    public boolean insererAppartement(final Appartement pappartement) {
        return (getInstance().insererDonnees(APPARTEMENT_TABLE,
                getMapAvecAppartement(pappartement)) == 1);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Méthodes reliées aux Baux">
    /**
     * Recoit un map de toutes les données et le convertit en un Bail c'est ici
     * que le liens entre le nom des champs dans la base de données et les noms
     * des propriétés dans notre Objet du Bl est établit.
     *
     * @param pmap L'objet contenant le retour d'une requete SQL.
     * @return Le Bail qui était dans le map.
     */
    private Bail getBailAvecMap(final Map<String, Object> pmap) {
        // On va chercher le locataire et colocataire.
        final Map<String, Object> locataire = getLocataire((Integer) pmap.get(BAIL_PK), true);
        final Map<String, Object> colocataire = getLocataire((Integer) pmap.get(BAIL_PK), false);


        Integer idColocataire;
        Boolean colocataireRespo;
        if (colocataire.isEmpty()) {
            idColocataire = -1;
            colocataireRespo = false;
        } else {
            idColocataire = (Integer) colocataire.get(RESIDENT_PK);
            colocataireRespo = (Boolean) colocataire.get(BAIL_EST_RESPONSABLE);
        }

        return new Bail(
                (Integer) pmap.get(BAIL_PK),
                (Integer) pmap.get(APPARTEMENT_PK),
                UtilitaireDate.dateEnString((Date) pmap.get("date_Debut")),
                UtilitaireDate.dateEnString((Date) pmap.get("date_Fin")),
                (String) pmap.get("dernier_Mois"),
                Double.parseDouble(pmap.get("montant_Loyer").toString()),
                (String) pmap.get("commentaire"),
                (Integer) locataire.get(RESIDENT_PK),
                idColocataire,
                colocataireRespo);
    }

    /**
     * Crée un dictionnaire avec les valeurs des champs dans la base de données
     * et les valeurs dans l'objet Bail reçu en paramètre.
     *
     * @param pidBail Id du bail
     * @param pestLocataire Option locataire
     * @return Locataire du bail ayant l'id pidBail.
     */
    private Map<String, Object> getLocataire(final int pidBail, final boolean pestLocataire) {
        // On va chercher les données reliées au baux.
        final List<Map<String, Object>> list =
                getInstance().obtenirDonneesSelonId(RESIDENTS_BAUX_TABLE, BAIL_PK, pidBail);

        final Map<String, Object> map = new ConcurrentHashMap<String, Object>();

        // Pour tout les entrés on vérifie si sa correpond
        for (Map<String, Object> locataire : list) {
            if ((Boolean) locataire.get(BAIL_EST_LOCATAIRE) == pestLocataire) {
                map.put(RESIDENT_PK, locataire.get(RESIDENT_PK));
                map.put(BAIL_EST_RESPONSABLE, locataire.get(BAIL_EST_RESPONSABLE));
            }
        }

        return map;
    }

    /**
     * Crée un dictionnaire avec les valeurs des champs dans la base de données
     * et les valeurs dans l'objet Bail reçu en paramètre.
     *
     * @param pbail Le Bail qu'on désire associée au valeurs.
     * @return Un dictionnaire avec comme clé le nom des champs de la base de
     * données et comme valeurs celle contenu dans le Bail.
     */
    private Map<String, Object> getMapAvecBail(final Bail pbail) {
        final Map map = new HashMap<String, Object>();

        map.put(APPARTEMENT_PK, pbail.getIdAppartement());
        map.put("date_Debut", pbail.getDateDebut());
        map.put("date_Fin", pbail.getDateFin());
        map.put("dernier_Mois", pbail.getDernierMois());
        map.put("montant_Loyer", pbail.getMontantLoyer());
        map.put("commentaire", pbail.getCommentaire());

        return map;
    }

    /**
     * Getter du map bail-locataire d'un locataire.
     *
     * @param pidBail le id du bail
     * @param pbail l'objet de bail
     * @return Map contenant les information d'un bail.
     */
    private Map<String, Object> getMapAvecBailLocataire(final int pidBail, final Bail pbail) {
        final Map map = new HashMap<String, Object>();

        map.put(BAIL_PK, pidBail);
        map.put(RESIDENT_PK, pbail.getIdLocataire());
        map.put(BAIL_EST_RESPONSABLE, true);
        map.put(BAIL_EST_LOCATAIRE, true);

        return map;
    }

    /**
     * Getter du map bail-locataire d'un colocataire.
     *
     * @param pidBail le id du bail
     * @param pbail l'objet de bail
     * @return Map contenant les information d'un bail.
     */
    private Map<String, Object> getMapAvecBailColocataire(final int pidBail, final Bail pbail) {
        final Map map = new HashMap<String, Object>();

        map.put(BAIL_PK, pidBail);
        map.put(RESIDENT_PK, pbail.getIdLocataireSecondaire());
        map.put(BAIL_EST_RESPONSABLE, pbail.isEstLocataireSignataire());
        map.put(BAIL_EST_LOCATAIRE, false);

        return map;
    }

    /**
     * Reçoit une liste de map contenant plusieurs entrées et les convertit en
     * une liste de Baux.
     *
     * @param plist liste de tout les map avec les Baux
     * @return Une liste de DetailBail.
     */
    private List<Bail> getBailsAvecList(final List<Map<String, Object>> plist) {
        final List<Bail> baux = new ArrayList<Bail>();

        for (int i = 0; i < plist.size(); ++i) {
            baux.add(getBailAvecMap(plist.get(i)));
        }

        return baux;
    }

    /**
     * Appelle le DataAccess pour avoir le bail avec le id spécifié en
     * paramètre.
     *
     * @param pid Le numéro de l'Id du Bail désiré.
     * @return le Bail ou null si inexistant.
     */
    @Override
    public Bail getBail(final int pid) {
        final List<Map<String, Object>> listMapBail = getInstance().
                obtenirDonneesSelonId(BAIL_TABLE, BAIL_PK, pid);

        Bail bail;
        if (!listMapBail.isEmpty()) {
            // Aucune données dans la BD...
            bail = getBailAvecMap(listMapBail.get(0));
        } else {
            bail = null;
        }

        return bail;
    }

    /**
     * Getter du id d'un bail à partir d'un bail.
     *
     * @param pbail Le bail pour lequel on get le ID
     * @return le id d'un bail
     */
    public int getIdBail(final Bail pbail) {
        // On va chercher tout les baux avec le numéro d'appartement et avec la date de début et de fin...
        final List<Map<String, Object>> listMapBail = getInstance().obtenirDonneesSelonPlusieursId(BAIL_TABLE,
                APPARTEMENT_PK, pbail.getIdAppartement(),
                "date_Debut", UtilitaireDate.dateBD(pbail.getDateDebut()),
                "date_Fin", UtilitaireDate.dateBD(pbail.getDateFin()));

        int idBail;
        if (listMapBail.isEmpty()) {
            // Aucune données dans la BD...
            idBail = -1;
        } else {
            idBail = Integer.parseInt(listMapBail.get(0).get(BAIL_PK).toString());
        }

        return idBail;
    }

    /**
     * Retourne tous les Baux contenues dans la base de données en appelant la
     * fonction adéquate dans le DataAccess.
     *
     * @return Toute les baux dans la base de données.
     */
    @Override
    public List<Bail> getBails() {
        return getBailsAvecList(getInstance().obtenirToutLesDonnees(BAIL_TABLE));
    }

    /**
     * Supprime le bail dans la base de données avec le Id sélectionné.
     *
     * @param pid Le Id du bail que l'on veut supprimer.
     * @return si une suppression à été effectué dans la base de données.
     */
    @Override
    public boolean supprimerBail(final int pid) {
        return (getInstance().effacerDonnees(BAIL_TABLE, BAIL_PK, pid) == 1);
    }

    /**
     * S'assure que le bail passé en paramètre soit modifier dans la base de
     * données.
     *
     * @param pbail le bail
     * @return Vrai si une modification à été effectué dans la base de données.
     */
    @Override
    public boolean modifierBail(final Bail pbail) {
        // On modifie le bail
        getInstance().modifierDonnees(BAIL_TABLE, getMapAvecBail(pbail), BAIL_PK,
                pbail.getIdBail());

        // Les infos du locataire
        getInstance().modifierDonneesSelonPlusieurs(RESIDENTS_BAUX_TABLE,
                getMapAvecBailLocataire(getIdBail(pbail), pbail), BAIL_PK, pbail.getIdBail(),
                BAIL_EST_LOCATAIRE, true);


        // On efface les locataires et colocataire.
        getInstance().effacerDonnees(RESIDENTS_BAUX_TABLE, BAIL_PK, pbail.getIdBail());

        // On en insére un nouveau.
        getInstance().insererDonnees(RESIDENTS_BAUX_TABLE,
                getMapAvecBailLocataire(getIdBail(pbail), pbail));

        if (pbail.getIdLocataireSecondaire() != -1) {
            getInstance().insererDonnees(RESIDENTS_BAUX_TABLE,
                    getMapAvecBailColocataire(pbail.getIdBail(), pbail));
        }

        return true;
    }

    /**
     * S'assure que le bail reçu en paramètre dans la base de données.
     *
     * @param pbail Le Bail à insérer dans la base de données.
     * @return Si la valeur à été insérer dans la base de données.
     */
    @Override
    public boolean insererBail(final Bail pbail) {
        boolean estInsertion;

        // On insère le bail.
        estInsertion = (getInstance().insererDonnees(BAIL_TABLE, getMapAvecBail(pbail)) == 1);

        // On insère le locataire.
        if (estInsertion) {
            estInsertion = (getInstance().insererDonnees(RESIDENTS_BAUX_TABLE,
                    getMapAvecBailLocataire(getIdBail(pbail), pbail)) == 1);
        }

        // On insère le colocataire.
        if (estInsertion && pbail.getIdLocataireSecondaire() != -1) {
            estInsertion = (getInstance().insererDonnees(RESIDENTS_BAUX_TABLE,
                    getMapAvecBailColocataire(getIdBail(pbail), pbail)) == 1);
        }

        return estInsertion;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Méthodes reliées aux Residents">
    /**
     * Reçoit un map de toutes les données et le convertit en un Résident c'est
     * ici que le liens entre le nom des champs dans la base de données et les
     * noms des propriétés dans notre Objet du Bl est établit.
     *
     * @param pmap L'objet contenant le retour d'une requete SQL.
     * @return Le Résident qui était dans le map.
     */
    private Resident getResidentAvecMap(final Map<String, Object> pmap) {
        return new Resident(
                (Integer) pmap.get(RESIDENT_PK),
                (String) pmap.get("nom_Resident"),
                (String) pmap.get("prenom_Resident"),
                (String) pmap.get("telephone_Resident"),
                (String) pmap.get("telephone_Secondaire_Resident"),
                (String) pmap.get("titre_Resident"),
                UtilitaireDate.dateEnString((Date) pmap.get("date_Naissance_Resident")),
                UtilitaireDate.dateEnString((Date) pmap.get("date_Arrivee_Resident")),
                (String) pmap.get("commentaire_Resident"),
                (String) pmap.get("couleur_Intervention"),
                (String) pmap.get("commentaire_Intervention"),
                (String) pmap.get("commentaire_plainte"),
                (String) pmap.get("nom_Véhicule"),
                (String) pmap.get("plaque_Immatriculation"));
    }

    /**
     * Crée un dictionnaire avec les valeurs des champs dans la base de données
     * et les valeurs dans l'objet Résident reçu en paramètre.
     *
     * @param president Le Résident qu'on désire associée au valeurs.
     * @return Un dictionnaire avec comme clé le nom des champs de la base de
     * données et comme valeurs celle contenu dans le Résident.
     */
    private Map<String, Object> getMapAvecResident(final Resident president) {
        Map map;
        map = new HashMap<String, Object>();

        map.put("nom_Resident", president.getNom());
        map.put("prenom_Resident", president.getPrenom());
        map.put("telephone_Resident", president.getTelephone());
        map.put("telephone_Secondaire_Resident",
                president.getTelephoneSecondaire());
        map.put("titre_Resident", president.getTitreResident());
        map.put("date_Naissance_Resident", president.
                getDateNaissance());
        map.put("date_Arrivee_Resident", president.getDateArrivee());
        map.put("commentaire_Resident", president.getCommentaire());
        map.put("couleur_Intervention", president.getCouleurIntervention());
        map.put("commentaire_Intervention",
                president.getCommentaireIntervention());
        map.put("commentaire_plainte", president.getCommentairePlainte());
        map.put("nom_Véhicule", president.getNomVehicule());
        map.put("plaque_Immatriculation", president.getPlaqueImmatriculation());

        return map;
    }

    /**
     * Reçoit une liste de map contenant plusieurs entrées et les convertit en
     * une liste des Résidents.
     *
     * @param plist List<Map<String, Object>> liste de tout les map avec les
     * Résidents
     * @return Une liste de DetailResident.
     */
    private List<Resident> getResidentsAvecList(final List<Map<String, Object>> plist) {
        final List<Resident> presidents = new ArrayList<Resident>();

        for (int i = 0; i < plist.size(); ++i) {
            presidents.add(getResidentAvecMap(plist.get(i)));
        }

        return presidents;
    }

    /**
     * Appelle le DataAccess pour avoir le résident avec le id spécifié en
     * paramètre.
     *
     * @param pvaleur Le numéro de l'Id du Resident désiré.
     * @return le Résident ou null si inexistant.
     */
    @Override
    public Resident getResident(final Object pvaleur) {
        List<Map<String, Object>> listMapResident;
        listMapResident = getInstance().
                obtenirDonneesSelonId(RESIDENT_TABLE, RESIDENT_PK, pvaleur);
        Resident resident = null;
        if (!listMapResident.isEmpty()) {
            // Aucune données n'à pu être trouvé dans la BD...
            resident = getResidentAvecMap(listMapResident.get(0));
        }

        return resident;
    }

    /**
     * Retourne tous les Résidents contenues dans la base de données en appelant
     * la fonction adéquate dans le DataAccess.
     *
     * @return Tous les résidents dans la base de données.
     */
    @Override
    public List<Resident> getResidents() {
        return getResidentsAvecList(getInstance().obtenirToutLesDonnees(
                RESIDENT_TABLE));
    }

    /**
     * Supprime le résident dans la base de données avec le Id sélectionné.
     *
     * @param pid Le Id du résident que l'on veut supprimer.
     * @return Vrai si une suppression à été effectué dans la base de données.
     */
    @Override
    public boolean supprimerResident(final int pid) {
        return (getInstance().effacerDonnees(RESIDENT_TABLE, RESIDENT_PK,
                pid) == 1);
    }

    /**
     * S'assure que le résident passé en paramètre soit modifier dans la base de
     * données.
     *
     * @param president Résident à modifier dans la base de données
     * @return Vrai si une modification à été effectué dans la base de données.
     */
    @Override
    public boolean modifierResident(final Resident president) {
        return (getInstance().modifierDonnees(RESIDENT_TABLE,
                getMapAvecResident(president), RESIDENT_PK,
                president.getIdResident()) == 1);
    }

    /**
     * S'assure que le resident reçu en paramètre dans la base de données.
     *
     * @param president Le Resident à insérer dans la base de données.
     * @return Si la valeur à été insérer dans la base de données.
     */
    @Override
    public boolean insererResident(final Resident president) {
        return (getInstance().insererDonnees(RESIDENT_TABLE,
                getMapAvecResident(president)) == 1);
    }
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methodes Sql Utilisateurs">
    /**
     * Nom de la table utilisateur.
     */
    private static final String UTILISATEUR_TABLE = "utilisateurs";
    /**
     * Clé primaire de la table utilisateur.
     */
    private static final String UTILISATEUR_CLEE = "id_utilisateur";

    /**
     * Reçoit un map de toutes les données et le convertit en un Utilisateur
     * c'est ici que le liens entre le nom des champs dans la base de données et
     * les noms des propriétés dans notre Objet du Bl est établit.
     *
     * @param pmap L'objet contenant le retour d'une requête SQL.
     * @return L'Utilisateur qui était dans le map.
     */
    private Utilisateur getUtilisateurAvecMap(
            final Map<String, Object> pmap) {
        return new Utilisateur(
                (Integer) pmap.get("id_Utilisateur"),
                (Integer) pmap.get(UTILISATEUR_ID_ROLE),
                (String) pmap.get("nom_Utilisateur"),
                (String) pmap.get("nom"),
                (String) pmap.get("prenom"),
                (String) pmap.get("mot_De_Passe"),
                (String) pmap.get("courriel"));
    }

    /**
     * Reçoit une liste de map contenant plusieurs entrées et les convertit en
     * une liste de Utilisateur.
     *
     * @param plist List<Map<String, Object>> liste de tout les map avec les
     * Utilisateurs
     * @return Une liste d'utilisateurs.
     */
    private List<Utilisateur> getUtlisateursAvecList(
            final List<Map<String, Object>> plist) {
        final List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

        for (Map<String, Object> map : plist) {
            utilisateurs.add(getUtilisateurAvecMap(map));
        }

        return utilisateurs;
    }

    /**
     * Obtient tout les utilisateurs contenu dans la base de données.
     *
     * @return La liste de tout les utilisateurs.
     */
    @Override
    public List<Utilisateur> getUtilisateurs() {
        return getUtlisateursAvecList(getInstance().obtenirToutLesDonnees(
                UTILISATEUR_TABLE));
    }

    /**
     * Obtient l'utilisateur avec le nom de l'utilisateur spécifié.
     *
     * @param pnomUtlisateur Le nom d'utilisateur.
     * @return L'utilisateur avec le nom spécifié.
     */
    @Override
    public Utilisateur getUtilisateur(final String pnomUtlisateur) {
        final List<Map<String, Object>> list =
                getInstance().obtenirDonneesSelonId(UTILISATEUR_TABLE,
                "nom_Utilisateur", pnomUtlisateur);

        Utilisateur utilisateur = null;
        if (!list.isEmpty()) {
            utilisateur = getUtilisateurAvecMap(list.get(0));
        }

        return utilisateur;
    }

    /**
     * Fonction qui obtient tout les droits utilisateurs reliés à un nom
     * d'utilisateur.
     *
     * @param pnomUtilisateur Le nom d'utilisateur.
     * @return La liste des droits utilisateurs.
     */
    @Override
    public List<String> getDroitsUtilisateurs(final String pnomUtilisateur) {
        final Utilisateur utilisateur = getUtilisateur(pnomUtilisateur);

        return getDroitsUtilisateurs(utilisateur.getIdRole());
    }

    /**
     * Fonction servant à obtenir tout les droits selon le numéro de role passé
     * en paramètre.
     *
     * @param pidRole Le numéro de role qu'on désire les droits
     * @return La liste des droits
     */
    @Override
    public List<String> getDroitsUtilisateurs(final int pidRole) {
        // Va chercher dans la bd tout les numéros de droits du role.
        final List<Map<String, Object>> list =
                getInstance().obtenirDonneesSelonId("roles_droits_utilisateur",
                UTILISATEUR_ID_ROLE, pidRole);

        // La liste contenant les droits d'utilisations du role.
        final List<String> listDroits = new ArrayList<String>();

        // Pour chaque numéro de role on entre sont nom dans listDroits.
        for (Map<String, Object> droit : list) {
            // On va chercher le nom associée au droits courant.
            listDroits.add(getInstance().obtenirDonneesSelonId(
                    "droits_Utilisateur", "id_Droit_Utilisateur",
                    droit.get("id_Droits_Utilisateur")).get(0).
                    get("nom_Droit_Utilisateur").toString());
        }

        return listDroits;
    }

    /**
     * Fonction servant à obtenir le role correspondant au id spécifié.
     *
     * @param pidRole Le numéro de role qu'on désire obtenir
     * @return Le role avec le id spécifié
     */
    @Override
    public Role getRole(final int pidRole) {
        // Va chercher dans la bd tout les numéros de droits du role.
        final List<Map<String, Object>> listrole =
                getInstance().obtenirDonneesSelonId("roles",
                "id_Role", pidRole);

        Role role = null;
        if (!listrole.isEmpty()) {
            role = new Role(
                    (Integer) listrole.get(0).get("id_Role"),
                    (String) listrole.get(0).get("nom_Role"),
                    (String) listrole.get(0).get("description_Role"));
        }

        return role;
    }

    /**
     * Obtient l'utilisateur avec le numéro d'identification.
     *
     * @param pid le numéro d'utilisateur.
     * @return L'utilisateur avec le numéro d'identification spécifié.
     */
    @Override
    public Utilisateur getUtilisateur(final int pid) {
        final List<Map<String, Object>> list =
                getInstance().obtenirDonneesSelonId(UTILISATEUR_TABLE,
                "id_Utilisateur", pid);

        Utilisateur utilisateur = null;
        if (!list.isEmpty()) {
            utilisateur = getUtilisateurAvecMap(list.get(0));
        }

        return utilisateur;
    }

    /**
     * Crée un dictionnaire avec les valeurs des champs dans la base de données
     * et les valeurs dans l'objet Utilisateur reçu en paramètre.
     *
     * @param putilisateur L'utilisateur qu'on désire associée au valeurs.
     * @return Un dictionnaire avec comme clé le nom des champs de la base de
     * données et comme valeurs celle contenu dans l'utilisateur.
     */
    private Map<String, Object> getMapAvecUtilisateur(
            final Utilisateur putilisateur) {
        final Map map = new HashMap<String, Object>();

        map.put("id_Utilisateur", putilisateur.getIdUtilisateur());
        map.put(UTILISATEUR_ID_ROLE, putilisateur.getIdRole());
        map.put("nom_Utilisateur", putilisateur.getNomUtilisateur());
        map.put("prenom", putilisateur.getPrenom());
        map.put("nom", putilisateur.getNom());
        map.put("mot_De_Passe", putilisateur.getMotDePasse());
        map.put("courriel", putilisateur.getCourriel());

        return map;
    }

    /**
     * Supprimer l'utilisateur entré dans la base de données à l'id spécifié.
     *
     * @param pid Le id de l'utilisateur à supprimer.
     * @return Si l'utilisateur à été supprimé.
     */
    @Override
    public boolean supprimerUtilisateur(final int pid) {
        return (getInstance().effacerDonnees(UTILISATEUR_TABLE,
                UTILISATEUR_CLEE, pid) == 1);
    }

    /**
     * Modifie l'utilisateur courant dans la base de données.
     *
     * @param putilisateur L'utilisateur à modifier.
     * @return Si l'utilisateur à été modifié.
     */
    @Override
    public boolean modifierUtilisateur(final Utilisateur putilisateur) {
        return (getInstance().modifierDonnees(UTILISATEUR_TABLE,
                getMapAvecUtilisateur(putilisateur), UTILISATEUR_CLEE,
                putilisateur.getIdUtilisateur()) == 1);
    }

    /**
     * Insère l'utilisateur passé en paramètre dans la base de données.
     *
     * @param putilisateur L'utilisateur à ajouter.
     * @return si l'utilisateur à été inséré.
     */
    @Override
    public boolean insererUtilisateur(final Utilisateur putilisateur) {
        return (getInstance().insererDonnees(UTILISATEUR_TABLE,
                getMapAvecUtilisateur(putilisateur)) == 1);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Méthodes reliées aux Logs">
    /**
     * Recoit un map de toutes les données et le convertit en un log c'est ici
     * que le liens entre le nom des champs dans la base de données et les noms
     * des propriétés dans notre Objet du Bl est établit.
     *
     * @param pmap L'objet contenant le retour d'une requete SQL.
     * @return Le log qui était dans le map.
     */
    private Log getLogAvecMap(final Map<String, Object> pmap) {
        return new Log(
                (Integer) pmap.get(LOG_PK),
                (String) pmap.get("action"),
                (String) pmap.get("nom_table"),
                (String) pmap.get("nom_utilisateur"),
                UtilitaireDate.dateTimeEnString((Date) pmap.get("date_log")),
                (String) pmap.get("valeur"),
                (String) pmap.get("ancienne_valeur"));
    }

    /**
     * Crée un dictionnaire avec les valeurs des champs dans la base de données
     * et les valeurs dans l'objet Log reçu en paramètre.
     *
     * @param plog L'inscription qu'on désire associée au valeurs.
     * @return Un dictionnaire avec comme clée le nom des champs de la base de
     * données et comme valeurs celle contenu. dans l'Log. >>>>>>>
     */
    private Map<String, Object> getMapAvecLog(final Log plog) {
        Map map;
        map = new HashMap<String, Object>();

        map.put("action", plog.getAction());
        map.put("nom_table", plog.getnomTable());
        map.put("nom_utilisateur", plog.getNomUtilisateur());
        map.put("date_Log", plog.getDateLog());
        map.put("valeur",
                plog.getValeur());
        map.put("ancienne_valeur",
                plog.getAncienneValeur());

        return map;
    }

    /**
     * Recoit une liste de map contenant plusieurs entrées et les convertit en
     * une liste de Log.
     *
     * @param plist List<Map<String, Object>> liste de tout les map avec les
     * logs.
     * @return Une liste de DetailLog.
     */
    private List<Log> getLogsAvecList(final List<Map<String, Object>> plist) {
        final List<Log> log = new ArrayList<Log>();

        for (int i = 0; i < plist.size(); ++i) {
            log.add(getLogAvecMap(plist.get(i)));
        }

        return log;
    }

    /**
     * Retourne toutes les inscriptions contenues dans la base de données en
     * appelant la fonction adéquate dans le DataAccess.
     *
     * @return Toute les inscriptions dans la base de données.
     */
    @Override
    public List<Log> getLogs() {
        return getLogsAvecList(getInstance().obtenirToutLesDonnees(
                LOG_TABLE));
    }

    /**
     * Appelle le DataAccess pour avoir l'inscription avec le id spécifié en
     * paramètre.
     *
     * @param pvaleur Le numéro de l'Id de l'Log désiré.
     * @return L'inscription ou null si inexistant.
     */
    @Override
    public Log getLog(final Object pvaleur) {
        List<Map<String, Object>> listMapLog = getInstance().
                obtenirDonneesSelonId(LOG_TABLE, LOG_PK,
                pvaleur);

        Log inscription = null;
        if (!listMapLog.isEmpty()) {
            // No data found ...
            inscription = getLogAvecMap(listMapLog.get(0));
        }

        return inscription;
    }

    /**
     * S'assure que le log reçu en paramètre dans la base de données.
     *
     * @param plog Le log à insérer dans la base de données.
     * @return Si la valeur à été insérer dans la base de données.
     */
    @Override
    public boolean insererLog(final Log plog) {
        return (getInstance().insererDonnees(LOG_TABLE,
                getMapAvecLog(plog)) == 1);
    }

    /**
     * Supprime le log dans la base de données avec le Id selectionné.
     *
     * @param pid Le Id du log que l'on veut supprimer.
     * @return Vrai si une suppression à été effectué dans la base de données.
     */
    @Override
    public boolean supprimerLog(final int pid) {
        return (getInstance().effacerDonnees(LOG_TABLE,
                LOG_PK, pid) == 1);
    }
    //</editor-fold>
}
