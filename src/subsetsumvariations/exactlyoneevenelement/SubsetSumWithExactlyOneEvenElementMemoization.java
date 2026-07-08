package subsetsumvariations.exactlyoneevenelement;


import java.util.Arrays;

class Solution1 {


    public  boolean find(int index,int[] nums,int target,int count,int[][][] dp){

        if(index==nums.length){
            if(target==0)
                return count==1;
            return false;
        }

        if(dp[index][target][count]!=-1)
            return dp[index][target][count]==1 ? true : false;

        boolean pick = false;

        if(nums[index]<=target)
            pick = find(index+1,nums,target-nums[index],nums[index]%2==0?count+1:count,dp);

        boolean notPick = find(index+1,nums,target,count,dp);

        return pick || notPick;
    }

    public boolean subsetSumExactlyOneEven(int[] nums, int target) {

        // Your code here
        int[][][] dp = new int[nums.length][target+1][nums.length];
        for(int[][] a : dp)
            for(int[] b : a)
                Arrays.fill(b,-1);

        return find(0,nums,target,0,dp);
    }

}

public class SubsetSumWithExactlyOneEvenElementMemoization {

    static void check(boolean result, boolean expected, String label) {
        String status = result == expected
                ? "PASS"
                : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {

        Solution1 sol = new Solution1();

        check(
                sol.subsetSumExactlyOneEven(new int[]{2, 3, 5}, 10),
                true,
                "{2,3,5}, target=10"
        );

        check(
                sol.subsetSumExactlyOneEven(new int[]{2, 4, 5}, 11),
                false,
                "{2,4,5}, target=11"
        );

        check(
                sol.subsetSumExactlyOneEven(new int[]{1, 3, 5}, 9),
                false,
                "{1,3,5}, target=9"
        );

        check(
                sol.subsetSumExactlyOneEven(new int[]{6}, 6),
                true,
                "Single even"
        );

        check(
                sol.subsetSumExactlyOneEven(new int[]{2, 4}, 6),
                false,
                "{2,4}, target=6"
        );

        check(
                sol.subsetSumExactlyOneEven(new int[]{1, 2, 7}, 10),
                true,
                "{1,2,7}, target=10"
        );

        check(
                sol.subsetSumExactlyOneEven(new int[]{2, 2, 3}, 5),
                true,
                "{2,2,3}, target=5"
        );

        check(
                sol.subsetSumExactlyOneEven(new int[]{2, 2, 4}, 4),
                true,
                "{2,2,4}, target=4"
        );

        check(
                sol.subsetSumExactlyOneEven(new int[]{2, 2, 4}, 6),
                false,
                "{2,2,4}, target=6"
        );

        check(
                sol.subsetSumExactlyOneEven(new int[]{1, 5, 7, 8}, 13),
                true,
                "{1,5,7,8}, target=13"
        );

        check(
                sol.subsetSumExactlyOneEven(new int[]{1, 5, 7, 8}, 12),
                false,
                "{1,5,7,8}, target=12"
        );

        check(
                sol.subsetSumExactlyOneEven(new int[]{8, 10, 3}, 21),
                false,
                "{8,10,3}, target=21"
        );

        check(
                sol.subsetSumExactlyOneEven(new int[]{1, 1, 2, 1}, 4),
                true,
                "{1,1,2,1}, target=4"
        );

        check(
                sol.subsetSumExactlyOneEven(new int[]{1, 1, 1, 1}, 2),
                false,
                "{1,1,1,1}, target=2"
        );

        check(
                sol.subsetSumExactlyOneEven(new int[]{4}, 5),
                false,
                "Target not achievable"
        );
    }
}
