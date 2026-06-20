package climbingstairsvariations.staircasewithksteplimit;


import java.util.Arrays;

class Solution1 {
    public int climbStairsK(int n, int k,int[] dp) {

        // dp[i] = ways to reach step i
        // prefix[i] = dp[0] + dp[1] + ... + dp[i]
        // dp[i] = prefix[i-1] - prefix[max(i-k-1, -1)]
        // Your code here

        if(n<=0)
            return 1;

        if(dp[n]!=-1)
            return dp[n];

        int ans = 0;

        for(int i=1;i<=k;i++){

            if(i<=n)
                ans  = ans + climbStairsK(n-i,k,dp);

        }
        dp[n] = ans;
        return ans;

    }
}

public class StairCaseWithKStepLimitMemoization {
    static void check(int result, int expected, String label) {
        String status = result == expected ? "PASS" : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();

        int n=3;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        check(sol.climbStairsK(n, 2,dp),  3,  "n=3, k=2");

        n=5;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        check(sol.climbStairsK(n, 3,dp),  13, "n=5, k=3");

        n=4;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        check(sol.climbStairsK(n, 4,dp),  8,  "n=4, k=4");

        n=6;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        check(sol.climbStairsK(6, 2,dp),  13, "n=6, k=2");

        n=1;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        check(sol.climbStairsK(1, 5,dp),  1,  "n=1, k=5");
    }
}
