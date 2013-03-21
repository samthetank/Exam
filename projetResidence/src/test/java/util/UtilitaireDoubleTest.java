/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 0962993
 */
public class UtilitaireDoubleTest {

    public UtilitaireDoubleTest() {
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
     *
     */
    private final static String MESSAGE_NON_EGALE = "Les deux objets devraient être égales.";

    /**
     * Test of reelPlusPetit method, of class UtilitaireDouble.
     */
    @Test
    public void testReelPlusPetit() {
        System.out.println("reelPlusPetit");
        double reel = 0.0;
        double reelCompare = 0.0;
        boolean expResult = false;
        boolean result = UtilitaireDouble.reelPlusPetit(reel, reelCompare);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        reel = 1.0;
        reelCompare = 0.0;
        expResult = false;
        result = UtilitaireDouble.reelPlusPetit(reel, reelCompare);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        reel = 0.0;
        reelCompare = 1.0;
        expResult = true;
        result = UtilitaireDouble.reelPlusPetit(reel, reelCompare);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of reelPlusGrand method, of class UtilitaireDouble.
     */
    @Test
    public void testReelPlusGrand() {
        System.out.println("reelPlusGrand");
        double reel = 0.0;
        double reelCompare = 0.0;
        boolean expResult = false;
        boolean result = UtilitaireDouble.reelPlusGrand(reel, reelCompare);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        reel = 0.0;
        reelCompare = 1.0;
        expResult = false;
        result = UtilitaireDouble.reelPlusGrand(reel, reelCompare);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        reel = 1.0;
        reelCompare = 0.0;
        expResult = true;
        result = UtilitaireDouble.reelPlusGrand(reel, reelCompare);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of reelDansIntervalle method, of class UtilitaireDouble.
     */
    @Test
    public void testReelDansIntervalle() {
        System.out.println("reelDansIntervalle");
        double reel = 0.0;
        double reelMin = 0.0;
        double reelMax = 0.0;
        boolean expResult = reelMin <= reel && reel <= reelMax;
        boolean result = UtilitaireDouble.reelDansIntervalle(reel, reelMin, reelMax);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        reel = 0.0;
        reelMin = -1.0;
        reelMax = 1.0;
        expResult = reelMin <= reel && reel <= reelMax;
        result = UtilitaireDouble.reelDansIntervalle(reel, reelMin, reelMax);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        reel = 0.0;
        reelMin = 1.0;
        reelMax = -1.0;
        expResult = reelMin <= reel && reel <= reelMax;
        result = UtilitaireDouble.reelDansIntervalle(reel, reelMin, reelMax);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        reel = 2.0;
        reelMin = -1.0;
        reelMax = 1.0;
        expResult = reelMin <= reel && reel <= reelMax;
        result = UtilitaireDouble.reelDansIntervalle(reel, reelMin, reelMax);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of obtenirReelAvecString method, of class UtilitaireDouble.
     */
    @Test
    public void testObtenirReelAvecString() {
        System.out.println("obtenirReelAvecString");
        String pchaine = "2.1";
        double expResult = 2.1;
        double result = UtilitaireDouble.obtenirReelAvecString(pchaine);
        assertEquals(expResult, result, 0.0);
        pchaine = "fraiufrg";
        expResult = -1;
        result = UtilitaireDouble.obtenirReelAvecString(pchaine);
        assertEquals(expResult, result, 0.0);
    }
}
