import java.util.Arrays;

/**
 * Created by RYchu on 2015-12-18.
 */

public class Main {

    public static void main(String[] args){
        Swiat s = new Swiat(6,6);
        s.wsadzZwierzakaDoMapy(5,1,'L');
        //s.wsadzZWartosci(0,'L');
        s.m.rysujSwiat();
        System.out.println();
        //int temp[] = s.losowanieWartosci(2);
        //System.out.println(Arrays.toString(temp));
       // System.out.println(Arrays.toString(s.losowanieCharow(2)));
        //s.wsadzWylosowaneZwierzaki();
        s.poruszenie('G',5,1);
        s.m.rysujSwiat();
    }
}
//@TODO potestowac metody