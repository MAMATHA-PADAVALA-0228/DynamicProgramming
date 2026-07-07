package subsetsumvariations.atleastoneprimenumber;



class Solution {

    public boolean isPrime(int n){

        if(n==1)
            return false;

        for(int i=2;i<n;i++){
            if(n%i==0)
                return false;
        }

        return true;
    }


    public boolean find(int index,int[] nums,int target,boolean hasPrime){

        if(index==nums.length){
            if( target==0 && hasPrime)
                return true;
            return false;
        }

        boolean left = false;
        if(nums[index]<=target)
            left = find(index+1,nums,target-nums[index],hasPrime||isPrime(nums[index]));

        boolean right = find(index+1,nums,target,hasPrime);

        return left||right;




    }

    public boolean subsetSumPrime(int[] nums, int target) {

        return find(0,nums,target,false);


    }

}

public class SubsetSumAtLeastOnePrimeRecursion {

    static void check(boolean result, boolean expected, String label) {
        String status = result == expected
                ? "PASS"
                : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        check(
                sol.subsetSumPrime(new int[]{4, 6, 5}, 11),
                true,
                "{4,6,5}, target=11"
        );

        check(
                sol.subsetSumPrime(new int[]{4, 6, 8}, 10),
                false,
                "{4,6,8}, target=10"
        );

        check(
                sol.subsetSumPrime(new int[]{2}, 2),
                true,
                "Single prime"
        );

        check(
                sol.subsetSumPrime(new int[]{9}, 9),
                false,
                "Single non-prime"
        );

        check(
                sol.subsetSumPrime(new int[]{3, 4, 8}, 7),
                true,
                "{3,4,8}, target=7"
        );

        check(
                sol.subsetSumPrime(new int[]{8, 10}, 18),
                false,
                "{8,10}, target=18"
        );

        check(
                sol.subsetSumPrime(new int[]{1, 2, 4}, 6),
                true,
                "{1,2,4}, target=6"
        );

        check(
                sol.subsetSumPrime(new int[]{1, 4, 6}, 10),
                false,
                "{1,4,6}, target=10"
        );

        check(
                sol.subsetSumPrime(new int[]{11, 7, 4}, 18),
                true,
                "{11,7,4}, target=18"
        );

        check(
                sol.subsetSumPrime(new int[]{15, 21, 25}, 40),
                false,
                "{15,21,25}, target=40"
        );

        check(
                sol.subsetSumPrime(new int[]{2, 3, 4, 5}, 9),
                true,
                "{2,3,4,5}, target=9"
        );

        check(
                sol.subsetSumPrime(new int[]{1, 1, 1}, 2),
                false,
                "{1,1,1}, target=2"
        );

        check(
                sol.subsetSumPrime(new int[]{13}, 12),
                false,
                "{13}, target=12"
        );

        check(
                sol.subsetSumPrime(new int[]{17}, 17),
                true,
                "{17}, target=17"
        );

        check(
                sol.subsetSumPrime(new int[]{2, 4, 6, 8}, 20),
                true,
                "{2,4,6,8}, target=20"
        );
    }
}
