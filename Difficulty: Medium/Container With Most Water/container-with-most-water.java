class Solution {
    public int maxWater(int arr[]) {
        // Code Here
        int maxWater = 0;
        int lp = 0;
        int rp = arr.length-1;
        while(lp < rp) {
            int ht = Math.min(arr[lp], arr[rp]);
            int width = rp - lp;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);
            
            if(arr[lp] < arr[rp]) {
                lp ++;
            } else {
                rp --;
            }
        }
        return maxWater;
    }
}