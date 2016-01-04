import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by RYchu on 2015-12-18.
 */
public class Swiat {
    public Mapa m;
    public String gatunki;

    public Swiat(int x, int y){
        m = new Mapa(x,y);
        gatunki = "CDGLOTWZ"; //@TODO Zamienic jak zwierzaczki beda gotowe na to: "CDGLOTWZ"
    }

    public int getXfromValue(int value) {
        return value / m.getSzerokosc();
    }

    public int getYfromValue(int value) {
        return value % m.getWysokosc();
    }
    public void wsadzZWartosci(int value, char zwierzakAscii){
        int x = value%m.getSzerokosc();
        int y = value/m.getSzerokosc();
        System.out.println("x:" + x + " y:" + y);
        wsadzZwierzakaDoMapy(x, y, zwierzakAscii);
    }

    public void wsadzZwierzakaDoMapy(int x, int y, char zwierzakAscii) {
        Organizm organizmWsadzany;

        switch (zwierzakAscii) {
            case 'L': {
                organizmWsadzany = new Lew();
                break;
            }
            case 'W': {
                organizmWsadzany = new Wilk();
                break;
            }
            case 'C': {
                organizmWsadzany = new Ciern();
                break;
            }
            case 'D': {
                organizmWsadzany = new Dinozaur();
                break;
            }
            case 'G': {
                organizmWsadzany = new Guarana();
                break;
            }
            case 'O': {
                organizmWsadzany = new Owca();
                break;
            }
            case 'T': {
                organizmWsadzany = new Trawa();
                break;
            }
            case 'Z': {
                organizmWsadzany = new Zolw();
                break;
            }
            default:{
                organizmWsadzany = null;
            }
        }
        //kolejka.addNode(organizmWsadzany);
        m.organizmyTab[x][y] = organizmWsadzany;
        if(organizmWsadzany!=null)
            organizmWsadzany.przypiszXY(x, y);
    }
    public int[] losowanieWartosci(int dzielnik){
        Random r = new Random();
        int tabSize = m.getSzerokosc() * m.getWysokosc();
        int iloscWylosowanych = (tabSize)/dzielnik;
        int values[]=IntStream.range(0,tabSize).toArray();

        for(int i=0;i<iloscWylosowanych;i++){
            int lastIndex = tabSize-1-i;
            int randomValue = r.nextInt(lastIndex+1-i);
            //swap
            int temp = values[lastIndex];
            values[lastIndex] = values[randomValue];
            values[randomValue] = temp;
        }

        return Arrays.copyOfRange(values, tabSize-iloscWylosowanych, tabSize);
    }

    public char[] losowanieCharow(int dzielnik){
        Random r = new Random();
        char zwierzakiDoWylosowania[]=gatunki.toCharArray();
        int iloscGatunkow = zwierzakiDoWylosowania.length;
        int tabSize = m.getSzerokosc() * m.getWysokosc();
        int iloscWylosowanych = (tabSize)/dzielnik;
        char wylosowaneChary[] = new char[iloscWylosowanych];

        for (int i = 0; i < iloscWylosowanych; i++) {
            int indexWylosowany = r.nextInt(iloscGatunkow);
            wylosowaneChary[i] = zwierzakiDoWylosowania[indexWylosowany];
        }
        return wylosowaneChary;
    }

    public void wsadzWylosowaneZwierzaki(){
        int dzielnik = 5;
        int values[] = losowanieWartosci(dzielnik);
        char chary[] = losowanieCharow(dzielnik);

        for (int i = 0; i <values.length ; i++) {
            wsadzZWartosci(values[i],chary[i]);
        }
    }





}
