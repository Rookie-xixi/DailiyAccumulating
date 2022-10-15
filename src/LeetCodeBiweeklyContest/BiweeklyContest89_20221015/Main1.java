package LeetCodeBiweeklyContest.BiweeklyContest89_20221015;

public class Main1 {
    public static int countTime(String time) {
        char h0 = time.charAt(0), h1 = time.charAt(1);
        char m0 = time.charAt(3), m1 = time.charAt(4);
        int valid = 1;
        // 判断时
        if (h0 == '?') {
            if (h1 == '?') {
                valid *= 24;
            } else {
                if (h1 <= '3') {
                    valid *= 3;
                } else {
                    valid *= 2;
                }
            }
        } else {
            if (h1 == '?') {
                if (h0 <= '1') {
                    valid *= 10;
                } else {
                    valid *= 4;
                }
            }
        }
        // 判断分
        if (m0 == '?') {
            if (m1 == '?') {
                valid *= 60;
            } else {
                valid *= 6;
            }
        } else {
            if (m1 == '?') {
                valid *= 10;
            }
        }
        return valid;
    }

    public static void main(String[] args) {

    }
}
