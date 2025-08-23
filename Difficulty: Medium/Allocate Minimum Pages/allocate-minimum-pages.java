class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        
        // if students are more than books
        if (k > n) return -1;
        
        int low = Integer.MIN_VALUE; 
        int high = 0;
        
        for (int pages : arr) {
            low = Math.max(low, pages); // at least max book
            high += pages;              // total sum of pages
        }
        
        int result = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isPossible(arr, k, mid)) {
                result = mid;   // valid allocation
                high = mid - 1; // try smaller max
            } else {
                low = mid + 1;  // increase max pages
            }
        }
        
        return result;
    }
    
    // helper function
    private boolean isPossible(int[] arr, int k, int mid) {
        int students = 1;
        int pagesSum = 0;
        
        for (int pages : arr) {
            if (pagesSum + pages > mid) {
                students++;
                pagesSum = pages; // assign new student
                
                if (students > k) return false;
            } else {
                pagesSum += pages;
            }
        }
        
        return true;
    }
}
