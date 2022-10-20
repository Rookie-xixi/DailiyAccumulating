package LeetCodeDailyTask.LC202210;

import java.util.Arrays;

public class LC20221014distinctSubseqII {
    // 不会，看灵神的题解，有些API还不太理解
    // https://leetcode.cn/problems/distinct-subsequences-ii/solution/xi-fen-wen-ti-fu-za-du-you-hua-pythonjav-1ihu/
    public static final long MOD = (long) 1e9 + 7;
    public static int distinctSubseqII(String s) {
        var n = s.length();
        var f = new long[n][26];
        f[0][s.charAt(0) - 'a'] = 1;
        for (var i = 1; i < n; i++) {
            f[i] = f[i - 1].clone();
            f[i][s.charAt(i) - 'a'] = (1 + Arrays.stream(f[i - 1]).sum()) % MOD;
        }
        return (int) (Arrays.stream(f[n - 1]).sum() % MOD);
    }
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(distinctSubseqII(s));
    }
}
