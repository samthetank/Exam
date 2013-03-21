/*
 * Utilitaire
 */
package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Classe utilitaire contenant des fonctions utiles.
 *
 * @author Benoit Jeunehomme
 */
public final class UtilitaireDate {

    /**
     * Constructeur privé afin d'éviter la création d'un objet UtilitaireDate.
     */
    private UtilitaireDate() {
    }
    /**
     * Position de fin de l'année pour le substr.
     */
    private static final int POS_FIN_ANNEE = 4;
    /**
     * Position de début du mois pour le substr.
     */
    private static final int POS_DEBUT_MOIS = 5;
    /**
     * Position de fin du mois pour le substr.
     */
    private static final int POS_FIN_MOIS = 7;
    /**
     * Position de début du jour pour le substr.
     */
    private static final int POS_DEBUT_JOUR = 8;
    /**
     * Position de fin du jour pour le substr.
     */
    private static final int POS_FIN_JOUR = 10;

    /**
     * Obtenir l'année d'une date en string.
     *
     * @param date date dont on veut l'année
     * @return Année
     */
    public static int getAnnee(final String date) {
        return UtilitaireTexte.texteAEntier(date.substring(0, POS_FIN_ANNEE));
    }

    /**
     * Obtenir le mois d'une date en string.
     *
     * @param date date dont on veut le mois
     * @return Mois
     */
    public static int getMois(final String date) {
        return UtilitaireTexte.texteAEntier(date.substring(POS_DEBUT_MOIS, POS_FIN_MOIS));
    }

    /**
     * Obtenir le jour d'une date en string.
     *
     * @param date date dont on veut le jour
     * @return Jour
     */
    public static int getJour(final String date) {
        return UtilitaireTexte.texteAEntier(date.substring(POS_DEBUT_JOUR, POS_FIN_JOUR));
    }

    /**
     * Reçoit une date en paramètre et retourne une string dans le format
     * YYYY-MM-DD.
     *
     * @param date la date a transformer en String.
     * @return La chaine transformer.
     */
    public static String dateEnString(final Date date) {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return dateFormat.format(date);
    }

    /**
     * Obtenir la date et le temps actuel.
     *
     * @return Temps actuel
     */
    public static String timeNowEnString() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        final Date temps = new Date();
        return dateFormat.format(temps);
    }

    /**
     * Transférer un dateTime en string.
     *
     * @param datetime Un dateTime
     * @return Datetime en string.
     */
    public static String dateTimeEnString(final Date datetime) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(datetime);
    }

    /**
     * Permet de savoir si la date représenté par le calendrier est antérieure à
     * celle comparée.
     *
     * @param date Calendrier grégorien représentant une date dont on veut
     * savoir si elle est antérieure à celle comparée
     * @param dateCompare Calendrier grégorien à comparer
     * @return Booléen indiquant si la date du calendrier est antérieure à celle
     * comparée.
     */
    public static boolean dateAnterieure(final GregorianCalendar date, final GregorianCalendar dateCompare) {
        return date.before(dateCompare);
    }

    /**
     * Permet de savoir si la date représenté par le calendrier est antérieure à
     * celle comparée.
     *
     * @param date Calendrier grégorien représentant une date dont on veut
     * savoir si elle est antérieure à celle comparée
     * @param dateCompare Calendrier grégorien à comparer
     * @return Booléen indiquant si la date du calendrier est antérieure à celle
     * comparée.
     */
    public static boolean dateAnterieure(final String date, final String dateCompare) {
        final GregorianCalendar cal = new GregorianCalendar(getAnnee(date), getMois(date), getJour(date));
        final GregorianCalendar calCompare = new GregorianCalendar(
                getAnnee(dateCompare), getMois(dateCompare), getJour(dateCompare));

        return dateValide(date) && dateValide(dateCompare) && dateAnterieure(cal, calCompare);
    }

    /**
     * Permet de savoir si la date représenté par le calendrier est postérieure
     * à celle comparée.
     *
     * @param date Calendrier grégorien représentant une date dont on veut
     * savoir si elle est postérieure à celle comparée
     * @param dateCompare Calendrier grégorien à comparer
     * @return Booléen indiquant si la date du calendrier est postérieure à
     * celle comparée.
     */
    public static boolean datePosterieure(final GregorianCalendar date, final GregorianCalendar dateCompare) {
        return date.after(dateCompare);
    }

    /**
     * Permet de déterminer si un calendrier représente une date se situant
     * entre deux autres.
     *
     * @param date Calendrier grégorien
     * @param dateAnt Calendrier grégorien représentant une date antérieure
     * @param datePost Calendrier grégorien représentant une date postérieure
     * @return Booléen indiquant si la date représentée par le calendrier se
     * situe entre les deux autres.
     */
    public static boolean dateDansIntervalle(final GregorianCalendar date, final GregorianCalendar dateAnt,
            final GregorianCalendar datePost) {
        return !date.before(dateAnt) && !date.after(datePost);
    }

    /**
     * Permet de déterminer si un calendrier représente une date se situant
     * entre deux autres.
     *
     * @param date Calendrier grégorien
     * @param dateAnt Calendrier grégorien représentant une date antérieure
     * @param datePost Calendrier grégorien représentant une date postérieure
     * @return Booléen indiquant si la date représentée par le calendrier se
     * situe entre les deux autres.
     */
    public static boolean dateDansIntervalle(final String date, final String dateAnt, final String datePost) {
        return dateDansIntervalle(new GregorianCalendar(getAnnee(date), getMois(date), getJour(date)),
                new GregorianCalendar(getAnnee(dateAnt), getMois(dateAnt), getJour(dateAnt)),
                new GregorianCalendar(getAnnee(datePost), getMois(datePost), getJour(datePost)));
    }

    /**
     * Permet de comparer deux calendrier pour déterminer s'ils représentent la
     * même date.
     *
     * @param date Calendrier grégorien
     * @param dateCompare Calendrier grégorien à comparer
     * @return Booléen indiquant si les deux calendrier représentent la même
     * date.
     */
    public static boolean dateEgale(final GregorianCalendar date, final GregorianCalendar dateCompare) {
        return !date.before(dateCompare) && !date.after(dateCompare);
    }

    /**
     * Vérifie si une année donnée est bissextile.
     *
     * @param annee Année
     * @return Booléen indiquant si l'année est bissextile.
     */
    public static boolean anneeBissextile(final int annee) {
        return ((annee % UtilitaireEntier.NOMBRE_QUATRE == 0 && annee % UtilitaireEntier.CENTAINE != 0)
                || annee % (UtilitaireEntier.NOMBRE_QUATRE * UtilitaireEntier.CENTAINE) == 0);
    }

    /**
     * Permet d'obtenir le jour de la semaine d'une date donnée.
     *
     * @param calendrier Calendrier grégorien
     * @return Chaîne de caractères représentant le jour de la semaine.
     */
    public static String jourDeSemaine(final GregorianCalendar calendrier) {
        final ArrayList<String> jourTexte = new ArrayList<String>();
        jourTexte.add(0, "Invalide");
        jourTexte.add(GregorianCalendar.SUNDAY, "Dimanche");
        jourTexte.add(GregorianCalendar.MONDAY, "Lundi");
        jourTexte.add(GregorianCalendar.TUESDAY, "Mardi");
        jourTexte.add(GregorianCalendar.WEDNESDAY, "Mercredi");
        jourTexte.add(GregorianCalendar.THURSDAY, "Jeudi");
        jourTexte.add(GregorianCalendar.FRIDAY, "Vendredi");
        jourTexte.add(GregorianCalendar.SATURDAY, "Samedi");

        return jourTexte.get(calendrier.get(GregorianCalendar.DAY_OF_WEEK));
    }

    /**
     * Permet d'obtenir la forme textuelle d'un mois à partir de sa forme
     * numérique.
     *
     * @param mois Entier correspondant à l'un des 12 mois de l'année
     * @return Chaîne de caractères représentant un mois.
     */
    public static String moisATexte(final int mois) {
        final ArrayList<String> moisTexte = new ArrayList<String>();
        moisTexte.add(GregorianCalendar.JANUARY, "Janvier");
        moisTexte.add(GregorianCalendar.FEBRUARY, "Février");
        moisTexte.add(GregorianCalendar.MARCH, "Mars");
        moisTexte.add(GregorianCalendar.APRIL, "Avril");
        moisTexte.add(GregorianCalendar.MAY, "Mai");
        moisTexte.add(GregorianCalendar.JUNE, "Juin");
        moisTexte.add(GregorianCalendar.JULY, "Juillet");
        moisTexte.add(GregorianCalendar.AUGUST, "Août");
        moisTexte.add(GregorianCalendar.SEPTEMBER, "Septembre");
        moisTexte.add(GregorianCalendar.OCTOBER, "Octobre");
        moisTexte.add(GregorianCalendar.NOVEMBER, "Novembre");
        moisTexte.add(GregorianCalendar.DECEMBER, "Décembre");

        return moisTexte.get(getMoisGregorien(mois));
    }

    /**
     * Transforme un calendrier grégorien en une chaîne de format AAAA/MM/JJ.
     *
     * @param calendrier Calendrier grégorien
     * @return Date formatée
     */
    public static String greorianToString(final GregorianCalendar calendrier) {
        final int annee = calendrier.get(GregorianCalendar.YEAR);
        final int mois = calendrier.get(GregorianCalendar.MONTH) + 1;
        final int jour = calendrier.get(GregorianCalendar.DATE);

        return UtilitaireEntier.entierATexteMin(annee, UtilitaireEntier.NOMBRE_QUATRE) + "-"
                + UtilitaireEntier.entierATexteMin(mois, 2) + "-"
                + UtilitaireEntier.entierATexteMin(jour, 2);
    }

    /**
     * Permet d'obtenir la date du jour.
     *
     * @return Date du jour
     */
    public static GregorianCalendar dateDuJour() {
        return (GregorianCalendar) GregorianCalendar.getInstance();
    }

    /**
     * Mois pour calendrier grégorien.
     *
     * @param mois Mois, Janvier correspond à 1
     * @return Mois grégorien
     */
    public static int getMoisGregorien(final int mois) {
        int moisGregorien;
        if (GregorianCalendar.JANUARY <= mois - 1 && mois - 1 <= GregorianCalendar.DECEMBER) {
            moisGregorien = mois - 1;
        } else {
            moisGregorien = -1;
        }

        return moisGregorien;
    }
    /**
     * Nombre de jour dans le mois de février.
     */
    public static final int NBR_JOUR_FEV = 28;
    /**
     * Nombre de jour dans le mois de février dans une année bissextile.
     */
    public static final int NBR_JOUR_FEV_BIS = 29;

    /**
     * Vérifie si une string est une date sous format valide.
     *
     * @param date String représentant une date
     * @return Booléen représentant la validité de la date
     */
    public static boolean dateValide(final String date) {
        boolean dateValide = date.matches("[0-9][0-9][0-9][0-9]-[01][0-9]-[0-3][0-9]");

        if (dateValide) {
            final int annee = UtilitaireTexte.texteAEntier(date.substring(0, 4));
            final int mois = getMoisGregorien(UtilitaireTexte.texteAEntier(date.substring(5, 7)));
            final int jour = UtilitaireTexte.texteAEntier(date.substring(8, 10));

            final GregorianCalendar calendrier = (GregorianCalendar) GregorianCalendar.getInstance(Locale.getDefault());
            calendrier.set(annee, mois, jour);

            dateValide = calendrier.get(GregorianCalendar.YEAR) == annee
                    && calendrier.get(GregorianCalendar.MONTH) == mois
                    && calendrier.get(GregorianCalendar.DAY_OF_MONTH) == jour;
        }

        return dateValide;
    }
    /**
     * Différence d'année pour l'initialisation d'un objet Date.
     */
    public static final int DIFF_ANNEE_DATE = 1900;

    /**
     * Crée une date SQL valide à partir d'une string.
     *
     * @param date Date en string
     * @return Date Pour le SQL
     */
    public static java.sql.Date dateBD(final String date) {
        java.sql.Date dateBD;
        if (dateValide(date)) {
            final int annee = getAnnee(date) - DIFF_ANNEE_DATE;
            final int mois = getMois(date) - 1;
            final int jour = getJour(date);
            dateBD = new java.sql.Date(annee, mois, jour);
        } else {
            dateBD = null;
        }

        return dateBD;
    }

    /**
     * Calcule le nombre de jour entre deux date.
     *
     * @param date1 Date
     * @param date2 Autre date
     * @return Nombre de jour entre les deux dates
     */
    public static int nombreJourEntre(final String date1, final String date2) {
        int nombreJour;

        if (dateValide(date1) && dateValide(date2)) {
            final Date dateVerif1 = dateBD(date1);
            final Date dateVerif2 = dateBD(date2);

            nombreJour = nombreJourEntre(dateVerif1, dateVerif2);
        } else {
            nombreJour = -1;
        }

        return nombreJour;
    }

    /**
     * Calcule le nombre de jour entre deux date.
     *
     * @param date1 Date
     * @param date2 Autre date
     * @return Nombre de jour entre les deux dates
     */
    public static int nombreJourEntre(final Date date1, final Date date2) {
        int nombreJour = 0;

        final GregorianCalendar calendrier1 = new GregorianCalendar(
                date1.getYear(), getMoisGregorien(date1.getMonth()), date1.getDate());
        final GregorianCalendar calendrier2 = new GregorianCalendar(
                date2.getYear(), getMoisGregorien(date2.getMonth()), date2.getDate());

        if (calendrier1.before(calendrier2)) {
            while (calendrier1.before(calendrier2)) {
                calendrier1.add(GregorianCalendar.DAY_OF_MONTH, 1);
                ++nombreJour;
            }
        } else {
            while (calendrier2.before(calendrier1)) {
                calendrier2.add(GregorianCalendar.DAY_OF_MONTH, 1);
                ++nombreJour;
            }
        }

        return nombreJour;
    }
}
