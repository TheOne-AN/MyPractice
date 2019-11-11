package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/*
* 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。

定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。

找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class leetcode363 {
    static class Pair implements Comparable<Pair>{
        public int n1;
        public int n2;
        public int sum;

        public Pair(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
            this.sum = n1 + n2;
        }


        @Override
        public int compareTo(Pair o) {
            if (this.sum < o.sum) {
                return -1;
            }
            if (this.sum > o.sum) {
                return 1;
            }
            return 0;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k < 1) {
            return result;
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for (int i = 0; i < nums1.length && i < k; i++) {
            for (int j = 0; j < nums2.length && i < k; j++) {
                //将数对加入队列
                queue.offer(new Pair(nums1[i],nums2[j]));
                //保证队列中数对个数不超过k
                //超过就将最大的数对出队列
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        //循环结束queue中保存了前k小的数对
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(pair.n1);
            tmp.add(pair.n2);
            //因为队列是从大到小排序，先出前k个里面和最大的，所以每次都插到0号位置
            result.add(0,tmp);
        }
        return result;
    }
}
