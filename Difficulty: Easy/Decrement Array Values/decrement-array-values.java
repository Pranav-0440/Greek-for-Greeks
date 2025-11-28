import java.util.*;
class Solution {
    public static int[] decrementArrayElements(int[] arr) {
        // Code here
        for(int i=0; i<arr.length; i++){
            arr[i] -= 1;
        }
        return arr;
    }
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int arr[] = new int [n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        decrementArrayElements(arr);
        printArr(arr);
    }
}