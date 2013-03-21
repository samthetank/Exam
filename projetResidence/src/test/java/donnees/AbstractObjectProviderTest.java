/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

import affaire.Appartement;
import affaire.Bail;
import affaire.Inscription;
import affaire.Log;
import affaire.Resident;
import affaire.Role;
import affaire.Utilisateur;
import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;
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
public class AbstractObjectProviderTest {
    
    public AbstractObjectProviderTest() {
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
     * Test of getDataSource method, of class AbstractObjectProvider.
     */
    @Test
    public void testGetDataSource() {
        System.out.println("getDataSource");
        DataSource expResult = AbstractObjectProvider.getDataSource();
        DataSource result = AbstractObjectProvider.getDataSource();
        assertEquals(expResult, result);
    }

    /**
     * Test of getConnection method, of class AbstractObjectProvider.
     */
    //@Test
    public void testGetConnection() {
        System.out.println("getConnection");
        //AbstractObjectProvider instance = new AbstractObjectProviderImpl();
        //Connection result = instance.getConnection();
        //assertNotNull(result);
    }

    /**
     * Test of freeConnection method, of class AbstractObjectProvider.
     */
    //@Test
    public void testFreeConnection() {
        System.out.println("freeConnection");
        Connection connexion = null;
        //AbstractObjectProvider instance = new AbstractObjectProviderImpl();
        //instance.freeConnection(connexion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
