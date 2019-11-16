package day5;

import java.util.HashSet;
import java.util.Set;
//leetcode  217 存在重复元素
public class problrm4 {
//    public boolean containsDuplicate(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[i] == nums[j])
//                    return true;
//            }
//        }
//        return false;
//    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }
}
