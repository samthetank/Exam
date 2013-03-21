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
public class FabriqueControleurTest {
    
    public FabriqueControleurTest() {
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
     * Test of getControleurParClasse method, of class FabriqueControleur.
     */
    @Test
    public void testGetControleurParClasse() {
        System.out.println("getControleurParClasse");
        Class classeAction = ControleurResident.class;
        Controleur result = FabriqueControleur.getControleurParClasse(classeAction);
        assertNotNull(result);
        classeAction = int.class;
        result = FabriqueControleur.getControleurParClasse(classeAction);
        assertNull(result);
    }

    /**
     * Test of getControleurParNomClasse method, of class FabriqueControleur.
     */
    @Test
    public void testGetControleurParNomClasse() {
        System.out.println("getControleurParNomClasse");
        String nomClasse = "Resident";
        Controleur result = FabriqueControleur.getControleurParNomClasse(nomClasse);
        assertNotNull(result);
        nomClasse = "AAA";
        result = FabriqueControleur.getControleurParNomClasse(nomClasse);
        assertNull(result);
    }
}
