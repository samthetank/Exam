/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package affaire;

import java.util.List;
import java.util.Map;
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
public class AppartementTest {

    public AppartementTest() {
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
     * Test of getIdAppartement method, of class Appartement.
     */
    @Test
    public void testGetIdAppartement() {
        System.out.println("getIdAppartement");
        Appartement instance = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        int expResult = 1;
        int result = instance.getIdAppartement();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNoAppartement method, of class Appartement.
     */
    @Test
    public void testGetNoAppartement() {
        System.out.println("getNoAppartement");
        Appartement instance = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        int expResult = 10;
        int result = instance.getNoAppartement();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEtage method, of class Appartement.
     */
    @Test
    public void testGetEtage() {
        System.out.println("getEtage");
        Appartement instance = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        String expResult = "1";
        String result = instance.getEtage();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhase method, of class Appartement.
     */
    @Test
    public void testGetPhase() {
        System.out.println("getPhase");
        Appartement instance = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        String expResult = "2";
        String result = instance.getPhase();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDimension method, of class Appartement.
     */
    @Test
    public void testGetDimension() {
        System.out.println("getDimension");
        Appartement instance = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        String expResult = "3";
        String result = instance.getDimension();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNbPieces method, of class Appartement.
     */
    @Test
    public void testGetNbPieces() {
        System.out.println("getNbPieces");
        Appartement instance = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        String expResult = "8";
        String result = instance.getNbPieces();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Appartement.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Appartement instance = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        String expResult = "Description";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of supprimer method, of class Appartement.
     */
    //@Test
    public void testSupprimer() {
        System.out.println("supprimer");
        Appartement instance = null;
        boolean expResult = false;
        boolean result = instance.supprimer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifier method, of class Appartement.
     */
    //@Test
    public void testModifier() {
        System.out.println("modifier");
        Appartement instance = null;
        boolean expResult = false;
        boolean result = instance.modifier();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of egale method, of class Appartement.
     */
    @Test
    public void testEgale() {
        System.out.println("egale");
        Appartement pappartement = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        Appartement instance = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        boolean expResult = true;
        boolean result = instance.egale(pappartement);
        assertEquals(expResult, result);
        pappartement = new Appartement(2, 10, "1", "2", "3", "8", "Description");
        instance = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        expResult = false;
        result = instance.egale(pappartement);
        assertEquals(expResult, result);
        pappartement = new Appartement(1, 11, "1", "2", "3", "8", "Description");
        instance = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        expResult = false;
        result = instance.egale(pappartement);
        assertEquals(expResult, result);
        pappartement = new Appartement(1, 10, "2", "2", "3", "8", "Description");
        instance = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        expResult = false;
        result = instance.egale(pappartement);
        assertEquals(expResult, result);
        pappartement = new Appartement(1, 10, "1", "3", "3", "8", "Description");
        instance = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        expResult = false;
        result = instance.egale(pappartement);
        assertEquals(expResult, result);
        pappartement = new Appartement(1, 10, "1", "2", "4", "8", "Description");
        instance = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        expResult = false;
        result = instance.egale(pappartement);
        assertEquals(expResult, result);
        pappartement = new Appartement(1, 10, "1", "2", "3", "9", "Description");
        instance = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        expResult = false;
        result = instance.egale(pappartement);
        assertEquals(expResult, result);
        pappartement = new Appartement(1, 10, "1", "2", "3", "8", "Descriptiona");
        instance = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        expResult = false;
        result = instance.egale(pappartement);
        assertEquals(expResult, result);
    }

    /**
     * Test of insererAppartement method, of class Appartement.
     */
    //@Test
    public void testInsererAppartement() {
        System.out.println("insererAppartement");
        Appartement pappartement = null;
        boolean expResult = false;
        boolean result = Appartement.insererAppartement(pappartement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAppartements method, of class Appartement.
     */
    //@Test
    public void testGetAppartements() {
        System.out.println("getAppartements");
        List expResult = null;
        List result = Appartement.getAppartements();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAppartement method, of class Appartement.
     */
    //@Test
    public void testGetAppartement() {
        System.out.println("getAppartement");
        int pid = 0;
        Appartement expResult = null;
        Appartement result = Appartement.getAppartement(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifierAppartement method, of class Appartement.
     */
    //@Test
    public void testModifierAppartement() {
        System.out.println("modifierAppartement");
        Appartement pappartement = null;
        boolean expResult = false;
        boolean result = Appartement.modifierAppartement(pappartement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerAppartement method, of class Appartement.
     */
    //@Test
    public void testSupprimerAppartement() {
        System.out.println("supprimerAppartement");
        int pid = 0;
        boolean expResult = false;
        boolean result = Appartement.supprimerAppartement(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    /**
     * Texte très long.
     */
    public static final String MONA_LISA = "$Z$7$O$Z$7$Z77OZ7ZO$ZZ$$Z$OOZ$Z7$$ZZ7$$ZZ$ZOZ$$$ZZ$$$$$$Z$OZ"
            + "Z777$I$$$O$Z7$77$$Z$$77$$$$7ZZZZ77$$7IZ$$$ZZ$7$7O$$$$$$$$ZZZ"
            + "$I7$$7$$$I7Z7Z7$$7$7$$7Z7$7$$777Z7Z77$777$?Z777$77$I7$ZZ7ZZZ"
            + "7II7777III7O7777$7$$77$7$7$7$7$7I77ZIII7I7$$7I77Z$$I77Z7$O$$"
            + "$ZII7I?I777$II7II777$77?7I7ZNDDOZZ$I7$7$7$$$$I?I?7I77?$$$II7"
            + "I$?I77IIII$777III7I7I?I7MN8NDNMMN8ND$$I$7$7I777I777II?7$$Z$$"
            + "$77II7I?$?IIII7?I77II78888O8DDNMMNMMN$7II$$$III$7I$II777I77Z"
            + "7?III++II?III?I7I????D87I+II$Z8NNMMNMNDII+??77?$7II7$7$7I7$$"
            + "IIIIIIII?I?I?I+I7?IIO8II====?7ZODDNMNNND+77III?II?IIIII$Z777"
            + "??I?$??+?I=?I??$I?+$NO7?II+?I7$OODNMNMNM77II7II?7I7I?III7$$7"
            + "$7I$$I++?$+=+I+I?+$DM$++I+++?II$$ODNMNNMO$$$7IZ77?+?I7I7777$"
            + "OZZZ7Z$7$Z$$?==?=?8DM$I7I+?$Z$$$Z8NMNMNMMOOZZ$78$7III??7ZZOO"
            + "DD8OOZZZZOOZ$?=I+ZO8NNDNZ?$DONNDDO8NNMMMMO8OZZOO$$I7II7$$OZO"
            + "88$OO88ZO8OZ8O$O8Z8DMIIZ?+Z$$ZZ77Z8MMMNMMDD88O88O7III?I$ZZOO"
            + "OZ8ZZO8O8O8DD88O88DDM7+$I+77?I?IZONNMMMNN8DDO8DD88$$77777ZZO"
            + "DD8OODO88O88D8DNNN8DNZI77?$$?II$O8NMNMMMMNDDDO8DOZ$$Z88N8ZDN"
            + "NNND8D888OD8DD8DNDNNM8Z7?8N877$ZODDNNMMNNNMDDDNDND888DD8NDNN"
            + "DN88D88888DDNDNDDNNDDMZIIODDZ$ZZ8DNMNMNMNNDDND8DNN88O88DNNDM"
            + "NDDDDD88ND8D8ND8DDNDMMNO777$$$O8DDNDNNMNMN88D8DNNN8DDN8ND8DN"
            + "NNNMDDDDNDD8DD8N8NDN8DMMDI?$O8DNDNNNNMMNMNN888D8DDDDNDDDDDNM"
            + "NDNDND8N8N88O8OOZ8NNMNNNMNMNNMNDNNNNNNMNMMDDDNDDNDNNNNNDNNNN"
            + "NDNNNNDO8OZZZ$OOOZDN8NMMMNOZ88D8D88DNMMMNMD8D8NDDNDDNDDDNNNN"
            + "MNNDO88Z8ONOOD8Z$88DMMNMMNM$$O$OOZZONDMMNNNNNDND8OZOZ888NDNN"
            + "8888888Z888DMMMNNMMNNMNNMO$7II7777$ZDNNDNNMMNMNNNNDOZ88DOMMN"
            + "N8DMO8D8888DNDMNMMMNNMDO7I+I??????7ZDNDNDNNNMNOZZ7ZZ8O88DNNN"
            + "DD8N88ODO88NM8NMDNNNMD$?+?+=+?I+?$7$88NNNMDDNMNNZOZO$OOOOONM"
            + "DDODD$OO8ZDN88NDMMND88??==+?+?++??IZDN8NMND8ODNND8O8O88OOODM"
            + "DDDND8N$88Z8D8MMMMMZ$7=?+?+=??+?+?7ZDDNODZOZ8DNNNMND88DZOOOO"
            + "D8Z8D8DD8OOZ8MMMNM8Z7+7?+=+==+=++?77O88OI$8ODNMMMNMMNNM87ZZN"
            + "DDND8OOZ8Z$8NMMNMNO8I+=+?====~+=+?IZZODDMDNMNMMMMMMMNDDMNNOD"
            + "D8OZOZ8888NNMNNNNN8888O8Z=+==?+I78ODNDNNMNNMMMMMMMNMMDDNDNDM"
            + "N88OOOZ$OOMNMMNM88N88DOO8ZO8Z7ZOZNZNNMMN8DDNMMMMMMMMMMNNNDDM"
            + "MD88OZO88MNMMMMNNNDNMNDD8O8N8ODONMMNMDNDNMNNONNDNDMMMNDNDNNM"
            + "NND88D888NMMMMMMNNMDMNDDNODDDMNNNMNMNMNNNND8DDNDNMNMMMM88MMM"
            + "ND8ZZOZODNMMMMMMNNNNNNMNNNMNNNMNMMNMNMMM8DDDO8MNMMMMMMMDNNMM"
            + "88ZOOZOZNMMMMNNMNNMNNNNNMMNDNDNMMMMNMNNDNN8DNMMMMMMNNMMMDONM"
            + "ND88DDDNMMMNNMNNMMNNMNMMNDNNNMMNMMMMMMDDMNMMNNMNMMNMMNMMNMMN"
            + "NND8DDNNNNNNDNMMNMMNMNMMMNMNNMMMMMMMNMMNNMMMNNMMMMMNMNMMNNNM"
            + "DNDMNMMMDDDDNNNNMMMNNNMNMMNNMNMMMMMMMMNMMMMNMMMMMMMMMMMMMMMM"
            + "DDMNNDM8DMMMMNNMNMMNMMNMDMMMMMMMMMMMNMNMMMNMDMNMMMMMMMMNMNNM"
            + "NNNNNMNMNNMNNMNMMNMNMMMMMMMMMMMMMMMMMNMMMMMNMNDMMMNMMNMNNMNM"
            + "NMNNMND88M8DDNNNMMNNMMMMMMMMMMMMMMMMMMNMMMNMNMNMMMMMMMMMMMMM"
            + "MNMNMDDO7ZN8OD8N8II$NMMMMMMMMMNMMNNMMMMMMMMNNMMNMMMMMNMMMMMM"
            + "MMNNMM88O$8MNNZI?++II7$$MMMMMMMMMMMMMMMMMMMNNNMMNMMMMMMMMMMM"
            + "MMMNMDDDDMMNN8D777I?III7I$ZNMMMMMMMMMMMMMMMNMMNMMNMMMMMMMMMM"
            + "MNNNMMNNDN8ND8NOOZZ$7IIIII?I7$OMMMMMMMMMMNMMNNMMMMMMMMMMMMMM"
            + "MMNNNNNNMMNNNNNMNDO$777$77OOI?ZZZDZ8Z8888DD8NMMMNMMMMMMMMMMM"
            + "NMMNMNMMMNMNNN8$$$OOZZZ$ZZ77NDOO8OD88DNN8ONNDNMMMMMMMMMNMMMM"
            + "MNMMNMMNMNNMMZOO7Z$OOOOZ77DZ7ODM8ZDN88O8NNNNNDMMMMMMMMMMMMNM"
            + "MMNNMNMMNMNMOO$ZO77$O88ZNZ7OOZZ8NNNNDMNDNMNMNMMMMMMMMMMMMMNM"
            + "MMMNMNNNMNMND8O8Z7Z8DDNN8DD8DDD88NNNNMNMMMMNMMMMMMMMMMMMMMMM"
            + "MNNMMNNNMNMNNDDZ$8NNNDDDDDDDNNNMMMMMMMMMMMMMMMMMMMMMMMMNMMMM"
            + "MNNNNNNMNNNNNNNO8NNNNNMMNNNMMMNMMMMMMMMMMMMMMMMMMMMMNMNMMMMM"
            + "MMNNMNNMNNNMMMNNDNDNNNNNNNMNMMMMMMMMNMMMMMMMMMMNMMMMMMMMMMMM"
            + "NNMNNNNNMMNNNNNNNMMNMMMMNMMMMMMMMMMMMMMMMNNMMMMMMMMMMMMMMMMM"
            + "MNNNNMNMNNMMMNMMMMMMNNNMNMMNMMMNMMMMNMMMMMMMMMMMMMMNMMMMMMMM"
            + "MMMNNMNNMNNNNMMNMMMNNNNMMMMMMMNMNMMMMMMMNMMMMMMMMMMMMMMMMMMM"
            + "MNMNNNNNMMNNNNMMNMMNMNNNMNNMNMMMMMNMNMMMMMNMMNMMMMMMMMMMMMMM";

    /**
     * Test of valide method, of class Appartement.
     */
    @Test
    public void testValide() {
        System.out.println("valide");
        Appartement pappartement = new Appartement(1, 10, "1", "2", "3", "8", "Description");
        Map result = Appartement.valide(pappartement);
        assertTrue(result.isEmpty());
        pappartement = new Appartement(1, 401, null, null, null, null, MONA_LISA);
        result = Appartement.valide(pappartement);
        assertFalse(result.isEmpty());
    }
}
