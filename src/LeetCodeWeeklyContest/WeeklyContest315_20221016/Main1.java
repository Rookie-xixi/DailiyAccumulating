package LeetCodeWeeklyContest.WeeklyContest315_20221016;

import java.util.Arrays;

public class Main1 {
    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 2) {
            return -1;
        }
        int i = 0, j = nums.length - 1;
        while (i < j && nums[i] < 0 && nums[j] > 0) {
            if (Math.abs(nums[i]) == nums[j]) {
                return nums[j];
            } else if (Math.abs(nums[i]) > nums[j]) {
                i++;
                continue;
            } else {
                j--;
                continue;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
