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
public class ControleurListeAttenteTest {
    
    public ControleurListeAttenteTest() {
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
     * Test of aAccesPage method, of class ControleurListeAttente.
     */
    //@Test
    public void testAAccesPage() {
        System.out.println("aAccesPage");
        ControleurListeAttente instance = new ControleurListeAttente();
        boolean expResult = false;
        boolean result = instance.aAccesPage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialiserControleur method, of class ControleurListeAttente.
     */
    @Test
    public void testInitialiserControleur() {
        System.out.println("initialiserControleur");
        ControleurListeAttente instance = new ControleurListeAttente();
        instance.initialiserControleur();
    }

    /**
     * Test of initialiserListeDroits method, of class ControleurListeAttente.
     */
    //@Test
    public void testInitialiserListeDroits() {
        System.out.println("initialiserListeDroits");
        ControleurListeAttente instance = new ControleurListeAttente();
        instance.initialiserListeDroits();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeSuppression method, of class ControleurListeAttente.
     */
    //@Test
    public void testExecuteSuppression() {
        System.out.println("executeSuppression");
        int pidSuppression = 0;
        ControleurListeAttente instance = new ControleurListeAttente();
        instance.executeSuppression(pidSuppression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attribuerListe method, of class ControleurListeAttente.
     */
    //@Test
    public void testAttribuerListe() {
        System.out.println("attribuerListe");
        ControleurListeAttente instance = new ControleurListeAttente();
        instance.attribuerListe();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeActionAlternative1 method, of class ControleurListeAttente.
     */
    //@Test
    public void testExecuteActionAlternative1() {
        System.out.println("executeActionAlternative1");
        ControleurListeAttente instance = new ControleurListeAttente();
        instance.executeActionAlternative1();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeActionAlternative2 method, of class ControleurListeAttente.
     */
    @Test
    public void testExecuteActionAlternative2() {
        System.out.println("executeActionAlternative2");
        ControleurListeAttente instance = new ControleurListeAttente();
        try{
        instance.executeActionAlternative2();
        } catch (UnsupportedOperationException e) {
        }
    }
}
