package com.company.JADev;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Pelilauta uuspeli = new Pelilauta();
        Pelaaja pelaaja = new Pelaaja();
        Scanner alku = new Scanner(System.in);
        String valinta;



        System.out.println("Tervetuloa pelaamaan shakkia. Paina L ladataksesi tallennuksen, aloittaaksesi uuden pelin paina enter");

        valinta = alku.nextLine();


        if ( valinta.equals("l") || valinta.equals("L") ){
            while(uuspeli.aloitaPeli()){
                uuspeli.lataaPelilauta();
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