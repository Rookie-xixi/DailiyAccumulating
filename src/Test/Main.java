package Test;

import java.util.Random;
import static java.lang.Math.*;


public class Main {

    public static void main(String[] args) {
        // 字符串对特殊字符分割的时候需要转义
//        String s = "a.b.c";
//        String[] sub = s.split("\\.");
//        for (int i = 0; i < sub.length; i++) {
//            System.out.println(sub[i]);
//        }
        var generator = new Random();
        System.out.println(generator.nextInt(1000));
        System.out.println((int) (Math.random() * 1000));
        System.out.println(sqrt(pow(4,2)));
    }
}
