package subsetsumvariations.atleastonemultipleofk;



import java.util.Arrays;

class Solution2 {



    public boolean find(int[] nums,int target,int k,int[][][] dp){

        dp[nums.length][0][0] = 1;

        dp[nums.length][0][1] = 0;

        for(int i=nums.length-1;i>=0;i--){

            for(int s=0;s<=target;s++){

                int pick0 = 0;
                int notPick0= 0;
                int pick1 = 0;
                int notPick1 = 0;

                if(nums[i]<=s){

                    if(nums[i]%k==0) {

                        pick1 = (dp[i + 1][s - nums[i]][0] == 1 || dp[i + 1][s - nums[i]][1] == 1) ? 1 : 0;
                        pick0 = 0;

                    }
                    else
                    {
                        pick1 = dp[i+1][s-nums[i]][1];
                        pick0 = dp[i+1][s-nums[i]][0];
                    }
                }

                notPick1 = dp[i+1][s][1];
                notPick0 = dp[i+1][s][0];

                dp[i][s][0] = (notPick0 == 1 || pick0 == 1) ? 1 : 0;
                dp[i][s][1] = (notPick1 ==1 || pick1 == 1) ? 1 : 0;
            }
        }

        return dp[0][target][1] ==1;

    }

    public boolean subsetSumMultipleOfK(int[] nums, int target, int k) {

        // Your code here

        int[][][] dp = new int[nums.length+1][target+1][2];




        return find(nums,target,k,dp);

    }

}

public class SubsetSumWithAtleastOneMultipleOfKTabulation {

    static void check(boolean result, boolean expected, String label) {
        String status = result == expected
                ? "PASS"
                : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {

        Solution2 sol = new Solution2();

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

