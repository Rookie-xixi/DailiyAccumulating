public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "a.b.c";
        String[] sub = s.split("\\.");
        for (int i = 0; i < sub.length; i++) {
            System.out.println(sub[i]);
        }
    }
}
