package climbingstairsvariations.minCostClimbingStairs;

import java.util.Arrays;

class Solution2 {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];

        Arrays.fill(dp,-1);

        dp[cost.length-1] = cost[cost.length-1];

        dp[cost.length] = 0;

        for(int index = cost.length-2;index>=0;index--) {

            int left = cost[index] + dp[index+1];

            int right = cost[index] + dp[index+2];

            dp[index] = Math.min(left, right);
        }

        int zeroIndex = dp[0];
        int oneIndex = dp[1];

        if(oneIndex==-1)
            oneIndex = Integer.MAX_VALUE;
        if(zeroIndex==-1)
            zeroIndex = Integer.MAX_VALUE;

        return Math.min(zeroIndex,oneIndex);
    }
}

public class MinCostClimbingStairsTabulation {
    static void check(int result, int expected, String label) {
        String status = result == expected ? "PASS" : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        check(sol.minCostClimbingStairs(new int[]{10,15,20}),                      15, "cost=[10,15,20]");
        check(sol.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}),      6, "zigzag");
        check(sol.minCostClimbingStairs(new int[]{0,0}),                             0, "zero cost");
        check(sol.minCostClimbingStairs(new int[]{1,2}),                             1, "pick cheaper");
        check(sol.minCostClimbingStairs(new int[]{10,15}),                          10, "single hop");
    }
}