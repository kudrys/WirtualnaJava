import java.lang.ref.Reference;

/**
 * Created by RYchu on 2015-12-29.
 */
public class Guarana extends Roslina {
    public Guarana() {
        label = 'G';
        sila = 0;
        szansa = 40;
    }
    public int kolizja(Reference<Organizm>  attacking) {
        attacking.get().increaseSila(3);
        return whoDied(attacking);
    }
}
