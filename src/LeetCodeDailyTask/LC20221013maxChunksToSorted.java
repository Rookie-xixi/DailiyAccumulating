package LeetCodeDailyTask;

import java.util.Arrays;

public class LC20221013maxChunksToSorted {
    public static int maxChunksToSorted(int[] arr) {
        // 看题解的
        /**
         4,3,2,1,0 排序成后为
         0,1,2,3,4

         1,0,2,3,4 排序成后为
         0,1,2,3,4

         前缀和
         */

        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int sum = 0, sortedSum = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            sortedSum += sorted[i];
            if (sum == sortedSum) {
                count++;
                sum = 0;
                sortedSum = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,1,0};
        System.out.println(maxChunksToSorted(arr));
    }
}
