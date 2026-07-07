package subsetsumvariations.atleastoneeven;



import java.util.Arrays;

class Solution2 {




    public boolean subsetSumEven(int[] nums, int target) {


        int[][][] dp = new int[nums.length+1][target+1][2];


        if(nums.length==1)
            return nums[0]%2==0 && nums[0]==target;


        dp[nums.length][0][1] = 0;

        dp[nums.length][0][0] = 1;




        for(int i=nums.length-1;i>=0;i--)
        {

            for(int s= 0 ;s<=target;s++)
            {

                int pick1 = 0;
                int notPick1 = 0;
                int pick2= 0;
                int notPick2=0;

                if(nums[i]<=s)
                {



                   if(nums[i]%2==0){

                               pick1 = (dp[i+1][s-nums[i]][1] + dp[i+1][s-nums[i]][0]);
                               pick2=0;
                   }
                   else {
                       pick1 = dp[i + 1][s - nums[i]][1];
                       pick2 = dp[i + 1][s - nums[i]][0];
                   }
                }

                    notPick1 =  dp[i + 1][s][1];

                   notPick2=  dp[i + 1][s][0];

                dp[i][s][1] = pick1+notPick1;

                dp[i][s][0] = pick2+notPick2;
            }

        }


        return dp[0][target][1] == 1 ;


    }
}


public class SubsetSumAtLeastOneEvenTabulation {

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

        Solution2 sol = new Solution2();


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

