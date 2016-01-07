package mäng;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


/**
 * Created by Lisete on 15/12/15.
 */
public class Runner extends JFrame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        KaardiPakk seeKaardiPakk = new KaardiPakk(1, true);

        System.out.println("Olete sisenemas mängu BlackJack");
        System.out.println("Palun sisestage oma vanus!");

        int kasutajaSisestus = sc.nextInt();

        if (kasutajaSisestus >= 21) {
            System.out.println("Kaardid on jagatud\n");
        } else {
            System.err.printf("Oled liiga noor. Hasartmängud on lubatud alates 21 eluaastast!");
            System.exit(1);
        }

        M2ngija mina = new M2ngija("Mängija");
        M2ngija jagaja = new M2ngija("Jagaja");



        mina.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart());
        jagaja.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart());

        mina.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart());
        jagaja.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart());


        mina.m2ngijaKaardid(true);
        jagaja.m2ngijaKaardid(false);
        System.out.println("\n");

        boolean minaL6petanud = false;
        boolean jagajaL6petanud = false;

        System.out.print("Juurde või Jääb? (Sisesta 1 või 2): ");
        System.out.println();

        while (!minaL6petanud || !jagajaL6petanud) {

            int sisestus = sc.nextInt();

            if(!minaL6petanud) {
                if (sisestus == 1) {

                    minaL6petanud = !mina.lisaKaart(seeKaardiPakk.jagaJ2rgmineKaart());
                    mina.m2ngijaKaardid(true);

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
                    jagaja.m2ngijaKaardid(false);
                } else {
                    System.out.println("Jagaja jääb\n");
                    jagajaL6petanud = true;
                }
            }

            System.out.println();
        }

        sc.close();

        mina.m2ngijaKaardid(true); //näitab kaarte
        jagaja.m2ngijaKaardid(true); //näitab ka jagaja kaarte

        int minuSumma = mina.m2ngijaKaartideSumma();
        int jagajaSumma = jagaja.m2ngijaKaartideSumma();

        if (minuSumma > jagajaSumma && minuSumma <= 21 || jagajaSumma > 21) {
            Runner gui = new Runner();
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.setVisible(true);
            gui.pack();
            gui.setTitle("BlackJack");
            System.out.println("Võitsid!");
        } else {
            System.out.println("Kaotasid!");
        }

    }

    private ImageIcon pilt;
    private JLabel pealkiri;
    private ImageIcon pilt2;
    private JLabel pealkiri2;

    Runner () {
        setLayout(new FlowLayout());

        pilt = new ImageIcon(getClass().getResource("pilt.png"));

        pealkiri = new JLabel(pilt);
        add(pealkiri);


    }


}
