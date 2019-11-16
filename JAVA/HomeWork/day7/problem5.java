package day7;
//leetcode 724 寻找数组的中心索引
public class problem5 {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        for (int x:nums) {
            rightSum += x;
        }
        for (int i = 0; i < nums.length; i++) {
            rightSum -=nums[i];
            if (rightSum == leftSum) {
                return i;
            }else {
                leftSum += nums[i];
            }
        }
        return -1;
    }
}
