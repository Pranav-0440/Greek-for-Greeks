// User function Template for Java

import java.util.*;

class Solution {
    static class Query {
        int l, r, idx;
        Query(int l, int r, int idx) {
            this.l = l;
            this.r = r;
            this.idx = idx;
        }
    }
    
    public int[] solveQueries(int[] nums, int[][] Queries, int k) {
        int n = nums.length;
        int q = Queries.length;
        
        int blockSize = (int) Math.sqrt(n);
        Query[] queryArr = new Query[q];
        
        for (int i = 0; i < q; i++) {
            int l = Queries[i][0] - 1; // 0-based index
            int r = Queries[i][1] - 1;
            queryArr[i] = new Query(l, r, i);
        }
        
        // Sort queries (Mo's ordering)
        Arrays.sort(queryArr, (a, b) -> {
            int blockA = a.l / blockSize;
            int blockB = b.l / blockSize;
            if (blockA != blockB) return blockA - blockB;
            return a.r - b.r;
        });
        
        int[] freq = new int[1005]; // since nums[i] <= 1000
        int currAns = 0;
        int[] ans = new int[q];
        
        int currL = 0, currR = -1;
        
        for (Query query : queryArr) {
            int L = query.l, R = query.r;
            
            // expand to right
            while (currR < R) {
                currR++;
                int x = nums[currR];
                freq[x]++;
                if (freq[x] == k) currAns++;
            }
            
            // shrink from right
            while (currR > R) {
                int x = nums[currR];
                if (freq[x] == k) currAns--;
                freq[x]--;
                currR--;
            }
            
            // expand to left
            while (currL > L) {
                currL--;
                int x = nums[currL];
                freq[x]++;
                if (freq[x] == k) currAns++;
            }
            
            // shrink from left
            while (currL < L) {
                int x = nums[currL];
                if (freq[x] == k) currAns--;
                freq[x]--;
                currL++;
            }
            
            ans[query.idx] = currAns;
        }
        
        return ans;
    }
}
