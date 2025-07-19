import java.util.*;
class Solution {
    boolean isPalindrome(String s) {
        // code here
        int n = s.length();
        for(int i=0; i<n/2; i++){
            while(s.charAt(i) != s.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
    void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isPalindrome(s));
    }
}