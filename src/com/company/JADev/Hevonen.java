package com.company.JADev;

public class Hevonen extends Nappula{


    public Hevonen(boolean onValkoinen) {
        super(onValkoinen);
    }

    @Override
    public void piirra() {
        if(this.onValkoinen) {
            System.out.print("\u2658");
        }
        else {
            System.out.print("\u265E");
        }
    }


    private static boolean lPolku(int alkuX, int alkuY, int loppuX, int loppuY) {
        /**
         * Tarkistaa onko Hevosen kulkema polku L:n mallinen
         * @return true, jos polku on L (sallittu), muuten false
         */
        return ((Math.abs(alkuX - loppuX) == 2 && Math.abs(alkuY - loppuY) == 1)
                || (Math.abs(alkuX - loppuX) == 1 && Math.abs(alkuY - loppuY) == 2));
    }

    @Override
    public boolean onkoSallittu(int alkuX, int alkuY, int loppuX, int loppuY) {
        return lPolku(alkuX, alkuY, loppuX, loppuY);
    }
}
