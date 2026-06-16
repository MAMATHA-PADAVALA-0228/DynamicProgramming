package climbingstairsvariations.twostepsafter2stepsforbidden;


import java.lang.reflect.Array;
import java.util.Arrays;

class Solution2 {
    public int climbWithCooldown(int n,int flag,int[][] dp) {

        if(n==0 || n==1)
            return 1;

        if(dp[n][flag]!=-1)
            return dp[n][flag];

        int step1 = climbWithCooldown(n-1,0,dp);

        int step2=0;
        if(flag!=1)
            step2 = climbWithCooldown(n-2,1,dp);

        dp[n][flag] = step1+step2;
        return dp[n][flag];

    }
}

public class ClimbingStairsWithCoolDownMemoization {
    static void check(int result, int expected, String label) {
        String status = result == expected ? "PASS" : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();

        int n=1;
        int[][] dp = new int[n+1][2];
        for(int[] a:dp)
            Arrays.fill(a,-1);
        check(sol.climbWithCooldown(n,0,dp), 1, "n=1");

        n=2;
        dp = new int[n+1][2];
        for(int[] a:dp)
            Arrays.fill(a,-1);
        check(sol.climbWithCooldown(n,0,dp), 2, "n=2");

        n=3;
        dp = new int[n+1][2];
        for(int[] a:dp)
            Arrays.fill(a,-1);
        check(sol.climbWithCooldown(3,0,dp), 3, "n=3");

        n=4;
        dp = new int[n+1][2];
        for(int[] a:dp)
            Arrays.fill(a,-1);
        check(sol.climbWithCooldown(4,0,dp), 4, "n=4");

        n=5;
        dp = new int[n+1][2];
        for(int[] a:dp)
            Arrays.fill(a,-1);
        check(sol.climbWithCooldown(5,0,dp), 6, "n=5");

        n=6;
        dp = new int[n+1][2];
        for(int[] a:dp)
            Arrays.fill(a,-1);
        check(sol.climbWithCooldown(6,0,dp), 9, "n=6");
    }
}

