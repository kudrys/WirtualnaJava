/**
 * Created by RYchu on 2016-01-05.
 */
public class Node  {
    public Organizm aktualny;
    public Node next;
    //methods
    public Node(){
        next = null;
    }
    public Node(Node n){
        next = n;
    }
    public Node(Organizm o){
        aktualny = o;
    }

}
