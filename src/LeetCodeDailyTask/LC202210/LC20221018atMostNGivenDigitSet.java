package LeetCodeDailyTask.LC202210;

import java.util.Arrays;

public class LC20221018atMostNGivenDigitSet {
    // 完全不会，抄的灵神答案
    // https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/solution/shu-wei-dp-tong-yong-mo-ban-xiang-xi-zhu-e5dg/
    static String[] digits;
    static char[] s;
    static int[] dp;
    public static int atMostNGivenDigitSet(String[] digits, int n) {
        LC20221018atMostNGivenDigitSet.digits = digits;
        s = Integer.toString(n).toCharArray();
        dp = new int[s.length];
        // dp[i] = -1 表示 i 这个状态还没被计算出来
        Arrays.fill(dp, -1);
        return f(0, true, false);
    }
    public static int f(int i, boolean isLimit, boolean isNum) {
        // 如果填了数字，则为 1 种合法方案
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        // 在不受到任何约束的情况下，返回记录的结果，避免重复运算
        if (!isLimit && isNum &&dp[i] >= 0) {
            return dp[i];
        }
        int res = 0;
        // 前面不填数字，那么可以跳过当前数位，也不填数字
        // isLimit 改为 false，因为没有填数字，位数都比 n 要短，自然不会受到 n 的约束
        // isNum 仍然为 false，因为没有填任何数字
        if (!isNum) {
            res = f(i + 1, false, false);
        }
        // 根据是否受到约束，决定可以填的数字的上限
        int up = isLimit ? s[i] : '9';
        // 注意：对于一般的题目而言，如果此时 isNum 为 false，则必须从 1 开始枚举，由于本题 digits 没有 0，所以无需处理这种情况
        for (String d : digits) {
            // d 超过上限，由于 digits 是有序的，后面的 d 都会超过上限，故退出循环
            if (d.charAt(0) > up) {
                break;
            }
            // isLimit：如果当前受到 n 的约束，且填的数字等于上限，那么后面仍然会受到 n 的约束
            // isNum 为 true，因为填了数字
            res += f(i + 1, isLimit && d.charAt(0) == up, true);
        }
        // 在不受到任何约束的情况下，记录结果
        if (isLimit && isNum) {
            dp[i] = res;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] digits = {"1","4","9"};
        int n = 1000000000;
        System.out.println(atMostNGivenDigitSet(digits, n));
    }
}
