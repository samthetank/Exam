/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class ControleurDivinTest {

    public ControleurDivinTest() {
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
     * Test of init method, of class ControleurDivin.
     */
    @Test
    public void testInit() throws Exception {
        System.out.println("init");
        ControleurDivin instance = new ControleurDivin();
        instance.init();
    }

    /**
     * Test of traiterRequete method, of class ControleurDivin.
     */
    //@Test
    public void testTraiterRequete() throws Exception {
        System.out.println("traiterRequete");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ControleurDivin instance = new ControleurDivin();
        instance.traiterRequete(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doGet method, of class ControleurDivin.
     */
    //@Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ControleurDivin instance = new ControleurDivin();
        instance.doGet(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doPost method, of class ControleurDivin.
     */
    //@Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ControleurDivin instance = new ControleurDivin();
        instance.doPost(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
