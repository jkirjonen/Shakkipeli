package com.company.JADev;

public abstract class Nappula {

    boolean onValkoinen;

    /**
     * Jos nappula on valkoinen, aseta true, jos musta, aseta false
     * @param onValkoinen
     */
    public Nappula(boolean onValkoinen) {
        this.onValkoinen = onValkoinen;
    }

    /**
     * @return true, jos valkoinen, muuten false
     */
    public boolean onValkoinen() {
        return onValkoinen;
    }

    /**
     * Piirtää annetun nappulan konsoliin
     */
    public abstract void piirra();

    /**
     * Tarkistaa onko siirto sallitu
     * @return true, jos siirto on sallittu, false ei sallittu siirto
     */
    public abstract boolean onkoSallittu(int alkuX, int alkuY, int loppuX, int loppuY);

    /**
     *
     * @return palauttaa "piirros" merkin tallennusta ja latausta varten
     */

    public abstract String annaMerkki();



}
