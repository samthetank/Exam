/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package affaire;

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
public class LogTest {

    public LogTest() {
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
     * Test of getIdLog method, of class Log.
     */
    @Test
    public void testGetIdLog() {
        System.out.println("getIdLog");
        Log instance = new Log(1, "action", "Appartement", "nomUtilisateur", "dateLog", "valeur", "ancienneValeur");
        int expResult = 1;
        int result = instance.getIdLog();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAction method, of class Log.
     */
    @Test
    public void testGetAction() {
        System.out.println("getAction");
        Log instance = new Log(1, "action", "Appartement", "nomUtilisateur", "dateLog", "valeur", "ancienneValeur");
        String expResult = "action";
        String result = instance.getAction();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNomUtilisateur method, of class Log.
     */
    @Test
    public void testGetNomUtilisateur() {
        System.out.println("getNomUtilisateur");
        Log instance = new Log(1, "action", "Appartement", "nomUtilisateur", "dateLog", "valeur", "ancienneValeur");
        String expResult = "nomUtilisateur";
        String result = instance.getNomUtilisateur();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateLog method, of class Log.
     */
    @Test
    public void testGetDateLog() {
        System.out.println("getDateLog");
        Log instance = new Log(1, "action", "Appartement", "nomUtilisateur", "dateLog", "valeur", "ancienneValeur");
        String expResult = "dateLog";
        String result = instance.getDateLog();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValeur method, of class Log.
     */
    @Test
    public void testGetValeur() {
        System.out.println("getValeur");
        Log instance = new Log(1, "action", "Appartement", "nomUtilisateur", "dateLog", "valeur", "ancienneValeur");
        String expResult = "valeur";
        String result = instance.getValeur();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAncienneValeur method, of class Log.
     */
    @Test
    public void testGetAncienneValeur() {
        System.out.println("getAncienneValeur");
        Log instance = new Log(1, "action", "Appartement", "nomUtilisateur", "dateLog", "valeur", "ancienneValeur");
        String expResult = "ancienneValeur";
        String result = instance.getAncienneValeur();
        assertEquals(expResult, result);
    }

    /**
     * Test of insererLog method, of class Log.
     */
    //@Test
    public void testInsererLog() {
        System.out.println("insererLog");
        Log plog = null;
        boolean expResult = false;
        boolean result = Log.insererLog(plog);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLogs method, of class Log.
     */
    //@Test
    public void testGetLogs() {
        System.out.println("getLogs");
        List expResult = null;
        List result = Log.getLogs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLog method, of class Log.
     */
    //@Test
    public void testGetLog() {
        System.out.println("getLog");
        int pid = 0;
        Log expResult = null;
        Log result = Log.getLog(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerLog method, of class Log.
     */
    //@Test
    public void testSupprimerLog() {
        System.out.println("supprimerLog");
        int pid = 0;
        boolean expResult = false;
        boolean result = Log.supprimerLog(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getnomTable method, of class Log.
     */
    @Test
    public void testGetnomTable() {
        System.out.println("getnomTable");
        Log instance = new Log(1, "action", "Appartement", "nomUtilisateur", "dateLog", "valeur", "ancienneValeur");
        String expResult = "Appartement";
        String result = instance.getnomTable();
        assertEquals(expResult, result);
    }
}
