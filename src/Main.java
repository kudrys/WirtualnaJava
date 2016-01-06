import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by RYchu on 2015-12-18.
 */

public class Main {
    public static void test1(){
        Swiat s = new Swiat(5,5);
        //nowy.losowanieXY();
        s.wsadzZWartosci(1,'W');
        s.k.wypisz();
        s.wsadzZWartosci(6,'L');
        s.wsadzZWartosci(11,'T');
        s.wsadzZWartosci(16,'Z');
        s.wsadzZWartosci(7,'L');
        s.wsadzZWartosci(12, 'C');
        System.out.println();
        System.out.println("----WYNIK---");
        s.m.rysujSwiat();
        s.k.wypisz();
        for(int i=0;i<10;i++){
            s.runda();
            System.out.println( "---------------");
            s.k.wypisz();
            //s.m.rysujSwiat();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PointsEx point = new PointsEx();
        point.main2(args);
        test1();
        //runApp();
    }

    private static void runApp() {
        System.out.println("RYSZARD KUDUK 143271");
        System.out.println("podaj x:");
        Scanner scanX = new Scanner(System.in);
        int x = scanX.nextInt();
        System.out.println("podaj y:");
        Scanner scanY = new Scanner(System.in);
        int y = scanY.nextInt();

        Swiat s = new Swiat(x,y);
        s.wsadzWylosowaneZwierzaki();
        System.out.println();
        s.k.wypisz();
        for(int i=0;i<10;i++){
            s.runda();
            System.out.println("-----------NOWA--RUNDA---------");
        }
    }
}
//@TODO potestowac metody