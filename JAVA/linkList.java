
class linkNode{
    public  int data = 0;
    public  linkNode  next = null;
}
public class linkList {
    //创建一个头结点，
    // head是一个引用，存地址
    private linkNode head = null;
    //头插法
    public void addFirst(int num){
        //new 一个 linkNode的对象，
        // 它具有data和next两个属性
        //data存值，next存放下一个值得地址
        linkNode node = new linkNode();
        //这个对象的data赋值num
        node.data = num;
        //如果链表的头结点为空，
        // 则让他指向刚创建的对象node
        if(this.head == null){
            this.head = node;
            return;
        }
        //如果头结点不为空，头插则需要将head的地址给node.next
        node.next = head;
        this.head = node;
    }
    public void addLast(int num){
        linkNode node = new linkNode();
        node.data = num;
        if(this.head == null){
            this.head = node;
            return;
        }
        linkNode cur = new linkNode();
        cur = this.head;
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = node;
    }
    public void addIndex(int index,int data){
        linkNode node = new linkNode();
        node.data = data;
        int len =listSize();
        if (index < 0 || index > len){
            return;
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == len){
            addLast(data);
            return;
        }
        linkNode linkNode =search(index);
        node.next = linkNode.next;
        linkNode.next = node;
    }
    private int listSize(){
        linkNode node = new linkNode();
        node = head;
        int len = 0;
        for(;node.next!=null;node = node.next){
            len++;
        }
        return len;
    }
    private linkNode search(int index){
        linkNode linkNode = new linkNode();
        linkNode = this.head;
        for (int i = 0; i < index; i++) {
            linkNode = linkNode.next;
        }
        return linkNode;
    }
    public boolean contains(int key){
        linkNode node = new linkNode();
        node = this.head;
        if (node == null){
            return false;
        }
        for (; node != null;node = node.next){
            if (node.data == key){
                return true;
            }
        }
        return false;
    }
    public void remove(int key){
        linkNode node = new linkNode();
        node = this.head;
        if (node == null){
            return;
        }
        if(head.data == key){
            this .head = this.head.next;
            return;
        }
        linkNode remove =searchToRemove(key);
        if (remove == null){
            return;
        }
        node = remove.next;
        remove.next = node.next;

    }
    private linkNode searchToRemove(int toRemove){
        linkNode node = new linkNode();
        if (this.head == null){
            return null;
        }
        node = this.head;
        while (node.next != null){
            if (node.next.data == toRemove){
                return node;
            }
            node = node.next;
        }
        return null;
    }


    public void show(){
        linkNode node = new linkNode();
        System.out.print("[");
        for (node = this.head;node != null;node = node.next){
            System.out.print(node.data);
            if(node.next != null){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
