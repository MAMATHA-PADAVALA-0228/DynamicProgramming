package climbingstairsvariations.staircasewithmandatorycheckpoints;

import java.util.*;

class Solution2 {


    public int climbWithCheckpoint(int n, int[] checkpoints) {
        Set<Integer> cpSet = new HashSet<>();
        for (int c : checkpoints) cpSet.add(c);

        int[][] dp = new int[n+1][2];

        dp[0][1] = 0;
        dp[0][0] = 1;

        if(cpSet.contains(1)){
            dp[1][0] = 0;
            dp[1][1] = 1;
        }
        else {
            dp[1][0] = 1;
            dp[1][1] = 0;
        }

        for(int i=2;i<=n;i++){

            if(cpSet.contains(i))
                dp[i][1] = dp[i-1][0] + dp[i-1][1]+
                        dp[i-2][0]+dp[i-2][1];
            else
                dp[i][1] = dp[i-1][1] + dp[i-2][1];

            if(!cpSet.contains(i))
                dp[i][0] = dp[i-1][0] + dp[i-2][0];

        }

        return dp[n][1];

        // Step 1: total ways to reach n (unrestricted)
        // Your code here

        // Step 2: ways to reach n avoiding ALL checkpoints
        // Your code here

        // Answer = total - avoiding


    }
}

class StairCaseWithMandatoryCheckPointTabulation {
    static void check(int result, int expected, String label) {
        String status = result == expected ? "PASS" : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        check(sol.climbWithCheckpoint(6, new int[]{2,4}), 12, "n=6, cp=[2,4]");
        check(sol.climbWithCheckpoint(5, new int[]{3}),    6, "n=5, cp=[3]");
        check(sol.climbWithCheckpoint(4, new int[]{2}),    4, "n=4, cp=[2]");
        check(sol.climbWithCheckpoint(6, new int[]{1}),    8, "n=6, cp=[1]");
        check(sol.climbWithCheckpoint(3, new int[]{1,2}),  3, "n=3, cp=[1,2]");
    }
}

