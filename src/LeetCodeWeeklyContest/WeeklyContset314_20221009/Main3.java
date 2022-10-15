package LeetCodeWeeklyContest.WeeklyContset314_20221009;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main3 {
    //未做出
    // 20221015看题解
    // 灵神
    // https://leetcode.cn/problems/using-a-robot-to-print-the-lexicographically-smallest-string/solution/tan-xin-zhan-by-endlesscheng-ldds/
    public static String robotWithString(String s) {
        char[] str = s.toCharArray();
        int[] cnt = new int[26];
        for (char c : str) {
            cnt[c - 'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        int min = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : str) {
            cnt[c - 'a']--;
            while (min < 25 && cnt[min] == 0) {
                min++;
            }
            stack.push(c);
            while (!stack.isEmpty() && stack.peek() - 'a' <= min) {
                sb.append(stack.poll());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "zza";
        System.out.println(robotWithString(s));
    }
}
