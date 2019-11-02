package Queue;

import org.omg.CORBA.NO_IMPLEMENT;

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class LinkedQueue {
    //head队首元素
    private Node head = null;
    //tail队尾元素
    private Node tail = null;
    //size队中元素的数量
    private int size = 0;
    public static void main(String[] args){
        LinkedQueue queue = new LinkedQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        while (!queue.isEmpty()) {
            int num = queue.peek();
            System.out.print(num+" ");
            queue.poll();
        }
    }
    //1.入队
    private void offer(int val) {
        Node newNode = new Node(val);
        //尾插
        //头结点为空
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            size++;
            return;
        }
        //头结点不为空
        this.tail.next = newNode;
        this.tail = this.tail.next;
        size++;
        return;
    }
    //2.出队列，队列先进先出，删除队首元素
    private Integer poll() {
        //1.空队列，返回null
        if (this.head == null) {
            return null;
        }
        //2.不为空，返回队首元素
        Integer ret = this.head.val;
        head = head.next;
        //如果队列中只有一个元素，则tail也需要变为null
        if (head == null) {
            tail = null;
        }
        size--;
        return ret;
    }
    //3.取队首元素
    private Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
    //4.判断队列是否为空
    private boolean isEmpty() {
        return head == null;
    }
    //5.求队列中元素个数
    private int size() {
        return this.size;
    }


}

