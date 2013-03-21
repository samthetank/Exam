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
 * @author 1399017
 */
public class ControleurInscriptionTest {
    
    public ControleurInscriptionTest() {
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
     * Test of initialiserControleur method, of class ControleurInscription.
     */
    @Test
    public void testInitialiserControleur() {
        System.out.println("initialiserControleur");
        ControleurInscription instance = new ControleurInscription();
        instance.initialiserControleur();
    }

    /**
     * Test of executeAjouter method, of class ControleurInscription.
     */

    //@Test
    public void testExecuteAjouter() {
        System.out.println("executeAjouter");
        ControleurInscription instance = new ControleurInscription();
        boolean expResult = false;
        boolean result = instance.executeAjouter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeRemplirForm method, of class ControleurInscription.
     */
    
    //@Test
    public void testExecuteRemplirForm() {
        System.out.println("executeRemplirForm");
        String pid = "";
        ControleurInscription instance = new ControleurInscription();
        instance.executeRemplirForm(pid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeMettreAJour method, of class ControleurInscription.
     */

    //@Test
    public void testExecuteMettreAJour() {
        System.out.println("executeMettreAJour");
        String pid = "";
        ControleurInscription instance = new ControleurInscription();
        boolean expResult = false;
        boolean result = instance.executeMettreAJour(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeActionAlternative1 method, of class ControleurInscription.
     */
    @Test
    public void testExecuteActionAlternative1() {
        System.out.println("executeActionAlternative1");
        ControleurInscription instance = new ControleurInscription();
        try {
            instance.executeActionAlternative1();
        } catch (UnsupportedOperationException e) {
        }
    }

    /**
     * Test of executeActionAlternative2 method, of class ControleurInscription.
     */
    @Test
    public void testExecuteActionAlternative2() {
        System.out.println("executeActionAlternative2");
        ControleurInscription instance = new ControleurInscription();
        try {
            instance.executeActionAlternative2();
        } catch (UnsupportedOperationException e) {
        }
    }
}

