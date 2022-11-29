package JavaFundamental.ThirdParty;

public class Calculator {
    public String name;

    public Calculator() {}

    public Calculator(String name) {
        this.name = name;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public String toString() {
        return name;
    }
}
