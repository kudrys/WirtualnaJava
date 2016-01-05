import java.lang.ref.Reference;

/**
 * Created by RYchu on 2015-12-29.
 */
public class Dinozaur extends Zwierze{
    public Dinozaur() {
        sila = 20;
        inicjatywa = 10;
        label = 'D';

    }
    int kolizja(Organizm attacking)
    {
        //dinozaur ginie kiedy atakuje go zwierze o sile<2 //"po rozmiarze mnie oceniasz?"
        if(attacking.getSila()<=2)
            return 2; //dino ginie (1 0)
        else
            return whoDied(attacking);
    }

}
