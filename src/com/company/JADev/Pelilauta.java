package com.company.JADev;

import java.io.*;
import java.util.Arrays;
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
    static boolean musa =true;
    public Pelilauta(){
        asetaPelilauta();


    }

    /**
    Asettaa pelinappulat laudalle oikeaan järjestykseen.
     */

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

    /**
     * Tarkistaa onko pelilaudan ruutu tyhjä.
     * @param x
     * @param y
     * @return palauttaa true jos ruudussa ei ole nappulaa.
     */

    public static boolean onTyhja(int x, int y) {
        if(pelilauta[x][y] == null) {
            return true;
        }
        return false;
    }

    /**
     * Piirtää pelilaudan ja siihen nappulat ruuduissa olevien nappuloiden mukaan kutsumalla
     * eri nappulaluokista piirra metodia.
     */


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

    /**
     * Tarkistaa onko mahdollinen siirto sallittu.
     * @return
     */

    private boolean onkoSallittu(){

        if(loppuX < 0 || loppuX > 7 || loppuY < 0 || loppuY > 7){
            System.out.println("Siirtosi on laudan ulkopuolella!");
            return false;
        }

        if(pelilauta[alkuX][alkuY] == null){
            System.out.println("Ruutu on tyhjä, valitse jokin omista nappuloistasi");
            return false;
        }

        if((pelilauta[alkuX][alkuY].onValkoinen && !valkoisenvuoro) ||
                (!pelilauta[alkuX][alkuY].onValkoinen() && valkoisenvuoro))  {
            System.out.println("Ei ole sinun vuorosi");
            return false;

        }

        if(!pelilauta[alkuX][alkuY].onkoSallittu(alkuX,alkuY,loppuX,loppuY)) {
            System.out.println("Nappula ei liiku näin. Katso: https://fi.wikipedia.org/wiki/Shakki");
            return false;
        }


        if(pelilauta[loppuX][loppuY] == null) {
            return true;
        }

        if(!pelilauta[alkuX][alkuY].onValkoinen && !pelilauta[loppuX][loppuY].onValkoinen) {
            System.out.println("Et voi siirtyä oman nappulasi päälle.");
            return false;
        }

        if(pelilauta[alkuX][alkuY].onValkoinen && pelilauta[loppuX][loppuY].onValkoinen) {
            System.out.println("Et voi siirtyä oman nappulasi päälle.");
            return false;
        }


        return true;


        }

    /**
     *
      * @return palauttaa muuttujan pelataan, jolla peli pysyy käynnissä.
     */

    public boolean aloitaPeli() {
        return pelataan;
    }

    /**
     * Ottaa pelissä kommennot vastaan tekstinä (d2 d4) ja vie sen taulukkoon josta se asetetaan muuttujien
     * alkuX, alkuY, loppuX ja loppuY arvoihin. Kutsutaan onkoSallittu() metodia ja jos on true niin
     * siirretään Nappula oliota pelilaudalla. Vaihdetaan vuoroa muuttamalla muuttuja valkoisenvuoro.
     */

    public void liiku(){

        if(laitonSiirto){
            System.out.println("Siirtosi on laiton, yritä uudestaan.");
            laitonSiirto = false;
        }

        if(valkoisenvuoro){
            System.out.println("Valkoisten vuoro. \u2656 ");
            //System.out.println("On " + Pelaaja.getPelaaja1() + "(valkoiset) vuoro" );
        }

        if(!valkoisenvuoro){
            System.out.println("Mustien vuoro. \u265C ");
            //System.out.println("On " + Pelaaja.getPelaaja2() + "(mustat) vuoro");
        }

        System.out.print("Anna komentosi(esim. h7 h6):");


        komento = syote.nextLine();


        komento  = komento.toLowerCase();

        try {
            String[] siirrot = komento.split(" ");

            alkuX = 7 - (siirrot[0].charAt(1) - '1');
            alkuY = siirrot[0].charAt(0) - 'a';
            loppuX = 7 - (siirrot[1].charAt(1) - '1');
            loppuY = siirrot[1].charAt(0) - 'a';
        }catch(Exception e){
            if(komento.equalsIgnoreCase("exit")){
                pelataan = false;
                System.out.println("Lopetit pelin. Kiitos pelaamisesta.");

            }

            else if(komento.equalsIgnoreCase("tallenna")){
                //System.out.println("Peli tallennettiin tiedostoon " + Pelaaja.getTiedostoNimi());
                System.out.println("Kiitos pelaamisesta. Pelisi on tallennettu tiedostoon tallennus.txt");
                tallennus();
                pelataan = false;

            }

            else if(komento.equalsIgnoreCase("musa")){
                if(musa) {
                    Intro.lopeta();
                    musa = !musa;
                    liiku();
                }
                else{
                    Intro.soita("peli.wav");
                    musa = !musa;
                    liiku();
                }


            }

            else {
                System.out.println("Virheellinen komento. Siirrot muodossa h7 h5.");
                System.out.println("Komennolla tallenna voit tallentaa pelin ja komennolla exit lopettaa pelin.");
                liiku();
            }
        }
        if(onkoSallittu()){
            pelilauta[loppuX][loppuY] = pelilauta[alkuX][alkuY];
            pelilauta[alkuX][alkuY] = null;
            valkoisenvuoro = !valkoisenvuoro;
        }else{
            laitonSiirto = true;
            liiku();
        }



    }

    /**
     * Luodaan uusi tiedosto tai jos jo olemassa, ylikirjoitetaan aina tallennettaessa.
     * Piirretään tekstitiedostoon pelilaudan tilanne käyttämällä Nappula olioissa olevaa
     * annaMerkki metodia joka palauttaa Shakki nappulaa vastaavan symbolin ruutu kerrallaan,
     * jos ei ruudulla ole nappulaa piirtää välilyönnin.
     *
     */

    public void tallennus(){

    try {
        File file = new File("tallennus.txt");
        file.createNewFile();
        FileWriter tallenna = new FileWriter(file);


        for (int rivi = 0; rivi < pelilauta.length; rivi++) {
            if(rivi > 0){ tallenna.write("\n"); }
            for (int indeksi = 0; indeksi < pelilauta[0].length; indeksi++) {
                if (pelilauta[rivi][indeksi] != null) {
                    tallenna.write(pelilauta[rivi][indeksi].annaMerkki());
                }else{
                    tallenna.write(" ");
                }
            }
        }

        tallenna.flush();
        tallenna.close();
    }catch(Exception e){
        e.printStackTrace();
        }
    }

    /**
     * Lukee tiedostosta tallennus.txt pelitilanteen käyttämällä sinne tallennettuja nappula symboleja.
     * Luetaan tekstitiedostosta rivi kerrallaan String taulukkoon ja siitä suoraan string kerrallaan
     * splitillä merkeittäin matriisiin. Luodaan pelilauta symbolien perusteella. Peli tilanteen voi myös
     * katsoa suoraan tekstitiedostosta.
     */


    public void lataaPelilauta(){

        Scanner tiedosto = null;
        try {
            tiedosto = new Scanner(new File("tallennus.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] rivit = new String[8];
        String[][] nappulat = new String[8][8];

        for(int i=0;i<rivit.length;i++){
            rivit[i] = tiedosto.nextLine();
            nappulat[i] = rivit[i].split("");
        }
        String temp= "";


        for(int rivi=0;rivi<nappulat.length-1;rivi++) {
            for (int indeksi = 0; indeksi < nappulat[0].length-1; indeksi++) {

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
