package module1;

import java.util.Scanner;

public class Step10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(divisorSimple(number));
    }

    public static boolean numberSimple(int num) {
        int max = Math.round((float) Math.sqrt(num));
        for (int i = 2; i < max + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String divisorSimple(int numer) {
        StringBuilder string = new StringBuilder();
        for (int i = 2; i <= numer; i++) {
            int div = numer % i;
            if (div == 0) {
                if (numberSimple(i)) {
                    string.append(i).append(" ");
                    numer = numer / i;
                    i = 1;
                }
            }
        }
        return string.toString();
    }
}
