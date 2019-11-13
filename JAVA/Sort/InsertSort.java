package Sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args){
        int[] arr = {9,5,7,4,8,3,6,1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr) {
        //bound用来划分已排序和未排序的元素边界

        for (int bound = 1; bound < arr.length; bound++) {
            //bound下标元素就是待插入元素
            // 把这个元素放到前面的有序表中的合适位置
            int tmp = arr[bound];
            int cur = bound - 1;
            for (;cur >= 0; cur--) {
                if (arr[cur] > tmp) {
                    //将比当前值打的元素向后挪一个位置
                    arr[cur+1] = arr[cur];
                }else {
                    break;
                }
            }
            //找到当前元素的位置，插入
            arr[cur+1] = tmp;
        }
    }

}
