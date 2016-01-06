import java.lang.ref.Reference;
import java.util.Random;

/**
 * Created by RYchu on 2015-12-29.
 */
public class Organizm {

    //getters
    public boolean isActive() {
        return active;
    }

    public char getLabel() {
        return label;
    }

    public char getOrganizmMark() {
        return OrganizmMark;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSila() {
        return sila;
    }

    public int getInicjatywa() {
        return inicjatywa;
    }

    public int getSzansa() {
        return szansa;
    }
    //fields
    protected boolean active;
    protected char label;
    protected String obrazek;
    protected char OrganizmMark;
    protected int x;
    protected int y;
    protected int sila;
    protected int inicjatywa;
    protected int szansa;
    //methods
    public Organizm(){
        szansa = 100;
        active = false;
    }
    void przypiszXY(int x, int y){
        this.x=x;
        this.y=y;
    }
    boolean szansaNaSukces(){
        Random r = new Random();
        int wylosowanaLiczba = r.nextInt(100);
        return (wylosowanaLiczba<=szansa);
    }
    /** whoDied:
     *  2 - def zyje (10)
     *  1 - att zyje (01)
     *  3 - obydwoje zyja (11)
     */
    int whoDied(Organizm attacking){
        int defAlive = 1;
        int attAlive = 1;
        if (this.sila <= attacking.getSila()){
            defAlive = 0;
        }else{
            attAlive = 0;
        }
        return defAlive*2+attAlive;
    }
    int kolizja(Organizm attacking){
        return whoDied(attacking);
    }
    void increaseSila(int v){
        this.sila += v;
    }
    void activate(){
        active = true;
    }
    void rozmnazanie(){
    }
    /** akcja:
     * flag 1 - organizm to roslina
     * flag 2 - napotkany to NULL
     * flag 3 - te same organizmy, rozmnazanie
     * flag 4 - kolizja
     * flag 0 - nic sie nie dzieje
     */
    int akcja(Organizm napotkany){
        if(szansaNaSukces()){
            if(this.OrganizmMark=='R'){
                return 1;
            }
            if(napotkany==null){
                return 2;
            }
            if (getLabel() == napotkany.getLabel()) {
                return 3;
            }
            return 4;
        }
        return 0;
    }
}

