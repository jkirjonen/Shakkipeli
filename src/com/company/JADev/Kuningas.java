package com.company.JADev;

public class Kuningas extends Nappula {


    public Kuningas(boolean onValkoinen) {
        super(onValkoinen);
    }

    @Override
    public void piirra() {
        if(this.onValkoinen) {
            System.out.print("\u2654");
        }
        else {
            System.out.print("\u265A");
        }
    }

    public String annaMerkki() {
        if(this.onValkoinen) {
            return "\u2654";
        }
        else {
            return "\u265A";
        }
    }

    @Override
    public boolean onkoSallittu(int alkuX, int alkuY, int loppuX, int loppuY) {
        return Math.abs(alkuX - loppuX) <= 1 || Math.abs(alkuY - loppuY) <= 1;
    }

}
