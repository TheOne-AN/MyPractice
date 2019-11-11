package Heap;

public class MyHeap {
    //用数组模拟队列
    private int[] arr = new int[100];
    //size表示实际元素的个数
    private int size = 0;
    public void offer(int x) {
        if (size > arr.length) {
            return;
        }
        arr[size] = x;
        size++;
        shiftUp(arr,size - 1);
    }
    //向上调整
    //复杂度O(logN)
    private void shiftUp(int[] arr,int index) {
        int child = index;
        int parent = (index - 1) / 2;
        while (child > 0) {
            if (arr[parent] < arr[child]) {
                swap(arr,parent,child);
            }else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }
    private void shiftDown(int[] arr,int size,int index) {
        int parent = index;
        int child = parent*2+1;
        while (child < size) {
            if (child+1 < size && arr[child] < arr[child+1]) {
                child = child+1;
            }
            if (arr[parent] <arr[child]) {
                swap(arr,parent,child);
            }else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }
    private void swap(int[] arr,int parent,int child) {
        int tmp = arr[parent];
        arr[parent] = arr[child];
        arr[child] = tmp;
    }
    //出堆，删除堆顶元素，用最后一个元素覆盖，然后在向下调整
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int ret = arr[0];
        arr[0] = arr[size -1];
        size--;
        shiftDown(arr,size,0);
        return ret;
    }
    //显示堆顶元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[0];
    }
}
