package secondList;
class ListNode{
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
public class LinkList {
    ListNode head = null;
    public static void main(String[] args){
    LinkList list = new LinkList();
//    list.addFirst(3);
//    list.addFirst(2);
//    list.addFirst(1);
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    list.addLast(5);
    //    list.removeOne(2);
    list.display();
//    list.removeAll(1);
    list.reverseList(list.head);
    list.display();
    }
    private void addFirst(int val) {
        ListNode node = new ListNode(val);
        if (this.head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
        return;
    }
    private void addLast(int val) {
        ListNode node = new ListNode(val);
        if (this.head == null) {
            head = node;
            return;
        }
        ListNode cur = head;
        while (cur.next!=null) {
            cur = cur.next;
        }
         //尾插，cur.next本来就是null
        //所以不需要这一句
        //node.next = cur.next ;
        cur.next = node;
        return;
    }
    private void removeOne(int key) {
        if (this.head == null) {
            return;
        }
        if (this.head.val == key) {
            head = head.next;
            return;
        }
   //     ListNode node = this.head;
        ListNode cur = this.head;
        while (cur!=null) {
            if (cur.next.val == key) {
                break;
            }
        }
        if (cur == null) {
            return;
        }
        cur.next = cur.next.next;
    }
    private void removeAll(int key) {
        if (this.head == null) {
            return;
        }
        ListNode fast = this.head.next;
        ListNode slow = this.head;
        while (fast != null) {

            if (fast.val == key) {
                slow.next = fast.next;
                fast = fast.next;
            }else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        if (this.head.val == key) {
            this.head = this.head.next;
        }
        return;
    }
    private void reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode newHead = null;
        ListNode newTail = newHead;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                newHead = cur;
            }
            cur.next = newTail;
            newTail = cur;
            cur = next;

        }
        this.head = newHead;
     }

    private void display() {
        ListNode node = this.head;
        for (;node!=null;node = node.next) {
            System.out.print(node.val+" ");
        }
        System.out.println();
    }
}
