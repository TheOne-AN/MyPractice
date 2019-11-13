package Sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args){
        int[] arr = {9,5,7,4,8,3,6,1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[] arr) {
        for (int bound = 0; bound < arr.length - 1; bound++) {
            for (int cur = bound + 1;cur < arr.length; cur++) {
                if (arr[cur] < arr[bound]) {
                    int tmp = arr[bound];
                    arr[bound] = arr[cur];
                    arr[cur] = tmp;
                }
            }
        }
    }

}
