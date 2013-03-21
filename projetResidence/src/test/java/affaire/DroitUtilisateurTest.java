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
public class DroitUtilisateurTest {

    public DroitUtilisateurTest() {
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
     * Test of getIdDroitUtilisateur method, of class DroitUtilisateur.
     */
    @Test
    public void testGetIdDroitUtilisateur() {
        System.out.println("getIdDroitUtilisateur");
        DroitUtilisateur instance = new DroitUtilisateur(1, "Droit");
        instance = new DroitUtilisateur(instance);
        int expResult = 1;
        int result = instance.getIdDroitUtilisateur();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNomDroitUtilisateur method, of class DroitUtilisateur.
     */
    @Test
    public void testGetNomDroitUtilisateur() {
        System.out.println("getNomDroitUtilisateur");
        DroitUtilisateur instance = new DroitUtilisateur(1, "Droit");
        String expResult = "Droit";
        String result = instance.getNomDroitUtilisateur();
        assertEquals(expResult, result);
    }
}
