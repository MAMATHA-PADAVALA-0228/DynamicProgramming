package climbingstairsvariations.climbingstairsforbidden;

class Solution {

    public int climbStairsForbidden(int n, int[] forbidden) {
        // Your code here
        for(int i=0;i<forbidden.length;i++){
            if(n==forbidden[i])
                return 0;
        }

        if(n==1 || n==0)
            return 1;

        return climbStairsForbidden(n-1,forbidden)+
                climbStairsForbidden(n-2,forbidden);

    }
}

public class ClimbingStairsForbiddenMemoization {
    static void check(int result, int expected, String label) {
        String status = result == expected ? "PASS" : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 6;
        int[] dp = new int[n+1];
        check(sol.climbStairsForbidden(n, new int[]{3}),    4, "n=6, forbidden=[3]");


        n=5;
        dp = new int[n+1];
        check(sol.climbStairsForbidden(5, new int[]{}),     8, "n=5, forbidden=[]");

        n=4;
        dp = new int[n+1];
        check(sol.climbStairsForbidden(4, new int[]{2}),    1, "n=4, forbidden=[2]");

        n=2;
        dp = new int[n+1];
        check(sol.climbStairsForbidden(7, new int[]{3,5}),  2, "n=7, forbidden=[3,5]");

        n=1;
        dp = new int[n+1];
        check(sol.climbStairsForbidden(1, new int[]{}),     1, "n=1, forbidden=[]");
    }
}

