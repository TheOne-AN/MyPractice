package day6;

import java.util.Arrays;
//leetcode 977 有序数组的平方
public class problem4 {
    public static void main(String[] args){
        int a[] ={-4,-1,0,3,10};
        problem4 pl = new problem4();
        System.out.println(Arrays.toString(pl.sortedSquares(a)));
    }
    public int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = (int)Math.pow(A[i],2);
        }
        Arrays.sort(B);
        return B;
    }
}
