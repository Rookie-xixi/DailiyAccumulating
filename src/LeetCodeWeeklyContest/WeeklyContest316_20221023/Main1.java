package LeetCodeWeeklyContest.WeeklyContest316_20221023;

public class Main1 {
    public static boolean haveConflict(String[] event1, String[] event2) {
        String s1 = event1[1];
        String s2 = event2[0];
        String s3 = event1[0];
        String s4 = event2[1];
        if (s2.equals(s3) && s1.equals(s4)) {
            return true;
        }
        if (haveConflict1(s1, s2)) {
            return !haveConflict1(s3, s4);
        } else {
            return false;
        }
    }
    public static boolean haveConflict1(String s1, String s2) {

        String[] num1 = s1.split(":");
        String[] num2 = s2.split(":");
        if (num1[0].equals(num2[0])) {
            char m1 = num1[1].charAt(0);
            char m2 = num2[1].charAt(0);
            if (m1 == m2) {
                char m11 = num1[1].charAt(1);
                char m22 = num2[1].charAt(1);
                return m11 >= m22;
            } else {
                return m1 >= m2;
            }
        } else {
            char h1 = num1[0].charAt(0);
            char h2 = num2[0].charAt(0);
            if (h1 == h2) {
                char h11 = num1[0].charAt(1);
                char h22 = num2[0].charAt(1);
                return h11 >= h22;
            } else {
                return h1 >= h2;
            }
        }
    }
    public static void main(String[] args) {
        String[] e1 = {"01:15","02:00"};
        String[] e2 = {"02:00","03:00"};
        System.out.println(haveConflict(e1, e2));
    }
}
