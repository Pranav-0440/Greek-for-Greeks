import java.util.Scanner;

public class Solution {

    // Binary Search Function: Find index of k
    public static int binarysearch(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == k) {
                // Optional: return first occurrence
                while (mid > 0 && arr[mid - 1] == k) {
                    mid--;
                }
                return mid;
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // Main Method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " sorted elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the number to search: ");
        int k = scanner.nextInt();

        int result = binarysearch(arr, k);

        if (result != -1) {
            System.out.println(k + " appears at index " + result + ".");
        } else {
            System.out.println(k + " is not present.");
        }

        scanner.close();
    }
}