package LeetCodeDailyTask.LC202210;

import java.util.ArrayList;
import java.util.List;

public class LC20221021StockSpanner {

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
