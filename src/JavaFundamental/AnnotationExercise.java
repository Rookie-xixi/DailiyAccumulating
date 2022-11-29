package JavaFundamental;

import java.util.LinkedList;

class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String getString() {
        return String.format("(%d, %d)", x, y);
    }
}

@SuppressWarnings("all")
@Deprecated
class ColorPoint extends Point {
    private String color;
    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    @Override // 只能用于函数
    public String getString() {
        return String.format("(%d, %d, %s)", super.x, super.y, color);
    }
}

public class AnnotationExercise {
    public static void main(String[] args) {

    }
}
