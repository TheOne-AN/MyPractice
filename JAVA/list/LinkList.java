package list;
class  LinkedNode{
    int val;
    LinkedNode next = null;

    public LinkedNode(int val) {
        this.val = val;
    }
}
public class LinkList {
    LinkedNode head = null;
    public static void main(String[] args){
        LinkList List = new LinkList();
        List.addFirst(3);
        List.addFirst(2);
        List.addFirst(1);
        List.display();
        List.addLast(1);
        List.addLast(2);
        List.addLast(3);
//        List.display();
//        List.removeOne(1);
//        List.display();
        List.removeAll(1);
        List.display();
    }
    private void addFirst(int val) {
        LinkedNode node = new LinkedNode(val);
        if (this.head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }
    private void addLast(int val) {
        LinkedNode node = new LinkedNode(val);
        if(this.head == null) {
            head = node;
            return;
        }
        LinkedNode Last = this.head;
        while (Last.next!=null) {
            Last = Last.next;
        }
        node.next = Last.next;
        Last.next = node;
        return;
    }
    private void removeOne(int key) {
        if (this.head == null) {
            return;
        }
        if (this.head.val == key) {
            this.head = head.next;
        }
        LinkedNode node = this.head;
        LinkedNode cur = null;
        while (node.next!=null){
            cur = node.next;
            if (cur.val == key) {
                break;
            }
            node = node.next;
        }
        if (cur == null) {
            return;
        }
        node.next = cur.next;
    }
    private void removeAll(int key) {
        if(head == null) {
            return;
        }
        LinkedNode first = head.next;
        LinkedNode slow = head;
        while (first!=null) {
          if (first.val == key) {
              slow.next = first.next;
              first = first.next;
          }else {
              first = first.next;
              slow = slow.next;
          }
        }
        if (this.head.val == key) {
            this.head = this.head.next;
        }
    }
    private void display() {
        for (LinkedNode node = this.head; node != null;
                node = node.next) {
            System.out.print(node.val+" ");
        }
        System.out.println();
    }
}
