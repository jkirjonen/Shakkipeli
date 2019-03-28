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

    public String annaMerkki() {
        if(this.onValkoinen) {
            return "\u2656";
        }
        else {
            return "\u265C";
        }
    }


    private static boolean suoraPolku(int alkuX, int alkuY, int loppuX, int loppuY) {
        /**
         * Tarkistaa onko Tornin kulkema polku suora
         * @return true, jos polku on suora (sallittu), muuten false
         */
        return !((alkuX != loppuX) && alkuY != loppuY);
    }

    private static boolean onkoPolkuVapaa(int alkuX, int alkuY, int loppuX, int loppuY) {
        /**
         * Tarkistaa onko Tornin kulkemalla polulla joku nappula tiellä
         * @return true, jos polku on vapaa (sallittu), muuten false
         */
        if(((alkuX - loppuX) > 0) && ((alkuY - loppuY) == 0)) {
            int x = alkuX;
            int y = alkuY;
            for(int i = 0; i < Math.abs(alkuX - loppuX); i++) {
                if(!(Pelilauta.onTyhja(x, y))) {
                    return false;
                }
                else {
                    x--;
                }
            }
        }
        else if(((alkuX - loppuX) < 0) && ((alkuY - loppuY) == 0)) {
            int x = alkuX;
            int y = alkuY;
            for (int i = 0; i < Math.abs(alkuX - loppuX); i++) {
                if(!(Pelilauta.onTyhja(x, y))) {
                    return false;
                } else {
                    x++;
                }
            }
        }
        else if(((alkuX - loppuX) == 0) && ((alkuY - loppuY) > 0)) {
            int x = alkuX;
            int y = alkuY;
            for (int i = 0; i < Math.abs(alkuX - loppuX); i++) {
                if(!(Pelilauta.onTyhja(x, y))) {
                    return false;
                } else {
                    y--;
                }
            }
        }
        else if(((alkuX - loppuX) == 0) && ((alkuY - loppuY) < 0)) {
            int x = alkuX;
            int y = alkuY;
            for (int i = 0; i < Math.abs(alkuX - loppuX); i++) {
                if(!(Pelilauta.onTyhja(x, y))) {
                    return false;
                } else {
                    y++;
                }
            }
        }
        return true;
    }

    @Override
    public boolean onkoSallittu(int alkuX, int alkuY, int loppuX, int loppuY) {
        return (suoraPolku(alkuX, alkuY, loppuX, loppuY) && onkoPolkuVapaa(alkuX, alkuY, loppuX, loppuY));
    }

}
