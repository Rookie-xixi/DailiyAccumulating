package LeetCodeDailyTask.LC202210;

public class LC20221020kthGrammar {
    // van了，越来越菜
    // 三叶大佬题解
    // https://leetcode.cn/problems/k-th-symbol-in-grammar/solution/by-ac_oier-fp2f/
    public static int kthGrammar(int n, int k) {
        return dfs(n, k, 1) == 0 ? 1 : 0;
    }

    public static int dfs(int r, int c, int cur) {
        if (r == 1) {
            return cur;
        }
        if ((c % 2 == 0 && cur == 0) ||(c % 2 == 1 && cur == 1)) {
            return dfs(r - 1, (c - 1) / 2 + 1, 1);
        } else {
            return dfs(r - 1, (c - 1) / 2 + 1, 0);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        int k = 1;
        System.out.println(kthGrammar(n, k));
    }
}
