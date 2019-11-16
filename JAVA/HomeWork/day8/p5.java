package day8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//leetcode 414 第三大的数
public class p5 {
    public static void main(String[] args){
        int arr[] = {3,2,1};
        p5 aa = new p5();
        int ret = aa.thirdMax(arr);
        System.out.println(ret);
    }
    public int thirdMax(int[] nums) {
        Set<Integer> arr = new HashSet<>();
        for (int x : nums) {
            arr.add(x);
        }
        int arr1[] = new int[arr.size()];
        int count = 0;
        for(int x : arr) {
            arr1[count] = x;
            count++;
        }
        Arrays.sort(arr1);
        if (arr1.length >=3) {
            return arr1[2];
        }
        return arr1[0];
    }
}
