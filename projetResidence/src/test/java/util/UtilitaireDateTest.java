/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import donnees.SqlObjectProvider;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class UtilitaireDateTest {

    public UtilitaireDateTest() {
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
     * Test of dateAnterieure method, of class UtilitaireDate.
     */
    @Test
    public void testDateAnterieure_GregorianCalendar_GregorianCalendar() {
        System.out.println("dateAnterieure");
        GregorianCalendar date = new GregorianCalendar(2012, 1, 1);
        GregorianCalendar dateCompare = new GregorianCalendar(2013, 1, 1);
        boolean expResult = true;
        boolean result = UtilitaireDate.dateAnterieure(date, dateCompare);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        date = new GregorianCalendar(2013, 1, 1);
        dateCompare = new GregorianCalendar(2012, 1, 1);
        expResult = false;
        result = UtilitaireDate.dateAnterieure(date, dateCompare);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        date = new GregorianCalendar(2013, 1, 1);
        dateCompare = new GregorianCalendar(2013, 1, 1);
        expResult = false;
        result = UtilitaireDate.dateAnterieure(date, dateCompare);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of dateAnterieure method, of class UtilitaireDate.
     */
    @Test
    public void testDateAnterieure_String_String() {
        System.out.println("dateAnterieure");
        String date = "2000-01-01";
        String dateCompare = "2000-15-15";
        boolean expResult = false;
        boolean result = UtilitaireDate.dateAnterieure(date, dateCompare);
        assertEquals(expResult, result);
        date = "2000-01-34";
        dateCompare = "2000-12-15";
        expResult = false;
        result = UtilitaireDate.dateAnterieure(date, dateCompare);
        assertEquals(expResult, result);
        date = "2000-01-01";
        dateCompare = "2000-12-15";
        expResult = true;
        result = UtilitaireDate.dateAnterieure(date, dateCompare);
        assertEquals(expResult, result);
        date = "2000-01-01";
        dateCompare = "1900-12-15";
        expResult = false;
        result = UtilitaireDate.dateAnterieure(date, dateCompare);
        assertEquals(expResult, result);
    }

    /**
     * Test of datePosterieure method, of class UtilitaireDate.
     */
    @Test
    public void testDatePosterieure() {
        System.out.println("datePosterieure");
        GregorianCalendar date = new GregorianCalendar(2013, 1, 1);
        GregorianCalendar dateCompare = new GregorianCalendar(2012, 1, 1);
        boolean expResult = true;
        boolean result = UtilitaireDate.datePosterieure(date, dateCompare);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        date = new GregorianCalendar(2012, 1, 1);
        dateCompare = new GregorianCalendar(2013, 1, 1);
        expResult = false;
        result = UtilitaireDate.datePosterieure(date, dateCompare);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        date = new GregorianCalendar(2013, 1, 1);
        dateCompare = new GregorianCalendar(2013, 1, 1);
        expResult = false;
        result = UtilitaireDate.datePosterieure(date, dateCompare);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of dateDansIntervalle method, of class UtilitaireDate.
     */
    @Test
    public void testDateDansIntervalle_GregorianCalendar_GregorianCalendar_GregorianCalendar() {
        System.out.println("dateDansIntervalle");
        GregorianCalendar date = new GregorianCalendar(2013, 1, 1);
        GregorianCalendar dateAnt = new GregorianCalendar(2012, 1, 1);
        GregorianCalendar datePost = new GregorianCalendar(2014, 1, 1);
        boolean expResult = true;
        boolean result = UtilitaireDate.dateDansIntervalle(date, dateAnt, datePost);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        date = new GregorianCalendar(2013, 1, 1);
        dateAnt = new GregorianCalendar(2013, 1, 1);
        datePost = new GregorianCalendar(2013, 1, 1);
        expResult = true;
        result = UtilitaireDate.dateDansIntervalle(date, dateAnt, datePost);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        date = new GregorianCalendar(2013, 1, 1);
        dateAnt = new GregorianCalendar(2014, 1, 1);
        datePost = new GregorianCalendar(2012, 1, 1);
        expResult = false;
        result = UtilitaireDate.dateDansIntervalle(date, dateAnt, datePost);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        date = new GregorianCalendar(2013, 1, 1);
        dateAnt = new GregorianCalendar(2011, 1, 1);
        datePost = new GregorianCalendar(2012, 1, 1);
        expResult = false;
        result = UtilitaireDate.dateDansIntervalle(date, dateAnt, datePost);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of dateEgale method, of class UtilitaireDate.
     */
    @Test
    public void testDateEgale() {
        System.out.println("dateEgale");
        GregorianCalendar date = new GregorianCalendar(2012, 1, 1);
        GregorianCalendar dateCompare = new GregorianCalendar(2012, 1, 1);
        boolean expResult = true;
        boolean result = UtilitaireDate.dateEgale(date, dateCompare);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        date = new GregorianCalendar(2012, 1, 1);
        dateCompare = new GregorianCalendar(2013, 1, 1);
        expResult = false;
        result = UtilitaireDate.dateEgale(date, dateCompare);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        date = new GregorianCalendar(2013, 1, 1);
        dateCompare = new GregorianCalendar(2012, 1, 1);
        expResult = false;
        result = UtilitaireDate.dateEgale(date, dateCompare);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of anneeBissextile method, of class UtilitaireDate.
     */
    @Test
    public void testAnneeBissextile() {
        System.out.println("anneeBissextile");
        int annee = 2016;
        boolean expResult = true;
        boolean result = UtilitaireDate.anneeBissextile(annee);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        annee = 2013;
        expResult = false;
        result = UtilitaireDate.anneeBissextile(annee);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        annee = 1900;
        expResult = false;
        result = UtilitaireDate.anneeBissextile(annee);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        annee = 2000;
        expResult = true;
        result = UtilitaireDate.anneeBissextile(annee);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of jourDeSemaine method, of class UtilitaireDate.
     */
    @Test
    public void testJourDeSemaine() {
        System.out.println("jourDeSemaine");
        GregorianCalendar calendrier = new GregorianCalendar(2013, 2, 11);
        String expResult = "Lundi";
        String result = UtilitaireDate.jourDeSemaine(calendrier);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        calendrier = new GregorianCalendar(2013, 2, 12);
        expResult = "Mardi";
        result = UtilitaireDate.jourDeSemaine(calendrier);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        calendrier = new GregorianCalendar(2013, 2, 13);
        expResult = "Mercredi";
        result = UtilitaireDate.jourDeSemaine(calendrier);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        calendrier = new GregorianCalendar(2013, 2, 14);
        expResult = "Jeudi";
        result = UtilitaireDate.jourDeSemaine(calendrier);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        calendrier = new GregorianCalendar(2013, 2, 15);
        expResult = "Vendredi";
        result = UtilitaireDate.jourDeSemaine(calendrier);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        calendrier = new GregorianCalendar(2013, 2, 16);
        expResult = "Samedi";
        result = UtilitaireDate.jourDeSemaine(calendrier);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        calendrier = new GregorianCalendar(2013, 2, 17);
        expResult = "Dimanche";
        result = UtilitaireDate.jourDeSemaine(calendrier);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of moisATexte method, of class UtilitaireDate.
     */
    @Test
    public void testMoisATexte() {
        System.out.println("moisATexte");
        int mois = 1;
        String expResult = "Janvier";
        String result = UtilitaireDate.moisATexte(mois);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        mois = 12;
        expResult = "Décembre";
        result = UtilitaireDate.moisATexte(mois);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of greorianToString method, of class UtilitaireDate.
     */
    @Test
    public void testGreorianToString() {
        System.out.println("greorianToString"); // Les mois commence a 0 jusqu'à 11...
        GregorianCalendar calendrier = new GregorianCalendar(2013, 1, 11);
        String expResult = "2013-02-11";
        String result = UtilitaireDate.greorianToString(calendrier);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of dateEnString method, of class UtilitaireDate.
     */
    @Test
    public void testDateEnString() {
        System.out.println("dateEnString");
        Date date = UtilitaireDate.dateBD("2000-01-01");
        String expResult = "2000-01-01";
        String result = UtilitaireDate.dateEnString(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of dateDuJour method, of class UtilitaireDate.
     */
    @Test
    public void testDateDuJour() {
        System.out.println("dateDuJour");
        GregorianCalendar expResult = new GregorianCalendar(Locale.getDefault());
        GregorianCalendar result = UtilitaireDate.dateDuJour();
        assertEquals(expResult.get(GregorianCalendar.YEAR), result.get(GregorianCalendar.YEAR));
        assertEquals(expResult.get(GregorianCalendar.MONTH), result.get(GregorianCalendar.MONTH));
        assertEquals(expResult.get(GregorianCalendar.DATE), result.get(GregorianCalendar.DATE));
    }

    /**
     * Test of dateValide method, of class UtilitaireDate.
     */
    @Test
    public void testDateValide() {
        System.out.println("dateValide");
        String date = "2000-01-01";
        boolean expResult = true;
        boolean result = UtilitaireDate.dateValide(date);
        assertEquals(expResult, result);
        date = "2a00-01-01";
        expResult = false;
        result = UtilitaireDate.dateValide(date);
        assertEquals(expResult, result);
        date = "0000-01-01";
        expResult = false;
        result = UtilitaireDate.dateValide(date);
        assertEquals(expResult, result);
        date = "2000-13-01";
        expResult = false;
        result = UtilitaireDate.dateValide(date);
        assertEquals(expResult, result);
        date = "2000-03-32";
        expResult = false;
        result = UtilitaireDate.dateValide(date);
        assertEquals(expResult, result);
        date = "2000-02-30";
        expResult = false;
        result = UtilitaireDate.dateValide(date);
        assertEquals(expResult, result);
        date = "2000-02-29";
        expResult = true;
        result = UtilitaireDate.dateValide(date);
        assertEquals(expResult, result);
        date = "2001-02-29";
        expResult = false;
        result = UtilitaireDate.dateValide(date);
        assertEquals(expResult, result);
        date = "2001-02-28";
        expResult = true;
        result = UtilitaireDate.dateValide(date);
        assertEquals(expResult, result);
        date = "0000-19-39";
        expResult = false;
        result = UtilitaireDate.dateValide(date);
        assertEquals(expResult, result);
        date = "2000-12-32";
        expResult = false;
        result = UtilitaireDate.dateValide(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of dateBD method, of class UtilitaireDate.
     */
    @Test
    public void testDateBD() {
        System.out.println("dateBD");
        String date = "2000-01-01";
        java.sql.Date expResult = new java.sql.Date(2000 - 1900, 1 - 1, 1);

        java.sql.Date result = UtilitaireDate.dateBD(date);
        assertEquals(expResult, result);
        date = "2000-01-91";
        expResult = null;
        result = UtilitaireDate.dateBD(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of nombreJourEntre method, of class UtilitaireDate.
     */
    @Test
    public void testNombreJourEntre_String_String() {
        System.out.println("nombreJourEntre");
        String date1 = "2000-01-01";
        String date2 = "2002-01-01";
        int expResult = 731;
        int result = UtilitaireDate.nombreJourEntre(date1, date2);
        assertEquals(expResult, result);
        date1 = "2000-13-01";
        date2 = "2002-01-01";
        expResult = -1;
        result = UtilitaireDate.nombreJourEntre(date1, date2);
        assertEquals(expResult, result);
        date1 = "2000-03-01";
        date2 = "2002-13-01";
        expResult = -1;
        result = UtilitaireDate.nombreJourEntre(date1, date2);
        assertEquals(expResult, result);
    }

    /**
     * Test of nombreJourEntre method, of class UtilitaireDate.
     */
    @Test
    public void testNombreJourEntre_Date_Date() {
        System.out.println("nombreJourEntre");
        Date date1 = new Date(2000, 1, 1);
        Date date2 = new Date(2002, 1, 1);
        int expResult = 731;
        int result = UtilitaireDate.nombreJourEntre(date1, date2);
        assertEquals(expResult, result);
        date1 = new Date(2002, 1, 1);
        date2 = new Date(2000, 1, 1);
        expResult = 731;
        result = UtilitaireDate.nombreJourEntre(date1, date2);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMoisGregorien method, of class UtilitaireDate.
     */
    @Test
    public void testGetMoisGregorien() {
        System.out.println("getMoisGregorien");
        int mois = 1;
        int expResult = 0;
        int result = UtilitaireDate.getMoisGregorien(mois);
        assertEquals(expResult, result);
        mois = 13;
        expResult = -1;
        result = UtilitaireDate.getMoisGregorien(mois);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnnee method, of class UtilitaireDate.
     */
    @Test
    public void testGetAnnee() {
        System.out.println("getAnnee");
        String date = "2000-01-01";
        int expResult = 2000;
        int result = UtilitaireDate.getAnnee(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of getMois method, of class UtilitaireDate.
     */
    @Test
    public void testGetMois() {
        System.out.println("getMois");
        String date = "2000-01-01";
        int expResult = 1;
        int result = UtilitaireDate.getMois(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of getJour method, of class UtilitaireDate.
     */
    @Test
    public void testGetJour() {
        System.out.println("getJour");
        String date = "2000-01-01";
        int expResult = 1;
        int result = UtilitaireDate.getJour(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of timeNowEnString method, of class UtilitaireDate.
     */
    @Test
    public void testTimeNowEnString() {
        Logger.getLogger(UtilitaireDateTest.class.getName()).log(Level.INFO, "test timeNowEnString");
        System.out.println("timeNowEnString");
        String dateDuJour = UtilitaireDate.greorianToString(UtilitaireDate.dateDuJour());
        String expResult = UtilitaireEntier.entierATexteMin(UtilitaireDate.getAnnee(dateDuJour), 4)
                + "-" + UtilitaireEntier.entierATexteMin(UtilitaireDate.getMois(dateDuJour), 2)
                + "-" + UtilitaireEntier.entierATexteMin(UtilitaireDate.getJour(dateDuJour), 2);
        String result = UtilitaireDate.timeNowEnString();
        assertTrue(result.contains(expResult));
    }

    /**
     * Test of dateDansIntervalle method, of class UtilitaireDate.
     */
    @Test
    public void testDateDansIntervalle_String_String_String() {
        System.out.println("dateDansIntervalle");
        String date = "2000-01-01";
        String dateAnt = "1999-01-01";
        String datePost = "2001-01-01";
        boolean expResult = true;
        boolean result = UtilitaireDate.dateDansIntervalle(date, dateAnt, datePost);
        assertEquals(expResult, result);
    }

    /**
     * Test of dateTimeEnString method, of class UtilitaireDate.
     */
    @Test
    public void testDateTimeEnString() {
        System.out.println("dateTimeEnString");
        Date datetime = new Date(2000-1900, 1-1, 1, 8, 32, 4);
        String expResult = "2000-01-01 08:32:04";
        String result = UtilitaireDate.dateTimeEnString(datetime);
        assertEquals(expResult, result);
    }
}
