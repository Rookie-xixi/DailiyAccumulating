package LeetCodeDailyTask;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC20221015buildArray {
    public static List<String> buildArray(int[] target, int n) {
        // 搞半天，用栈模拟栈，感觉问题很大，有点脑抽
        // 看看题解
        List<String> list = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int len = target.length;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (target[i] == nums[j]) {
                if (i == 0 && j != 0) {
                  while (stack.size() != 0) {
                      list.add("Pop");
                      stack.pop();
                  }
                }
                if (i > 0 && stack.peek() != target[i - 1]) {
                    while (stack.peek() != target[i - 1]) {
                        list.add("Pop");
                        stack.pop();
                    }
                }
                list.add("Push");
                stack.push(nums[j]);
                j++;
            } else {
                list.add("Push");
                stack.push(nums[j]);
                j++;
                i--;
            }
        }
        return list;
    }
    // 三叶解法
    // https://leetcode.cn/problems/build-an-array-with-stack-operations/solution/by-ac_oier-q37s/
    public static List<String> buildArray1(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int m = target.length;
        for (int i = 1, j = 0; i <= n && j < m; i++) {
            ans.add("Push");
            if (target[j] != i) {
                ans.add("Pop");
            } else {
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] target = {2,3,4};
        int n = 4;
        List<String> list = buildArray(target, n);
        System.out.println(list.toString());
        System.out.println(buildArray1(target, n).toString());
    }
}
