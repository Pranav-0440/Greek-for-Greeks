// User function Template for Java
import java.util.*;
class Solution {
    public static char extraChar(String s1, String s2) {

        // write your code here
        int count [] = new int[26];
        for(char c: s1.toCharArray()){
            count[c - 'a']++;
        }
        for( char c : s2.toCharArray()){
            if(--count[c - 'a'] < 0){
                return c;
            }
        }
        return ' ';
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.print(extraChar(s1,s2));
    }
}
