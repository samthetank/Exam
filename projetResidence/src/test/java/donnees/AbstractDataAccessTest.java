/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

import java.sql.Connection;
import java.util.List;
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
public class AbstractDataAccessTest {
    
    public AbstractDataAccessTest() {
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
     * Test of insererDonnees method, of class AbstractDataAccess.
     */
    //@Test
    public void testInsererDonnees() {
        System.out.println("insererDonnees");
        String nomTable = "";
        Map<String, Object> donnees = null;
        AbstractDataAccess instance = new AbstractDataAccessImpl();
        int expResult = 0;
        int result = instance.insererDonnees(nomTable, donnees);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifierDonnees method, of class AbstractDataAccess.
     */
    //@Test
    public void testModifierDonnees() {
        System.out.println("modifierDonnees");
        String nomTable = "";
        Map<String, Object> donnees = null;
        String nomClee = "";
        Object valeurClee = null;
        AbstractDataAccess instance = new AbstractDataAccessImpl();
        int expResult = 0;
        int result = instance.modifierDonnees(nomTable, donnees, nomClee, valeurClee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifierDonneesSelonPlusieurs method, of class AbstractDataAccess.
     */
    //@Test
    public void testModifierDonneesSelonPlusieurs() {
        System.out.println("modifierDonneesSelonPlusieurs");
        String nomTable = "";
        Map<String, Object> donnees = null;
        String nomChampId1 = "";
        Object valeurId1 = null;
        String nomChampId2 = "";
        Object valeurId2 = null;
        AbstractDataAccess instance = new AbstractDataAccessImpl();
        int expResult = 0;
        int result = instance.modifierDonneesSelonPlusieurs(nomTable, donnees, nomChampId1, valeurId1, nomChampId2, valeurId2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of effacerDonnees method, of class AbstractDataAccess.
     */
    //@Test
    public void testEffacerDonnees() {
        System.out.println("effacerDonnees");
        String nomTable = "";
        String nomChampId = "";
        int valeurId = 0;
        AbstractDataAccess instance = new AbstractDataAccessImpl();
        int expResult = 0;
        int result = instance.effacerDonnees(nomTable, nomChampId, valeurId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenirToutLesDonnees method, of class AbstractDataAccess.
     */
    //@Test
    public void testObtenirToutLesDonnees() {
        System.out.println("obtenirToutLesDonnees");
        String nomTable = "";
        AbstractDataAccess instance = new AbstractDataAccessImpl();
        List expResult = null;
        List result = instance.obtenirToutLesDonnees(nomTable);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenirDonneesSelonId method, of class AbstractDataAccess.
     */
    //@Test
    public void testObtenirDonneesSelonId() {
        System.out.println("obtenirDonneesSelonId");
        String nomTable = "";
        String nomChampId = "";
        Object valeurId = null;
        AbstractDataAccess instance = new AbstractDataAccessImpl();
        List expResult = null;
        List result = instance.obtenirDonneesSelonId(nomTable, nomChampId, valeurId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenirDonneesSelonPlusieursId method, of class AbstractDataAccess.
     */
    //@Test
    public void testObtenirDonneesSelonPlusieursId() {
        System.out.println("obtenirDonneesSelonPlusieursId");
        String nomTable = "";
        String nomChampId1 = "";
        Object valeurId1 = null;
        String nomChampId2 = "";
        Object valeurId2 = null;
        String nomChampId3 = "";
        Object valeurId3 = null;
        AbstractDataAccess instance = new AbstractDataAccessImpl();
        List expResult = null;
        List result = instance.obtenirDonneesSelonPlusieursId(nomTable, nomChampId1, valeurId1, nomChampId2, valeurId2, nomChampId3, valeurId3);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AbstractDataAccessImpl extends AbstractDataAccess {

        public Connection getConnection() {
            return null;
        }

        public void freeConnection(Connection connexion) {
        }
    }
}
