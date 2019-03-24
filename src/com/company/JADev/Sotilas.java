package com.company.JADev;

public class Sotilas extends Nappula {


    public Sotilas(boolean onValkoinen) {
        super(onkoValkoinen);
    }

    @Override
    public void piirra() {
        if(this.onValkoinen) {
            System.out.print("\u2659");
        }
        if(!(this.onValkoinen)) {
            System.out.print("\u265F");
        }
    }

    @Override
    public boolean onkoSallittu(int aX, int aY, int bX, int bY) {

        /**
         * Saa liikkua 1 eteenpäin tai aloitusruudusta
         * 2 eteenpäin tai syödä vastapuolen nappulan
         */
        if (this.onValkoinen) {
            return (((aY == bY) && aX == (bX + 1))
                    || ((aX == 6) (aY == bY) && (aX == (bX + 2)))
                    ||((aX == (bX + 1)) && (Math.abs(aY - bY) == 1)));
        }
        else {
            return (((aY == bY) && aX == (bX -1))
                    || ((aX == 1) && (aY == bY) &&(aX == (bX - 2)))
                    || ((aX == (bX - 1)) && (Math.abs(aY - bY) == 1)));
        }

    }

    @Override
    public int arvo() {
        return 1;
    }

}
