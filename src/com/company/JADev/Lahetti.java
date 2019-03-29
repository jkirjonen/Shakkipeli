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

    private static boolean onkoPolkuVapaa(int alkuX, int alkuY, int loppuX, int loppuY) {
        /**
         * Tarkistaa onko Lähetin kulkemalla polulla joku nappula tiellä
         * @return true, jos polku on vapaa (sallittu), muuten false
         */
        if(((alkuX - loppuX) > 0) && ((alkuY - loppuY) > 0)) {
            int x = alkuX - 1;
            int y = alkuY - 1;
            for(int i = 1; i < Math.abs(alkuX - loppuX); i++) {
                if(!(Pelilauta.onTyhja(x, y))) {
                    return false;
                }
                else {
                    x--;
                    y--;
                }
            }
        }
        else if(((alkuX - loppuX) < 0) && ((alkuY - loppuY) < 0)) {
            int x = alkuX + 1;
            int y = alkuY + 1;
            for (int i = 1; i < Math.abs(alkuX - loppuX); i++) {
                if(!(Pelilauta.onTyhja(x, y))) {
                    return false;
                } else {
                    x++;
                    y++;
                }
            }
        }
        else if(((alkuX - loppuX) < 0) && ((alkuY - loppuY) > 0)) {
            int x = alkuX + 1;
            int y = alkuY - 1;
            for (int i = 1; i < Math.abs(alkuX - loppuX); i++) {
                if(!(Pelilauta.onTyhja(x, y))) {
                    return false;
                } else {
                    x++;
                    y--;
                }
            }
        }
        else if(((alkuX - loppuX) > 0) && ((alkuY - loppuY) < 0)) {
            int x = alkuX - 1;
            int y = alkuY + 1;
            for (int i = 1; i < Math.abs(alkuX - loppuX); i++) {
                if(!(Pelilauta.onTyhja(x, y))) {
                    return false;
                } else {
                    x--;
                    y++;
                }
            }
        }
        return true;
    }

    @Override
    public boolean onkoSallittu(int alkuX, int alkuY, int loppuX, int loppuY) {
        return (vinoPolku(alkuX, alkuY, loppuX, loppuY) && onkoPolkuVapaa(alkuX, alkuY, loppuX, loppuY));
    }

}
