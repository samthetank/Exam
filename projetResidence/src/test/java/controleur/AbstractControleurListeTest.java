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
public class AbstractControleurListeTest {
    
    public AbstractControleurListeTest() {
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
     * Test of getActionAlternative1 method, of class AbstractControleurListe.
     */
    @Test
    public void testGetActionAlternative1() {
        System.out.println("getActionAlternative1");
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        String expResult = "actionalternative1";
        instance.setActionAlternative1("actionalternative1");
        String result = instance.getActionAlternative1();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActionAlternative1 method, of class AbstractControleurListe.
     */
    @Test
    public void testSetActionAlternative1() {
        System.out.println("setActionAlternative1");
        String pactionAlternative1 = "actionalternative1";
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        instance.setActionAlternative1(pactionAlternative1);
    }

    /**
     * Test of getActionAlternative2 method, of class AbstractControleurListe.
     */
    @Test
    public void testGetActionAlternative2() {
        System.out.println("getActionAlternative2");
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        String expResult = "actionalternative2";
        instance.setActionAlternative2("actionalternative2");
        String result = instance.getActionAlternative2();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActionAlternative2 method, of class AbstractControleurListe.
     */
    @Test
    public void testSetActionAlternative2() {
        System.out.println("setActionAlternative2");
        String pactionAlternative2 = "actionalternative2";
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        instance.setActionAlternative2(pactionAlternative2);
    }

    /**
     * Test of getSession method, of class AbstractControleurListe.
     */
    //@Test
    public void testGetSession() {
        System.out.println("getSession");
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        HttpSession expResult = null;
        HttpSession result = instance.getSession();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSession method, of class AbstractControleurListe.
     */
    //@Test
    public void testSetSession() {
        System.out.println("setSession");
        HttpSession psession = null;
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        instance.setSession(psession);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPageRetourForm method, of class AbstractControleurListe.
     */
    @Test
    public void testGetPageRetourForm() {
        System.out.println("getPageRetourForm");
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        String expResult = "./pageRetourForme";
        instance.setPageRetourForm("./pageRetourForme");
        String result = instance.getPageRetourForm();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPageRetourForm method, of class AbstractControleurListe.
     */
    @Test
    public void testSetPageRetourForm() {
        System.out.println("setPageRetourForm");
        String ppageRetourForm = "./pageRetourForme";
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        instance.setPageRetourForm(ppageRetourForm);
    }

    /**
     * Test of getPageRetourListe method, of class AbstractControleurListe.
     */
    @Test
    public void testGetPageRetourListe() {
        System.out.println("getPageRetourListe");
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        String expResult = "./pageRetourListe";
        instance.setPageRetourListe("./pageRetourListe");
        String result = instance.getPageRetourListe();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPageRetourListe method, of class AbstractControleurListe.
     */
    @Test
    public void testSetPageRetourListe() {
        System.out.println("setPageRetourListe");
        String ppageRetourListe = "./pageRetourListe";
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        instance.setPageRetourListe(ppageRetourListe);
    }

    /**
     * Test of getTitrePage method, of class AbstractControleurListe.
     */
    @Test
    public void testGetTitrePage() {
        System.out.println("getTitrePage");
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        String expResult = "titrePage";
        instance.setTitrePage("titrePage");
        String result = instance.getTitrePage();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitrePage method, of class AbstractControleurListe.
     */
    @Test
    public void testSetTitrePage() {
        System.out.println("setTitrePage");
        String ptitrePage = "titrePage";
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        instance.setTitrePage(ptitrePage);
    }

    /**
     * Test of aAccesPage method, of class AbstractControleurListe.
     */
    @Test
    public void testAAccesPage() {
        System.out.println("aAccesPage");
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        boolean expResult = false;
        boolean result = instance.aAccesPage();
        assertEquals(expResult, result);
    }

    /**
     * Test of initialiserControleur method, of class AbstractControleurListe.
     */
    @Test
    public void testInitialiserControleur() {
        System.out.println("initialiserControleur");
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        instance.initialiserControleur();
    }

    /**
     * Test of initialiserListeDroits method, of class AbstractControleurListe.
     */
    @Test
    public void testInitialiserListeDroits() {
        System.out.println("initialiserListeDroits");
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        instance.initialiserListeDroits();
    }

    /**
     * Test of executeSuppression method, of class AbstractControleurListe.
     */
    @Test
    public void testExecuteSuppression() {
        System.out.println("executeSuppression");
        int pidSuppression = 0;
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        instance.executeSuppression(pidSuppression);
    }

    /**
     * Test of executeActionAlternative1 method, of class AbstractControleurListe.
     */
    @Test
    public void testExecuteActionAlternative1() {
        System.out.println("executeActionAlternative1");
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        instance.executeActionAlternative1();
    }

    /**
     * Test of executeActionAlternative2 method, of class AbstractControleurListe.
     */
    @Test
    public void testExecuteActionAlternative2() {
        System.out.println("executeActionAlternative2");
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        instance.executeActionAlternative2();
    }

    /**
     * Test of attribuerListe method, of class AbstractControleurListe.
     */
    @Test
    public void testAttribuerListe() {
        System.out.println("attribuerListe");
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        instance.attribuerListe();
    }

    /**
     * Test of execute method, of class AbstractControleurListe.
     */
    //@Test
    public void testExecute() {
        System.out.println("execute");
        AbstractControleurListe instance = new AbstractControleurListeImpl();
        instance.execute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AbstractControleurListeImpl extends AbstractControleurListe {

        public boolean aAccesPage() {
            return false;
        }

        public void initialiserControleur() {
        }

        public void initialiserListeDroits() {
        }

        public void executeSuppression(int pidSuppression) {
        }

        public void executeActionAlternative1() {
        }

        public void executeActionAlternative2() {
        }

        public void attribuerListe() {
        }
    }
}