package LeetCodeDailyTask.LC202210;

import java.util.Arrays;

public class LC20221006threeEqualParts {
    // 我的解法，从来只会暴力+模拟,
    // 思想质朴，这用例限制在10^4根本不现实
    // ac 104/121 ~85%
    //    public static int[] threeEqualParts(int[] arr) {
    //        int l = 0, r = 0, n = arr.length;
    //        for (int i = 0; i < n - 2; i++) {
    //            if (arr.length > 128) {
    //                break;
    //            }
    //            long start = 0;
    //            l = i;
    //            for (int lp = l; lp >= 0; lp--) {
    //                start += arr[lp] * Math.pow(2, l - lp);
    //            }
    //            for (int j = l + 2; j < n; j++) {
    //                long mid = 0, end = 0;
    //                r = j;
    //                for (int mp = j - 1; mp >= l + 1; mp--) {
    //                    mid += arr[mp] * Math.pow(2, j - 1 - mp);
    //                }
    //                for (int ep = n - 1; ep >= j; ep--) {
    //                    end += arr[ep] * Math.pow(2, n - 1 - ep);
    //                }
    //                if (start == mid && mid == end) {
    //                    return new int[] {l, r};
    //                }
    //            }
    //        }
    //        return new int[] {-1, -1};
    //    }

    public static int[] threeEqualParts(int[] arr) {
        // 如果存在一种分法使得三个非空部分所表示的二进制值相同
        // 那么最终每一部分 1 的数量一定是相等的。
        // 根据这个思想，我们首先统计数组 arr 中 1的个数，把它设为 sum
        // 如果sum不能被3整除，则不存在正确分法

        //统计二进制数组中1的个数
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (sum == 0) {
            return new int[]{0, 2};
        }

        int partial = sum / 3;
        // first —— arr 中第 1 个 1 出现的位置
        // second —— 第 partial+1 个 1 出现的位置
        // third —— 第 2 * partial+1 个 1 出现的位置
        int first = 0, second = 0, third = 0, cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (cur == 0) {
                    first = i;
                } else if (cur == partial) {
                    second = i;
                } else if (cur == 2 * partial) {
                    third = i;
                }
                cur++;
            }
        }
        // 因为每一部分末尾的 0 可以移动到下一部分的首部从而改变二进制值的大小,所以每一部分的末尾难以界定。
        // 但是注意到，数组的末尾是无法改变的，因此区间[third, arr.length - 1]所表示的二进制值固定
        // （arr.length - 1 - third + 1）->区间长度
        // len = arr.length - third表示二进制的长度;
        // 判断[first, first +len), [second, second +len),[third, third + len)是否完全相同即可
        int len = arr.length - third;
        if (first + len <= second && second + len <= third) {
            int i = 0;
            while (third + i < arr.length) {
                if (arr[first + i] != arr[second + i] || arr[first + i] != arr[third + i]) {
                    return new int[]{-1, -1};
                }
                i++;
            }
            return new int[]{first + len - 1, second + len};
        }
        return new int[] {-1, -1};
    }
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,1,1,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,1,0,0,0,1,1,0,1,0,1,0,1,1,0,1,0,1,0,1,1,1,0,0,1,1,1,1,0,1,0,0,1,1,0,1,1,1,0,0,0,1,0,0,0,1,0,1,1,0,0,0,1,0,0,1,1,0,1,1,0,1,1,0,0,0,1,0,1,1,1,0,0,0,1,0,0,0,0,1,1,0,0,1,1,1,1,0,1,0,1,1,1,1,0,0,0,1,1,0,0,0,1,1,1,0,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,1,1,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,1,0,0,0,1,1,0,1,0,1,0,1,1,0,1,0,1,0,1,1,1,0,0,1,1,1,1,0,1,0,0,1,1,0,1,1,1,0,0,0,1,0,0,0,1,0,1,1,0,0,0,1,0,0,1,1,0,1,1,0,1,1,0,0,0,1,0,1,1,1,0,0,0,1,0,0,0,0,1,1,0,0,1,1,1,1,0,1,0,1,1,1,1,0,0,0,1,1,0,0,0,1,1,1,0,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,1,1,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,1,0,0,0,1,1,0,1,0,1,0,1,1,0,1,0,1,0,1,1,1,0,0,1,1,1,1,0,1,0,0,1,1,0,1,1,1,0,0,0,1,0,0,0,1,0,1,1,0,0,0,1,0,0,1,1,0,1,1,0,1,1,0,0,0,1,0,1,1,1,0,0,0,1,0,0,0,0,1,1,0,0,1,1,1,1,0,1,0,1,1,1,1,0,0,0,1,1,0,0,0,1,1,1,0,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(nums.length);
        int[] res = threeEqualParts(nums);
        System.out.println(Arrays.toString(res));
    }
}
