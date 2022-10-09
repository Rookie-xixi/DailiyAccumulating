package LeetCodeDailyTask;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC20221009scoreOfParentheses {
    public static int scoreOfParentheses(String s) {
        //看题解
        // 法1——栈
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                int top = st.pop() + Math.max(2 * v, 1);
                st.push(top);
            }
        }
        return st.peek();
    }

    public static int scoreOfParentheses1(String s) {
        // 法2——判断深度
        int bal = 0, n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            bal += (s.charAt(i) == '(' ? 1 : -1);
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                res += 1 << bal;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "(()(()))";
        System.out.println(scoreOfParentheses(s));
        System.out.println(scoreOfParentheses1(s));
    }
}
