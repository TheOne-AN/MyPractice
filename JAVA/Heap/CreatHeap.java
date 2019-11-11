package Heap;

import java.util.Arrays;

public class CreatHeap {
    //大堆，向下调整建堆
    public static void shiftDown(int[] arr, int size, int index) {
        int parent = index;
        int child = index * 2 +1;
        while (child < size) {
            if (child + 1 < size && arr[child] < arr[child+1]) {
                child += 1;
            }
            if (arr[child] > arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
            }else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }
    //建堆
    public static void creat(int[] arr, int size) {
        //从最后一个父节点出发，对每个节点向下调整
        //size-1才是最后一个元素的下标
        for (int i = (size - 1 - 1) / 2; i >= 0 ; i--) {
                shiftDown(arr,size,i);
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        creat(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
