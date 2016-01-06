/**
 * Created by RYchu on 2016-01-05.
 */
public class Node  {
    public Organizm organizm;
    public Node next;
    //methods
    public Node(){
        next = null;
    }
    public Node(Node n){
        next = n;
    }
    public Node(Organizm o){
        organizm = o;
    }

}
