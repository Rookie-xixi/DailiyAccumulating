package LeetCodeDailyTask;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LC20221008advantageCount {

    public static int[] advantageCount(int[] nums1, int[] nums2) {
        //宫水三叶题解 https://leetcode.cn/problems/advantage-shuffle/solution/by-ac_oier-i01s/
        int n = nums1.length;
        TreeSet<Integer> tset = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) == 1) {
                tset.add(x);
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            Integer cur = tset.ceiling(nums2[i] + 1);
            if (cur == null) {
                cur = tset.ceiling(- 1);
            }
            ans[i] = cur;
            map.put(cur, map.get(cur) - 1);
            if (map.get(cur) == 0) {
                tset.remove(cur);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums1 = {12,24,8,32};
        int[] nums2 = {13,25,32,11};
        int[] res = advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
