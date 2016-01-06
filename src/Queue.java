
/**
 * Created by RYchu on 2015-12-29.
 */
public class Queue {
    //fields
    Node first;
    Node aktualny;

    //methods
    public Queue() {
        first = null;
    }

    public void next() {
        aktualny = aktualny.next;
    }
    public void wypisz(){
        Node temp = first;
        while(temp!=null){
            System.out.print(temp.aktualny.getLabel() + " ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void addNode(Organizm wsadzany) {
        Node dodany = new Node(wsadzany);
        Node temp = first;
        while(temp!=null) {
            if (temp.next == null || wsadzany.getInicjatywa() > temp.aktualny.getInicjatywa()) {
                dodany.next = temp.next;
                temp.next = dodany;
                return;
            }
            temp = temp.next;
        }
        if (temp == null) {
            if(temp == first){
                first = dodany;
            }
            temp = dodany;
        }
    }

    public void deleteNode(Organizm  nodeToDelete){
        Node temp = first;
        if (temp.aktualny==nodeToDelete){
            first=first.next;
            return;
        }
        while(temp.next!=null && temp.next.aktualny!=nodeToDelete){
            temp=temp.next;
        }
        if(temp.next!=null){
            temp.next=temp.next.next;
        }
    }
    public void reset(){
        aktualny = first;
    }
}