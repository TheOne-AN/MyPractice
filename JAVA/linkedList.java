class linkedNode{
    int data = 0;
    linkedNode next = null;
}
public class linkedList {

    linkedNode head =null;
    public void addFnum(int num){
        linkedNode node = new linkedNode();
        node.data = num;
        if (this.head == null){
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }
    public void lastAdd(int num){
        linkedNode Node = new linkedNode();
        Node.data = num;
        if (this.head == null){
            head = Node;
            return;
        }
        linkedNode sea = new linkedNode();
        sea = this.head;
        while (sea.next != null){
            sea = sea.next;
        }
        sea.next = Node;
    }
    public void display(){
        if (this.head == null){
            return;
        }
        linkedNode node = new linkedNode();
        node = this.head;
        for (;node!=null;node = node.next){
            System.out.print(node.data);
        }
    }
}
