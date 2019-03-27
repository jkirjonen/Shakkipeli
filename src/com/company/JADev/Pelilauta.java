package com.company.JADev;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Pelilauta {
    private Nappula[][] pelilauta = new Nappula[8][8];
    private static boolean pelataan;
    private static boolean valkoisenvuoro;
    private static Scanner syote = new Scanner(System.in);
    private static String komento;
    private static int alkuX;
    private static int alkuY;
    private static int loppuX;
    private static int loppuY;
    private static boolean laitonSiirto;

    public Pelilauta(){
        asetaPelilauta();


    }

    private void asetaPelilauta(){


        for(int rivi=0;rivi<pelilauta.length;rivi++){
            for(int indeksi=0;indeksi<pelilauta[0].length;indeksi++){
                if(rivi == 0 && indeksi == 0){
                    pelilauta[rivi][indeksi] = new Torni(false);
                }
                if(rivi == 0 && indeksi == 1){
                    pelilauta[rivi][indeksi] = new Hevonen(false);
                }
                if(rivi == 0 && indeksi == 2){
                    pelilauta[rivi][indeksi] = new Lahetti(false);
                }
                if(rivi == 0 && indeksi == 3){
                    pelilauta[rivi][indeksi] = new Kuningatar(false);
                }
                if(rivi == 0 && indeksi == 4){
                    pelilauta[rivi][indeksi] = new Kuningas(false);
                }
                if(rivi == 0 && indeksi == 5){
                    pelilauta[rivi][indeksi] = new Lahetti(false);
                }
                if(rivi == 0 && indeksi == 6){
                    pelilauta[rivi][indeksi] = new Hevonen(false);
                }
                if(rivi == 0 && indeksi == 7){
                    pelilauta[rivi][indeksi] = new Torni(false);
                }
                if(rivi == 1 && indeksi < 8){
                    pelilauta[rivi][indeksi] = new Sotilas(false);
                }
                if(rivi == 6 && indeksi < 8){
                    pelilauta[rivi][indeksi] = new Sotilas(true);
                }
                if(rivi == 7 && indeksi == 0){
                    pelilauta[rivi][indeksi] = new Torni(true);
                }
                if(rivi == 7 && indeksi == 1){
                    pelilauta[rivi][indeksi] = new Hevonen(true);
                }
                if(rivi == 7 && indeksi == 2){
                    pelilauta[rivi][indeksi] = new Lahetti(true);
                }
                if(rivi == 7 && indeksi == 3){
                    pelilauta[rivi][indeksi] = new Kuningatar(true);
                }
                if(rivi == 7 && indeksi == 4){
                    pelilauta[rivi][indeksi] = new Kuningas(true);
                }
                if(rivi == 7 && indeksi == 5){
                    pelilauta[rivi][indeksi] = new Lahetti(true);
                }
                if(rivi == 7 && indeksi == 6){
                    pelilauta[rivi][indeksi] = new Hevonen(true);
                }
                if(rivi == 7 && indeksi == 7){
                    pelilauta[rivi][indeksi] = new Torni(true);
                }
                else{
                    pelilauta[rivi][indeksi] = null;
                }

            }

        }
    }


    public void piirraPelilauta(){

        System.out.println("\ta\tb\tc\td\te\tf\tg\th");

        for(int rivi=0;rivi<pelilauta.length;rivi++){
            System.out.print(rivi +1 + "  ");
            for(int indeksi=0;indeksi<pelilauta[0].length;indeksi++){
                if(pelilauta[rivi][indeksi] != null){
                    pelilauta[rivi][indeksi].piirra();
                    System.out.print("\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    private boolean onkoSallittu(){

        if(loppuX < 0 || loppuX > 7 || loppuY < 0 || loppuY > 7){
            System.out.println("Siirtosi on laudan ulkopuolella!");
            return false;
        }

        if(pelilauta[alkuX][alkuY] == null){
            System.out.println("Ruutu on tyhjä, valitse jokin omista nappuloistasi");
            return false;
        }

        if(!pelilauta[alkuX][alkuY].onkoSallittu(alkuX,alkuY,loppuX,loppuY)) {
            System.out.println("Nappula ei liiku näin. Katso: https://fi.wikipedia.org/wiki/Shakki");
            return false;
        }

        if(pelilauta[alkuX][alkuY].onValkoinen() && !valkoisenvuoro){
            System.out.println("Ei ole sinun vuorosi");
            return false;

        }

        if(pelilauta[loppuX][loppuY] == null){
            return true;
        }

        return true;


        }


    public boolean aloitaPeli() {
        return pelataan;
    }

    public void liiku(){

        if(laitonSiirto){
            System.out.println("Siirtosi on laiton, yritä uudestaan.");
            laitonSiirto = false;
        }

        if(valkoisenvuoro){
        System.out.print("On valkoisen vuoro. Anna komentosi:");
        }

        if(!valkoisenvuoro){
            System.out.print("On mustien vuoro. Anna komentosi:");
        }


        komento = syote.nextLine();


        if(komento.equalsIgnoreCase("exit")){
        pelataan = false;
        System.out.println("Lopetit pelin. Kiitos pelaamisesta.");

        }


        if(komento.equalsIgnoreCase("tallenna")){
            tallennus();
            pelataan = false;
            System.out.println("Peli tallennettiin tiedostoon" + Pelaaja.getTiedostoNimi());
            System.out.println("Kiitos pelaamisesta.");
        }


        komento  = komento.toLowerCase();

        String[] siirrot = komento.split(" ");

        alkuX = 7 - (siirrot[0].charAt(1) - '1');
        alkuY = siirrot[0].charAt(0) - 'a';
        loppuX = 7 - (siirrot[1].charAt(1) - '1');
        loppuY = siirrot[1].charAt(0) - 'a';

        if(onkoSallittu()){
            pelilauta[loppuX][loppuY] = pelilauta[alkuX][alkuY];
            pelilauta[alkuX][alkuY] = null;
            valkoisenvuoro = !valkoisenvuoro;
        }else{
            laitonSiirto = true;
            liiku();
        }



    }

    public void tallennus(){
        PrintWriter tallenna = null;
        try {
            tallenna = new PrintWriter(Pelaaja.getTiedostoNimi());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(int rivi=0;rivi<pelilauta.length;rivi++){
            if(rivi>0){ System.out.println(); }
            for(int indeksi=0;indeksi<pelilauta[0].length;indeksi++){
                tallenna.println(pelilauta[rivi][indeksi].annaMerkki());
            }
        }
        tallenna.close();
    }

    public void lataaPelilauta(File tallennus){

        Scanner tiedosto = null;
        try {
            tiedosto = new Scanner(tallennus);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[][] nappulat = new String[8][8];

        for(int rivi=0;rivi<pelilauta.length;rivi++){
            for(int indeksi=0;indeksi<pelilauta[0].length;indeksi++){
                nappulat[rivi][indeksi] = tiedosto.nextLine();
            }
        }
        for(int rivi=0;rivi<nappulat.length;rivi++) {
            for (int indeksi = 0; indeksi < nappulat[0].length; indeksi++) {
                switch (nappulat[rivi][indeksi]) {
                    case "\u2659":
                        pelilauta[rivi][indeksi] = new Sotilas(true);
                        continue;
                    case "\u265F":
                        pelilauta[rivi][indeksi] = new Sotilas(false);
                        continue;
                    case "\u2657":
                        pelilauta[rivi][indeksi] = new Lahetti(true);
                        continue;
                    case "\u265D":
                        pelilauta[rivi][indeksi] = new Lahetti(false);
                        continue;
                    case "\u2656":
                        pelilauta[rivi][indeksi] = new Torni(true);
                        continue;
                    case "\u265C":
                        pelilauta[rivi][indeksi] = new Torni(false);
                        continue;
                    case "\u2658":
                        pelilauta[rivi][indeksi] = new Hevonen(true);
                        continue;
                    case "\u265E":
                        pelilauta[rivi][indeksi] = new Hevonen(false);
                        continue;
                    case "\u2655":
                        pelilauta[rivi][indeksi] = new Kuningatar(true);
                        continue;
                    case "\u265B":
                        pelilauta[rivi][indeksi] = new Kuningatar(false);
                        continue;
                    case "\u2654":
                        pelilauta[rivi][indeksi] = new Kuningas(true);
                        continue;
                    case "\u265A":
                        pelilauta[rivi][indeksi] = new Kuningas(false);
                        continue;
                    default:
                        pelilauta[rivi][indeksi] = null;


                }
            }
        }

    }

}
