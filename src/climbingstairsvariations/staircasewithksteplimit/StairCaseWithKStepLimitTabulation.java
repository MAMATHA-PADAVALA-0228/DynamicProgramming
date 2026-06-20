package climbingstairsvariations.staircasewithksteplimit;


import java.util.Arrays;

class Solution2 {
    public int climbStairsK(int n, int k,int[] dp) {


        dp[0] = 1;




        for(int ind=1;ind<=n;ind++) {
            int ans = 0;
            for (int i = 1; i <= k; i++) {

                if (i <= ind)
                    ans = ans + dp[ind - i];

            }
            dp[ind] = ans;
        }
        return dp[n];

    }
}

public class StairCaseWithKStepLimitTabulation {
    static void check(int result, int expected, String label) {
        String status = result == expected ? "PASS" : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();

        int n=3;
        int[] dp = new int[n+1];

        check(sol.climbStairsK(n, 2,dp),  3,  "n=3, k=2");

        n=5;
        dp = new int[n+1];

        check(sol.climbStairsK(n, 3,dp),  13, "n=5, k=3");

        n=4;
        dp = new int[n+1];

        check(sol.climbStairsK(n, 4,dp),  8,  "n=4, k=4");

        n=6;
        dp = new int[n+1];

        check(sol.climbStairsK(6, 2,dp),  13, "n=6, k=2");

        n=1;
        dp = new int[n+1];

        check(sol.climbStairsK(1, 5,dp),  1,  "n=1, k=5");
    }
}

