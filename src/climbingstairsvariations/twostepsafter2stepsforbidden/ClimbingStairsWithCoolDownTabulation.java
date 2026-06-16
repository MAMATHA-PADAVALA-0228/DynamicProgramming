package climbingstairsvariations.twostepsafter2stepsforbidden;



import java.lang.reflect.Array;
import java.util.Arrays;

class Solution3 {
    public int climbWithCooldown(int n,int flag,int[][] dp) {

        if(n==0 || n==1)
            return 1;

        dp[0][0]=1;
        dp[0][1]=1;
        dp[1][0]=1;
        dp[1][1]=1;


        for(int i=2;i<=n;i++){
            dp[i][0] = dp[i-1][0]+dp[i-2][1];

            dp[i][1] = dp[i-1][0];
        }

        return dp[n][0];

    }
}

public class ClimbingStairsWithCoolDownTabulation {
    static void check(int result, int expected, String label) {
        String status = result == expected ? "PASS" : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {
        Solution3 sol = new Solution3();

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


