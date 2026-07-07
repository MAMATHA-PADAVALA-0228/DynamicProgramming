package subsetsumvariations.atleastonemultipleofk;


import java.util.Arrays;

class Solution1 {



    public boolean find(int index,int[] nums,int target,int k,boolean isMutiple,int[][][] dp){

        if(index==nums.length){

            if(isMutiple)
                return target==0;
            return false;

        }
        boolean pick = false;

        if(dp[index][target][isMutiple?1:0]!=-1)
            return dp[index][target][isMutiple?1:0]==1;

        if(nums[index]<=target)
            pick = find(index+1,nums,target-nums[index],k,nums[index]%k==0 || isMutiple,dp);

        boolean notPick  = find(index+1,nums,target,k,isMutiple,dp);

        dp[index][target][isMutiple?1:0] = pick || notPick ? 1 : 0;

        return pick||notPick;
    }

    public boolean subsetSumMultipleOfK(int[] nums, int target, int k) {

        // Your code here

        int[][][] dp = new int[nums.length][target+1][2];

        for(int[][] a : dp)
            for(int[] b : a)
                Arrays.fill(b,-1);

        return find(0,nums,target,k,false,dp);

    }

}

public class SubsetSumWithAtleastOneMultipleOfKMemoization {

    static void check(boolean result, boolean expected, String label) {
        String status = result == expected
                ? "PASS"
                : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {

        Solution1 sol = new Solution1();

        check(
                sol.subsetSumMultipleOfK(new int[]{2, 3, 6}, 8, 3),
                true,
                "{2,3,6}, target=8, k=3"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{2, 5, 7}, 7, 2),
                true,
                "{2,5,7}, target=7, k=2"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{4}, 4, 2),
                true,
                "Single multiple of k"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{5}, 5, 2),
                false,
                "Single non-multiple"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{1, 4, 5}, 9, 4),
                true,
                "{1,4,5}, target=9, k=4"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{1, 5, 7}, 12, 4),
                false,
                "{1,5,7}, target=12, k=4"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{6, 2, 1}, 9, 3),
                true,
                "{6,2,1}, target=9, k=3"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{2, 4, 8}, 12, 5),
                false,
                "{2,4,8}, target=12, k=5"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{10, 15, 7}, 22, 5),
                true,
                "{10,15,7}, target=22, k=5"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{1, 2, 3}, 6, 7),
                false,
                "{1,2,3}, target=6, k=7"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{5, 10, 15}, 25, 5),
                true,
                "{5,10,15}, target=25, k=5"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{1, 1, 1}, 2, 1),
                true,
                "{1,1,1}, target=2, k=1"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{8}, 7, 4),
                false,
                "Target not achievable"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{9, 14, 20}, 34, 7),
                true,
                "{9,14,20}, target=34, k=7"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{2, 4, 6}, 5, 2),
                false,
                "No subset equals target"
        );


        check(
                sol.subsetSumMultipleOfK(new int[]{5}, 0, 5),
                false,
                "Empty subset should not satisfy the condition"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{6}, 6, 3),
                true,
                "Single element is a multiple of k"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{7}, 7, 3),
                false,
                "Single element is not a multiple of k"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{2,3,4}, 5, 2),
                true,
                "{2,3}"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{3,5,7}, 8, 2),
                false,
                "{3,5}"
        );

        check(
                sol.subsetSumMultipleOfK(new int[]{4,6,8}, 18, 4),
                true,
                "{4,6,8}"
        );
    }
}
