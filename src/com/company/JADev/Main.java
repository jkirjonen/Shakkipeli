package com.company.JADev;

public class Main {

    public static void main(String[] args) {

        Pelilauta uuspeli = new Pelilauta();
        Pelaaja pelaaja = new Pelaaja();

        pelaaja.asetaPelaajat();

        while(uuspeli.aloitaPeli()){
            uuspeli.piirraPelilauta();
            uuspeli.liiku();

        }

    }
}
[]