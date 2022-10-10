package LeetCodeDailyTask;

public class LCDT221010minSwap {
    //不会，看的题解
    //    https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/solution/shi-xu-lie-di-zeng-de-zui-xiao-jiao-huan-ux2y/
    // 二维数组dp
    public static int minSwap(int[] nums1, int[] nums2) {
        // 滚动数组——最优解
        int n = nums1.length;
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int at = a, bt = b;
            a = b = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                a = Math.min(a, at);
                b = Math.min(b, bt + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                a = Math.min(a, bt);
                b = Math.min(b, at + 1);
            }
        }
        return Math.min(a, b);
    }

    public static int minSwap1(int[] nums1, int[] nums2) {
        // 状态机DP——三叶题解
        // https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/solution/by-ac_oier-fjhp/
        int n = nums1.length;
        int[][] dp = new int[n][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = n;
            dp[i][1] = n;
        }
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
            }
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,4};
        int[] nums2 = {1,2,3,7};
        System.out.println(minSwap(nums1, nums2));
        System.out.println(minSwap1(nums1, nums2));
    }
}
