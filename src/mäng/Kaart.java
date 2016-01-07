package mäng;

/**
 * Created by Lisete on 15/12/15.
 * Kaartide kasutamine.
 */
public class Kaart {

    private int kaardiNumber; // Äss: 1, Poiss - Kuningas 11-13
    private Mastid kaardiMast; // Mastile vastav kaart

    /**
     * kaardi konstruktor
     *
     * @param Mast
     * @param aNumber
     */
    public Kaart(Mastid Mast, int aNumber) {

        this.kaardiMast = Mast;
        if (aNumber >= 1 && aNumber <= 13) { //Kontrollib numbri sobivust. Sobivad arvud 1-13
            this.kaardiNumber = aNumber;
        } else {
            System.err.println(aNumber + " ei ole sobiv number");
            System.exit(1);
        }

        kaardiNumber = aNumber;
    }

    /**
     * Tagastab kaardi numbri
     *
     * @return number
     */
    public int getNumber() {
        return kaardiNumber;
    }

    /**
     * Tagastab kaardi nime
     *
     * @return
     */
    public String toString() {

        String numStr = "number";

        switch (this.kaardiNumber) {

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

        return kaardiMast.toString() + " " + numStr;
    }
}
