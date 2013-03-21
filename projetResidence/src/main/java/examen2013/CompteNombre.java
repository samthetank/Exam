/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2013;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe ayant été créée pour l'examen final d'outil.
 *
 * @author Samuel Roussin
 */
public final class CompteNombre {

    /**
     * Classe que j'ai créé pour réduire la complexité cyclomatique
     * 
     * @param psave param représentant la variable save
     * @param pcvariable param représentant la varialbe cvariable
     * @return 
     */
    public static int autreCompteur(final int psave,final int pcvariable) {
        int save;
        save = psave;
        while (save > 0) {
            if (save % 10 == pcvariable) {
                break;
            }
            save /= 10;
        }
        return save;
    }

    /**
     * Constructeur privé de la classe compteNombre
     */
    private CompteNombre() {
    }

    ;
	
	

    /**
     * Fonction compter nombre de la classe CompteNombre.
     * 
     * @param pnombre le nombre qui sera tester âr la fonction
     * @return 
     */
    public static int compterNombreNonRepetes(final int pnombre) {

        int save;
        save = pnombre;
        int nombre;
        nombre = 0;
        while (save > 0) {
            nombre++;
            save /= 10;
        }

        int svariable;
        svariable = 0;
        for (int i = 0; i < nombre; i++) {
            save = pnombre;
            int cvariable;
            cvariable = save % 10;
            save /= 10;
            save = autreCompteur(save, cvariable);
            if (save == 0) {
                svariable++;
            }
            save /= 10;
        }

        return svariable;
    }

    /**
     * La function main de la clase CompteNombre
     *
     * @param args tableau de caractères pouvant contenir des arguments
     */
    public static void main(final String[] args) {
        final int nombre;
        nombre = 10;
        try {
            System.out.println("Nombres non test gitrépétés :" + compterNombreNonRepetes(nombre));
        } catch (Exception ex) {
            Logger.getLogger(CompteNombre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
