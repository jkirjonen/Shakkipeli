package com.company.JADev;

import java.util.Scanner;

public class Pelilauta {
    private Nappula[][] pelilauta = New Nappula[8][8];
    private boolean pelataan;
    private boolean valkoisenvuoro;
    private Scanner syote = new Scanner(System.in);
    private String komentoAlku;
    private String komentoLoppu
    private int alkuX;
    private int alkuY;
    private int loppuX;
    private int loppuY;

    public Pelilauta(){
        asetaPelilauta();
        pelataan == true;


    }

    private static void asetaPelilauta(){


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

        for(int rivi=0;rivi<pelilauta.lenght;rivi++){
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

    private boolean onkoSallittu(int alkuX,int alkuY,int loppuX,int loppuY){

        if(loppuX < 0 || loppuX > 7 || loppuY < 0 || loppuY > 7){
            System.out.println("Siirtosi on laudan ulkopuolella!");
            return false;
        }

        if(pelilauta[alkuX][alkuY] == null){
            System.out.println("Ruutu on tyhjä, valitse jokin omista nappuloistasi");
            return false;
        }

        if(!pelilauta[alkuX][alkuY].onkoSallittu(alkuX,alkuY,loppuX,loppuY) {
            System.out.println("Nappula ei liiku näin. Katso: https://fi.wikipedia.org/wiki/Shakki");
            return false;
        }

        if(pelilauta.[loppuX][loppuY] == null){
            return true;
        }


        }


    public boolean aloitaPeli() {
        return this.pelataan;
    }

    public void liiku(){


        if(valkoisenvuoro){
        System.out.print("On valkoisen vuoro. Anna komentosi:")
        }

        if(!valkoisenvuoro){
            System.out.print("On mustien vuoro. Anna komentosi:")
        }

        System.out.println("Anna ensin nappulan koordinaatit jota haluat liikuttaa")

        komentoAlku = syote.nextLine();

        Syste.out.println("Sitten")
        komentoLoppu = syote.nextLine();

        if(komento.equalsIgnoreCase("exit"){
        pelataan = false;
        System.out.println("Lopetit pelin. Kiitos pelaamisesta.");

        }

        /*
        if(komento.equalsIgnoreCase("tallenna"){

            pelataan = false;
            System.out.println("Peli tallennettiin tiedostoon" + Pelaaja.getTiedostoNimi())
            System.out.println("Kiitos pelaamisesta.");
        }
        */



    }
}
