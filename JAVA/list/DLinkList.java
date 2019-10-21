package list;

class DLinkNode {
    public int val = 0;
    public DLinkNode prve = null;
    public DLinkNode next = null;

    public DLinkNode(int val) {
        this.val = val;
    }
}

public class DLinkList {
    public static void main(String[] args) {
        DLinkList list = new DLinkList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.show();
        System.out.println(list.contains(2));
        list.removeOne(1);
        list.show();
        list.addFirst(2);
        list.addFirst(2);
        list.show();
        list.removeAll(2);
        list.show();
    }

    private DLinkNode head = null;

    public DLinkList() {
        head = new DLinkNode(0);
        head.next = head;
        head.prve = head;
    }

    private void addFirst(int data) {
        DLinkNode newNode = new DLinkNode(data);
        DLinkNode next = head.next;
        newNode.next = next;
        next.prve = newNode;
        head.next = newNode;
        newNode.prve = head;
    }

    private void addLast(int data) {
        DLinkNode newNode = new DLinkNode(data);
        DLinkNode prve = head.prve;
        newNode.next = head;
        prve.next = newNode;
        head.prve = newNode;
        newNode.prve = prve;
    }

    private void insertData(int index, int data) {
        int len = size();
        if(index<0 || index>len) {
            return;
        }
        if ( index == 0) {
            addFirst(data);
            return;
        }
        if (index == len) {
            addLast(data);
            return;
        }
        DLinkNode next = getPos(index);
        DLinkNode prve = next.prve;
        DLinkNode newNode = new DLinkNode(data);
        newNode.prve = prve;
        prve.next = newNode;
        next.prve = newNode;
        newNode.next = next;
    }

    private DLinkNode getPos(int index) {
        DLinkNode node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    /*判断链表中是否包含某个数*/
    private boolean contains(int key){
        for(DLinkNode node = head.next; node != head;
                node = node.next) {
            if(key == node.val) {
                return true;
            }
        }
        return false;
    }
    /*删除链表中第一次出现的这个数*/
    private void removeOne(int key) {
        DLinkNode toRmeove = searchRemove(key);
        if (toRmeove == null) {
            return;
        }
        DLinkNode prve = toRmeove.prve;
        DLinkNode next = toRmeove.next;
        prve.next = next;
        next.prve = prve;
    }
    /*找到眼删除的数的地址（引用）*/
    private DLinkNode searchRemove(int toRemove) {
        for (DLinkNode node = head.next;node!=head;
                node = node.next) {
            if(node.val == toRemove) {
                return node;
            }
        }
        return null;
    }
    private void removeAll(int key) {
        while (true) {
            DLinkNode toRmeove = searchRemove(key);
            if (toRmeove == null) {
                return;
            }
            DLinkNode prve = toRmeove.prve;
            DLinkNode next = toRmeove.next;
            prve.next = next;
            next.prve = prve;
        }
    }

    private int size() {
        int size = 0;
        for (DLinkNode Node = head.next;Node!=head;Node = Node.next) {
            size++;
        }
        return size;
    }

    private void show() {
        for (DLinkNode newNode = head.next; newNode != head;
             newNode = newNode.next) {
            System.out.print(newNode.val + " ");
        }
        System.out.println();
    }
}
