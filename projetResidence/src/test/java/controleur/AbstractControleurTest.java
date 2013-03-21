/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author 0962993
 */
public class AbstractControleurTest {
    
    public AbstractControleurTest() {
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
     * Test of init method, of class AbstractControleur.
     */

    //@Test
    public void testInit() {
        System.out.println("init");
        HttpServletRequest prequete = null;
        AbstractControleur instance = new AbstractControleurImpl();
        instance.init(prequete);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPageRetour method, of class AbstractControleur.
     */
    @Test
    public void testSetPageRetour() {
        System.out.println("setPageRetour");
        String page = "./pageretour";
        AbstractControleur instance = new AbstractControleurImpl();
        instance.setPageRetour(page);
    }

    /**
     * Test of getPageRetour method, of class AbstractControleur.
     */
    @Test
    public void testGetPageRetour() {
        System.out.println("getPageRetour");
        AbstractControleur instance = new AbstractControleurImpl();
        String expResult = "./pageretour";
        instance.setPageRetour("./pageretour");
        String result = instance.getPageRetour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRequete method, of class AbstractControleur.
     */
    //@Test
    public void testGetRequete() {
        System.out.println("getRequete");
        AbstractControleur instance = new AbstractControleurImpl();
        HttpServletRequest expResult = null;
        HttpServletRequest result = instance.getRequete();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRequete method, of class AbstractControleur.
     */
    //@Test
    public void testSetRequete() {
        System.out.println("setRequete");
        HttpServletRequest prequete = null;
        AbstractControleur instance = new AbstractControleurImpl();
        instance.setRequete(prequete);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOnglet method, of class AbstractControleur.
     */
    @Test
    public void testSetOnglet() {
        System.out.println("setOnglet");
        String ponglet = "onglet";
        AbstractControleur instance = new AbstractControleurImpl();
        instance.setOnglet(ponglet);
    }

    /**
     * Test of getOnglet method, of class AbstractControleur.
     */
    @Test
    public void testGetOnglet() {
        System.out.println("getOnglet");
        AbstractControleur instance = new AbstractControleurImpl();
        String expResult = "onglet";
        instance.setOnglet("onglet");
        String result = instance.getOnglet();
        assertEquals(expResult, result);
    }

    public class AbstractControleurImpl extends AbstractControleur {
        @Override
        public void execute() {
            
        }
    }
}

