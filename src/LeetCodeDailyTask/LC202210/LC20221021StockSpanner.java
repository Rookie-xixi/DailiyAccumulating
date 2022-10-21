package LeetCodeDailyTask.LC202210;

import java.util.ArrayList;
import java.util.List;

public class LC20221021StockSpanner {
    // 单调栈
    // 三叶解法
    // https://leetcode.cn/problems/online-stock-span/solution/by-ac_oier-m8g7/
    Deque<int[]> d = new ArrayDeque<>();
    int cur = 0;
    public int next(int price) {
        while (!d.isEmpty() && d.peekLast()[1] <= price) {
            d.pollLast();
        }
        int prev = d.isEmpty() ? -1 : d.peekLast()[0], ans = cur - prev;
        d.addLast(new int[]{cur++, price});
        return ans;
    }

    // 暴力解法，自己写出的
    class StockSpanner {
        List<Integer> list;
        public StockSpanner() {
            list = new ArrayList<>();
        }

        public int next(int price) {
            list.add(price);
            int n = list.size();
            int max = 0, end = n - 1;
            for (int start = n - 1; start >= 0; start--) {
                if (list.get(start) <= price) {
                    max = Math.max(max, end - start + 1);
                } else {
                    break;
                }
            }
            return max;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
