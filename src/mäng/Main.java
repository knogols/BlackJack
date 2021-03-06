package mäng;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


/**
 * Created by Lisete on 15/12/15.
 */
public class Main extends JFrame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        KaardiPakk seeKaardiPakk = new KaardiPakk(1, true);
        Scanner panus = new Scanner(System.in);

        System.out.println("Olete sisenemas mängu BlackJack");
        System.out.println("Palun sisestage oma vanus!");

        int kasutajaSisestus = sc.nextInt(); //mängija vanus
        int m2ngijaRaha = 100; //mängija raha mängu alguses

        if (kasutajaSisestus >= 21) {

            System.out.println("Sul on " + m2ngijaRaha + "€, kui palju soovid panustada? ");

            int m2ngijaPanus = panus.nextInt();
            m2ngijaRaha = m2ngijaRaha - m2ngijaPanus;

            if (m2ngijaPanus > m2ngijaRaha) {
                System.out.println("Sul ei ole piisavalt raha. Sind logitakse automaatselt välja");
                System.exit(1);
            }

        } else {

            System.err.printf("Oled liiga noor. Hasartmängud on lubatud alates 21 eluaastast!");
            System.exit(1);
        }

        while (m2ngijaRaha > 0) {

            System.out.println("Kaardid on jagatud\n");
            break;

        }

        M2ngija mina = new M2ngija("Mängija");
        M2ngija jagaja = new M2ngija("Jagaja");

        mina.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart()); //mängijakaart
        jagaja.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart()); //jagajakaart

        mina.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart()); //mängijakaart
        jagaja.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart()); //jagajakaart

        mina.n2itaEsimest(true); // näitab mängija kaarte
        jagaja.n2itaEsimest(false); // näitab vaid ühte jagaja kaarti, teine varjatud
        System.out.println("\n");

        boolean minaL6petanud = false;
        boolean jagajaL6petanud = false;

        System.out.print("Juurde või Jääb? (Sisesta 1 või 2): ");
        System.out.println();

        while (!minaL6petanud || !jagajaL6petanud) {

            int sisestus = sc.nextInt();

            if (!minaL6petanud) {
                if (sisestus == 1) {

                    minaL6petanud = !mina.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart());
                    mina.n2itaEsimest(true);

                } else {

                    minaL6petanud = true;

                }
            }

            if (sisestus == 2) {

                minaL6petanud = true;
            }

            if (!jagajaL6petanud) {
                if (jagaja.m2ngijaKaartideSumma() < 17) {
                    System.out.println("Jagaja võtab juurde\n");
                    jagajaL6petanud = !jagaja.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart());
                    jagaja.n2itaEsimest(false);
                } else {
                    System.out.println("Jagaja jääb\n");
                    jagajaL6petanud = true;
                }
            }

            System.out.println();
        }

        sc.close();

        mina.n2itaEsimest(true); //näitab kaarte
        jagaja.n2itaEsimest(true); //näitab ka jagaja mõlemat kaarti

        int minuSumma = mina.m2ngijaKaartideSumma();
        int jagajaSumma = jagaja.m2ngijaKaartideSumma();

        if (minuSumma > jagajaSumma && minuSumma <= 21 || jagajaSumma > 21) {
            Main gui = new Main();
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.setVisible(true);
            gui.pack();
            gui.setTitle("BlackJack");
            System.out.println("Võitsid!");
        } else {

            System.out.println("Kaotasid! Sulle jäi alles " + m2ngijaRaha + "€");
        }

    }

    private ImageIcon pilt;
    private JLabel pealkiri;

    Main() {
        setLayout(new FlowLayout());

        pilt = new ImageIcon(getClass().getResource("pilt.png"));

        pealkiri = new JLabel(pilt);
        add(pealkiri);

    }


}
