package day4;

import java.util.Arrays;
//leetcode  88 合并两个有序数组
public class problem5 {
    public static void main(String[] args){
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        merge(arr1,3,arr2,3);
        System.out.println(Arrays.toString(arr1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while ((i >= 0) && (j >= 0)) {
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            }else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }
        System.arraycopy(nums2,0,nums1,0,j+1);
    }
}
