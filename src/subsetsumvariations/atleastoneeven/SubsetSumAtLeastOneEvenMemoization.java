package subsetsumvariations.atleastoneeven;


import java.util.Arrays;

class Solution1 {


    public boolean find(int index,int target,int[] nums,boolean hasEven,int[][][] dp)
    {


        if(index==nums.length){
            if(target==0 && hasEven)
                return true;
            else
                return false;
        }

        boolean left = false;

        if(dp[index][target][hasEven?1:0]!=-1)
            return dp[index][target][hasEven?1:0]==1;

        if(nums[index]<=target)
            left = find(index+1,target-nums[index],nums,hasEven||nums[index]%2==0,dp);

        boolean right = find(index+1,target,nums,hasEven,dp);

         dp[index][target][hasEven?1:0]= left || right ? 1 : 0;
            return left||right;


    }

    public boolean subsetSumEven(int[] nums, int target) {


        int[][][] dp = new int[nums.length][target+1][2];
        for(int[][] a: dp)
        {
            for(int[] b:a)
                Arrays.fill(b,-1);
        }



        return find(0,target,nums,false,dp);


    }
}


public class SubsetSumAtLeastOneEvenMemoization {

    static void check(boolean result,
                      boolean expected,
                      String label) {

        String status =
                result == expected ?
                        "PASS" :
                        "FAIL (got " + result + ")";

        System.out.println(label +
                " => " +
                status +
                " | expected=" +
                expected);
    }

    public static void main(String[] args) {

        Solution1 sol = new Solution1();


        check(sol.subsetSumEven(new int[]{1,3,5,6},11),
                true,
                "[1,3,5,6],11");

        check(sol.subsetSumEven(new int[]{1,3,5},8),
                false,
                "[1,3,5],8");

        check(sol.subsetSumEven(new int[]{2},2),
                true,
                "[2],2");

        check(sol.subsetSumEven(new int[]{1},1),
                false,
                "[1],1");

        check(sol.subsetSumEven(new int[]{2,4,6},5),
                false,
                "[2,4,6],5");

        check(sol.subsetSumEven(new int[]{7,2,9},9),
                true,
                "[7,2,9],9");

        check(sol.subsetSumEven(new int[]{4,5,6},10),
                true,
                "[4,5,6],10");

        check(sol.subsetSumEven(new int[]{5,7,9},12),
                false,
                "[5,7,9],12");

    }
}
