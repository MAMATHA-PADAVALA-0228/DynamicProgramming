package subsetsumvariations.atmostkeven;


import java.lang.reflect.Array;
import java.util.Arrays;

class Solution1 {

    public boolean find(int[] nums,int target,int k,int index,int evenCount,int[][][] dp){

        if(evenCount>k)
            return false;


        if(index==nums.length){

            if(target==0 && evenCount<=k){
                return true;
            }
            return false;


        }

        if(dp[index][target][evenCount]!=-1)
            return dp[index][target][evenCount]==1;

        boolean pick = false;

        if(nums[index]<=target)
            pick = find(nums,target-nums[index],k,index+1,nums[index]%2==0?evenCount+1:evenCount,dp);

        boolean notPick = find(nums,target,k,index+1,evenCount,dp);

        dp[index][target][evenCount] = pick || notPick?1:0;

        return pick || notPick;

    }

    public boolean subsetSumAtMostKEven(int[] nums, int target, int k) {

        // Your code here
        int[][][] dp = new int[nums.length][target+1][k+1];
        for(int[][] a : dp){
            for(int[] b: a)
                Arrays.fill(b,-1);
        }
        return find(nums,target,k,0,0,dp);

    }

}

public class SubsetSumWithAtMostKEvenMemoization {

    static void check(boolean result, boolean expected, String label) {
        String status = result == expected
                ? "PASS"
                : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {

        Solution1 sol = new Solution1();

        check(
                sol.subsetSumAtMostKEven(new int[]{2, 3, 5}, 10, 1),
                true,
                "{2,3,5}, target=10, k=1"
        );

        check(
                sol.subsetSumAtMostKEven(new int[]{2, 4, 5}, 11, 1),
                false,
                "{2,4,5}, target=11, k=1"
        );

        check(
                sol.subsetSumAtMostKEven(new int[]{2, 4, 6}, 12, 2),
                false,
                "{2,4,6}, target=12, k=2"
        );

        check(
                sol.subsetSumAtMostKEven(new int[]{2, 4, 6}, 12, 3),
                true,
                "{2,4,6}, target=12, k=3"
        );

        check(
                sol.subsetSumAtMostKEven(new int[]{1, 3, 5}, 9, 0),
                true,
                "{1,3,5}, target=9, k=0"
        );

        check(
                sol.subsetSumAtMostKEven(new int[]{2, 3, 5}, 5, 0),
                true,
                "{2,3,5}, target=5, k=0"
        );

        check(
                sol.subsetSumAtMostKEven(new int[]{2, 3, 5}, 7, 0),
                false,
                "{2,3,5}, target=7, k=0"
        );

        check(
                sol.subsetSumAtMostKEven(new int[]{4}, 4, 1),
                true,
                "{4}, target=4, k=1"
        );

        check(
                sol.subsetSumAtMostKEven(new int[]{4}, 4, 0),
                false,
                "{4}, target=4, k=0"
        );

        check(
                sol.subsetSumAtMostKEven(new int[]{2, 2, 3}, 5, 1),
                true,
                "{2,2,3}, target=5, k=1"
        );

        check(
                sol.subsetSumAtMostKEven(new int[]{2, 2, 4}, 6, 1),
                false,
                "{2,2,4}, target=6, k=1"
        );

        check(
                sol.subsetSumAtMostKEven(new int[]{2, 2, 4}, 6, 2),
                true,
                "{2,2,4}, target=6, k=2"
        );

        check(
                sol.subsetSumAtMostKEven(new int[]{1, 2, 7}, 10, 1),
                true,
                "{1,2,7}, target=10, k=1"
        );

        check(
                sol.subsetSumAtMostKEven(new int[]{8, 10, 3}, 21, 2),
                true,
                "{8,10,3}, target=21, k=2"
        );

        check(
                sol.subsetSumAtMostKEven(new int[]{8, 10, 3}, 21, 1),
                false,
                "{8,10,3}, target=21, k=1"
        );

        check(
                sol.subsetSumAtMostKEven(new int[]{1, 1, 1}, 2, 0),
                true,
                "{1,1,1}, target=2, k=0"
        );

        check(
                sol.subsetSumAtMostKEven(new int[]{2, 4, 6}, 5, 2),
                false,
                "Target not achievable"
        );
    }
}

