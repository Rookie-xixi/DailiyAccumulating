package LeetCodeWeeklyContest.WeeklyContest315_20221016;

public class Main3 {
    public boolean sumOfNumberAndReverse(int num) {
        if (num == 0) {
            return true;
        }
        for (int i = 1; i <= num; i++) {
            int reverseNum = reverseNumber(i);
            if (i + reverseNum == num) {
                return true;
            }
        }
        return false;
    }
    public static int reverseNumber(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }
}
