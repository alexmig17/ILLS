package test;

import java.util.List;
import java.util.Map;

public class A {

    public A(B b) {
        this.b = b;
    }

    public A(Map<String, List<String>> names) {
        System.out.println(names);
    }

    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public A() {
    }
}
