// User function Template for Java

// functions should slice the given string
// i.e. remove the first and the last character
// of the given string and return the sliced
// string
import java.util.*;
class Solution {
    public static String sliceString(String s) {
        // code here
        return s.substring(1, s.length()-1);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(sliceString(s));
    }
}
