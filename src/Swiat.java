import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by RYchu on 2015-12-18.
 */
public class Swiat {
    public Mapa m;
    public Queue k;
    public String gatunki;

    public Swiat(int x, int y){
        m = new Mapa(x,y);
        k = new Queue();
        gatunki = "CDGLOTWZ";
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

    public void poruszenie(char kierunek, int x, int y) {
        Organizm aktualny = m.organizmyTab[x][y];
        int newX = x;
        int newY = y;
        switch(kierunek){
            case 'G':{
                newY--;
                break;
            }
            case 'D':{
                newY++;
                break;
            }
            case 'P':{
                newX++;
                break;
            }
            case 'L':{
                newX--;
                break;
            }
            default: {}
        }
        if(newX<m.getSzerokosc() && newY<m.getWysokosc() && newX>=0 && newY>=0) {
            m.organizmyTab[newX][newY] = m.organizmyTab[x][y];
            m.organizmyTab[newX][newY].przypiszXY(newX, newY);
            m.organizmyTab[x][y] = null;
        }
    }

    public int wylosujPoleDoOkola(int x, int y){
        return wylosujPole(x,y,false);
    }

    public int wylosujWolnePole(int x, int y){
        return wylosujPole(x,y,true);
    }

    public int wylosujPole(int x, int y, boolean mustBeFree){
        int TempX[] = new int[4];
        int TempY[] = new int[4];

        int kierunkiX[]={x,x+1,x,x-1};
        int kierunkiY[]={y-1,y,y+1,y};

        for(int i=0; i<4; i++){
            boolean isInWorld = kierunkiX[i]<m.getSzerokosc() && kierunkiY[i]<m.getWysokosc() && kierunkiX[i]>=0 && kierunkiY[i]>=0;
            boolean isEmpty = isInWorld ? !mustBeFree||m.organizmyTab[kierunkiY[i]][kierunkiX[i]]==null : false;
            if(isInWorld && isEmpty){
                TempX[i] = kierunkiX[i];
                TempY[i] = kierunkiY[i];
            }else{
                TempX[i] = -1;
                TempY[i] = -1;
            }
        }
        Random r = new Random();
        int indexR = r.nextInt(4);
        int value=TempX[indexR];

        if(TempX[0]==-1 && TempX[1]==-1 && TempX[2]==-1 && TempX[3]==-1){
            return -1;
        }

        while(value == -1){
            indexR = r.nextInt(4);
            value = TempX[indexR];
        }

        //cout<<"wynik: "<<TempX[r]*szerokosc+TempY[r]<<endl;
        return TempX[indexR]*m.getSzerokosc()+TempY[indexR];
    }







}
