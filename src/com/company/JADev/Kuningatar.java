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

    public String annaMerkki() {
        if(this.onValkoinen) {
            return "\u2655";
        }
        else {
            return "\u265B";
        }
    }


    private static boolean suoraPolku(int alkuX, int alkuY, int loppuX, int loppuY) {
        /**
         * Tarkistaa onko Kuningattaren kulkema polku suora
         * @return true, jos polku on suora (sallittu), muuten false
         */
        return !((alkuX != loppuX) && alkuY != loppuY);
    }

    private static boolean onkoSuoraPolkuVapaa(int alkuX, int alkuY, int loppuX, int loppuY) {
        /**
         * Tarkistaa onko Kuningattaren kulkemalla suoralla polulla joku nappula tiellä
         * @return true, jos polku on vapaa (sallittu), muuten false
         */
        if(((alkuX - loppuX) > 0) && ((alkuY - loppuY) == 0)) {
            int x = alkuX -1;
            int y = alkuY;
            for(int i = 1; i < Math.abs(alkuX - loppuX); i++) {
                if(!(Pelilauta.onTyhja(x, y))) {
                    return false;
                }
                else {
                    x--;
                }
            }
        }
        else if(((alkuX - loppuX) < 0) && ((alkuY - loppuY) == 0)) {
            int x = alkuX + 1;
            int y = alkuY;
            for (int i = 1; i < Math.abs(alkuX - loppuX); i++) {
                if(!(Pelilauta.onTyhja(x, y))) {
                    return false;
                } else {
                    x++;
                }
            }
        }
        else if(((alkuX - loppuX) == 0) && ((alkuY - loppuY) > 0)) {
            int x = alkuX;
            int y = alkuY - 1;
            for (int i = 1; i < Math.abs(alkuY - loppuY); i++) {
                if(!(Pelilauta.onTyhja(x, y))) {
                    return false;
                } else {
                    y--;
                }
            }
        }
        else if(((alkuX - loppuX) == 0) && ((alkuY - loppuY) < 0)) {
            int x = alkuX;
            int y = alkuY +1;
            for (int i = 1; i < Math.abs(alkuY - loppuY); i++) {
                if(!(Pelilauta.onTyhja(x, y))) {
                    return false;
                } else {
                    y++;
                }
            }
        }
        return true;
    }

    private static boolean vinoPolku(int alkuX, int alkuY, int loppuX, int loppuY) {
        /**
         * Tarkistaa onko Kuningattaren kulkema polku vino
         * @return true, jos polku on vino (sallittu), muuten false
         */
        return ((Math.abs(alkuX - loppuX) == Math.abs(alkuY - loppuY)));
    }

    private static boolean onkoVinoPolkuVapaa(int alkuX, int alkuY, int loppuX, int loppuY) {
        /**
         * Tarkistaa onko Kuningattaren kulkemalla vinolla polulla joku nappula tiellä
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
        return ((suoraPolku(alkuX, alkuY, loppuX, loppuY) && onkoSuoraPolkuVapaa(alkuX, alkuY, loppuX, loppuY))
                ||  (vinoPolku(alkuX, alkuY, loppuX, loppuY) && onkoVinoPolkuVapaa(alkuX, alkuY, loppuX, loppuY)));
    }

}
