package com.company.JADev;

public class Torni extends Nappula {


    public Torni(boolean onValkoinen) {
        super(onValkoinen);
    }

    @Override
    public void piirra() {
        if(this.onValkoinen) {
            System.out.print("\u2656");
        }
        else {
            System.out.print("\u265C");
        }
    }


    private static boolean suoraPolku(int alkuX, int alkuY, int loppuX, int loppuY) {
        /**
         * Tarkistaa onko Tornin kulkema polku suora
         * @return true, jos polku on suora (sallittu), muuten false
         */
        return !((alkuX != loppuX) && alkuY != loppuY);
    }

    @Override
    public boolean onkoSallittu(int alkuX, int alkuY, int loppuX, int loppuY) {
        return suoraPolku(alkuX, alkuY, loppuX, loppuY);
    }

}
