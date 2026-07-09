package subsetsumvariations.atleastkeven;


import java.util.Arrays;

public class SubsetSumWithAtLeastKEvenMemoization {

    static void check(boolean result, boolean expected, String label) {

        final String GREEN = "\u001B[32m";
        final String RED = "\u001B[31m";
        final String RESET = "\u001B[0m";

        String status = (result == expected)
                ? GREEN + "✔ PASS" + RESET
                : RED + "✘ FAIL (got " + result + ")" + RESET;

        System.out.printf("%-45s : %s | expected=%s%n",
                label, status, expected);
    }

    public static void main(String[] args) {

        Solution1 sol = new Solution1();

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 3, 5}, 5, 1),
                true,
                "{2,3,5}, target=5, k=1"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 3, 5}, 2, 1),
                true,
                "{2,3,5}, target=2, k=1"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 4, 5}, 6, 2),
                true,
                "{2,4,5}, target=6, k=2"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 4, 5}, 6, 3),
                false,
                "{2,4,5}, target=6, k=3"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{1, 3, 5}, 9, 1),
                false,
                "{1,3,5}, target=9, k=1"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 4, 6}, 12, 2),
                true,
                "{2,4,6}, target=12, k=2"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 4, 6}, 12, 3),
                true,
                "{2,4,6}, target=12, k=3"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 4, 6}, 12, 4),
                false,
                "{2,4,6}, target=12, k=4"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 4, 6}, 6, 2),
                true,
                "{2,4,6}, target=6, k=2"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 4, 6}, 6, 3),
                false,
                "{2,4,6}, target=6, k=3"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{1, 2, 3, 4}, 10, 2),
                true,
                "{1,2,3,4}, target=10, k=2"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{1, 2, 3, 4}, 6, 2),
                true,
                "{1,2,3,4}, target=6, k=2"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{1, 2, 3, 4}, 5, 1),
                true,
                "{1,2,3,4}, target=5, k=1"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{1, 2, 3, 4}, 5, 2),
                false,
                "{1,2,3,4}, target=5, k=2"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2}, 2, 1),
                true,
                "{2}, target=2, k=1"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2}, 2, 2),
                false,
                "{2}, target=2, k=2"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{1}, 1, 1),
                false,
                "{1}, target=1, k=1"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{}, 0, 0),
                true,
                "Empty subset"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{}, 0, 1),
                false,
                "Empty subset, k=1"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 4, 5, 7}, 11, 2),
                true,
                "{2,4,5}, target=11, k=2"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 4, 5, 7}, 9, 2),
                false,
                "{2,4,5,7}, target=9, k=2"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 2, 2}, 4, 2),
                true,
                "{2,2,2}, target=4, k=2"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 2, 2}, 4, 3),
                false,
                "{2,2,2}, target=4, k=3"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{1, 2, 2, 3}, 5, 2),
                true,
                "{1,2,2,3}, target=5, k=2"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{1, 2, 2, 3}, 3, 2),
                false,
                "{1,2,2,3}, target=3, k=2"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 4}, 0, 0),
                true,
                "Empty subset"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 4}, 0, 1),
                false,
                "Empty subset, k=1"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 4}, 6, 5),
                false,
                "k > total evens"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{1, 3, 5}, 8, 1),
                false,
                "{1,3,5}, target=8, k=1"
        );

        check(
                sol.subsetSumAtLeastKEven(new int[]{2, 6, 1, 5}, 14, 2),
                true,
                "{2,6,1,5}, target=14, k=2"
        );
    }
}

class Solution1 {


    public boolean find(int index,int[] nums,int target,int k,int evenCount,int[][][] dp){



        if(index==nums.length)
        {
            if(target==0 && evenCount>=k)
                return true;
            return false;
        }

        if(dp[index][target][evenCount]!=-1)
            return dp[index][target][evenCount]==1;

        boolean pick = false;

        if(nums[index]<=target)
            pick = find(index+1,nums,target-nums[index],k,nums[index]%2==0?evenCount+1:evenCount,dp);

        boolean notPick = find(index+1,nums,target,k,evenCount,dp);

        dp[index][target][evenCount] = pick || notPick?1:0;

        return pick || notPick;
    }

    public boolean subsetSumAtLeastKEven(int[] nums, int target, int k) {
        // Your code here

        int[][][] dp = new int[nums.length][target+1][k+1];

        for(int[][] a :dp)
        {
            for(int[] b : a)
                Arrays.fill(b,-1);
        }
        return find(0,nums,target,k,0,dp);

    }
}

