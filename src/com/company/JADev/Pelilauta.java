package com.company.JADev;

import java.io.*;
import java.util.Scanner;

public class Pelilauta {
    private static Nappula[][] pelilauta = new Nappula[8][8];
    private static boolean pelataan = true;
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
                else if(rivi == 0 && indeksi == 1){
                    pelilauta[rivi][indeksi] = new Hevonen(false);
                }
                else if(rivi == 0 && indeksi == 2){
                    pelilauta[rivi][indeksi] = new Lahetti(false);
                }
                else if(rivi == 0 && indeksi == 3){
                    pelilauta[rivi][indeksi] = new Kuningatar(false);
                }
                else if(rivi == 0 && indeksi == 4){
                    pelilauta[rivi][indeksi] = new Kuningas(false);
                }
                else if(rivi == 0 && indeksi == 5){
                    pelilauta[rivi][indeksi] = new Lahetti(false);
                }
                else if(rivi == 0 && indeksi == 6){
                    pelilauta[rivi][indeksi] = new Hevonen(false);
                }
                else if(rivi == 0 && indeksi == 7){
                    pelilauta[rivi][indeksi] = new Torni(false);
                }
                else if(rivi == 1 && indeksi < 8){
                    pelilauta[rivi][indeksi] = new Sotilas(false);
                }
                else if(rivi == 6 && indeksi < 8){
                    pelilauta[rivi][indeksi] = new Sotilas(true);
                }
                else if(rivi == 7 && indeksi == 0){
                    pelilauta[rivi][indeksi] = new Torni(true);
                }
                else if(rivi == 7 && indeksi == 1){
                    pelilauta[rivi][indeksi] = new Hevonen(true);
                }
                else if(rivi == 7 && indeksi == 2){
                    pelilauta[rivi][indeksi] = new Lahetti(true);
                }
                else if(rivi == 7 && indeksi == 3){
                    pelilauta[rivi][indeksi] = new Kuningatar(true);
                }
                else if(rivi == 7 && indeksi == 4){
                    pelilauta[rivi][indeksi] = new Kuningas(true);
                }
                else if(rivi == 7 && indeksi == 5){
                    pelilauta[rivi][indeksi] = new Lahetti(true);
                }
                else if(rivi == 7 && indeksi == 6){
                    pelilauta[rivi][indeksi] = new Hevonen(true);
                }
                else if(rivi == 7 && indeksi == 7){
                    pelilauta[rivi][indeksi] = new Torni(true);
                }
                else{
                    pelilauta[rivi][indeksi] = null;
                }

            }

        }
    }

    public static boolean onTyhja(int x, int y) {
        if(pelilauta[x][y] == null) {
            return true;
        }
        return false;
    }


    public void piirraPelilauta(){

        System.out.println("\ta\tb\tc\td\te\tf\tg\th");

        for(int rivi=0;rivi<pelilauta.length;rivi++){
            System.out.print(8 - rivi + ".\t");
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

        if(pelilauta[loppuX][loppuY] == null) {
            return true;
        }

        if(pelilauta[alkuX][alkuY].onValkoinen && pelilauta[loppuX][loppuY].onValkoinen) {
            System.out.println("Et voi siirtyä oman nappulasi päälle.");
            return false;
        }

        if(!pelilauta[alkuX][alkuY].onValkoinen && !pelilauta[loppuX][loppuY].onValkoinen) {
            System.out.println("Et voi siirtyä oman nappulasi päälle.");
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

        if(!valkoisenvuoro){
        System.out.println("On " + Pelaaja.getPelaaja1() + "(valkoiset) vuoro" );
        }

        if(valkoisenvuoro){
            System.out.println("On " + Pelaaja.getPelaaja2() + "(mustatgit) vuoro");
        }

        System.out.print("Anna komentosi(esim. h7 h6):");
        komento = syote.nextLine();


        if(komento.equalsIgnoreCase("exit")){
        pelataan = false;
        System.out.println("Lopetit pelin. Kiitos pelaamisesta.");

        }


        if(komento.equalsIgnoreCase("tallenna")){
            System.out.println("Peli tallennettiin tiedostoon " + Pelaaja.getTiedostoNimi());
            System.out.println("Kiitos pelaamisesta.");
            tallennus();
            pelataan = false;

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

    try {
        File file = new File(Pelaaja.getTiedostoNimi());
        file.createNewFile();
        FileWriter tallenna = new FileWriter(file);


        for (int rivi = 0; rivi < pelilauta.length; rivi++) {
            if(rivi > 0){ tallenna.write("\n"); }
            for (int indeksi = 0; indeksi < pelilauta[0].length; indeksi++) {
                if (pelilauta[rivi][indeksi] != null) {
                    tallenna.write(pelilauta[rivi][indeksi].annaMerkki());
                }else{
                    tallenna.write("\t");
                }
            }
        }

        tallenna.flush();
        tallenna.close();
    }catch(Exception e){
        e.printStackTrace();
        }
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
