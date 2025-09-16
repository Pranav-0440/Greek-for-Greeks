// User function Template for Java
class Solution {
    // Function to check if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int nextPrime(int n) {
        int candidate = n + 1;

        while (true) {
            if (isPrime(candidate)) {
                return candidate; // found the next prime
            }
            candidate++;
        }
    }
}
