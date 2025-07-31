import java.util.Scanner;

// class Pair<K, V> {
//     private final K key;
//     private final V value;

//     public Pair(K key, V value) {
//         this.key = key;
//         this.value = value;
//     }

//     public K getKey() {
//         return key;
//     }

//     public V getValue() {
//         return value;
//     }

//     @Override
//     public String toString() {
//         return key + " " + value;
//     }
// }

class Solution {
    public static Pair<Integer, Integer> getMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new Pair<>(0, 0); // Handle empty array case
        }
        
        int min = arr[0];
        int max = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        return new Pair<>(min, max);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Pair<Integer, Integer> result = getMinMax(arr);
        System.out.println(result);
        sc.close();
    }
}