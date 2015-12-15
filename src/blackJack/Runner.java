package blackJack;

import java.util.Scanner;

/**
 * Created by Lisete on 15/12/15.
 */
public class Runner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        KaardiPakk seeKaardiPakk = new KaardiPakk(1, true);

        M2ngija mina = new M2ngija("Kätlin");
        M2ngija jagaja = new M2ngija("Jagaja");

        mina.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart());
        jagaja.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart());
        mina.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart());
        jagaja.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart());

        System.out.println("Kaardid on jagatud\n");
        mina.m2ngijaKaardid(true);
        jagaja.m2ngijaKaardid(false);
        System.out.println("\n");

        boolean minaDone = false;
        boolean jagajaDone = false;
        String ans;

        while (!minaDone || !jagajaDone) {

            if(!minaDone) {

                System.out.print("Hit or Stay? (Enter H or S): ");
                ans = sc.next();
                System.out.println();

                if (ans.compareToIgnoreCase("H") == 0) {

                    minaDone = !mina.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart());
                } else {
                    minaDone = true;

                }
            }

            if (!jagajaDone) {
                if (jagaja.m2ngijaKaartideSumma() < 17) {
                    System.out.println("The Dealer hits\n");
                    jagajaDone = !jagaja.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart());
                    jagaja.m2ngijaKaardid(false);
                } else {
                    System.out.println("The Dealer stays\n");
                    jagajaDone = true;
                }
            }

            System.out.println();
        }

        sc.close();

        mina.m2ngijaKaardid(true);
        jagaja.m2ngijaKaardid(true);

        int minuSumma = mina.m2ngijaKaartideSumma();
        int jagajaSumma = jagaja.m2ngijaKaartideSumma();

        if (minuSumma > jagajaSumma && minuSumma <= 21 || jagajaSumma > 21) {
            System.out.println("Võitsid!");
        } else {
            System.out.println("Kaotasid!");
        }
    }
}
