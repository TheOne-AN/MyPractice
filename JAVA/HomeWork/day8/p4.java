package day8;

import java.util.Arrays;
//leetcode  66 加一
public class p4 {
    public static void main(String[] args){
        int arr[] = new int[1];
        arr[0] = 9;
        p4 aa = new p4();
        arr = aa.plusOne(arr);
        System.out.println(Arrays.toString(arr));
    }
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0 ; i--) {
            digits[i] += 1;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
