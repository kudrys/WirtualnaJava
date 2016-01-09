import java.lang.ref.Reference;

/**
 * Created by RYchu on 2015-12-29.
 */
public class Guarana extends Roslina {
    public Guarana() {
        label = 'G';
        sila = 0;
        szansa = 20;
    }
    public int kolizja(Organizm attacking) {
        attacking.increaseSila(3);
        return whoDied(attacking);
    }
}
