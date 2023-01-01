package main.Models;

public class Pair {
    private int a;
    private int b;
    public Pair(int a, int b){
        this.setA(a);
        this.setB(b);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
