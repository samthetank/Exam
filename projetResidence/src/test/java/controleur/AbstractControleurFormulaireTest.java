/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.servlet.http.HttpSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1399017
 */
public class AbstractControleurFormulaireTest {
    
    public AbstractControleurFormulaireTest() {
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
     * Test of getActionAlternative1 method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testGetActionAlternative1() {
        System.out.println("getActionAlternative1");
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        String expResult = "actionAlternative1";
        instance.setActionAlternative1("actionAlternative1");
        String result = instance.getActionAlternative1();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActionAlternative1 method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testSetActionAlternative1() {
        System.out.println("setActionAlternative1");
        String pactionAlternative1 = "actionAlternative1";
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        instance.setActionAlternative1(pactionAlternative1);
    }

    /**
     * Test of getActionAlternative2 method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testGetActionAlternative2() {
        System.out.println("getActionAlternative2");
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        String expResult = "actionAlternative2";
        instance.setActionAlternative2("actionAlternative2");
        String result = instance.getActionAlternative2();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActionAlternative2 method, of class AbstractControleurFormulaire.
     */
    @Test
    public final void testSetActionAlternative2() {
        System.out.println("setActionAlternative2");
        String pactionAlternative2 = "actionAlternative2";
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        instance.setActionAlternative2(pactionAlternative2);
    }

    /**
     * Test of getSession method, of class AbstractControleurFormulaire.
     */
    //@Test
    public void testGetSession() {
        System.out.println("getSession");
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        HttpSession expResult = null;
        HttpSession result = instance.getSession();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSession method, of class AbstractControleurFormulaire.
     */
    //@Test
    public void testSetSession() {
        System.out.println("setSession");
        HttpSession psession = null;
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        instance.setSession(psession);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPageRetourForm method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testGetPageRetourForm() {
        System.out.println("getPageRetourForm");
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        String expResult = "./pageRetourForm";
        instance.setPageRetourForm("./pageRetourForm");
        String result = instance.getPageRetourForm();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPageRetourForm method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testSetPageRetourForm() {
        System.out.println("setPageRetourForm");
        String ppageRetourForm = "./pageRetourForm";
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        instance.setPageRetourForm(ppageRetourForm);
    }

    /**
     * Test of getPageRetourListe method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testGetPageRetourListe() {
        System.out.println("getPageRetourListe");
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        String expResult = "./pageRetourListe";
        instance.setPageRetourListe("./pageRetourListe");
        String result = instance.getPageRetourListe();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPageRetourListe method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testSetPageRetourListe() {
        System.out.println("setPageRetourListe");
        String ppageRetourListe = "./pageRetourListe";
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        instance.setPageRetourListe(ppageRetourListe);
    }

    /**
     * Test of getTitrePage method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testGetTitrePage() {
        System.out.println("getTitrePage");
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        String expResult = "titrepage";
        instance.setTitrePage("titrepage");
        String result = instance.getTitrePage();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitrePage method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testSetTitrePage() {
        System.out.println("setTitrePage");
        String ptitrePage = "titrepage";
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        instance.setTitrePage(ptitrePage);
    }

    /**
     * Test of setValeur method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testSetValeur() {
        System.out.println("setValeur");
        String pvaleur = "valeur";
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        instance.setValeur(pvaleur);
    }

    /**
     * Test of setAncienneValeur method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testSetAncienneValeur() {
        System.out.println("setAncienneValeur");
        String pancienneValeur = "anciennevaleur";
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        instance.setAncienneValeur(pancienneValeur);
    }

    /**
     * Test of setNomTable method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testSetNomTable() {
        System.out.println("setNomTable");
        String pnomTable = "nomtable";
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        instance.setNomTable(pnomTable);
    }

    /**
     * Test of initialiserControleur method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testInitialiserControleur() {
        System.out.println("initialiserControleur");
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        instance.initialiserControleur();
    }

    /**
     * Test of executeAjouter method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testExecuteAjouter() {
        System.out.println("executeAjouter");
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        boolean expResult = false;
        boolean result = instance.executeAjouter();
        assertEquals(expResult, result);
    }

    /**
     * Test of executeRemplirForm method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testExecuteRemplirForm() {
        System.out.println("executeRemplirForm");
        String pid = "1";
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        instance.executeRemplirForm(pid);
    }

    /**
     * Test of executeActionAlternative2 method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testExecuteActionAlternative2() {
        System.out.println("executeActionAlternative2");
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        instance.executeActionAlternative2();
    }

    /**
     * Test of executeMettreAJour method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testExecuteMettreAJour() {
        System.out.println("executeMettreAJour");
        String pid = "1";
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        boolean expResult = false;
        boolean result = instance.executeMettreAJour(pid);
        assertEquals(expResult, result);
    }

    /**
     * Test of executeActionAlternative1 method, of class AbstractControleurFormulaire.
     */
    @Test
    public void testExecuteActionAlternative1() {
        System.out.println("executeActionAlternative1");
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        instance.executeActionAlternative1();
    }

    /**
     * Test of execute method, of class AbstractControleurFormulaire.
     */
    //@Test
    public void testExecute() {
        System.out.println("execute");
        AbstractControleurFormulaire instance = new AbstractControleurFormulaireImpl();
        instance.execute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AbstractControleurFormulaireImpl extends AbstractControleurFormulaire {

        public void initialiserControleur() {
        }

        public boolean executeAjouter() {
            return false;
        }

        public void executeRemplirForm(String pid) {
        }

        public void executeActionAlternative2() {
        }

        public boolean executeMettreAJour(String pid) {
            return false;
        }

        public void executeActionAlternative1() {
        }
    }
}