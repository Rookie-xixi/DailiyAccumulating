package LeetCodeDailyTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainCount20221005 {
    /**
    public static List<String> subdomainVisits(String[] cpdomains) {
        //自己的写法
        HashMap<String, Integer> map = new HashMap<>();
        int n = cpdomains.length;
        for (int i = 0; i < n; i++) {
            String[] countDomain = cpdomains[i].split(" ");
            int count = Integer.parseInt(countDomain[0]);
            String domain = countDomain[1];
            String[] allDomain = domain.split("\\.");
            int len = allDomain.length;
            for (int j = len - 1; j >= 0; j--) {
                StringBuilder sb = new StringBuilder();
                for (int k = j; k < len; k++) {
                    sb.append(allDomain[k]);
                    sb.append(".");
                }
                String sub = sb.toString();
                String subDomain = sub.substring(0, sub.length() - 1);
                map.put(subDomain, map.getOrDefault(subDomain, 0) + count);
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String tmp = entry.getValue() + " " + entry.getKey();
            list.add(tmp);
        }
        return list;
    }
    */
    // beats 100%的解法，思路其实一样
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> m = new HashMap();
        for (String s : cpdomains) {
            String[] t1 = s.split(" ");
            int cnt = Integer.valueOf(t1[0]), idx = -1;
            String domain = t1[1];
            do {
                domain = domain.substring(idx + 1);
                m.put(domain, m.getOrDefault(domain, 0) + cnt);
                idx = domain.indexOf(".");
            } while (idx != -1);
        }
        List<String> r = new ArrayList();
        for (String key : m.keySet())
            r.add(new StringBuilder().append(m.get(key)).append(' ').append(key).toString());
        return r;
    }

    public static void main(String[] args) {
        String[] input = {"9001 discuss.leetcode.com"};
        List<String> output = subdomainVisits(input);
        System.out.println(output.toString());
    }
}
