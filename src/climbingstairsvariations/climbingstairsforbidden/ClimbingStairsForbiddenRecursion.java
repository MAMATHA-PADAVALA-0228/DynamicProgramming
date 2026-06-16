package climbingstairsvariations.climbingstairsforbidden;

class Solution1 {

    public int climbStairsForbidden1(int n, int[] forbidden) {
        // Your code here
        for(int i=0;i<forbidden.length;i++){
            if(n==forbidden[i])
                return 0;
        }

        if(n==1 || n==0)
            return 1;

        return climbStairsForbidden1(n-1,forbidden)+
                climbStairsForbidden1(n-2,forbidden);

    }
}

public class ClimbingStairsForbiddenRecursion {
    static void check(int result, int expected, String label) {
        String status = result == expected ? "PASS" : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }
    public static void main(String[] args) {

        Solution1 sol = new Solution1();
        check(sol.climbStairsForbidden1(6, new int[]{3}),    4, "n=6, forbidden=[3]");
        check(sol.climbStairsForbidden1(5, new int[]{}),     8, "n=5, forbidden=[]");
        check(sol.climbStairsForbidden1(4, new int[]{2}),    1, "n=4, forbidden=[2]");
        check(sol.climbStairsForbidden1(7, new int[]{3,5}),  2, "n=7, forbidden=[3,5]");
        check(sol.climbStairsForbidden1(1, new int[]{}),     1, "n=1, forbidden=[]");
    }
}
