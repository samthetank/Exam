/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Classe de test.
 *
 * @author Benoit Jeunehomme
 */
public class UtilitaireTexteTest {

    /**
     *
     */
    private final static String MESSAGE_NON_EGALE = "Les deux objets devraient être égales.";

    /**
     * Test of chaineNonVide method, of class UtilitaireTexte.
     */
    @Test
    public void testChaineNonVide() {
        System.out.println("chaineNonVide");
        String chaine = "";
        boolean expResult = false;
        boolean result = UtilitaireTexte.chaineNonVide(chaine);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "a";
        expResult = true;
        result = UtilitaireTexte.chaineNonVide(chaine);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of chaineVide method, of class UtilitaireTexte.
     */
    @Test
    public void testChaineVide() {
        System.out.println("chaineVide");
        String chaine = "";
        boolean expResult = true;
        boolean result = UtilitaireTexte.chaineVide(chaine);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "a";
        expResult = false;
        result = UtilitaireTexte.chaineVide(chaine);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of chaineContenant method, of class UtilitaireTexte.
     */
    @Test
    public void testChaineContenant() {
        System.out.println("chaineContenant");
        String chaine = "Les pied de dieu.";
        String recherche = "pied";
        boolean expResult = true;
        boolean result = UtilitaireTexte.chaineContenant(chaine, recherche);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "Les pied de dieu.";
        recherche = "satan";
        expResult = false;
        result = UtilitaireTexte.chaineContenant(chaine, recherche);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "";
        recherche = "satan";
        expResult = false;
        result = UtilitaireTexte.chaineContenant(chaine, recherche);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "Les pied de dieu.";
        recherche = "";
        expResult = false;
        result = UtilitaireTexte.chaineContenant(chaine, recherche);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "";
        recherche = "";
        expResult = false;
        result = UtilitaireTexte.chaineContenant(chaine, recherche);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of chaineNeContenantPas method, of class UtilitaireTexte.
     */
    @Test
    public void testChaineNeContenantPas() {
        System.out.println("chaineNeContenantPas");
        String chaine = "Les pied de dieu.";
        String recherche = "pied";
        boolean expResult = false;
        boolean result = UtilitaireTexte.chaineNeContenantPas(chaine, recherche);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "Les pied de dieu.";
        recherche = "satan";
        expResult = true;
        result = UtilitaireTexte.chaineNeContenantPas(chaine, recherche);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "Les pied de dieu.";
        recherche = "";
        expResult = false;
        result = UtilitaireTexte.chaineNeContenantPas(chaine, recherche);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "";
        recherche = "satan";
        expResult = false;
        result = UtilitaireTexte.chaineNeContenantPas(chaine, recherche);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "";
        recherche = "";
        expResult = false;
        result = UtilitaireTexte.chaineNeContenantPas(chaine, recherche);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of longueurChaineMin method, of class UtilitaireTexte.
     */
    @Test
    public void testLongueurChaineMin() {
        System.out.println("longueurChaineMin");
        String chaine = "";
        int longueurMin = 1;
        boolean expResult = false;
        boolean result = UtilitaireTexte.longueurChaineMin(chaine, longueurMin);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "ee";
        longueurMin = 1;
        expResult = true;
        result = UtilitaireTexte.longueurChaineMin(chaine, longueurMin);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "ee";
        longueurMin = -1;
        expResult = true;
        result = UtilitaireTexte.longueurChaineMin(chaine, longueurMin);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of longueurChaineMax method, of class UtilitaireTexte.
     */
    @Test
    public void testLongueurChaineMax() {
        System.out.println("longueurChaineMax");
        String chaine = "";
        int longueurMax = 0;
        boolean expResult = true;
        boolean result = UtilitaireTexte.longueurChaineMax(chaine, longueurMax);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "e";
        longueurMax = 0;
        expResult = false;
        result = UtilitaireTexte.longueurChaineMax(chaine, longueurMax);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "";
        longueurMax = -1;
        expResult = false;
        result = UtilitaireTexte.longueurChaineMax(chaine, longueurMax);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of longueurChaineIntervalle method, of class UtilitaireTexte.
     */
    @Test
    public void testLongueurChaineIntervalle() {
        System.out.println("longueurChaineIntervalle");
        String chaine = "a";
        int longueurMin = 0;
        int longueurMax = 2;
        boolean expResult = true;
        boolean result = UtilitaireTexte.longueurChaineIntervalle(chaine, longueurMin, longueurMax);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "a";
        longueurMin = 2;
        longueurMax = 0;
        expResult = false;
        result = UtilitaireTexte.longueurChaineIntervalle(chaine, longueurMin, longueurMax);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "";
        longueurMin = 0;
        longueurMax = 2;
        expResult = true;
        result = UtilitaireTexte.longueurChaineIntervalle(chaine, longueurMin, longueurMax);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "aa";
        longueurMin = 0;
        longueurMax = 2;
        expResult = true;
        result = UtilitaireTexte.longueurChaineIntervalle(chaine, longueurMin, longueurMax);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "aaa";
        longueurMin = 0;
        longueurMax = 2;
        expResult = false;
        result = UtilitaireTexte.longueurChaineIntervalle(chaine, longueurMin, longueurMax);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "";
        longueurMin = 1;
        longueurMax = 3;
        expResult = false;
        result = UtilitaireTexte.longueurChaineIntervalle(chaine, longueurMin, longueurMax);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of extraireTexte method, of class UtilitaireTexte.
     */
    @Test
    public void testExtraireTexte() {
        System.out.println("extraireTexte");
        String chaine = "Les petit pieds de dieux: 72334;";
        String avant = ": ";
        String apres = ";";
        String expResult = "72334";
        String result = UtilitaireTexte.extraireTexte(chaine, avant, apres);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "Les petit pieds de dieux: 72334;";
        avant = "&";
        apres = ";";
        expResult = "";
        result = UtilitaireTexte.extraireTexte(chaine, avant, apres);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "Les petit pieds de dieux: 72334;";
        avant = ":";
        apres = "?";
        expResult = "";
        result = UtilitaireTexte.extraireTexte(chaine, avant, apres);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "Les petit pieds de dieux: 72334;";
        avant = "";
        apres = ";";
        expResult = "";
        result = UtilitaireTexte.extraireTexte(chaine, avant, apres);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "Les petit pieds de dieux: 72334;";
        avant = ":";
        apres = "";
        expResult = "";
        result = UtilitaireTexte.extraireTexte(chaine, avant, apres);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "Les petit pieds de dieux: 72334;";
        avant = "";
        apres = "";
        expResult = "";
        result = UtilitaireTexte.extraireTexte(chaine, avant, apres);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "";
        avant = "&";
        apres = ";";
        expResult = "";
        result = UtilitaireTexte.extraireTexte(chaine, avant, apres);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }

    /**
     * Test of texteAEntier method, of class UtilitaireTexte.
     */
    @Test
    public void testTexteAEntier() {
        System.out.println("texteAEntier");
        String chaine = "0";
        int expResult = 0;
        int result = UtilitaireTexte.texteAEntier(chaine);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "-27";
        expResult = -27;
        result = UtilitaireTexte.texteAEntier(chaine);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
        chaine = "007";
        expResult = 7;
        result = UtilitaireTexte.texteAEntier(chaine);
        assertEquals(MESSAGE_NON_EGALE, expResult, result);
    }
}
