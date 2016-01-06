
/**
 * Created by RYchu on 2015-12-29.
 */
public class Queue {
    //fields
    Node first;
    Node aktualnyNode;

    //methods
    public Queue() {
        first = null;
    }

    public void next() {
        aktualnyNode = aktualnyNode.next;
    }
    public void wypisz(){
        Node temp = first;
        while(temp!=null){
            System.out.print(temp.organizm.getLabel() + " ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void addNode(Organizm wsadzany) {
        Node dodany = new Node(wsadzany);
        Node temp = first;
        System.out.print(wsadzany.getLabel());
        if(temp == null || dodany.organizm.getInicjatywa()>temp.organizm.getInicjatywa()){
            dodany.next = first;
            first = dodany;
        } else {
            while (true) {
                if (temp.next == null || wsadzany.getInicjatywa() > temp.next.organizm.getInicjatywa()) {
                    dodany.next = temp.next;
                    temp.next = dodany;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void deleteNode(Organizm  nodeToDelete){
        Node temp = first;
        if (temp.organizm ==nodeToDelete){
            first=first.next;
            return;
        }
        while(temp.next!=null && temp.next.organizm !=nodeToDelete){
            temp=temp.next;
        }
        if(temp.next!=null){
            temp.next=temp.next.next;
        }
    }
    public void reset(){
        aktualnyNode = first;
    }
}