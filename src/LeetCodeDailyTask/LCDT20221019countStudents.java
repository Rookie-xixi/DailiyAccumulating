package LeetCodeDailyTask;

import java.util.Arrays;

public class LCDT20221019countStudents {
    // 看题解
    // 学会用stream方法技术
    // https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/solution/wu-fa-chi-wu-can-de-xue-sheng-shu-liang-fv3f5/
    public static int countStudents(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();
        int s0 = students.length - s1;
        for (int i = 0; i < sandwiches.length;  i++) {
            if (sandwiches[i] == 0 && s0 > 0) {
                s0--;
            } else if (sandwiches[i] == 1 && s1 > 0) {
                s1--;
            } else {
              break;
            }
        }
        return s0 + s1;
    }

    public static void main(String[] args) {
        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        System.out.println(countStudents(students, sandwiches));
    }
}
