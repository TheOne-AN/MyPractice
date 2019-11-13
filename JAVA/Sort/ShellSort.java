package Sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args){
        int[] arr = {9,5,7,4,8,3,6,1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            gap /= 2;
            insertSortGap(arr,gap);
        }
        insertSortGap(arr,1);
    }
    private static void insertSortGap(int[] arr,int gap) {
        for (int bound = 1;bound < arr.length;bound++) {
            int tmp = arr[bound];
            int cur = bound - gap;
            for (; cur >= 0; cur -= gap) {
                if (arr[cur] > tmp) {
                    arr[cur+gap] = arr[cur];
                }else {
                    break;
                }
            }
            arr[cur+gap] = tmp;
        }
    }
}
