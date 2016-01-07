package mäng;

import java.util.Random;

/**
 * Created by Lisete on 15/12/15.
 * Kaardipaki kasutus
 */
public class KaardiPakk {

    private Kaart[] minuKaardid;
    private int numberKaardid; //Kaartide arv kaardipakis

    /**
     * konstruktor.
     *
     * @param
     */
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
     *
     */
    public void segama() {

        Random rng = new Random();
        Kaart temp;

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
     * @return
     */
    public Kaart jagaJ2rgmineKaart() {

        Kaart pealmine = this.minuKaardid[0]; // Pealmine kaart

        for (int c = 1; c < this.numberKaardid; c++) {
            this.minuKaardid[c - 1] = this.minuKaardid[c];
        }
        this.minuKaardid[this.numberKaardid - 1] = null;

        this.numberKaardid--;

        return pealmine;
    }


    //public void v2ljastaKaart(int numberV2ljastada) {

    //  for (int c = 0; c < numberV2ljastada; c++) {
    // System.out.printf("% 3d/%d %s\n", c + 1, this.numberKaardid, this.minuKaardid[c].toString());
    // }
    // System.out.printf("\t[%d others]\n", this.numberKaardid - numberV2ljastada);
    //}

}
