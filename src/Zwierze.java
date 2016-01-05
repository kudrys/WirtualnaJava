import java.lang.ref.Reference;

/**
 * Created by RYchu on 2015-12-29.
 */

public class Zwierze extends Organizm {
    //methods
    public Zwierze(){
        OrganizmMark ='Z';
    }

    int atak(Organizm napotkany)
    {
        int isAlive = 0;
        if(napotkany.getLabel()==this.label){
            rozmnazanie();
            isAlive = 1;
        }else{
            return napotkany.kolizja(this);
        }
        return isAlive;
    }
}
