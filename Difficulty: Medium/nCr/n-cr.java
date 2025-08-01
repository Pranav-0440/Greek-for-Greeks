import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static BigInteger nCr(int n, int r) {
        if (r > n) return BigInteger.ZERO;
        
        BigInteger factN = factorial(n);
        BigInteger factR = factorial(r);
        BigInteger factNMinusR = factorial(n - r);

        return factN.divide(factR.multiply(factNMinusR));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(nCr(n, r));
        sc.close();
    }
}