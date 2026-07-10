package subsetsumvariations.nothreeconsecutiveelements;


import java.util.Arrays;

class Solution1 {

    public boolean find(int index,int[] nums,int target,int[] taken,int[][] dp){

        if(index==nums.length){
            return target==0;
        }


        boolean pick = false;

        if(dp[index][target]!=-1)
            return dp[index][target]==1;

        if(nums[index]<=target) {
            if (index >= 2) {
                if (taken[index - 1] !=1 || taken[index - 2] != 1) {
                    taken[index] = 1;
                    pick = find(index + 1, nums, target - nums[index], taken,dp);
                    taken[index] = 0;
                }

            } else {
                taken[index] = 1;
                pick = find(index + 1, nums, target - nums[index], taken,dp);
                taken[index] = 0;
            }
        }

        boolean notPick = find(index+1,nums,target,taken,dp);

        dp[index][target] = (pick || notPick) ? 1 : 0;

        return  pick || notPick;
    }


    public boolean subsetSumNoThreeConsecutive(int[] nums, int target) {


        if(target==0)
            return true;

        int[][] dp = new int[nums.length][target+1];
        for(int[] a:dp)
            Arrays.fill(a,-1);

        return find(0,nums,target,new int[nums.length],dp);
    }

}

public class SubsetSumWithoutThreeConsecutiveElementsMemoization {

    static void check(boolean result, boolean expected, String label) {
        String status = result == expected
                ? "\u001B[32mPASS\u001B[0m"
                : "\u001B[31mFAIL\u001B[0m (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {

        Solution1 sol = new Solution1();

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{}, 0),
                true,
                "Empty array, target=0"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{}, 5),
                false,
                "Empty array, target=5"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{5}, 5),
                true,
                "{5}, target=5"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{5}, 0),
                true,
                "{5}, target=0"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{1,2}, 3),
                true,
                "{1,2}, target=3"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{1,2,3}, 6),
                false,
                "{1,2,3}, target=6"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{1,2,3}, 5),
                true,
                "{1,2,3}, target=5"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{1,2,3}, 4),
                true,
                "{1,2,3}, target=4"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{2,4,6}, 12),
                false,
                "{2,4,6}, target=12"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{2,4,6}, 10),
                true,
                "{2,4,6}, target=10"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{1,2,3,4}, 10),
                false,
                "{1,2,3,4}, target=10"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{1,2,3,4}, 9),
                false,
                "{1,2,3,4}, target=9"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{1,2,3,4}, 6),
                true,
                "{1,2,3,4}, target=6"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{5,5,5,5}, 20),
                false,
                "{5,5,5,5}, target=20"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{5,5,5,5}, 15),
                true,
                "{5,5,5,5}, target=15"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{5,5,5,5}, 10),
                true,
                "{5,5,5,5}, target=10"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{1,1,1,1}, 3),
                true,
                "{1,1,1,1}, target=3"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{2,1,2,1,2}, 8),
                false,
                "{2,1,2,1,2}, target=8"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{2,1,2,1,2}, 6),
                true,
                "{2,1,2,1,2}, target=6"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{3,7,2,5}, 17),
                false,
                "{3,7,2,5}, target=17"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{3,7,2,5}, 12),
                true,
                "{3,7,2,5}, target=12"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{10,1,10}, 21),
                false,
                "{10,1,10}, target=21"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{10,1,10,1}, 22),
                false,
                "{10,1,10,1}, target=22"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{1,2,3,4,5}, 15),
                false,
                "{1,2,3,4,5}, target=15"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{1,2,3,4,5}, 12),
                true,
                "{1,2,3,4,5}, target=12"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{6,4,2,8}, 20),
                false,
                "{6,4,2,8}, target=20"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{6,4,2,8}, 12),
                true,
                "{6,4,2,8}, target=12"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{9,9,9}, 27),
                false,
                "{9,9,9}, target=27"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{9,9,9,9}, 27),
                true,
                "{9,9,9,9}, target=27"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{2,5,1,6,2}, 16),
                false,
                "{2,5,1,6,2}, target=16"
        );

        check(
                sol.subsetSumNoThreeConsecutive(new int[]{2,5}, 2),
                true,
                "{2,5}, target=2"
        );
    }
}
