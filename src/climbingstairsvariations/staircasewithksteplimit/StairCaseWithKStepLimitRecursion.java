package climbingstairsvariations.staircasewithksteplimit;

class Solution {
    public int climbStairsK(int n, int k) {
        final int MOD = 1_000_000_007;
        // dp[i] = ways to reach step i
        // prefix[i] = dp[0] + dp[1] + ... + dp[i]
        // dp[i] = prefix[i-1] - prefix[max(i-k-1, -1)]
        // Your code here

        if(n<=0)
            return 1;

        int ans = 0;

        for(int i=1;i<=k;i++){

            if(i<=n)
                ans  = ans + climbStairsK(n-i,k);

        }

        return ans;

    }
}

public class StairCaseWithKStepLimitRecursion {
    static void check(int result, int expected, String label) {
        String status = result == expected ? "PASS" : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        check(sol.climbStairsK(3, 2),  3,  "n=3, k=2");
        check(sol.climbStairsK(5, 3),  13, "n=5, k=3");
        check(sol.climbStairsK(4, 4),  8,  "n=4, k=4");
        check(sol.climbStairsK(6, 2),  13, "n=6, k=2");
        check(sol.climbStairsK(1, 5),  1,  "n=1, k=5");
    }
}