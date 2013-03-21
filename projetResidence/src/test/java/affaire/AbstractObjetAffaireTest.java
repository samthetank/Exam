/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package affaire;

import java.util.HashMap;
import java.util.Map;
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
public class AbstractObjetAffaireTest {

    public AbstractObjetAffaireTest() {
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
     * Test of supprimer method, of class AbstractObjetAffaire.
     */
    //@Test
    public void testSupprimer() {
        System.out.println("supprimer");
        AbstractObjetAffaire instance = new AbstractObjetAffaireImpl();
        boolean expResult = false;
        boolean result = instance.supprimer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifier method, of class AbstractObjetAffaire.
     */
    //@Test
    public void testModifier() {
        System.out.println("modifier");
        AbstractObjetAffaire instance = new AbstractObjetAffaireImpl();
        boolean expResult = false;
        boolean result = instance.modifier();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mapErreur method, of class AbstractObjetAffaire.
     */
    @Test
    public void testMapErreur() {
        System.out.println("mapErreur");
        Map<String, Object> map = new HashMap<String, Object>();
        boolean condition = false;
        String nomErreur = "error";
        String messageErreur = "Erreur";
        AbstractObjetAffaire.mapErreur(map, condition, nomErreur, messageErreur);
        assertTrue(map.isEmpty());
        map = new HashMap<String, Object>();
        condition = true;
        nomErreur = "error";
        messageErreur = "Erreur";
        AbstractObjetAffaire.mapErreur(map, condition, nomErreur, messageErreur);
        assertFalse(map.isEmpty());
    }

    public class AbstractObjetAffaireImpl extends AbstractObjetAffaire {

        public boolean supprimer() {
            return false;
        }

        public boolean modifier() {
            return false;
        }
    }
}
