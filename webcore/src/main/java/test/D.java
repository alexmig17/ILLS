package test;

public class D {

    public D(B b) {
        System.out.println("D " + b);
        this.b = b;
    }

    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        System.out.println(b);
        this.b = b;
    }

    public D() {
    }
}
