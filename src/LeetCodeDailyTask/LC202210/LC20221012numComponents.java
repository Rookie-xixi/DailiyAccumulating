package LeetCodeDailyTask.LC202210;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ListNode{
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class LC20221012numComponents {

    public static int numComponents(ListNode head, int[] nums) {
        ListNode cur = head;
        List<Integer> list = new ArrayList<Integer>();
        while (cur != null) {
           list.add(cur.val);
           cur = cur.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        // 滑窗法求最大连续子数组长度
        int i = 0, j = 0, res = 0, n = arr.length;
        while (j < n) {
            if ( set.contains(arr[j])) {
                while (j < n && set.contains(arr[j++])) {}
                res++;
            } else {
                j++;
            }
        }
        return res;
    }
    public static int numComponents1(ListNode head, int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        while (head != null) {
            if (set.contains(head.val)) {
                while (head != null && set.contains(head.val)) head = head.next;
                ans++;
            } else {
                head = head.next;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] head = {0,1,2,3,4};
        int[] nums = {0,3,1};
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int n = head.length;
        for (int i = 0; i < n; i++) {
            cur.next = new ListNode(head[i]);
            cur = cur.next;
        }
        cur.next = null;
        ListNode newHead = dummy.next;
        int res = numComponents(newHead, nums);
        System.out.println(res);
        System.out.println(numComponents1(newHead, nums));
    }
}
