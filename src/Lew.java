import java.lang.ref.Reference;

/**
 * Created by RYchu on 2015-12-29.
 */
public class Lew extends Zwierze {

    public Lew()
    {
        label = 'L';
        sila = 11;
        inicjatywa = 7;
    }

    public int kolizja(Organizm attacking)
    {
        if(attacking.getSila()<5)
            return 3;
        else
            return whoDied(attacking);
    }
}
