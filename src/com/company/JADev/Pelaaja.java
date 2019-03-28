package com.company.JADev;


import java.util.Scanner;

public class Pelaaja {

    private static String pelaaja1 = "Alku";
    private static String pelaaja2 = "Arvo";
    private Scanner nimi = new Scanner(System.in);
    private static String tiedostoNimi = "";



    public void asetaPelaajat() {
       System.out.println("Anna nimesi pelaaja1:");
       setPelaaja1(nimi.nextLine());
       System.out.println("Terve " + pelaaja1 + ".");
       System.out.println("Anna nimesi pelaaja2:");
       setPelaaja2(nimi.nextLine());
       System.out.println("Terve " + pelaaja2 + ". Aloitetaan...");

    }

    public static String getPelaaja1() {
        return pelaaja1;
    }

    public void setPelaaja1(String pelaaja1) {
        this.pelaaja1 = pelaaja1;
    }

    public static String getPelaaja2() {
        return pelaaja2;
    }

    public void setPelaaja2(String pelaaja2) {
        this.pelaaja2 = pelaaja2;
    }

    public static String getTiedostoNimi() {

        return tiedostoNimi + pelaaja1 + "vs" + pelaaja2 + ".txt";
    }

}
