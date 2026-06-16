package climbingstairsvariations.twostepsafter2stepsforbidden;

class Solution1 {
    public int climbWithCooldown(int n,int flag) {

        if(n==0 || n==1)
            return 1;

        int step1 = climbWithCooldown(n-1,0);
        int step2=0;
        if(flag!=1)
            step2 = climbWithCooldown(n-2,1);

        return step1+step2;

    }
}

public class ClimbingStairsWithCoolDownRecursion {
    static void check(int result, int expected, String label) {
        String status = result == expected ? "PASS" : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        check(sol.climbWithCooldown(1,0), 1, "n=1");
        check(sol.climbWithCooldown(2,0), 2, "n=2");
        check(sol.climbWithCooldown(3,0), 3, "n=3");
        check(sol.climbWithCooldown(4,0), 4, "n=4");
        check(sol.climbWithCooldown(5,0), 6, "n=5");
        check(sol.climbWithCooldown(6,0), 9, "n=6");
    }
}
