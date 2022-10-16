package LeetCodeWeeklyContest.WeeklyContest315_20221016;

import java.util.Arrays;
public class Main2 {
    public static int countDistinctIntegers(int[] nums) {
        int n = nums.length;
        int[] reverseNums = new int[n];
        for (int i = 0; i < n; i++) {
            reverseNums[i] = reverseNumber(nums[i]);
        }
        int[] res = new int[n * 2];
        for (int i = 0; i < n; i++) {
            res[i] = nums[i];
            res[i + n] = reverseNums[i];
        }
        Arrays.sort(res);
        int id = 1, cnt = 1;
        while (id < 2 * n) {
            if (res[id] == res[id - 1]) {
                id++;
                continue;
            }
            cnt++;
            id++;
        }

        return cnt;
    }
    public static int reverseNumber(int n) {
//        String s = String.valueOf(n);
//        StringBuilder sb = new StringBuilder();
//        for (int i = s.length() - 1; i >= 0; i--) {
//            if (s.charAt(i) == '0') {
//                continue;
//            }
//            sb.append(s.charAt(i));
//        }
//        return Integer.parseInt(sb.toString());
        int res = 0;
        while (n > 0) {
            res = res * 10 + n % 10;
            n = n / 10;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1,13,10,12,31};
        int[] nums2 = {2};
//        System.out.println(countDistinctIntegers(nums1));
        System.out.println(countDistinctIntegers(nums2));
    }
}
