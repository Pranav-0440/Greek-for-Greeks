// User function Template for Java

class Solution {
    public long countFriendsPairings(int n) {
        // code here
        if(n == 1 || n == 2){
            return n;
        }
        
        long fnm1 = countFriendsPairings(n-1);
        long fnm2 = countFriendsPairings(n-2);
        
        long pairways = (n-1) * fnm2;
        
        long totalways = fnm1 + pairways;
        
        return totalways;
    }
}
