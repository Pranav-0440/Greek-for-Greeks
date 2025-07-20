import java.util.*;

class Solution {
    public String shortestPath(String S) {
        int north = 0, south = 0, east = 0, west = 0;

        for (char dir : S.toCharArray()) {
            switch (dir) {
                case 'N': north++; break;
                case 'S': south++; break;
                case 'E': east++; break;
                case 'W': west++; break;
            }
        }

        // Cancel opposites
        int vertical = north - south;
        int horizontal = east - west;

        StringBuilder path = new StringBuilder();

        // Lexicographical order: E, N, S, W
        if (horizontal > 0) for (int i = 0; i < horizontal; i++) path.append('E');
        if (vertical > 0) for (int i = 0; i < vertical; i++) path.append('N');
        if (vertical < 0) for (int i = 0; i < -vertical; i++) path.append('S');
        if (horizontal < 0) for (int i = 0; i < -horizontal; i++) path.append('W');

        return path.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        Solution sol = new Solution();
        System.out.println(sol.shortestPath(S));
    }
}
