/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

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
public class ControleurLogTest {
    
    public ControleurLogTest() {
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
     * Test of initialiserControleur method, of class ControleurLog.
     */
    @Test
    public void testInitialiserControleur() {
        System.out.println("initialiserControleur");
        ControleurLog instance = new ControleurLog();
        instance.initialiserControleur();
    }

    /**
     * Test of executeAjouter method, of class ControleurLog.
     */
    @Test
    public void testExecuteAjouter() {
        System.out.println("executeAjouter");
        ControleurLog instance = new ControleurLog();
        boolean expResult = false;
        try {
        boolean result = instance.executeAjouter();
        assertEquals(expResult, result);
        } catch (UnsupportedOperationException e) {
        }
    }

    /**
     * Test of executeRemplirForm method, of class ControleurLog.
     */
    @Test
    public void testExecuteRemplirForm() {
        System.out.println("executeRemplirForm");
        String pid = "";
        ControleurLog instance = new ControleurLog();
        try {
        instance.executeRemplirForm(pid);
        } catch (UnsupportedOperationException e) {
        }
    }

    /**
     * Test of executeMettreAJour method, of class ControleurLog.
     */
    @Test
    public void testExecuteMettreAJour() {
        System.out.println("executeMettreAJour");
        String pid = "";
        ControleurLog instance = new ControleurLog();
        boolean expResult = false;
        try {
        boolean result = instance.executeMettreAJour(pid);
        assertEquals(expResult, result);
        } catch (UnsupportedOperationException e) {
        }
    }

    /**
     * Test of executeActionAlternative1 method, of class ControleurLog.
     */
    //@Test
    public void testExecuteActionAlternative1() {
        System.out.println("executeActionAlternative1");
        ControleurLog instance = new ControleurLog();
        instance.executeActionAlternative1();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeActionAlternative2 method, of class ControleurLog.
     */
    @Test
    public void testExecuteActionAlternative2() {
        System.out.println("executeActionAlternative2");
        ControleurLog instance = new ControleurLog();
        try{
        instance.executeActionAlternative2();
        } catch (UnsupportedOperationException e) {
        }
    }
}
