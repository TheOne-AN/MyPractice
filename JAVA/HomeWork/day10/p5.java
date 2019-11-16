package day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//leetcode 34 在排序数组中查找元素的第一个和最后一个位置
public class p5 {
    public static void main(String[] args) {
        p5 aa = new p5();
        int[] arr = {3,3,3};
        int[] ret = aa.searchRange(arr,3);
        System.out.println(Arrays.toString(ret));
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        int[] noFind ={-1,-1};
        int count = 0;
        boolean flag = false;
        for (int i = 0;i < nums.length;i++) {
            if ( target == nums[i]) {
                flag = true;
                if (count >= ret.length) {
                    ret[count - 1] = i;
                    continue;
                }
                ret[count] = i;
                count++;
            }
        }
        if (flag) {
            if (ret[ret.length -1] == 0) {
                ret[ret.length -1] = ret[0];
                return ret;
            }
        }else {
            return noFind;
        }
        return ret;
    }
    //      Olog(n)
//    public int[] searchRange(int[] nums, int target) {
//        int left = getleft(nums,target);
//        int right = getRight(nums,target);
//        int[] ret = new int[2];
//        if (right == 0 && left!=0) {
//            ret[0] = left;
//            ret[1] = left;
//        }else {
//            ret[0] = left;
//            ret[1] = right;
//        }
//        return ret;
//    }
//    private int getleft(int[] nums, int target) {
//        if (nums.length == 0) {
//            return -1;
//        }
//        int left = 0;
//        int right = nums.length;
//        while (left < right) {
//            int mid = left+(right - left)/2;
//            if (nums[mid] == target) {
//                right = mid;
//            }else if (nums[mid] > target) {
//                right = mid;
//            }else {
//                left =  mid + 1;
//            }
//        }
//        if (nums[left] == target){
//            return left;
//        }
//        return -1;
//
//    }
//    private  int getRight(int[] nums, int target) {
//        if (nums.length == 0) {
//            return -1;
//        }
//        int left = 0;
//        int right = nums.length;
//        while (left < right) {
//            int mid = left+(right - left)/2;
//            if (nums[mid] == target) {
//                left = mid + 1;
//            }else if (nums[mid] > target) {
//                right = mid;
//            }else {
//                left =  mid + 1;
//            }
//        }
//        if (nums[left - 1] == target) {
//            return left - 1;
//        }
//        return -1;
//    }
}
