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
import java.util.ArrayList;
import java.util.List;
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
public class SqlObjectProviderTest {
    
    public SqlObjectProviderTest() {
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
     * Test of getInstance method, of class SqlObjectProvider.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        AbstractObjectProvider expResult = SqlObjectProvider.getInstance();
        AbstractObjectProvider result = SqlObjectProvider.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of objetEnString method, of class SqlObjectProvider.
     */
    @Test
    public void testObjetEnString() {
        System.out.println("objetEnString");
        Object pobjet = new Resident(1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        SqlObjectProvider instance = (SqlObjectProvider)SqlObjectProvider.getInstance();
        String expResult = "telephone Secondaire Resident: 5141231234, commentaire plainte: , telephone Resident: 4501231234, plaque Immatriculation: GOD666, nom Véhicule: Lada, commentaire Resident: , nom Resident: Nom, commentaire Intervention: , couleur Intervention: V, prenom Resident: Prenom, date Arrivee Resident: 2000-01-01, titre Resident: M., date Naissance Resident: 1900-01-01";
        String result = instance.objetEnString(pobjet);
        assertEquals(expResult, result);
    }

    /**
     * Test of getInscriptions method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetInscriptions() {
        System.out.println("getInscriptions");
        SqlObjectProvider instance = (SqlObjectProvider)SqlObjectProvider.getInstance();
        List expResult = new ArrayList<Inscription>();
        List result = instance.getInscriptions();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInscription method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetInscription() {
        System.out.println("getInscription");
        Object pvaleur = null;
        SqlObjectProvider instance = null;
        Inscription expResult = null;
        Inscription result = instance.getInscription(pvaleur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerInscription method, of class SqlObjectProvider.
     */
    //@Test
    public void testSupprimerInscription() {
        System.out.println("supprimerInscription");
        int pid = 0;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.supprimerInscription(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifierInscription method, of class SqlObjectProvider.
     */
    //@Test
    public void testModifierInscription() {
        System.out.println("modifierInscription");
        Inscription pinscription = null;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.modifierInscription(pinscription);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insererInscription method, of class SqlObjectProvider.
     */
    //@Test
    public void testInsererInscription() {
        System.out.println("insererInscription");
        Inscription pinscription = null;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.insererInscription(pinscription);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAppartement method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetAppartement() {
        System.out.println("getAppartement");
        Object pvaleur = null;
        SqlObjectProvider instance = null;
        Appartement expResult = null;
        Appartement result = instance.getAppartement(pvaleur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAppartements method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetAppartements() {
        System.out.println("getAppartements");
        SqlObjectProvider instance = null;
        List expResult = null;
        List result = instance.getAppartements();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerAppartement method, of class SqlObjectProvider.
     */
    //@Test
    public void testSupprimerAppartement() {
        System.out.println("supprimerAppartement");
        int pid = 0;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.supprimerAppartement(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifierAppartement method, of class SqlObjectProvider.
     */
    //@Test
    public void testModifierAppartement() {
        System.out.println("modifierAppartement");
        Appartement pappartement = null;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.modifierAppartement(pappartement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insererAppartement method, of class SqlObjectProvider.
     */
    //@Test
    public void testInsererAppartement() {
        System.out.println("insererAppartement");
        Appartement pappartement = null;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.insererAppartement(pappartement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBail method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetBail() {
        System.out.println("getBail");
        int pid = 0;
        SqlObjectProvider instance = null;
        Bail expResult = null;
        Bail result = instance.getBail(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdBail method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetIdBail() {
        System.out.println("getIdBail");
        Bail pbail = null;
        SqlObjectProvider instance = null;
        int expResult = 0;
        int result = instance.getIdBail(pbail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBails method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetBails() {
        System.out.println("getBails");
        SqlObjectProvider instance = null;
        List expResult = null;
        List result = instance.getBails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerBail method, of class SqlObjectProvider.
     */
    //@Test
    public void testSupprimerBail() {
        System.out.println("supprimerBail");
        int pid = 0;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.supprimerBail(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifierBail method, of class SqlObjectProvider.
     */
    //@Test
    public void testModifierBail() {
        System.out.println("modifierBail");
        Bail pbail = null;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.modifierBail(pbail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insererBail method, of class SqlObjectProvider.
     */
    //@Test
    public void testInsererBail() {
        System.out.println("insererBail");
        Bail pbail = null;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.insererBail(pbail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResident method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetResident() {
        System.out.println("getResident");
        Object pvaleur = null;
        SqlObjectProvider instance = null;
        Resident expResult = null;
        Resident result = instance.getResident(pvaleur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResidents method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetResidents() {
        System.out.println("getResidents");
        SqlObjectProvider instance = null;
        List expResult = null;
        List result = instance.getResidents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerResident method, of class SqlObjectProvider.
     */
    //@Test
    public void testSupprimerResident() {
        System.out.println("supprimerResident");
        int pid = 0;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.supprimerResident(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifierResident method, of class SqlObjectProvider.
     */
    //@Test
    public void testModifierResident() {
        System.out.println("modifierResident");
        Resident president = null;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.modifierResident(president);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insererResident method, of class SqlObjectProvider.
     */
    //@Test
    public void testInsererResident() {
        System.out.println("insererResident");
        Resident president = null;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.insererResident(president);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUtilisateurs method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetUtilisateurs() {
        System.out.println("getUtilisateurs");
        SqlObjectProvider instance = null;
        List expResult = null;
        List result = instance.getUtilisateurs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUtilisateur method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetUtilisateur_String() {
        System.out.println("getUtilisateur");
        String pnomUtlisateur = "";
        SqlObjectProvider instance = null;
        Utilisateur expResult = null;
        Utilisateur result = instance.getUtilisateur(pnomUtlisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDroitsUtilisateurs method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetDroitsUtilisateurs_String() {
        System.out.println("getDroitsUtilisateurs");
        String pnomUtilisateur = "";
        SqlObjectProvider instance = null;
        List expResult = null;
        List result = instance.getDroitsUtilisateurs(pnomUtilisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDroitsUtilisateurs method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetDroitsUtilisateurs_int() {
        System.out.println("getDroitsUtilisateurs");
        int pidRole = 0;
        SqlObjectProvider instance = null;
        List expResult = null;
        List result = instance.getDroitsUtilisateurs(pidRole);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRole method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetRole() {
        System.out.println("getRole");
        int pidRole = 0;
        SqlObjectProvider instance = null;
        Role expResult = null;
        Role result = instance.getRole(pidRole);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUtilisateur method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetUtilisateur_int() {
        System.out.println("getUtilisateur");
        int pid = 0;
        SqlObjectProvider instance = null;
        Utilisateur expResult = null;
        Utilisateur result = instance.getUtilisateur(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerUtilisateur method, of class SqlObjectProvider.
     */
    //@Test
    public void testSupprimerUtilisateur() {
        System.out.println("supprimerUtilisateur");
        int pid = 0;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.supprimerUtilisateur(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifierUtilisateur method, of class SqlObjectProvider.
     */
    //@Test
    public void testModifierUtilisateur() {
        System.out.println("modifierUtilisateur");
        Utilisateur putilisateur = null;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.modifierUtilisateur(putilisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insererUtilisateur method, of class SqlObjectProvider.
     */
    //@Test
    public void testInsererUtilisateur() {
        System.out.println("insererUtilisateur");
        Utilisateur putilisateur = null;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.insererUtilisateur(putilisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLogs method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetLogs() {
        System.out.println("getLogs");
        SqlObjectProvider instance = null;
        List expResult = null;
        List result = instance.getLogs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLog method, of class SqlObjectProvider.
     */
    //@Test
    public void testGetLog() {
        System.out.println("getLog");
        Object pvaleur = null;
        SqlObjectProvider instance = null;
        Log expResult = null;
        Log result = instance.getLog(pvaleur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insererLog method, of class SqlObjectProvider.
     */
    //@Test
    public void testInsererLog() {
        System.out.println("insererLog");
        Log plog = null;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.insererLog(plog);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerLog method, of class SqlObjectProvider.
     */
    //@Test
    public void testSupprimerLog() {
        System.out.println("supprimerLog");
        int pid = 0;
        SqlObjectProvider instance = null;
        boolean expResult = false;
        boolean result = instance.supprimerLog(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
