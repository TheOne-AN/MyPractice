package Queue;

public class ArryQueue {
    private int[] data = new int [100];
    //[head,tail) 前闭后开
    private int head = 0;//队首元素下标
    private int tail = 0;//队尾元素下标
    private int size = 0;//当前队列元素个数
    //1.入队列，入队成功返回true,失败 返回false
    private boolean offer(int val) {
        if (size == data.length) {
            return false;
        }
        //新元素放在tail位置
        data[tail] = val;
        tail++;
        if (tail == data.length) {
            tail = 0;
        }
        size++;
        return true;
    }
    //2.出队列
    private Integer poll() {
        if (size == 0){
            return null;
        }
        Integer ret = data[head];
        head++;
        if (head == data.length) {
            head = 0;
        }
        size--;
        return  ret;
    }
    //3.取队首元素
    private Integer peek() {
        if (size == 0) {
            return null;
        }
        return data[head];
    }
    //4.判断队列是否为空
    private boolean isEmpty() {
        return size == 0;
    }
    //5.求队列的长度
    private int size() {
        return size;
    }
    public static void main(String[] args){
        ArryQueue queue = new ArryQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        while (!queue.isEmpty()) {
            int ret = queue.peek();
            System.out.print(ret+" ");
            queue.poll();
        }
    }
}
