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
public class UtilitaireEntierTest {

    public UtilitaireEntierTest() {
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
     * Message dans un cas où deux objets sont inégaux.
     */
    private static final String MESSAGE_NON_EGAL = "Les deux objets devraient être égales.";

    /**
     * Test of entierPlusPetit method, of class UtilitaireEntier.
     */
    @Test
    public final void testEntierPlusPetit() {
        System.out.println("entierPlusPetit");
        int entier = -1;
        int entierCompare = 1;
        boolean expResult = entier < entierCompare;
        boolean result = UtilitaireEntier.entierPlusPetit(entier, entierCompare);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
        entier = 1;
        entierCompare = -1;
        expResult = entier < entierCompare;
        result = UtilitaireEntier.entierPlusPetit(entier, entierCompare);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
        entier = 1;
        entierCompare = 1;
        expResult = entier < entierCompare;
        result = UtilitaireEntier.entierPlusPetit(entier, entierCompare);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
    }

    /**
     * Test of entierPlusGrand method, of class UtilitaireEntier.
     */
    @Test
    public final void testEntierPlusGrand() {
        System.out.println("entierPlusGrand");
        int entier = 1;
        int entierCompare = -1;
        boolean expResult = entier > entierCompare;
        boolean result = UtilitaireEntier.entierPlusGrand(entier, entierCompare);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
        entier = 0;
        entierCompare = 0;
        expResult = entier > entierCompare;
        result = UtilitaireEntier.entierPlusGrand(entier, entierCompare);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
        entier = -1;
        entierCompare = 1;
        expResult = entier > entierCompare;
        result = UtilitaireEntier.entierPlusGrand(entier, entierCompare);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
    }

    /**
     * Test of entierDansIntervalle method, of class UtilitaireEntier.
     */
    @Test
    public final void testEntierDansIntervalle() {
        System.out.println("entierDansIntervalle");
        int entier = 0;
        int entierMin = -1;
        int entierMax = 1;
        boolean expResult = entierMin <= entier && entier <= entierMax;
        boolean result = UtilitaireEntier.entierDansIntervalle(entier, entierMin, entierMax);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
        entier = -1;
        entierMin = -1;
        entierMax = 1;
        expResult = entierMin <= entier && entier <= entierMax;
        result = UtilitaireEntier.entierDansIntervalle(entier, entierMin, entierMax);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
        entier = 1;
        entierMin = -1;
        entierMax = 1;
        expResult = entierMin <= entier && entier <= entierMax;
        result = UtilitaireEntier.entierDansIntervalle(entier, entierMin, entierMax);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
        entier = 0;
        entierMin = 0;
        entierMax = 0;
        expResult = entierMin <= entier && entier <= entierMax;
        result = UtilitaireEntier.entierDansIntervalle(entier, entierMin, entierMax);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
        entier = 2;
        entierMin = -1;
        entierMax = 1;
        expResult = entierMin <= entier && entier <= entierMax;
        result = UtilitaireEntier.entierDansIntervalle(entier, entierMin, entierMax);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
        entier = -2;
        entierMin = -1;
        entierMax = 1;
        expResult = entierMin <= entier && entier <= entierMax;
        result = UtilitaireEntier.entierDansIntervalle(entier, entierMin, entierMax);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
        entier = 0;
        entierMin = 1;
        entierMax = -1;
        expResult = entierMin <= entier && entier <= entierMax;
        result = UtilitaireEntier.entierDansIntervalle(entier, entierMin, entierMax);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
    }

    /**
     * Test of entierATexte method, of class UtilitaireEntier.
     */
    @Test
    public final void testEntierATexte() {
        System.out.println("entierATexte");
        int entier = 0;
        String expResult = "0";
        String result = UtilitaireEntier.entierATexte(entier);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
        entier = 100;
        expResult = "100";
        result = UtilitaireEntier.entierATexte(entier);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
        entier = -100;
        expResult = "-100";
        result = UtilitaireEntier.entierATexte(entier);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
    }

    /**
     * Test of entierATexteMin method, of class UtilitaireEntier.
     */
    @Test
    public final void testEntierATexteMin() {
        System.out.println("entierATexteMin");
        int entier = 0;
        int chiffreMin = 2;
        String expResult = "00";
        String result = UtilitaireEntier.entierATexteMin(entier, chiffreMin);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
        entier = 1000;
        chiffreMin = 2;
        expResult = "1000";
        result = UtilitaireEntier.entierATexteMin(entier, chiffreMin);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
        entier = -1000;
        chiffreMin = 2;
        expResult = "-1000";
        result = UtilitaireEntier.entierATexteMin(entier, chiffreMin);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
        entier = -100;
        chiffreMin = 5;
        expResult = "-00100";
        result = UtilitaireEntier.entierATexteMin(entier, chiffreMin);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
        entier = -100;
        chiffreMin = -1;
        expResult = "-100";
        result = UtilitaireEntier.entierATexteMin(entier, chiffreMin);
        assertEquals(MESSAGE_NON_EGAL, expResult, result);
    }

    /**
     * Test of obtenirEntierAvecString method, of class UtilitaireEntier.
     */
    @Test
    public void testObtenirEntierAvecString() {
        System.out.println("obtenirEntierAvecString");
        String pchaine = "100";
        int expResult = 100;
        int result = UtilitaireEntier.obtenirEntierAvecString(pchaine);
        assertEquals(expResult, result);
        pchaine = "error";
        expResult = -1;
        result = UtilitaireEntier.obtenirEntierAvecString(pchaine);
        assertEquals(expResult, result);
    }
}
