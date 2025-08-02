import java.util.*;
class Solution {
    void selectionSort(int[] arr) {
        // code here
        for(int i=0; i<arr.length-1; i++){
            int minPos = i; 
            for(int j=i+1; j<arr.length; j++){
                if(arr[minPos] > arr[j]){
                    minPos = j;
                }
            }
            int temp =arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }
    void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        selectionSort(arr);
        printArr(arr);
    }
}