package day2;
//leetcode 35 搜索插入位置
public class problem5 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
                continue;
            }
            if (nums[mid] < target) {
                left = mid + 1;
                continue;
            }
        }
        return left;
    }
}
