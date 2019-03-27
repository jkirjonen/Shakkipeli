package com.company.JADev;

public class Sotilas extends Nappula {


    public Sotilas(boolean onValkoinen) {
        super(onValkoinen);
    }

    @Override
    public void piirra() {
        if(this.onValkoinen) {
            System.out.print("\u2659");
        }
        else {
            System.out.print("\u265F");
        }
    }

    @Override
    public boolean onkoSallittu(int alkuX, int alkuY, int loppuX, int loppuY) {
        /**
         * Saa liikkua 1 eteenpäin tai aloitusruudusta
         * 2 eteenpäin tai syödä vastapuolen nappulan
         */
        if (this.onValkoinen) {
            return (((alkuY == loppuY) && alkuX == (loppuX + 1))
                    || ((alkuX == 6) && (alkuY == loppuY) && (alkuX == (loppuX + 2)))
                    ||((alkuX == (loppuX + 1)) && (Math.abs(alkuY - loppuY) == 1)));
        }
        else {
            return (((alkuY == loppuY) && alkuX == (loppuX -1))
                    || ((alkuX == 1) && (alkuY == loppuY) &&(alkuX == (loppuX - 2)))
                    || ((alkuX == (loppuX - 1)) && (Math.abs(alkuY - loppuY) == 1)));
        }

    }

}
