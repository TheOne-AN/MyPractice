package day1;

import java.util.Arrays;
//leetcode 189 旋转数组
public class problem5 {
    public static void main(String[] args) {
        problem5 problem5 = new problem5();
        int [] nums = {1,2,3,4,5,6,7};
        problem5.rotate(nums,3);
        System.out.println(Arrays.toString(nums));

    }
    public void rotate(int[] nums, int k) {
        if (k <= 0 ) {
            return;
        }
       int tmp;
        for (int i = 0; i < k; i++) {
            int tmp2 = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                tmp = nums[j];
                nums[j] = tmp2;
                tmp2 = tmp;
            }
        }
    }
}
