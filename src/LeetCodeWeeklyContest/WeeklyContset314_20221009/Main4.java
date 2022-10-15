package LeetCodeWeeklyContest.WeeklyContset314_20221009;

public class Main4 {
    //未做出
    // 20221015 灵神题解
    public static int numberOfPaths(int[][] grid, int k) {
        final int MOD = (int) 1e9 + 7;
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m + 1][n + 1][k];
        dp[1][1][grid[0][0] % k] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                for (int v = 0; v < k; v++) {
                    dp[i + 1][j + 1][(v + grid[i][j]) % k] =
                            (dp[i + 1][j][v] + dp[i][j + 1][v]) % MOD;
                }
            }
        }
        return dp[m][n][0];
    }

    public static void main(String[] args) {
        int[][] grid = {{5,2,4}, {3,0,5}, {0,7,2}};
        int k = 3;
        System.out.println(numberOfPaths(grid, k));
    }
}
