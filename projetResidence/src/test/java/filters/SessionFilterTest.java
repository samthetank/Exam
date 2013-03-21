/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
public class SessionFilterTest {
    
    public SessionFilterTest() {
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
     * Test of init method, of class SessionFilter.
     */
    @Test
    public void testInit() throws Exception {
        System.out.println("init");
        FilterConfig config = null;
        SessionFilter instance = new SessionFilter();
        instance.init(config);
    }

    /**
     * Test of doFilter method, of class SessionFilter.
     */
    //@Test
    public void testDoFilter() throws Exception {
        System.out.println("doFilter");
        ServletRequest request = null;
        ServletResponse response = null;
        FilterChain chain = null;
        SessionFilter instance = new SessionFilter();
        instance.doFilter(request, response, chain);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class SessionFilter.
     */
    @Test
    public void testDestroy() {
        System.out.println("destroy");
        SessionFilter instance = new SessionFilter();
        instance.destroy();
    }
}
