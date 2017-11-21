package test;

public class B {

    public B() {
    }

    public B(C c) {
        this.c = c;
    }

    public C c;
    public String n;

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }
}
