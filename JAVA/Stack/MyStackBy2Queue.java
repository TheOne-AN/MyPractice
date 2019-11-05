package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackBy2Queue {
    /** Push element x onto stack. */
    //A用来入栈，B用来出栈
    private LinkedList<Integer> A = new LinkedList<>();
    private LinkedList<Integer> B = new LinkedList<>();
    public void push(int x) {
        A.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //把A中元素往B中转移，知道A中只有一个元素
        //最后互换A和B
        //空栈，直接返回
        if (A.isEmpty()) {
            return 0;
        }
        while (A.size()>1) {
            int cur = A.removeFirst();
            B.addLast(cur);
        }
        //弹出最后进入队列的元素
        int ret = A.removeFirst();
        swapAB();
        return ret;
    }
    public void swapAB(){
        LinkedList<Integer> temp = new LinkedList<>();
        temp = A;
        A = B;
        B = temp;
    }

    /** Get the top element. */
    public int top() {
    //先把A中元素转移到B中，剩下一个元素，返回这个元素
        if (A.isEmpty()) {
            return 0;
        }
        while (A.size()>1) {
            int cur = A.removeFirst();
            B.addLast(cur);
        }
        int ret = A.removeFirst();
        B.addLast(ret);
        //交换AB
        swapAB();
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return A.isEmpty();
    }
}
