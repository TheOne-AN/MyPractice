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
    private void middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        int steps = size(head)/2;
        ListNode node = head;
        for (int i = 0; i < steps; i++) {
            node = node.next;
        }
        this.head = node;
    }
    private void FindKthToTail(ListNode head,int k) {
        if (head == null) {
            return;
        }
        int len = size(head);
        if(k <= 0 || k > len) {
           this.head = null;
            return;
        }
        int steps = len -k;
        ListNode node = head;
        for (int i = 0; i < steps;i++) {
            node = node.next;
        }
        this.head = node;
    }
    private int size(ListNode head) {
        ListNode node = head;
        int size = 0;
        for (;node!=null;node=node.next) {
            size++;
        }
        return size;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val > cur2.val) {
                newTail.next = new ListNode(cur2.val);
                newTail = newTail.next;
                cur2 = cur2.next;
            } else {
                newTail.next = new ListNode(cur1.val);
                newTail = newTail.next;
                cur1 = cur1.next;
            }
        }
        if (cur1 == null) {
            newTail.next = cur2;
        }
        if (cur2 == null) {
            newTail.next = cur1;
        }
        return newHead.next;
    }
    public void partition(ListNode pHead, int x) {
        if (pHead == null || pHead.next == null) {
            return ;
        }
        ListNode smallHead = new ListNode(0);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(0);
        ListNode bigTail = bigHead;
        ListNode prve = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val > x) {
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            } else {
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            }
            cur = cur.next;
        }
        smallTail.next = bigHead.next;
        this.head = smallHead.next;
    }
    private ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode prve = new ListNode(0);
        prve.next = pHead;
        ListNode cur = prve.next;
        ListNode node = prve;

        while (cur!= null) {
            if (cur.next!= null && cur.val == cur.next.val) {
                while (cur.next!= null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;
                node.next = cur;
            }else {
                node = node.next;
                cur = cur.next;
            }
        }
        return prve.next;
    }
    private void display() {
        ListNode node = this.head;
        for (;node!=null;node = node.next) {
            System.out.print(node.val+" ");
        }
        System.out.println();
    }
}
