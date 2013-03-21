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
public class BailTest {

    public BailTest() {
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
     * Test of getIdLocataire method, of class Bail.
     */
    @Test
    public void testGetIdLocataire() {
        System.out.println("getIdLocataire");
        Bail instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        int expResult = 1;
        int result = instance.getIdLocataire();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdLocataireSecondaire method, of class Bail.
     */
    @Test
    public void testGetIdLocataireSecondaire() {
        System.out.println("getIdLocataireSecondaire");
        Bail instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        int expResult = 2;
        int result = instance.getIdLocataireSecondaire();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstLocataireSignataire method, of class Bail.
     */
    @Test
    public void testIsEstLocataireSignataire() {
        System.out.println("isEstLocataireSignataire");
        Bail instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        boolean expResult = true;
        boolean result = instance.isEstLocataireSignataire();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdBail method, of class Bail.
     */
    @Test
    public void testGetIdBail() {
        System.out.println("getIdBail");
        Bail instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        int expResult = 1;
        int result = instance.getIdBail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdAppartement method, of class Bail.
     */
    @Test
    public void testGetIdAppartement() {
        System.out.println("getIdAppartement");
        Bail instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        int expResult = 1;
        int result = instance.getIdAppartement();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateDebut method, of class Bail.
     */
    @Test
    public void testGetDateDebut() {
        System.out.println("getDateDebut");
        Bail instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        String expResult = "2000-01-01";
        String result = instance.getDateDebut();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateFin method, of class Bail.
     */
    @Test
    public void testGetDateFin() {
        System.out.println("getDateFin");
        Bail instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        String expResult = "2001-01-01";
        String result = instance.getDateFin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDernierMois method, of class Bail.
     */
    @Test
    public void testGetDernierMois() {
        System.out.println("getDernierMois");
        Bail instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        String expResult = "1";
        String result = instance.getDernierMois();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMontantLoyer method, of class Bail.
     */
    @Test
    public void testGetMontantLoyer() {
        System.out.println("getMontantLoyer");
        Bail instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        double expResult = 300.50;
        double result = instance.getMontantLoyer();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getCommentaire method, of class Bail.
     */
    @Test
    public void testGetCommentaire() {
        System.out.println("getCommentaire");
        Bail instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        String expResult = "Commentaire";
        String result = instance.getCommentaire();
        assertEquals(expResult, result);
    }

    /**
     * Test of egale method, of class Bail.
     */
    @Test
    public void testEgale() {
        System.out.println("egale");
        Bail pbail = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        Bail instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        boolean expResult = true;
        boolean result = instance.egale(pbail);
        assertEquals(expResult, result);
        pbail = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        instance = new Bail(2, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        expResult = false;
        result = instance.egale(pbail);
        assertEquals(expResult, result);
        pbail = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        instance = new Bail(1, 2, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        expResult = false;
        result = instance.egale(pbail);
        assertEquals(expResult, result);
        pbail = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        instance = new Bail(1, 1, "2001-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        expResult = false;
        result = instance.egale(pbail);
        assertEquals(expResult, result);
        pbail = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        instance = new Bail(1, 1, "2000-01-01", "2002-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        expResult = false;
        result = instance.egale(pbail);
        assertEquals(expResult, result);
        pbail = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "2", 300.50, "Commentaire", 1, 2, true);
        expResult = false;
        result = instance.egale(pbail);
        assertEquals(expResult, result);
        pbail = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 301.50, "Commentaire", 1, 2, true);
        expResult = false;
        result = instance.egale(pbail);
        assertEquals(expResult, result);
        pbail = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Coamentaire", 1, 2, true);
        expResult = false;
        result = instance.egale(pbail);
        assertEquals(expResult, result);
        pbail = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 2, 2, true);
        expResult = false;
        result = instance.egale(pbail);
        assertEquals(expResult, result);
        pbail = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 1, true);
        expResult = false;
        result = instance.egale(pbail);
        assertEquals(expResult, result);
        pbail = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        instance = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, false);
        expResult = false;
        result = instance.egale(pbail);
        assertEquals(expResult, result);
    }

    /**
     * Test of insererBail method, of class Bail.
     */
    //@Test
    public void testInsererBail() {
        System.out.println("insererBail");
        Bail pbail = null;
        boolean expResult = false;
        boolean result = Bail.insererBail(pbail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBails method, of class Bail.
     */
    //@Test
    public void testGetBails() {
        System.out.println("getBails");
        List expResult = null;
        List result = Bail.getBails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBail method, of class Bail.
     */
    //@Test
    public void testGetBail() {
        System.out.println("getBail");
        int pid = 0;
        Bail expResult = null;
        Bail result = Bail.getBail(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifierBail method, of class Bail.
     */
    //@Test
    public void testModifierBail() {
        System.out.println("modifierBail");
        Bail pbail = null;
        boolean expResult = false;
        boolean result = Bail.modifierBail(pbail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerBail method, of class Bail.
     */
    //@Test
    public void testSupprimerBail() {
        System.out.println("supprimerBail");
        int pid = 0;
        boolean expResult = false;
        boolean result = Bail.supprimerBail(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valide method, of class Bail.
     */
    //@Test
    public void testValide() {
        System.out.println("valide");
        Bail pbail = new Bail(1, 1, "2000-01-01", "2001-01-01", "1", 300.50, "Commentaire", 1, 2, true);
        int pid = 1;
        ConcurrentHashMap result = Bail.valide(pbail, pid);
        assertTrue(result.isEmpty());
    }
}
