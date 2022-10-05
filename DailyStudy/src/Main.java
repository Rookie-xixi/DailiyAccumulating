public class Main {

    public static void main(String[] args) {
        // 字符串对特殊字符分割的时候需要转义
        String s = "a.b.c";
        String[] sub = s.split("\\.");
        for (int i = 0; i < sub.length; i++) {
            System.out.println(sub[i]);
        }
    }
}
