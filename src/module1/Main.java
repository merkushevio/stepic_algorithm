package module1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.ProtectionDomain;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println(9%-5);
        System.out.println(-9%5);
        System.out.println((-9)%(-5));
        ClassLoader l = ClassLoader.getSystemClassLoader();
        SecurityManager manager = new SecurityManager();

        char c = '\u0202';
        System.out.println((int)c);
        System.out.println(1 + 2 + " = " + 12);
        System.out.println(1 + "!=" + 2);

        Test test = new Test();
        test.start();

        B b = new B("good bye");

        Float f = Float.valueOf(1.0f);
        Integer i = Integer.valueOf(1);
        if (f.equals(i)) {
            System.out.println("Equals");
        }
        else {
            System.out.println("Not equals");
        }

        InputStream is = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
        int day = new Date().getDay();
        System.out.println(day);
        System.gc();
    }

    static class Test extends Thread {
        @Override
        public void run() {
            System.out.println(1);
            yield();
            System.out.println(2);
            suspend();
            System.out.println(3);
            resume();
            System.out.println(4);
        }
    }

    static class A {
        A() {

        }

        A(String s) {
            System.out.println(s);
        }

        A(String s, String s1) {
            this(s + s1);
        }
    }

    static class B extends A {
        B() {
            super();
        }

        B(String s) {
            super(s, " world ");
        }

        B(String s1, String s2) {
            System.out.println(s1 + s2 + " !");
        }
    }

}
