package Stack;

public class ArryStack {
    //使用数组模拟栈
    private int[] mystack = new int[100];
    private int size = 0;
    public static void main(String[] args){
        ArryStack stack = new ArryStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.isEmpty()) {
            int ret = stack.peek();
            System.out.print(ret+" ");
            stack.pop();
        }
    }
    //1.入栈
    private void push(int val) {
        mystack[size] = val;
        size++;
    }
    //2.出栈
    private Integer pop() {
        if (size == 0) {
            return null;
        }
        int ret = mystack[size-1];
        size--;
        return ret;
    }
    //3.取栈顶元素
    private Integer peek() {
        if (size == 0) {
            return null;
        }
        return mystack[size-1];
    }
    //4.判断栈是否为空
    private boolean isEmpty() {
        return size == 0;
    }
    //5.获取栈的大小
    private  int size() {
        return size;
    }
}
