package com.company.JADev;

public class Kuningatar extends Nappula {

    public Kuningatar(boolean onValkoinen) {
        super(onValkoinen);
    }

    @Override
    public void piirra() {
        if(this.onValkoinen) {
            System.out.print("\u2655");
        }
        else {
            System.out.print("\u265B");
        }
    }


    private static boolean suoraPolku(int alkuX, int alkuY, int loppuX, int loppuY) {
        /**
         * Tarkistaa onko Kuningattaren kulkema polku suora
         * @return true, jos polku on suora (sallittu), muuten false
         */
        return !((alkuX != loppuX) && alkuY != loppuY);
    }

    private static boolean vinoPolku(int alkuX, int alkuY, int loppuX, int loppuY) {
        /**
         * Tarkistaa onko Kuningattaren kulkema polku vino
         * @return true, jos polku on vino (sallittu), muuten false
         */
        return ((Math.abs(alkuX - loppuX) == Math.abs(alkuY - loppuY)));
    }

    @Override
    public boolean onkoSallittu(int alkuX, int alkuY, int loppuX, int loppuY) {
        return (suoraPolku(alkuX, alkuY, loppuX, loppuY)) ||  vinoPolku(alkuX, alkuY, loppuX, loppuY));
    }

}
