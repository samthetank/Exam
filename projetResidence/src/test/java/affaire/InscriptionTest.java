/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package affaire;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 0962993
 */
public class InscriptionTest {

    public InscriptionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getIdInscription method, of class Inscription.
     */
    @Test
    public void testGetIdInscription() {
        System.out.println("getIdInscription");
        Inscription instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        instance = new Inscription(instance);
        int expResult = 1;
        int result = instance.getIdInscription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNom method, of class Inscription.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Inscription instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        String expResult = "Nom";
        String result = instance.getNom();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrenom method, of class Inscription.
     */
    @Test
    public void testGetPrenom() {
        System.out.println("getPrenom");
        Inscription instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        String expResult = "Prenom";
        String result = instance.getPrenom();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTelephone method, of class Inscription.
     */
    @Test
    public void testGetTelephone() {
        System.out.println("getTelephone");
        Inscription instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        String expResult = "4501231234";
        String result = instance.getTelephone();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate method, of class Inscription.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Inscription instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        String expResult = "2000-01-01";
        String result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCommentairePersonne method, of class Inscription.
     */
    @Test
    public void testGetCommentairePersonne() {
        System.out.println("getCommentairePersonne");
        Inscription instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        String expResult = "CommentaireP";
        String result = instance.getCommentairePersonne();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCommentaireAdministrateur method, of class Inscription.
     */
    @Test
    public void testGetCommentaireAdministrateur() {
        System.out.println("getCommentaireAdministrateur");
        Inscription instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        String expResult = "CommentaireA";
        String result = instance.getCommentaireAdministrateur();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCommentaireRefus method, of class Inscription.
     */
    @Test
    public void testGetCommentaireRefus() {
        System.out.println("getCommentaireRefus");
        Inscription instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        String expResult = "CommentaireR";
        String result = instance.getCommentaireRefus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPreferenceAppartement method, of class Inscription.
     */
    @Test
    public void testGetPreferenceAppartement() {
        System.out.println("getPreferenceAppartement");
        Inscription instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        String expResult = "3";
        String result = instance.getPreferenceAppartement();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPreferenceEtage method, of class Inscription.
     */
    @Test
    public void testGetPreferenceEtage() {
        System.out.println("getPreferenceEtage");
        Inscription instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        String expResult = "1";
        String result = instance.getPreferenceEtage();
        assertEquals(expResult, result);
    }

    /**
     * Test of isConfirme method, of class Inscription.
     */
    @Test
    public void testIsConfirme() {
        System.out.println("isConfirme");
        Inscription instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        boolean expResult = true;
        boolean result = instance.isConfirme();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCourriel method, of class Inscription.
     */
    @Test
    public void testGetCourriel() {
        System.out.println("getCourriel");
        Inscription instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        String expResult = "Courriel";
        String result = instance.getCourriel();
        assertEquals(expResult, result);
    }

    /**
     * Test of supprimer method, of class Inscription.
     */
    //@Test
    public void testSupprimer() {
        System.out.println("supprimer");
        Inscription instance = null;
        boolean expResult = false;
        boolean result = instance.supprimer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifier method, of class Inscription.
     */
    //@Test
    public void testModifier() {
        System.out.println("modifier");
        Inscription instance = null;
        boolean expResult = false;
        boolean result = instance.modifier();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of egale method, of class Inscription.
     */
    @Test
    public void testEgale() {
        System.out.println("egale");
        Inscription pinscription = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        Inscription instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        boolean expResult = true;
        boolean result = instance.egale(pinscription);
        assertEquals(expResult, result);
        pinscription = new Inscription(1, "Nomm", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        expResult = false;
        result = instance.egale(pinscription);
        assertEquals(expResult, result);
        pinscription = new Inscription(2, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        expResult = false;
        result = instance.egale(pinscription);
        assertEquals(expResult, result);
        pinscription = new Inscription(1, "Nom", "Prenomd", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        expResult = false;
        result = instance.egale(pinscription);
        assertEquals(expResult, result);
        pinscription = new Inscription(1, "Nom", "Prenom", "4501231224", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        expResult = false;
        result = instance.egale(pinscription);
        assertEquals(expResult, result);
        pinscription = new Inscription(1, "Nom", "Prenom", "4501231234", "2001-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        expResult = false;
        result = instance.egale(pinscription);
        assertEquals(expResult, result);
        pinscription = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommwntaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        expResult = false;
        result = instance.egale(pinscription);
        assertEquals(expResult, result);
        pinscription = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "ComwentaireA", "CommentaireR", "3", "1", true, "Courriel");
        instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        expResult = false;
        result = instance.egale(pinscription);
        assertEquals(expResult, result);
        pinscription = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "ComqentaireR", "3", "1", true, "Courriel");
        instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        expResult = false;
        result = instance.egale(pinscription);
        assertEquals(expResult, result);
        pinscription = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "4", "1", true, "Courriel");
        instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        expResult = false;
        result = instance.egale(pinscription);
        assertEquals(expResult, result);
        pinscription = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "2", true, "Courriel");
        instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        expResult = false;
        result = instance.egale(pinscription);
        assertEquals(expResult, result);
        pinscription = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", false, "Courriel");
        instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        expResult = false;
        result = instance.egale(pinscription);
        assertEquals(expResult, result);
        pinscription = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courariel");
        instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        expResult = false;
        result = instance.egale(pinscription);
        assertEquals(expResult, result);
    }

    /**
     * Test of insererInscription method, of class Inscription.
     */
    //@Test
    public void testInsererInscription() {
        System.out.println("insererInscription");
        Inscription pinscription = null;
        boolean expResult = false;
        boolean result = Inscription.insererInscription(pinscription);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInscriptions method, of class Inscription.
     */
    //@Test
    public void testGetInscriptions() {
        System.out.println("getInscriptions");
        List expResult = null;
        List result = Inscription.getInscriptions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInscription method, of class Inscription.
     */
    //@Test
    public void testGetInscription() {
        System.out.println("getInscription");
        int pid = 0;
        Inscription expResult = null;
        Inscription result = Inscription.getInscription(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifierInscription method, of class Inscription.
     */
    //@Test
    public void testModifierInscription() {
        System.out.println("modifierInscription");
        Inscription pinscription = null;
        boolean expResult = false;
        boolean result = Inscription.modifierInscription(pinscription);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerInscription method, of class Inscription.
     */
    //@Test
    public void testSupprimerInscription() {
        System.out.println("supprimerInscription");
        int pid = 0;
        boolean expResult = false;
        boolean result = Inscription.supprimerInscription(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInscriptonValide method, of class Inscription.
     */
    @Test
    public void testGetInscriptonValide() {
        System.out.println("getInscriptonValide");
        int pid = 1;
        String pnom = "Nom";
        String pprenom = "Prenom";
        String ptelephone = "4501231234";
        String pdate = "2000-01-01";
        String pcommentairePersonne = "CommentaireP";
        String pcommentaireAdministrateur = "CommentaireA";
        String pcommentaireRefus = "CommentaireR";
        String ppreferenceAppartement = "3";
        String ppreferenceEtage = "1";
        boolean pconfirme = true;
        String pcourriel = "Courriel";
        Inscription expResult = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        Inscription result = Inscription.getInscriptonValide(pid, pnom, pprenom, ptelephone, pdate, pcommentairePersonne, pcommentaireAdministrateur, pcommentaireRefus, ppreferenceAppartement, ppreferenceEtage, pconfirme, pcourriel);
        assertEquals(expResult, result);
        pid = 1;
        pnom = null;
        pprenom = "Prenom";
        ptelephone = "4501231234";
        pdate = "2000-01-01";
        pcommentairePersonne = "CommentaireP";
        pcommentaireAdministrateur = "CommentaireA";
        pcommentaireRefus = "CommentaireR";
        ppreferenceAppartement = "3";
        ppreferenceEtage = "1";
        pconfirme = true;
        pcourriel = "Courriel";
        expResult = null;
        result = Inscription.getInscriptonValide(pid, pnom, pprenom, ptelephone, pdate, pcommentairePersonne, pcommentaireAdministrateur, pcommentaireRefus, ppreferenceAppartement, ppreferenceEtage, pconfirme, pcourriel);
        assertEquals(expResult, result);
        pid = 1;
        pnom = "a";
        pprenom = null;
        ptelephone = null;
        pdate = null;
        pcommentairePersonne = "CommentaireP";
        pcommentaireAdministrateur = "CommentaireA";
        pcommentaireRefus = "CommentaireR";
        ppreferenceAppartement = "3";
        ppreferenceEtage = "1";
        pconfirme = true;
        pcourriel = "Courriel";
        expResult = null;
        result = Inscription.getInscriptonValide(pid, pnom, pprenom, ptelephone, pdate, pcommentairePersonne, pcommentaireAdministrateur, pcommentaireRefus, ppreferenceAppartement, ppreferenceEtage, pconfirme, pcourriel);
        assertEquals(expResult, result);
        pid = 1;
        pnom = "";
        pprenom = "";
        ptelephone = "";
        pdate = "";
        pcommentairePersonne = "CommentaireP";
        pcommentaireAdministrateur = "CommentaireA";
        pcommentaireRefus = "CommentaireR";
        ppreferenceAppartement = "3";
        ppreferenceEtage = "1";
        pconfirme = true;
        pcourriel = "Courriel";
        expResult = null;
        result = Inscription.getInscriptonValide(pid, pnom, pprenom, ptelephone, pdate, pcommentairePersonne, pcommentaireAdministrateur, pcommentaireRefus, ppreferenceAppartement, ppreferenceEtage, pconfirme, pcourriel);
        assertEquals(expResult, result);
        pid = 1;
        pnom = "a";
        pprenom = "a";
        ptelephone = null;
        pdate = null;
        pcommentairePersonne = "CommentaireP";
        pcommentaireAdministrateur = "CommentaireA";
        pcommentaireRefus = "CommentaireR";
        ppreferenceAppartement = "3";
        ppreferenceEtage = "1";
        pconfirme = true;
        pcourriel = "Courriel";
        expResult = null;
        result = Inscription.getInscriptonValide(pid, pnom, pprenom, ptelephone, pdate, pcommentairePersonne, pcommentaireAdministrateur, pcommentaireRefus, ppreferenceAppartement, ppreferenceEtage, pconfirme, pcourriel);
        assertEquals(expResult, result);
        pid = 1;
        pnom = "a";
        pprenom = "";
        ptelephone = "";
        pdate = "";
        pcommentairePersonne = "CommentaireP";
        pcommentaireAdministrateur = "CommentaireA";
        pcommentaireRefus = "CommentaireR";
        ppreferenceAppartement = "3";
        ppreferenceEtage = "1";
        pconfirme = true;
        pcourriel = "Courriel";
        expResult = null;
        result = Inscription.getInscriptonValide(pid, pnom, pprenom, ptelephone, pdate, pcommentairePersonne, pcommentaireAdministrateur, pcommentaireRefus, ppreferenceAppartement, ppreferenceEtage, pconfirme, pcourriel);
        assertEquals(expResult, result);
        pid = 1;
        pnom = "a";
        pprenom = "a";
        ptelephone = "a";
        pdate = null;
        pcommentairePersonne = "CommentaireP";
        pcommentaireAdministrateur = "CommentaireA";
        pcommentaireRefus = "CommentaireR";
        ppreferenceAppartement = "3";
        ppreferenceEtage = "1";
        pconfirme = true;
        pcourriel = "Courriel";
        expResult = null;
        result = Inscription.getInscriptonValide(pid, pnom, pprenom, ptelephone, pdate, pcommentairePersonne, pcommentaireAdministrateur, pcommentaireRefus, ppreferenceAppartement, ppreferenceEtage, pconfirme, pcourriel);
        assertEquals(expResult, result);
        pid = 1;
        pnom = "a";
        pprenom = "a";
        ptelephone = "";
        pdate = "";
        pcommentairePersonne = "CommentaireP";
        pcommentaireAdministrateur = "CommentaireA";
        pcommentaireRefus = "CommentaireR";
        ppreferenceAppartement = "3";
        ppreferenceEtage = "1";
        pconfirme = true;
        pcourriel = "Courriel";
        expResult = null;
        result = Inscription.getInscriptonValide(pid, pnom, pprenom, ptelephone, pdate, pcommentairePersonne, pcommentaireAdministrateur, pcommentaireRefus, ppreferenceAppartement, ppreferenceEtage, pconfirme, pcourriel);
        assertEquals(expResult, result);
        pid = 1;
        pnom = "a";
        pprenom = "a";
        ptelephone = "a";
        pdate = "";
        pcommentairePersonne = "CommentaireP";
        pcommentaireAdministrateur = "CommentaireA";
        pcommentaireRefus = "CommentaireR";
        ppreferenceAppartement = "3";
        ppreferenceEtage = "1";
        pconfirme = true;
        pcourriel = "Courriel";
        expResult = null;
        result = Inscription.getInscriptonValide(pid, pnom, pprenom, ptelephone, pdate, pcommentairePersonne, pcommentaireAdministrateur, pcommentaireRefus, ppreferenceAppartement, ppreferenceEtage, pconfirme, pcourriel);
        assertEquals(expResult, result);
    }
    /**
     * Texte très long.
     */
    public static final String MONA_LISA = "$Z$7$O$Z$7$Z77OZ7ZO$ZZ$$Z$OOZ$Z7$$ZZ7$$ZZ$ZOZ$$$ZZ$$$$$$Z$OZ"
            + "Z777$I$$$O$Z7$77$$Z$$77$$$$7ZZZZ77$$7IZ$$$ZZ$7$7O$$$$$$$$ZZZ"
            + "$I7$$7$$$I7Z7Z7$$7$7$$7Z7$7$$777Z7Z77$777$?Z777$77$I7$ZZ7ZZZ"
            + "7II7777III7O7777$7$$77$7$7$7$7$7I77ZIII7I7$$7I77Z$$I77Z7$O$$"
            + "$ZII7I?I777$II7II777$77?7I7ZNDDOZZ$I7$7$7$$$$I?I?7I77?$$$II7"
            + "I$?I77IIII$777III7I7I?I7MN8NDNMMN8ND$$I$7$7I777I777II?7$$Z$$"
            + "$77II7I?$?IIII7?I77II78888O8DDNMMNMMN$7II$$$III$7I$II777I77Z"
            + "7?III++II?III?I7I????D87I+II$Z8NNMMNMNDII+??77?$7II7$7$7I7$$"
            + "IIIIIIII?I?I?I+I7?IIO8II====?7ZODDNMNNND+77III?II?IIIII$Z777"
            + "??I?$??+?I=?I??$I?+$NO7?II+?I7$OODNMNMNM77II7II?7I7I?III7$$7"
            + "$7I$$I++?$+=+I+I?+$DM$++I+++?II$$ODNMNNMO$$$7IZ77?+?I7I7777$"
            + "OZZZ7Z$7$Z$$?==?=?8DM$I7I+?$Z$$$Z8NMNMNMMOOZZ$78$7III??7ZZOO"
            + "DD8OOZZZZOOZ$?=I+ZO8NNDNZ?$DONNDDO8NNMMMMO8OZZOO$$I7II7$$OZO"
            + "88$OO88ZO8OZ8O$O8Z8DMIIZ?+Z$$ZZ77Z8MMMNMMDD88O88O7III?I$ZZOO"
            + "OZ8ZZO8O8O8DD88O88DDM7+$I+77?I?IZONNMMMNN8DDO8DD88$$77777ZZO"
            + "DD8OODO88O88D8DNNN8DNZI77?$$?II$O8NMNMMMMNDDDO8DOZ$$Z88N8ZDN"
            + "NNND8D888OD8DD8DNDNNM8Z7?8N877$ZODDNNMMNNNMDDDNDND888DD8NDNN"
            + "DN88D88888DDNDNDDNNDDMZIIODDZ$ZZ8DNMNMNMNNDDND8DNN88O88DNNDM"
            + "NDDDDD88ND8D8ND8DDNDMMNO777$$$O8DDNDNNMNMN88D8DNNN8DDN8ND8DN"
            + "NNNMDDDDNDD8DD8N8NDN8DMMDI?$O8DNDNNNNMMNMNN888D8DDDDNDDDDDNM"
            + "NDNDND8N8N88O8OOZ8NNMNNNMNMNNMNDNNNNNNMNMMDDDNDDNDNNNNNDNNNN"
            + "NDNNNNDO8OZZZ$OOOZDN8NMMMNOZ88D8D88DNMMMNMD8D8NDDNDDNDDDNNNN"
            + "MNNDO88Z8ONOOD8Z$88DMMNMMNM$$O$OOZZONDMMNNNNNDND8OZOZ888NDNN"
            + "8888888Z888DMMMNNMMNNMNNMO$7II7777$ZDNNDNNMMNMNNNNDOZ88DOMMN"
            + "N8DMO8D8888DNDMNMMMNNMDO7I+I??????7ZDNDNDNNNMNOZZ7ZZ8O88DNNN"
            + "DD8N88ODO88NM8NMDNNNMD$?+?+=+?I+?$7$88NNNMDDNMNNZOZO$OOOOONM"
            + "DDODD$OO8ZDN88NDMMND88??==+?+?++??IZDN8NMND8ODNND8O8O88OOODM"
            + "DDDND8N$88Z8D8MMMMMZ$7=?+?+=??+?+?7ZDDNODZOZ8DNNNMND88DZOOOO"
            + "D8Z8D8DD8OOZ8MMMNM8Z7+7?+=+==+=++?77O88OI$8ODNMMMNMMNNM87ZZN"
            + "DDND8OOZ8Z$8NMMNMNO8I+=+?====~+=+?IZZODDMDNMNMMMMMMMNDDMNNOD"
            + "D8OZOZ8888NNMNNNNN8888O8Z=+==?+I78ODNDNNMNNMMMMMMMNMMDDNDNDM"
            + "N88OOOZ$OOMNMMNM88N88DOO8ZO8Z7ZOZNZNNMMN8DDNMMMMMMMMMMNNNDDM"
            + "MD88OZO88MNMMMMNNNDNMNDD8O8N8ODONMMNMDNDNMNNONNDNDMMMNDNDNNM"
            + "NND88D888NMMMMMMNNMDMNDDNODDDMNNNMNMNMNNNND8DDNDNMNMMMM88MMM"
            + "ND8ZZOZODNMMMMMMNNNNNNMNNNMNNNMNMMNMNMMM8DDDO8MNMMMMMMMDNNMM"
            + "88ZOOZOZNMMMMNNMNNMNNNNNMMNDNDNMMMMNMNNDNN8DNMMMMMMNNMMMDONM"
            + "ND88DDDNMMMNNMNNMMNNMNMMNDNNNMMNMMMMMMDDMNMMNNMNMMNMMNMMNMMN"
            + "NND8DDNNNNNNDNMMNMMNMNMMMNMNNMMMMMMMNMMNNMMMNNMMMMMNMNMMNNNM"
            + "DNDMNMMMDDDDNNNNMMMNNNMNMMNNMNMMMMMMMMNMMMMNMMMMMMMMMMMMMMMM"
            + "DDMNNDM8DMMMMNNMNMMNMMNMDMMMMMMMMMMMNMNMMMNMDMNMMMMMMMMNMNNM"
            + "NNNNNMNMNNMNNMNMMNMNMMMMMMMMMMMMMMMMMNMMMMMNMNDMMMNMMNMNNMNM"
            + "NMNNMND88M8DDNNNMMNNMMMMMMMMMMMMMMMMMMNMMMNMNMNMMMMMMMMMMMMM"
            + "MNMNMDDO7ZN8OD8N8II$NMMMMMMMMMNMMNNMMMMMMMMNNMMNMMMMMNMMMMMM"
            + "MMNNMM88O$8MNNZI?++II7$$MMMMMMMMMMMMMMMMMMMNNNMMNMMMMMMMMMMM"
            + "MMMNMDDDDMMNN8D777I?III7I$ZNMMMMMMMMMMMMMMMNMMNMMNMMMMMMMMMM"
            + "MNNNMMNNDN8ND8NOOZZ$7IIIII?I7$OMMMMMMMMMMNMMNNMMMMMMMMMMMMMM"
            + "MMNNNNNNMMNNNNNMNDO$777$77OOI?ZZZDZ8Z8888DD8NMMMNMMMMMMMMMMM"
            + "NMMNMNMMMNMNNN8$$$OOZZZ$ZZ77NDOO8OD88DNN8ONNDNMMMMMMMMMNMMMM"
            + "MNMMNMMNMNNMMZOO7Z$OOOOZ77DZ7ODM8ZDN88O8NNNNNDMMMMMMMMMMMMNM"
            + "MMNNMNMMNMNMOO$ZO77$O88ZNZ7OOZZ8NNNNDMNDNMNMNMMMMMMMMMMMMMNM"
            + "MMMNMNNNMNMND8O8Z7Z8DDNN8DD8DDD88NNNNMNMMMMNMMMMMMMMMMMMMMMM"
            + "MNNMMNNNMNMNNDDZ$8NNNDDDDDDDNNNMMMMMMMMMMMMMMMMMMMMMMMMNMMMM"
            + "MNNNNNNMNNNNNNNO8NNNNNMMNNNMMMNMMMMMMMMMMMMMMMMMMMMMNMNMMMMM"
            + "MMNNMNNMNNNMMMNNDNDNNNNNNNMNMMMMMMMMNMMMMMMMMMMNMMMMMMMMMMMM"
            + "NNMNNNNNMMNNNNNNNMMNMMMMNMMMMMMMMMMMMMMMMNNMMMMMMMMMMMMMMMMM"
            + "MNNNNMNMNNMMMNMMMMMMNNNMNMMNMMMNMMMMNMMMMMMMMMMMMMMNMMMMMMMM"
            + "MMMNNMNNMNNNNMMNMMMNNNNMMMMMMMNMNMMMMMMMNMMMMMMMMMMMMMMMMMMM"
            + "MNMNNNNNMMNNNNMMNMMNMNNNMNNMNMMMMMNMNMMMMMNMMNMMMMMMMMMMMMMM";

    /**
     * Test of valide method, of class Inscription.
     */
    @Test
    public void testValide() {
        System.out.println("valide");
        Inscription pinscription = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel@alpaga.ca");
        ConcurrentHashMap expResult = new ConcurrentHashMap();
        ConcurrentHashMap result = Inscription.valide(pinscription);
        assertEquals(expResult, result);
        pinscription = new Inscription(1, MONA_LISA, MONA_LISA, "4501231234-", "2000-13-01", MONA_LISA, MONA_LISA, MONA_LISA, "a", "a", true, MONA_LISA);
        result = Inscription.valide(pinscription);
        assertFalse(result.isEmpty());
        pinscription = new Inscription(1, "999", "666", "4501231234-", "2000-13-01", MONA_LISA, MONA_LISA, MONA_LISA, "a", "a", true, "Courriel");
        result = Inscription.valide(pinscription);
        assertFalse(result.isEmpty());
    }

    /**
     * Test of equals method, of class Inscription.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object objet = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        Inscription instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        boolean expResult = true;
        boolean result = instance.equals(objet);
        assertEquals(expResult, result);
        objet = new Inscription(1, "Nomm", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        expResult = false;
        result = instance.equals(objet);
        assertEquals(expResult, result);
        objet = null;
        instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        expResult = false;
        result = instance.equals(objet);
        assertEquals(expResult, result);
        objet = 1;
        instance = new Inscription(1, "Nom", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        expResult = false;
        result = instance.equals(objet);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Inscription.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Inscription instance = new Inscription(1, "Nomm", "Prenom", "4501231234", "2000-01-01", "CommentaireP", "CommentaireA", "CommentaireR", "3", "1", true, "Courriel");
        int expResult = 1;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
}
