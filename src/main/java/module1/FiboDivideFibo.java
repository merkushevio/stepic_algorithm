package module1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by igor on 5/29/16.
 * <p>
 * Find residue for divide two fibo numbers (n%m)
 * first  1≤n≤10^18, second 2≤m≤10^5,
 */
public class FiboDivideFibo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        BigInteger m = scanner.nextBigInteger();
        BigInteger result = fiboNumber(n).remainder(fiboNumber(m));
        System.out.println(result);
    }

    private static BigInteger fiboNumber(BigInteger number) {
        ArrayList<BigInteger> list = new ArrayList<>();
        list.add(BigInteger.ZERO);
        list.add(BigInteger.ONE);
        for (BigInteger num = BigInteger.valueOf(2); num.compareTo(number) < 0; num.add(BigInteger.ONE)) {
//            fibo[i] = fibo[ i - 1 ] + fibo[i - 2];

        }
        return list.get(list.size() - 1);
    }
}
