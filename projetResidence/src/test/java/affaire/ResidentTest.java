/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package affaire;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class ResidentTest {

    public ResidentTest() {
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
     * Test of getIdResident method, of class Resident.
     */
    @Test
    public void testGetIdResident() {
        System.out.println("getIdResident");
        final Resident instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        int expResult = 1;
        int result = instance.getIdResident();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNom method, of class Resident.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        final Resident instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        String expResult = "Nom";
        String result = instance.getNom();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrenom method, of class Resident.
     */
    @Test
    public void testGetPrenom() {
        System.out.println("getPrenom");
        final Resident instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        String expResult = "Prenom";
        String result = instance.getPrenom();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTelephone method, of class Resident.
     */
    @Test
    public void testGetTelephone() {
        System.out.println("getTelephone");
        final Resident instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        String expResult = "4501231234";
        String result = instance.getTelephone();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTelephoneSecondaire method, of class Resident.
     */
    @Test
    public void testGetTelephoneSecondaire() {
        System.out.println("getTelephoneSecondaire");
        final Resident instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        String expResult = "5141231234";
        String result = instance.getTelephoneSecondaire();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitre method, of class Resident.
     */
    @Test
    public void testGetTitreResident() {
        System.out.println("getTitre");
        final Resident instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        String expResult = "M.";
        String result = instance.getTitreResident();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateNaissance method, of class Resident.
     */
    @Test
    public void testGetDateNaissance() {
        System.out.println("getDateNaissance");
        final Resident instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        String expResult = "1900-01-01";
        String result = instance.getDateNaissance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateArrivee method, of class Resident.
     */
    @Test
    public void testGetDateArrivee() {
        System.out.println("getDateArrivee");
        final Resident instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        String expResult = "2000-01-01";
        String result = instance.getDateArrivee();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCommentaire method, of class Resident.
     */
    @Test
    public void testGetCommentaire() {
        System.out.println("getCommentaire");
        final Resident instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        String expResult = "";
        String result = instance.getCommentaire();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCouleurIntervention method, of class Resident.
     */
    @Test
    public void testGetCouleurIntervention() {
        System.out.println("getCouleurIntervention");
        final Resident instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        String expResult = "V";
        String result = instance.getCouleurIntervention();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCommentaireIntervention method, of class Resident.
     */
    @Test
    public void testGetCommentaireIntervention() {
        System.out.println("getCommentaireIntervention");
        final Resident instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        String expResult = "";
        String result = instance.getCommentaireIntervention();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCommentairePlainte method, of class Resident.
     */
    @Test
    public void testGetCommentairePlainte() {
        System.out.println("getCommentairePlainte");
        final Resident instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        String expResult = "";
        String result = instance.getCommentairePlainte();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNomVehicule method, of class Resident.
     */
    @Test
    public void testGetNomVehicule() {
        System.out.println("getNomVehicule");
        final Resident instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        String expResult = "Lada";
        String result = instance.getNomVehicule();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlaqueImmatriculation method, of class Resident.
     */
    @Test
    public void testGetPlaqueImmatriculation() {
        System.out.println("getPlaqueImmatriculation");
        final Resident instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        String expResult = "GOD666";
        String result = instance.getPlaqueImmatriculation();
        assertEquals(expResult, result);
    }

    /**
     * Test of supprimer method, of class Resident.
     */
    //@Test
    public void testSupprimer() {
        System.out.println("supprimer");
        Resident instance = null;
        boolean expResult = false;
        boolean result = instance.supprimer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifier method, of class Resident.
     */
    //@Test
    public void testModifier() {
        System.out.println("modifier");
        Resident instance = null;
        boolean expResult = false;
        boolean result = instance.modifier();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of egale method, of class Resident.
     */
    @Test
    public void testEgale() {
        System.out.println("egale");
        Resident president = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        Resident instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        boolean expResult = true;
        boolean result = instance.egale(president);
        assertEquals(expResult, result);
        president = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        instance = new Resident(
                2, "Nom2", "Prenom2", "4501231224", "5141231224", "Mme.", "1901-01-01",
                "2001-01-01", "a", "J", "a", "a", "Lada2", "GOD266");
        expResult = false;
        result = instance.egale(president);
        assertEquals(expResult, result);
        president = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        instance = new Resident(
                1, "Nom2", "Prenom2", "4501231224", "5141231224", "Mme.", "1901-01-01",
                "2001-01-01", "a", "J", "a", "a", "Lada2", "GOD266");
        expResult = false;
        result = instance.egale(president);
        assertEquals(expResult, result);
        president = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        instance = new Resident(
                1, "Nom", "Prenom2", "4501231224", "5141231224", "Mme.", "1901-01-01",
                "2001-01-01", "a", "J", "a", "a", "Lada2", "GOD266");
        expResult = false;
        result = instance.egale(president);
        assertEquals(expResult, result);
        president = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        instance = new Resident(
                1, "Nom", "Prenom", "4501231224", "5141231224", "Mme.", "1901-01-01",
                "2001-01-01", "a", "J", "a", "a", "Lada2", "GOD266");
        expResult = false;
        result = instance.egale(president);
        assertEquals(expResult, result);
        president = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231224", "Mme.", "1901-01-01",
                "2001-01-01", "a", "J", "a", "a", "Lada2", "GOD266");
        expResult = false;
        result = instance.egale(president);
        assertEquals(expResult, result);
        president = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "Mme.", "1901-01-01",
                "2001-01-01", "a", "J", "a", "a", "Lada2", "GOD266");
        expResult = false;
        result = instance.egale(president);
        assertEquals(expResult, result);
        president = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1901-01-01",
                "2001-01-01", "a", "J", "a", "a", "Lada2", "GOD266");
        expResult = false;
        result = instance.egale(president);
        assertEquals(expResult, result);
        president = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2001-01-01", "a", "J", "a", "a", "Lada2", "GOD266");
        expResult = false;
        result = instance.egale(president);
        assertEquals(expResult, result);
        president = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "a", "J", "a", "a", "Lada2", "GOD266");
        expResult = false;
        result = instance.egale(president);
        assertEquals(expResult, result);
        president = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "J", "a", "a", "Lada2", "GOD266");
        expResult = false;
        result = instance.egale(president);
        assertEquals(expResult, result);
        president = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "a", "a", "Lada2", "GOD266");
        expResult = false;
        result = instance.egale(president);
        assertEquals(expResult, result);
        president = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "a", "Lada2", "GOD266");
        expResult = false;
        result = instance.egale(president);
        assertEquals(expResult, result);
        president = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada2", "GOD266");
        expResult = false;
        result = instance.egale(president);
        assertEquals(expResult, result);
        president = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        instance = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD266");
        expResult = false;
        result = instance.egale(president);
        assertEquals(expResult, result);
    }

    /**
     * Test of insererResident method, of class Resident.
     */
    //@Test
    public void testInsererResident() {
        System.out.println("insererResident");
        Resident president = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        ;
        boolean expResult = true;
        boolean result = Resident.insererResident(president);
        assertEquals(expResult, result);
        List<Resident> listeResident = Resident.getResidents();
        int pid = 0;
        for (int i = 0; i < listeResident.size(); ++i) {
            if (listeResident.get(i).getNom() == "Nom"
                    && listeResident.get(i).getPrenom() == "Prenom") {
                pid = listeResident.get(i).getIdResident();
            }
        }
        Resident.supprimerResident(pid);
    }

    /**
     * Test of getResidents method, of class Resident.
     */
    //@Test
    public void testGetResidents() {
        System.out.println("getResidents");
        List expResult = null;
        List result = Resident.getResidents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResident method, of class Resident.
     */
    //@Test
    public void testGetResident() {
        System.out.println("getResident");
        int pid = 0;
        Resident expResult = null;
        Resident result = Resident.getResident(pid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifierResident method, of class Resident.
     */
    //@Test
    public void testModifierResident() {
        System.out.println("modifierResident");
        Resident president = null;
        boolean expResult = false;
        boolean result = Resident.modifierResident(president);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of supprimerResident method, of class Resident.
     */
    //@Test
    public void testSupprimerResident() {
        System.out.println("supprimerResident");
        Resident.insererResident(
                new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666"));
        List<Resident> listeResident = Resident.getResidents();
        int pid = 0;
        for (int i = 0; i < listeResident.size(); ++i) {
            if (listeResident.get(i).getNom() == "Nom"
                    && listeResident.get(i).getPrenom() == "Prenom") {
                pid = listeResident.get(i).getIdResident();
            }
        }

        boolean expResult = true;
        boolean result = Resident.supprimerResident(pid);
        assertEquals(expResult, result);
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
     * Test of valide method, of class Resident.
     */
    @Test
    public void testValide() {
        System.out.println("valide");
        Resident resident = new Resident(
                1, "Nom", "Prenom", "4501231234", "5141231234", "M.", "1900-01-01",
                "2000-01-01", "", "V", "", "", "Lada", "GOD666");
        Map expResult = new HashMap<String, Object>();
        Map result = Resident.valide(resident);
        assertEquals(expResult, result);
        resident = new Resident(
                1, "", "", "", "", "", "",
                "", "", "", "", "", "", "");
        expResult = new HashMap<String, Object>();
        result = Resident.valide(resident);
        assertFalse(result.isEmpty());
        resident = new Resident(
                1, MONA_LISA, MONA_LISA, MONA_LISA, MONA_LISA, MONA_LISA, MONA_LISA,
                MONA_LISA, MONA_LISA, "J", MONA_LISA, MONA_LISA, MONA_LISA, MONA_LISA);
        expResult = new HashMap<String, Object>();
        result = Resident.valide(resident);
        assertFalse(result.isEmpty());
        resident = new Resident(
                1, "", "", "", "", "Mme.", "",
                "", "", "R", "", "", "", "");
        expResult = new HashMap<String, Object>();
        result = Resident.valide(resident);
        assertFalse(result.isEmpty());
        resident = new Resident(
                1, null, null, null, "5141231234", "M.", null,
                null, "", "V", "", "", null, "GOD666");
        expResult = new HashMap<String, Object>();
        result = Resident.valide(resident);
        assertFalse(result.isEmpty());
    }
}
