package mäng;

/**
 * Created by Lisete on 15/12/15.
 */
public class M2ngija {

    String nimi; //Mängija nimi
    private Kaart[] k2si = new Kaart[10]; //Mängija kaart
    private int kaartideArvM; //Kaartide arv mängija käes

    /**
     * Mängija konstruktor
     *
     * @param aNimi mängija nimi
     */
    public M2ngija(String aNimi) {

        this.nimi = aNimi;
        this.tyhiK2si(); //Mängija käsi tühi
    }

    public void tyhiK2si() { // Mängijal ei ole kaarte

        for (int c = 0; c < 10; c++) {
            this.k2si[c] = null;
        }
        this.kaartideArvM = 0;
    }

    /**
     * Lisab kaardi mängijale
     *
     * @param aKaart lisatav kaart
     * @return kas käes olevate kaartide summa on väiksem või võrdne 21ga
     */
    public boolean lisaKaart(Kaart aKaart) {

        if (this.kaartideArvM == 10) { //prindib errori kui mängijal on maksimum arv kaarte
            System.err.printf("%s mängijal juba on 10 kaarti; " + "ei saa uut kaarti\n", this.nimi);
            System.exit(1);
        }

        this.k2si[this.kaartideArvM] = aKaart;
        this.kaartideArvM++;

        return (this.m2ngijaKaartideSumma() <= 21);

    }

    /**
     * Mängija käes olevate kaartide summa
     *
     * @return tagastab summa
     */
    public int m2ngijaKaartideSumma() {

        int k2eSumma = 0;
        int kaardiNumber;
        int ässaNumber = 0;

        for (int c = 0; c < this.kaartideArvM; c++) { //arvutab kaardi panuse summaks

            kaardiNumber = this.k2si[c].getNumber(); //käesoleva kaardi number

            if (kaardiNumber == 1) { // äss
                ässaNumber++;
                k2eSumma += 11;
            } else if (kaardiNumber > 10) { //pildiga kaart
                k2eSumma += 10;
            } else {
                k2eSumma += kaardiNumber;
            }
        }

        while (k2eSumma > 21 && ässaNumber > 0) {
            k2eSumma -= 10;
            ässaNumber--;
        }

        return k2eSumma;
    }

    /**
     * @param n2itaEsimestKaarti esimene kaart peidetud või mitte
     */
    public void m2ngijaKaardid(boolean n2itaEsimestKaarti) {

        System.out.printf("%s kaardid:\n", this.nimi);
        for (int c = 0; c < this.kaartideArvM; c++) {
            if (c == 0 && !n2itaEsimestKaarti) {
                System.out.println(" [varjatud]");
            } else {
                System.out.printf(" %s\n", this.k2si[c].toString());
            }
        }

    }

}

