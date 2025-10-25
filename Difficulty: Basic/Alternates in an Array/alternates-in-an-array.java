import java.util.ArrayList;

class Solution {
    // function to print alternate elements of an array
    public ArrayList<Integer> getAlternates(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Loop through array and take elements at even indices
        for (int i = 0; i < arr.length; i += 2) {
            result.add(arr[i]);
        }
        
        return result;
    }
}
