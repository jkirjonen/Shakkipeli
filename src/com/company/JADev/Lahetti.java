package com.company.JADev;

public class Lahetti extends Nappula {

    public Lahetti(boolean onValkoinen) {
        super(onValkoinen);
    }

    @Override
    public void piirra() {
        if(this.onValkoinen) {
            System.out.print("\u2657");
        }
        else {
            System.out.print("\u265D");
        }
    }


    public String annaMerkki() {
        if(this.onValkoinen) {
            return "\u2657";
        }
        else {
            return "\u265D";
        }
    }


    private static boolean vinoPolku(int alkuX, int alkuY, int loppuX, int loppuY) {
        /**
         * Tarkistaa onko Lähetin kulkema polku vino
         * @return true, jos polku on vino (sallittu), muuten false
         */
        return ((Math.abs(alkuX - loppuX) == Math.abs(alkuY - loppuY)));
    }

    @Override
    public boolean onkoSallittu(int alkuX, int alkuY, int loppuX, int loppuY) {
        return vinoPolku(alkuX, alkuY, loppuX, loppuY);
    }

}
