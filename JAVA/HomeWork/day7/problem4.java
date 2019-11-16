package day7;

import java.util.Arrays;
//leetcode 905 按奇偶排序数组
public class problem4 {
    public static void main(String[] args){
        int[] arr = {3,1,2,4};
        problem4 pl = new problem4();
        int[] ret = pl.sortArrayByParity(arr);
        System.out.println(Arrays.toString(ret));
    }
    public int[] sortArrayByParity(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            while (A[start] %2 ==0 && start < end ) {
                start++;
            }
            while (A[end] %2 !=0 && start < end) {
                end--;
            }
            int tmp = A[start];
            A[start] = A[end];
            A[end] = tmp;
        }
        return A;
    }
}

