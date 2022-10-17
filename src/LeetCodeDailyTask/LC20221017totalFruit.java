package LeetCodeDailyTask;

import java.util.HashMap;

public class LC20221017totalFruit {
    // 搞半天还是错的，看题解
    // https://leetcode.cn/problems/fruit-into-baskets/solution/shui-guo-cheng-lan-by-leetcode-solution-1uyu/
    public static int totalFruit(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int l = 0, ans = 0;
        for (int r = 0; r < n; r++) {
            cnt.put(nums[r], cnt.getOrDefault(nums[r], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(nums[l], cnt.get(nums[l]) - 1);
                if (cnt.get(nums[l]) == 0) {
                    cnt.remove(nums[l]);
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(nums));
    }
}
