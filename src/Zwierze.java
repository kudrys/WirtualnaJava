import java.lang.ref.Reference;

/**
 * Created by RYchu on 2015-12-29.
 */

public class Zwierze extends Organizm {
    //methods
    public Zwierze(){
        OrganizmMark ='Z';
    }

    int atak(Reference<Organizm> napotkany)
    {
        int isAlive;
        if(napotkany.get().getLabel()==this.label){
            rozmnazanie();
            isAlive = 1;
        }else{
            return napotkany.get().kolizja(this);          //@TODO Pass by Reference
        }
        return isAlive;
    }
}
