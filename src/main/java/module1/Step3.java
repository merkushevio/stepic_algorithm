package module1;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Step3 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arrayA = new int[n];
        int[] arrayB = new int[n];
        String[] stringsA = reader.readLine().split(" ");
        String[] stringsB = reader.readLine().split(" ");
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = Integer.parseInt(stringsA[i]);
        }
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = Integer.parseInt(stringsB[i]);
        }
        reader.close();
        int max = arrayA[0] + arrayB[0];
        int maxA = arrayA[0];
        int maxB = arrayB[0];
        int x = 0;
        int y = 0;
        for (int i = 0; i < arrayB.length; i++) {
            for (int j = 0; j <= i; j++) {
                int sum = arrayA[j] + arrayB[i];
                if (max < sum) {
                    max = sum;
                    x = j;
                    y = i;
                }
            }
        }
        System.out.println(x + " " + y);
    }
}
