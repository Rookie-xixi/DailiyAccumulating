package LeetCodeDailyTask.LC202210;

import java.util.ArrayList;
import java.util.List;

public class LC20221016possibleBipartition {
    // 二分图，图论的题
    // 官方题解: https://leetcode.cn/problems/possible-bipartition/solution/ke-neng-de-er-fen-fa-by-leetcode-solutio-guo7/
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<Integer>();
        }
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !dfs(i, 1, color, g)) {
                return false;
            }
        }
        return true;
    }

    public static boolean dfs(int curnode, int nowcolor, int[] color, List<Integer>[] g) {
        color[curnode] = nowcolor;
        for (int nextnode : g[curnode]) {
            if (color[nextnode] != 0 && color[nextnode] == color[curnode]) {
                return false;
            }
            // 这里3 ^ nowcolor 进行染色分组，0表示未分组，1表示分组1，2表示分组2
            // 在进行使用时，采用异或，3（11）异或1（01）得到2（10），3（11）异或2（10）得到1（01）
            if (color[nextnode] == 0 && !dfs(nextnode, 3 ^  nowcolor, color, g)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] dislikes = {{1,2}, {1,3}, {2,4}};
        System.out.println(possibleBipartition(n, dislikes));
    }
}
