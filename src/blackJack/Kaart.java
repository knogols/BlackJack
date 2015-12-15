package blackJack;

/**
 * Created by Lisete on 15/12/15.
 * Kaartide kasutamine
 */
public class Kaart {
    /**
     * Üks mastidest kaardile
     */
    private Mastid minuMastid;

    /**
     * Tabamuste arv, Äss: 1, Poiss - Kuningas: 11-13
     */
    private int minuNumber;

    /**
     * kaardi konstruktor
     * @param aMastid kaardi mast
     * @param aNumber kaardi number
     */

    public Kaart(Mastid aMastid, int aNumber) {

        this.minuMastid = aMastid;
        /**
         * Kontrollib numbri sobivust. Sobivad arvud 1-13
         */
        if (aNumber >= 1 && aNumber <= 13) {
            this.minuNumber = aNumber;
        } else {
            System.err.println(aNumber + " ei ole sobiv number");
            System.exit(1);
        }

        minuNumber = aNumber;
    }

    /**
     * Tagastab kaardi numbri
     * @return number
     */
    public int getNumber() {
        return minuNumber;
    }

    /**
     * Tagastab kaardi nime
     * @return
     */
    public String toString() {

        String numStr = "number";

        switch(this.minuNumber) {

            case 2:
                numStr = "Kaks";
                break;
            case 3:
                numStr = "Kolm";
                break;
            case 4:
                numStr = "Neli";
                break;
            case 5:
                numStr = "Viis";
                break;
            case 6:
                numStr = "Kuus";
                break;
            case 7:
                numStr = "Seitse";
                break;
            case 8:
                numStr = "Kaheksa";
                break;
            case 9:
                numStr = "Üheksa";
                break;
            case 10:
                numStr = "Kümme";
                break;
            case 11:
                numStr = "Poiss";
                break;
            case 12:
                numStr = "Emand";
                break;
            case 13:
                numStr = "Kuningas";
                break;
            case 1:
                numStr = "Äss";
                break;

        }

        return minuMastid.toString() + " " + numStr;  /**numStr + " on " + minuMastid.toString();**/
    }
}
