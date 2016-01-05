import java.lang.ref.Reference;

/**
 * Created by RYchu on 2015-12-29.
 */
public class Zolw extends  Zwierze{
    public Zolw(){
        sila = 2;
        inicjatywa = 1;
        label = 'Z';
        szansa = 75;
    }
    public int kolizja(Organizm attacking) {
        if(attacking.getSila()<5)
            return 3;
        else
            return whoDied(attacking);
    }
}
