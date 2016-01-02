/**
 * Created by RYchu on 2015-12-18.
 */
public class Swiat {
    public Mapa m;

    public void wsadzZwierzakaDoSwiata(int x, int y, char zwierzakAscii) {
        Organizm organizmWsadzany;

        switch (zwierzakAscii) {
            case 'L': {
                organizmWsadzany = new Lew();
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
}
