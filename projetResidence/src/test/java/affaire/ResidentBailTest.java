/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package affaire;

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
public class ResidentBailTest {

    public ResidentBailTest() {
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
     * Test of getIdResident method, of class ResidentBail.
     */
    @Test
    public void testGetIdResident() {
        System.out.println("getIdResident");
        ResidentBail instance = new ResidentBail(1, 2, true);
        instance = new ResidentBail(instance);
        int expResult = 1;
        int result = instance.getIdResident();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdBail method, of class ResidentBail.
     */
    @Test
    public void testGetIdBail() {
        System.out.println("getIdBail");
        ResidentBail instance = new ResidentBail(1, 2, true);
        int expResult = 2;
        int result = instance.getIdBail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEstResponsable method, of class ResidentBail.
     */
    @Test
    public void testGetEstResponsable() {
        System.out.println("getEstResponsable");
        ResidentBail instance = new ResidentBail(1, 2, true);
        boolean expResult = true;
        boolean result = instance.getEstResponsable();
        assertEquals(expResult, result);
    }
}
