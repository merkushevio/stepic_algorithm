package module1;

import java.io.*;
import java.security.ProtectionDomain;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(9%-5);
        System.out.println(-9%5);
        System.out.println((-9)%(-5));
        ClassLoader l = Runtime.class.getClassLoader();
        SecurityManager manager = new SecurityManager();
        StringTokenizer tokenizer = new StringTokenizer("ab,ac;", ",;", true);
        System.out.println(tokenizer.nextToken());
        Locale locale = Locale.getDefault();
        //double d = 1.0*5/3;
        //System.out.println(d);
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
        try {
            Reader reader = new InputStreamReader(is, "windows-1251");
        } catch (Exception e) {

        }
        int day = new Date().getDay();
        System.out.println(day);
        System.gc();


        new Object(){};
        File file = new File("test");
        Map<int[], String> map=new HashMap<>();

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
