package climbingstairsvariations.climbingstairsforbidden;


import java.util.HashSet;

class Solution2 {

    public int climbStairsForbidden2(int n, int[] forbidden,int[] dp) {
        // Your code here
        HashSet<Integer> hashSet = new HashSet<>();
        for(int element:forbidden)
            hashSet.add(element);


        dp[0]=1;
        dp[1]=1;
        for(int i=0;i<=n;i++) {
            if(hashSet.contains(i))
                dp[i]=0;
            else{
                if(i>=2)
                    dp[i] = dp[i-1]+dp[i-2];
            }
        }



        return dp[n];



    }
}

public class ClimbingStairsForbiddenTabulation {
    static void check(int result, int expected, String label) {
        String status = result == expected ? "PASS" : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }
    public static void main(String[] args) {
        Solution2 sol = new Solution2();

        int n=6;
        int[] dp = new int[n+1];
        check(sol.climbStairsForbidden2(n, new int[]{3},dp),    4, "n=6, forbidden=[3]");

        n=5;
        dp = new int[n+1];
        check(sol.climbStairsForbidden2(n, new int[]{},dp),     8, "n=5, forbidden=[]");

        n=4;
        dp = new int[n+1];
        check(sol.climbStairsForbidden2(n, new int[]{2},dp),    1, "n=4, forbidden=[2]");

        n=7;
        dp = new int[n+1];
        check(sol.climbStairsForbidden2(n, new int[]{3,5},dp),  2, "n=7, forbidden=[3,5]");

        n=1;
        dp = new int[n+1];
        check(sol.climbStairsForbidden2(n, new int[]{},dp),     1, "n=1, forbidden=[]");
    }
}
