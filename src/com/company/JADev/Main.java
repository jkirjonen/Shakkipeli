package com.company.JADev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Pelilauta uuspeli = new Pelilauta();
        Pelaaja pelaaja = new Pelaaja();
        Scanner alku = new Scanner(System.in);
        String valinta;




        Intro.alku();

        Intro.soita("alku.wav");

        valinta = alku.nextLine();

        System.out.println("Voit tallentaa peli tilanteesi komennolla tallenna");
        System.out.println("Voit poistua pelistä komennolla exit");
        System.out.println("Musiikin saat päälle ja pois komennolla musa");



        Intro.lopeta();
        Intro.soita("peli.wav");

        if ( valinta.equals("l") || valinta.equals("L") ){
            uuspeli.lataaPelilauta();
            while(uuspeli.aloitaPeli()){
                uuspeli.piirraPelilauta();
                uuspeli.liiku();
            }
        }

        //pelaaja.asetaPelaajat();

        while(uuspeli.aloitaPeli()){
            uuspeli.piirraPelilauta();
            uuspeli.liiku();


        }

    }
}