// User function Template for Java
import java.util.Arrays;
class Solution {
    public boolean checkDuplicates(int arr[]) {
        // Code here
        Arrays.sort(arr);
        for(int i=1; i<arr.length; i++){
            if(arr[i] == arr[i-1]){
                return true;
            }
        }
        return false;
    }
    public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        checkDuplicates(arr);
    }
}