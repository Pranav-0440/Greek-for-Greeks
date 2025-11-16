class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        Arrays.sort (arr);
       int j = arr.length-1, i = 0;
       
       while (i<j) {
            if ((arr[i] + arr[j]) == target) return true;
           
            else if ( (arr[i] + arr[j]) > target) {
                  j--;
            }
       
            else if ((arr[i] + arr[j]) < target) {
                 i++;
            }
       }
       
        return false;
    }
}