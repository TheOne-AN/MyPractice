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
	 /*反转一个链表*/
    private void reverseList(LinkedNode head) {
        //如果该链表为空或者只有一个元素就返回
        if (head == null || head.next == null) {
            return;
        }
        //创建一个新链表
        LinkedNode newHead = null;
        LinkedNode newTail = newHead;
        LinkedNode node = head;
        //当链表没有元素是结束循环
        while (node != null) {
            //记录node的下一个节点
            LinkedNode next = node.next;
            if (next == null) {
                //当链表结束时，新链表的头结点为node
                newHead = node;
            }
            //反转链表
            node.next = newTail;
            newTail = node;
            node = next;
        }
        this.head = newHead;
    }
    /*合并两个链表*/
    private LinkedNode  mergeTwoLists(LinkedNode L1,LinkedNode L2) {
        //当L1或L2任意一个为空时，返回另一个链表
        if(L1 == null) {
            return L2;
        }
        if (L2 == null) {
            return L1;
        }
        //创建新链表
        LinkedNode newHead = new LinkedNode(0);
        LinkedNode newTail = newHead;
        LinkedNode cur = L1;
        LinkedNode prve = L2;
        //当两个链表有一个为空时就结束循环
        while (cur != null && prve != null) {
            if (cur.val < prve.val) {
                //尾插
                newTail.next = new LinkedNode(cur.val);
                cur = cur.next;
                newTail = newTail.next;
            }else {
                //尾插
                newTail.next = new LinkedNode(prve.val);
                prve = prve.next;
                newTail =  newTail.next;
            }
        }
        //找到未结束的链表，将其插入在新链表后面
        if (cur == null) {
            newTail.next = prve;
        }
        if (prve == null) {
            newTail.next = cur;
        }
        return newHead.next;
    }
    /*按照给定值分割链表*/
    private void partition(LinkedNode head,int key) {
        //如果链表为空或链表只有一个元素直接返回
        if (head == null || head.next == null) {
            return;
        }
        //创建小于key的数据的链表
        LinkedNode smallHead = new LinkedNode(0);
        LinkedNode smallTail = smallHead;
        //创建大于key的数据的链表
        LinkedNode bigHead = new LinkedNode(0);
        LinkedNode bigTail = bigHead;
        LinkedNode cur = head;
        //当cur为空时，结束循环
        while (cur!=null) {
            //val大于等于key时插入big链表
            if (cur.val>=key) {
                bigTail.next = new LinkedNode(cur.val);
                bigTail = bigTail.next;
            }else {
                //val小于key时插入small链表
                smallTail.next = new LinkedNode(cur.val);
                smallTail = smallTail.next;
            }
            cur = cur.next;
        }
        smallTail.next = bigHead.next;
        this.head = smallHead.next;
    }
	/*删除一个已排序链表中所有重复元素*/
    //将不重复元素插入到新链表
    private void deleteDuplication(LinkedNode head) {
        //如果这个链表为空或者只有一个元素直接返回
        if(head == null && head.next == null) {
            return;
        }
        //创建新链表存放不重复元素
        LinkedNode newHead = new LinkedNode(0);
        LinkedNode newTail = newHead;
        LinkedNode cur = head;
        while ( cur != null) {
            //记录下一个节点地址
            LinkedNode next = cur.next;
            //当下个节点不为空且当前节点的值与下个节点的值相同
            if (cur.next != null && cur.val == cur.next.val) {
                //跳过所有节点值相同的结点
                while(cur.next!=null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                //在走一步，该节点值才与当前节点值不同
                cur = cur.next;
            }else { //如果下个节点值与当前节点值不相同，直接将当前节点插入新链表
                newTail.next = cur;
                cur.next = null;
                newTail = newTail.next;
                cur = next;
            }
        }
        this.head = newHead.next;
    }
    /*删除一个已排序链表中所有重复元素*/
    //在原链表上改变
    private void newDeleteDuplication(LinkedNode head) {
        //如果这个链表为空或者只有一个元素直接返回
        if (head == null || head.next == null) {
            return;
        }
        //创建新链表
        LinkedNode newHead = new LinkedNode(0);
        //将原链表接在新链表后面
        newHead.next = head;
        //通过prve和cur遍历新链表
        LinkedNode prve = newHead;
        LinkedNode cur = prve.next;
        while (cur != null) {
            //当下个节点不为空且当前节点的值与下个节点的值相同
            if (cur.next != null && cur.val == cur.next.val) {
                //跳过所有节点值相同的结点
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                //直接改变链表的指向，跳过重复元素
                prve.next = cur.next;
                cur = cur.next;
            } else {
                //节点值不同，遍历
                prve = prve.next;
                cur = cur.next;
            }
        }
        this.head = newHead.next;
    }
    private void display() {
        for (LinkedNode node = this.head; node != null;
                node = node.next) {
            System.out.print(node.val+" ");
        }
        System.out.println();
    }
}
