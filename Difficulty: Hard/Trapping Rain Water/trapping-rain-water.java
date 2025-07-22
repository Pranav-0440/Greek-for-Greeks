import java.util.Scanner;
class Solution {
    public static int maxWater(int height[]){
        int n = height.length;
        // LeftMax
        int leftMax[] = new int[n];
        leftMax[0] = height[0];

        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        // RightMax
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];

        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        // Loop
        int trappedWater = 0;
        for(int i=0; i<n; i++){
            // WaterLevel
            int WaterLevel = Math.min(leftMax[i], rightMax[i]);
            // TrappedWater
            trappedWater += WaterLevel - height[i];
            // System.out.print(trappedWater + " ");
        }
        return trappedWater; // Return the total trapped water
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int height[] = new int[n];
        for(int i=0; i<n; i++){
            height[i]=sc.nextInt();
        }
        System.out.println(maxWater(height));

    }
}