package AcWingRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AC718 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double sum = 0.0D;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            int m = Integer.parseInt(s[0]);
            double dm = Double.parseDouble(String.valueOf(m));
            sum += dm;
            String c = s[1];
            map.put(c, map.getOrDefault(c, 0) + m);
        }
        int[] nums = new int[3];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            switch (entry.getKey()) {
                case "C" -> nums[0] = entry.getValue();
                case "R" -> nums[1] = entry.getValue();
                case "F" -> nums[2] = entry.getValue();
            }
        }
        int total = (int) sum;
        System.out.println("Total: " + total + " animals");
        System.out.println("Total coneys: " + nums[0]);
        System.out.println("Total rats: " + nums[1]);
        System.out.println("Total frogs: " + nums[2]);
        System.out.println("Percentage of coneys: " + String.format("%.2f", nums[0] * 100.0 / sum) + " %");
        System.out.println("Percentage of rats: " + String.format("%.2f", nums[1] * 100.0 / sum) + " %");
        System.out.println("Percentage of frogs: " + String.format("%.2f", nums[2] * 100.0 / sum) + " %");
    }
}
