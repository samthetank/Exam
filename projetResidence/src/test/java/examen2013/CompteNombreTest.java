/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2013;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 0910062
 */
public class CompteNombreTest {
    
    public CompteNombreTest() {
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
     * Test of compterNombreNonRepetes method, of class CompteNombre.
     */
    @Test
    public void testCompterNombreNonRepetes() {
        System.out.println("compterNombreNonRepetes");
        int pnombre = 10;
        int expResult = 2;
        int result = CompteNombre.compterNombreNonRepetes(pnombre);
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class CompteNombre.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CompteNombre.main(args);
    }
}
