package LeetCodeBiweeklyContest.BiweeklyContest89_20221015;

public class Main3 {
    public static int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        long minMax = nums[0];
        long sumR = 0;
        for (int i = n - 1; i >= 1; i--) {
            long sum = nums[i] + nums[i - 1];
            sumR += nums[i];
            long tmpAverage;
            long allAverage;
            if (sum % 2 == 0) {
                tmpAverage = sum / 2;
            } else {
                tmpAverage = sum / 2 + 1;
            }
            if (sumR % (n - i) == 0) {
                allAverage = sumR / (n - i);
            } else {
                allAverage = sumR / (n - i) + 1;
            }
            long tmp = Math.min(allAverage, tmpAverage);
            minMax = Math.max(minMax, tmp);
        }
        return (int) minMax;
    }
    public static void main(String[] args) {
        int[] nums = {3,7,1,6};
        System.out.println(minimizeArrayValue(nums));
    }
}
