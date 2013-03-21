/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

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
public class UtilitaireTest {
    
    public UtilitaireTest() {
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
     * Test of filtrerString method, of class Utilitaire.
     */
    @Test
    public void testFiltrerString() {
        System.out.println("filtrerString");
        String chaine = "Lalalalalalablalalala";
        String souschaine = "b";
        String filtre = "la";
        String expResult = "Lalalalalalalalalalala";
        String result = Utilitaire.filtrerString(chaine, souschaine, filtre);
        assertEquals(expResult, result);
    }
}
