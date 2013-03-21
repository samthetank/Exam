/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package affaire;

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
public class UtilisateurTest {

    public UtilisateurTest() {
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
     * Test of getIdUtilisateur method, of class Utilisateur.
     */
    //@Test
    public void testGetIdUtilisateur() {
        System.out.println("getIdUtilisateur");
        Utilisateur instance = new Utilisateur(1, 1, "User", "Nom", "Prenom", "MotPasse", "Courriel");
        int expResult = 1;
        int result = instance.getIdUtilisateur();
        assertEquals(expResult, result);
    }
    

    /**
     * Test of getIdRole method, of class Utilisateur.
     */
    //@Test
    public void testGetIdRole() {
        System.out.println("getIdRole");
        Utilisateur instance = null;
        int expResult = 0;
        int result = instance.getIdRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNomUtilisateur method, of class Utilisateur.
     */
    //@Test
    public void testGetNomUtilisateur() {
        System.out.println("getNomUtilisateur");
        Utilisateur instance = null;
        String expResult = "";
        String result = instance.getNomUtilisateur();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNom method, of class Utilisateur.
     */
    //@Test
    public void testGetNom() {
        System.out.println("getNom");
        Utilisateur instance = null;
        String expResult = "";
        String result = instance.getNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrenom method, of class Utilisateur.
     */
    //@Test
    public void testGetPrenom() {
        System.out.println("getPrenom");
        Utilisateur instance = null;
        String expResult = "";
        String result = instance.getPrenom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMotDePasse method, of class Utilisateur.
     */
    //@Test
    public void testGetMotDePasse() {
        System.out.println("getMotDePasse");
        Utilisateur instance = null;
        String expResult = "";
        String result = instance.getMotDePasse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCourriel method, of class Utilisateur.
     */
    //@Test
    public void testGetCourriel() {
        System.out.println("getCourriel");
        Utilisateur instance = null;
        String expResult = "";
        String result = instance.getCourriel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNomRole method, of class Utilisateur.
     */
    //@Test
    public void testGetNomRole() {
        System.out.println("getNomRole");
        Utilisateur instance = null;
        String expResult = "";
        String result = instance.getNomRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUtilisateurs method, of class Utilisateur.
     */
    //@Test
    public void testGetUtilisateurs() {
        System.out.println("getUtilisateurs");
        List expResult = null;
        List result = Utilisateur.getUtilisateurs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUtilisateurString method, of class Utilisateur.
     */
    //@Test
    public void testGetUtilisateurString() {
        System.out.println("getUtilisateurString");
        String pnomUtilisateur = "";
        Utilisateur expResult = null;
        Utilisateur result = Utilisateur.getUtilisateurString(pnomUtilisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUtilisateur method, of class Utilisateur.
     */
    //@Test
    public void testGetUtilisateur() {
        System.out.println("getUtilisateur");
        int pid = 0;
        Utilisateur expResult = null;
        Utilisateur result = Utilisateur.getUtilisateur(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerUtilisateur method, of class Utilisateur.
     */
    //@Test
    public void testSupprimerUtilisateur() {
        System.out.println("supprimerUtilisateur");
        int pid = 0;
        boolean expResult = false;
        boolean result = Utilisateur.supprimerUtilisateur(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifierUtilisateur method, of class Utilisateur.
     */
    //@Test
    public void testModifierUtilisateur() {
        System.out.println("modifierUtilisateur");
        Utilisateur putilisateur = null;
        boolean expResult = false;
        boolean result = Utilisateur.modifierUtilisateur(putilisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insererUtilisateur method, of class Utilisateur.
     */
    //@Test
    public void testInsererUtilisateur() {
        System.out.println("insererUtilisateur");
        Utilisateur putilisateur = null;
        boolean expResult = false;
        boolean result = Utilisateur.insererUtilisateur(putilisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aDroitsUtilisateur method, of class Utilisateur.
     */
    //@Test
    public void testADroitsUtilisateur() {
        System.out.println("aDroitsUtilisateur");
        String pnomUtilisateur = "";
        String pnomDroits = "";
        Boolean expResult = null;
        Boolean result = Utilisateur.aDroitsUtilisateur(pnomUtilisateur, pnomDroits);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valide method, of class Utilisateur.
     */
    //@Test
    public void testValide() {
        System.out.println("valide");
        Utilisateur utilisateur = null;
        ConcurrentHashMap expResult = null;
        ConcurrentHashMap result = Utilisateur.valide(utilisateur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
