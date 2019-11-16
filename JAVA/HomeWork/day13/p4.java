package day13;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

//leetcode 78 子集
public class p4 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.add(new ArrayList<Integer>());
        for (int i : nums) {
            int size = ret.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newSub = new ArrayList<Integer>(ret.get(j));
                newSub.add(i);
                ret.add(newSub);
            }
        }
        return ret;
    }
}
