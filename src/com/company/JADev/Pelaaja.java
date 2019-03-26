package com.company.JADev;

import java.util.Scanner;

public class Pelaaja {

    String pelaaja1;
    String pelaaja2;
    Scanner nimi = new Scanner(System.in);

    public void asetaPelaajat() {
       System.out.println("Tervetuloa pelaamaan shakkia. Anna nimesi pelaaja1:");
       setPelaaja1(nimi.nextLine());
       System.out.println("Terve" + pelaaja1 + ".");
       System.out.println("Anna nimesi pelaaja2:");
       setPelaaja2(nimi.nextLine());
       System.out.println("Terve" + pelaaja2 + ". Aloitetaan...")
    }

    public String getPelaaja1() {
        return pelaaja1;
    }

    public void setPelaaja1(String pelaaja1) {
        this.pelaaja1 = pelaaja1;
    }

    public String getPelaaja2() {
        return pelaaja2;
    }

    public void setPelaaja2(String pelaaja2) {
        this.pelaaja2 = pelaaja2;
    }

    public static String getTiedostoNimi(){
        return System.out.println( pelaaja1 + "vs" + pelaaja2 ".txt");
    }
}
