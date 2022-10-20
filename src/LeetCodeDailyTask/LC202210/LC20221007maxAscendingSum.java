package LeetCodeDailyTask.LC202210;

public class LC20221007maxAscendingSum {
    public static int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int j = i, sum = nums[j];
            while (j + 1 < n && nums[j + 1] > nums[j]) {
                sum += nums[++j];
            }
            max = Math.max(max, sum);
            i = j;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10,20,30,40,50};
        System.out.println(maxAscendingSum(nums));
    }
}
