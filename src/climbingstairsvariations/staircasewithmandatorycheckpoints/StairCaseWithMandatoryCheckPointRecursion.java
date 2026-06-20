package climbingstairsvariations.staircasewithmandatorycheckpoints;

import java.util.*;

class Solution {


    public int find(int n,Set<Integer> cpSet,boolean isHit){

        if(n==0 || n==1) {
            if(isHit)
                return 1;
            else if(cpSet.contains(n) && n!=0)
                return 1;
            else
                return 0;
        }

        return find(n-1,cpSet,cpSet.contains(n) || isHit)
                + find(n-2,cpSet,cpSet.contains(n) || isHit);

    }

    public int climbWithCheckpoint(int n, int[] checkpoints) {
        Set<Integer> cpSet = new HashSet<>();
        for (int c : checkpoints) cpSet.add(c);

        // Step 1: total ways to reach n (unrestricted)
        // Your code here

        // Step 2: ways to reach n avoiding ALL checkpoints
        // Your code here

        // Answer = total - avoiding
        return find(n,cpSet,false);

    }
}

class StairCaseWithMandatoryCheckPointRecursion {
    static void check(int result, int expected, String label) {
        String status = result == expected ? "PASS" : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        check(sol.climbWithCheckpoint(6, new int[]{2,4}), 12, "n=6, cp=[2,4]");
        check(sol.climbWithCheckpoint(5, new int[]{3}),    6, "n=5, cp=[3]");
        check(sol.climbWithCheckpoint(4, new int[]{2}),    4, "n=4, cp=[2]");
        check(sol.climbWithCheckpoint(6, new int[]{1}),    8, "n=6, cp=[1]");
        check(sol.climbWithCheckpoint(3, new int[]{1,2}),  3, "n=3, cp=[1,2]");
    }
}
