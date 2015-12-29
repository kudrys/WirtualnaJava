import java.lang.ref.Reference;

/**
 * Created by RYchu on 2015-12-29.
 */
public class Mapa {
    //fields
    protected int szerokosc;
    protected int wysokosc;
    Reference<Organizm> [][] organizmyTab;
    //getters
    public int getSzerokosc() {
        return szerokosc;
    }
    public int getWysokosc() {
        return wysokosc;
    }
    //methods
    public Mapa(int szerokosc, int wysokosc){
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        //organizmyTab = new Reference<Organizm> [szerokosc][wysokosc];  //@TODO array
    }
}