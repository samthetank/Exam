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
public class RoleTest {

    public RoleTest() {
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
     * Test of getIdRole method, of class Role.
     */
    @Test
    public void testGetIdRole() {
        System.out.println("getIdRole");
        Role instance = new Role(1, "Nom", "Description");
        int expResult = 1;
        int result = instance.getIdRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNomRole method, of class Role.
     */
    @Test
    public void testGetNomRole() {
        System.out.println("getNomRole");
        Role instance = new Role(1, "Nom", "Description");
        instance = new Role(instance);
        String expResult = "Nom";
        String result = instance.getNomRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescriptionRole method, of class Role.
     */
    @Test
    public void testGetDescriptionRole() {
        System.out.println("getDescriptionRole");
        Role instance = new Role(1, "Nom", "Description");
        String expResult = "Description";
        String result = instance.getDescriptionRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRole method, of class Role.
     */
    //@Test
    public void testGetRole() {
        System.out.println("getRole");
        int pid = 1;
        Role expResult = new Role(1, "Nom", "Description");
        Role result = Role.getRole(pid);
        assertEquals(expResult, result);
    }
}
