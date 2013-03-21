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
public class ControleurAppartementTest {
    
    public ControleurAppartementTest() {
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
     * Test of initialiserControleur method, of class ControleurAppartement.
     */
    @Test
    public void testInitialiserControleur() {
        System.out.println("initialiserControleur");
        ControleurAppartement instance = new ControleurAppartement();
   }

    /**
     * Test of executeAjouter method, of class ControleurAppartement.
     */
    //@Test
    public void testExecuteAjouter() {
        System.out.println("executeAjouter");
        ControleurAppartement instance = new ControleurAppartement();
        boolean expResult = false;
        boolean result = instance.executeAjouter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeRemplirForm method, of class ControleurAppartement.
     */
    //@Test
    public void testExecuteRemplirForm() {
        System.out.println("executeRemplirForm");
        String pid = "";
        ControleurAppartement instance = new ControleurAppartement();
        instance.executeRemplirForm(pid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeMettreAJour method, of class ControleurAppartement.
     */
    //@Test
    public void testExecuteMettreAJour() {
        System.out.println("executeMettreAJour");
        String pid = "";
        ControleurAppartement instance = new ControleurAppartement();
        boolean expResult = false;
        boolean result = instance.executeMettreAJour(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeActionAlternative1 method, of class ControleurAppartement.
     */
    @Test
    public void testExecuteActionAlternative1() {
        System.out.println("executeActionAlternative1");
        ControleurAppartement instance = new ControleurAppartement();
        try {
        instance.executeActionAlternative1();
        } catch (UnsupportedOperationException e) {
        }
    }

    /**
     * Test of executeActionAlternative2 method, of class ControleurAppartement.
     */
    @Test
    public void testExecuteActionAlternative2() {
        System.out.println("executeActionAlternative2");
        ControleurAppartement instance = new ControleurAppartement();
        try {
        instance.executeActionAlternative2();
        } catch (UnsupportedOperationException e) {
        }
    }
}
