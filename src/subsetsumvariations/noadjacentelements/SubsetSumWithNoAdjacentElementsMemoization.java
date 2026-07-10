package subsetsumvariations.noadjacentelements;


import java.lang.reflect.Array;
import java.util.Arrays;

class Solution1 {

    public boolean find(int index,int[] nums,int target,boolean isPrevTaken,int[][][] dp){

        if(index==nums.length){
            return target==0;
        }

        boolean pick = false;

        if(dp[index][target][isPrevTaken?1:0]!=-1)
            return dp[index][target][isPrevTaken?1:0]==1;

        if(nums[index]<=target && !isPrevTaken)
            pick = find(index+1,nums,target-nums[index],true,dp);

        boolean notPick = find(index+1,nums,target,false,dp);

        dp[index][target][isPrevTaken?1:0] = (pick || notPick)?1:0;

        return pick || notPick;


    }

    public boolean subsetSumNoAdjacent(int[] nums, int target) {

        int[][][] dp = new int[nums.length][target+1][2];

        for(int[][] a : dp){
            for(int[] b:a)
                Arrays.fill(b,-1);
        }

        return find(0,nums,target,false,dp);

    }

}

public class SubsetSumWithNoAdjacentElementsMemoization {

    static void check(boolean result, boolean expected, String label) {
        String status = result == expected
                ? "\u001B[32mPASS\u001B[0m"
                : "\u001B[31mFAIL\u001B[0m (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {

        Solution1 sol = new Solution1();

        check(
                sol.subsetSumNoAdjacent(new int[]{}, 0),
                true,
                "Empty array, target=0"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{}, 5),
                false,
                "Empty array, target=5"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{5}, 5),
                true,
                "{5}, target=5"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{5}, 0),
                true,
                "{5}, target=0"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{5}, 3),
                false,
                "{5}, target=3"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{1,2,3,4}, 5),
                true,
                "{1,2,3,4}, target=5"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{1,2,3,4}, 6),
                true,
                "{1,2,3,4}, target=6"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{2,4,6}, 6),
                true,
                "{2,4,6}, target=6"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{2,4,6}, 8),
                true,
                "{2,4,6}, target=8"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{2,4,6}, 12),
                false,
                "{2,4,6}, target=12"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{1,1,1}, 2),
                true,
                "{1,1,1}, target=2"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{1,1}, 2),
                false,
                "{1,1}, target=2"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{3,7,2,5}, 8),
                true,
                "{3,7,2,5}, target=8"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{3,7,2,5}, 9),
                false,
                "{3,7,2,5}, target=9"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{10,1,10}, 20),
                true,
                "{10,1,10}, target=20"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{4,1,2,7}, 11),
                true,
                "{4,1,2,7}, target=11"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{4,1,2,7}, 9),
                false,
                "{4,1,2,7}, target=9"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{8,3,5,2}, 10),
                true,
                "{8,3,5,2}, target=10"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{8,3,5,2}, 13),
                true,
                "{8,3,5,2}, target=13"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{8,3,5,2}, 15),
                false,
                "{8,3,5,2}, target=15"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{1,2,3,4,5}, 9),
                true,
                "{1,2,3,4,5}, target=9"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{1,2,3,4,5}, 12),
                false,
                "{1,2,3,4,5}, target=12"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{2,1,2,1,2}, 6),
                true,
                "{2,1,2,1,2}, target=6"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{2,1,2,1,2}, 5),
                false,
                "{2,1,2,1,2}, target=5"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{6,4,2,8}, 14),
                true,
                "{6,4,2,8}, target=14"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{6,4,2,8}, 12),
                true,
                "{6,4,2,8}, target=12"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{9,1,9}, 18),
                true,
                "{9,1,9}, target=18"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{9,9}, 18),
                false,
                "{9,9}, target=18"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{1,3,5,7}, 8),
                true,
                "{1,3,5,7}, target=8"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{1,3,5,7}, 10),
                true,
                "{1,3,5,7}, target=10"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{1,3,5,7}, 12),
                false,
                "{1,3,5,7}, target=12"
        );

        check(
                sol.subsetSumNoAdjacent(new int[]{2,5,1,6,2}, 10),
                false,
                "{2,5,1,6,2}, target=10"
        );
    }
}
