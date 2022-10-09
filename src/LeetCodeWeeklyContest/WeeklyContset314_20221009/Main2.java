package LeetCodeWeeklyContest.WeeklyContset314_20221009;

import java.util.Arrays;

public class Main2 {
    public static int[] findArray(int[] pref) {
        int n = pref.length;
        int[] res = new int[n];
        res[0] = pref[0];
        int pre = res[0];
        for (int i = 1; i < n; i++) {
            res[i] = pref[i] ^ pre;
            pre = pre ^ res[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] pref = {5,2,0,3,1};
        System.out.println(Arrays.toString(findArray(pref)));
    }
}
