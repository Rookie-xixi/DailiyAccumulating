package LeetCodeDailyTask.LC202210;

import java.util.ArrayList;
import java.util.List;

public class LC20221011areAlmostEqual {
    //模拟半天，提交四次，还是没a,-> 130/131
    public static boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        List<Integer> diff = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if (diff.size() >= 2) {
                    return false;
                }
                diff.add(i);
            }
        }
        if (diff.isEmpty()) {
            return true;
        }
        if (diff.size() != 2) {
            return false;
        }
        int i = diff.get(0), j = diff.get(1);
        return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
    }

    public static void main(String[] args) {
        String s1 = "bankb";
        String s2 = "kannb";
        System.out.println(areAlmostEqual(s1, s2));
    }
}
