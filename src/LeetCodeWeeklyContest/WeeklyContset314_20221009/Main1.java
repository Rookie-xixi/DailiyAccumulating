package LeetCodeWeeklyContest.WeeklyContset314_20221009;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main1 {
    public static int hardestWorker(int n, int[][] logs) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int m = logs.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < m; i++) {
            int levaeTime = logs[i][1];
            int duration = levaeTime - stack.peek();
            map.put(i, map.getOrDefault(i, 0) + duration);
            stack.push(levaeTime);
        }
        int maxTime = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            maxTime = Math.max(maxTime, entry.getValue());
        }
        int minNumber = n;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == maxTime) {
                minNumber = Math.min(minNumber, logs[entry.getKey()][0]);
            }
        }
        return minNumber;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] logs = {{0,10}, {1,20}};
        System.out.println(hardestWorker(n, logs));
    }
}
