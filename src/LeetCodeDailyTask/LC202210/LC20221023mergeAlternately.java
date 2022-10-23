package LeetCodeDailyTask.LC202210;

public class LC20221023mergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n1 = word1.length();
        int n2 = word2.length();
        int k = 0;
        while (k < Math.min(n1, n2)) {
            sb.append(word1.charAt(k));
            sb.append(word2.charAt(k));
            k++;
        }
        if (k == n1) {
            while (k < n2) {
                sb.append(word2.charAt(k));
                k++;
            }
        } else {
            while (k < n1) {
                sb.append(word1.charAt(k));
                k++;
            }
        }
        return sb.toString();
    }
}
