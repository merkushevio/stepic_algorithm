package module1;

import java.awt.*;
public class Test {
    public static void main(String[] args) {
        Test c = new Test();
        c.f1(1, 1);
    }
    public void f1(int b, long c) {
        System.out.println("1");
    }
    public void f1(short b, short c) {
        System.out.println("2");
    }
    public void f1(int b, int c) {
        System.out.println("3");
    }
    public void f1(long b, long c) {
        System.out.println("4");
    }
}


