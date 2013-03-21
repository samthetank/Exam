package javahelp;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author alexec (alex.e.c@gmail.com)
 */
public final class Example {

    /**
     * Constructeur.
     */
    private Example() {
    }

    /**
     * Main du JavaHelp.
     *
     * @param args Arguments de l'exécution
     * @throws UnsupportedLookAndFeelException Exception
     * @throws ClassNotFoundException Exception
     * @throws InstantiationException Exception
     * @throws IllegalAccessException Exception
     * @throws HelpSetException Exception
     */
    public static void main(final String[] args)
            throws UnsupportedLookAndFeelException, ClassNotFoundException,
            InstantiationException, IllegalAccessException, HelpSetException {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        final HelpBroker broker = new HelpSet(null,
                Example.class.getResource("/javahelp/jhelpset.hs")).createHelpBroker();
        broker.setCurrentID("Index");
        broker.setDisplayed(true);
    }
}
