import java.lang.ref.Reference;

/**
 * Created by RYchu on 2015-12-29.
 */
public class Mapa {
    //fields
    protected int szerokosc;
    protected int wysokosc;
    Organizm [][] organizmyTab;
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
        organizmyTab = new Organizm [szerokosc][wysokosc];  //@TODO array
    }
    public void rysujSwiat(){
        for(int i=0;i<wysokosc;i++){
            for(int j=0;j<szerokosc;j++){
                if(organizmyTab[i][j]==null){
                    System.out.print("*");
                }else{
                    System.out.print(organizmyTab[i][j].getLabel());
                }
            }
            System.out.println();
        }
    }
}