package mäng;

import java.util.Random;

/**
 * Created by Lisete on 15/12/15.
 * Kaardipaki kasutus
 */
public class KaardiPakk {

    private Kaart[] minuKaardid;
    private int numberKaardid; //Kaartide arv kaardipakis

    public KaardiPakk(int numberKaart, boolean segama) {

        this.numberKaardid = numberKaart * 52;
        this.minuKaardid = new Kaart[this.numberKaardid];

        int c = 0;

        for (int d = 0; d < numberKaart; d++) {

            for (int s = 0; s < 4; s++) {

                for (int n = 1; n <= 13; n++) {

                    this.minuKaardid[c] = new Kaart(Mastid.values()[s], n);
                    c++;

                }
            }
        }

        if (segama) {
            this.segama();
        }

    }

    /**
     * Kaartide segamine
     */
    public void segama() {

        Random rng = new Random(); // suvaline number
        Kaart temp; // ajutine kaart

        int j;
        for (int i = 0; i < this.numberKaardid; i++) {

            j = rng.nextInt(this.numberKaardid);

            temp = this.minuKaardid[i];
            this.minuKaardid[i] = minuKaardid[j];
            this.minuKaardid[j] = temp;
        }

    }

    /**
     * Jagab pakist järgmise pealmise kaardi
     *
     * @return jagatud kaart
     */
    public Kaart jagaJ2rgmineKaart() {

        Kaart pealmine = this.minuKaardid[0]; // Pealmine kaart

        for (int c = 1; c < this.numberKaardid; c++) {
            this.minuKaardid[c - 1] = this.minuKaardid[c];
        }
        this.minuKaardid[this.numberKaardid - 1] = null;

        this.numberKaardid--; // kaart vähemaks

        return pealmine;
    }
}
