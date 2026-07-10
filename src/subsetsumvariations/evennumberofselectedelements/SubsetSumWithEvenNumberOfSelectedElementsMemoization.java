package subsetsumvariations.evennumberofselectedelements;


import java.util.Arrays;

class Solution1 {



    public boolean find(int index,int[] nums,int target,int selectedCount,int[][][] dp){

        if(index==nums.length){

            if(target==0 && selectedCount%2==0)
                return true;

            return false;

        }

        if(dp[index][target][selectedCount]!=-1)
            return dp[index][target][selectedCount] == 1;

        boolean pick = false;

        if(nums[index]<=target)
            pick = find(index+1,nums,target-nums[index],selectedCount+1,dp);

        boolean notPick = find(index+1,nums,target,selectedCount,dp);

        dp[index][target][selectedCount] = pick || notPick?1:0;

        return pick || notPick;
    }

    public boolean subsetSumEvenSelected(int[] nums, int target) {

        int[][][] dp = new int[nums.length][target+1][nums.length+1];


        for(int[][] a : dp){
            for(int[] b:a)
                Arrays.fill(b,-1);
        }

        return find(0,nums,target,0,dp);


    }

}

public class SubsetSumWithEvenNumberOfSelectedElementsMemoization{

    static void check(boolean result, boolean expected, String label) {
        String status = result == expected
                ? "\u001B[32mPASS\u001B[0m"
                : "\u001B[31mFAIL\u001B[0m (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {

        Solution1 sol = new Solution1();

        check(
                sol.subsetSumEvenSelected(new int[]{}, 0),
                true,
                "Empty array, target=0"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{}, 5),
                false,
                "Empty array, target=5"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{5}, 5),
                false,
                "{5}, target=5"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{5}, 0),
                true,
                "{5}, target=0"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{2}, 2),
                false,
                "{2}, target=2"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{2,3}, 5),
                true,
                "{2,3}, target=5"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{2,3}, 2),
                false,
                "{2,3}, target=2"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{1,2,3}, 3),
                true,
                "{1,2,3}, target=3"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{1,2,3}, 6),
                false,
                "{1,2,3}, target=6"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{1,2,3}, 0),
                true,
                "Empty subset"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{2,4,6}, 6),
                true,
                "{2,4,6}, target=6"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{2,4,6}, 10),
                true,
                "{4,6}"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{2,4,6}, 12),
                false,
                "{2,4,6}"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{1,3,5,7}, 8),
                true,
                "{1,7}"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{1,3,5,7}, 16),
                true,
                "{1,3,5,7}"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{1,2,4,8}, 10),
                true,
                "{2,8}"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{1,2,4,8}, 15),
                true,
                "{1,2,4,8}"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{3,5,7,9}, 24),
                true,
                "{3,5,7,9}"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{2,5,6,9}, 11),
                true,
                "{2,9}"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{1,2,5,6}, 8),
                true,
                "{2,6}"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{4,6,8,10}, 28),
                true,
                "{4,6,8,10}"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{1,1,1,1}, 2),
                true,
                "{1,1}"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{2,2,2,2}, 4),
                true,
                "{2,2}"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{5,10,15,20}, 30),
                true,
                "{10,20}"
        );

        check(
                sol.subsetSumEvenSelected(new int[]{2,3,5,7,11}, 18),
                true,
                "{7,11}"
        );
    }
}