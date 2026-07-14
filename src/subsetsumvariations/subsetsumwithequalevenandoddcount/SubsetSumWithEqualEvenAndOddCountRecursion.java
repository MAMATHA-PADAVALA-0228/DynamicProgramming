package subsetsumvariations.subsetsumwithequalevenandoddcount;


class Solution {

    public boolean find(int index,int[] nums,int target,int countEven,int countOdd){

        if(index==nums.length)
        {
            if(target==0 && countEven==countOdd)
                return true;

            return false;
        }

        boolean pick = false;

        if(nums[index]<=target)
            pick = find(index+1,nums,target-nums[index],nums[index]%2==0?countEven+1:countEven,nums[index]%2!=0?countOdd+1:countOdd);

        boolean notPick = find(index+1,nums,target,countEven,countOdd);

        return pick || notPick;
    }

    public boolean subsetSumEqualEvenOdd(int[] nums, int target) {

        return find(0,nums,target,0,0);

    }

}

public class SubsetSumWithEqualEvenAndOddCountRecursion {

    static void check(boolean result, boolean expected, String label) {
        String status = result == expected
                ? "\u001B[32mPASS\u001B[0m"
                : "\u001B[31mFAIL\u001B[0m (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        check(
                sol.subsetSumEqualEvenOdd(new int[]{}, 0),
                true,
                "Empty array, target=0"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{}, 5),
                false,
                "Empty array, target=5"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{2}, 2),
                false,
                "{2}, target=2"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{3}, 3),
                false,
                "{3}, target=3"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{2,3}, 5),
                true,
                "{2,3}, target=5"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{2,4}, 6),
                false,
                "{2,4}, target=6"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{1,3}, 4),
                false,
                "{1,3}, target=4"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{2,3,4}, 5),
                true,
                "{2,3,4}, target=5"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{2,3,4}, 9),
                false,
                "{2,3,4}, target=9"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{2,4,6}, 12),
                false,
                "{2,4,6}, target=12"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{1,3,5}, 9),
                false,
                "{1,3,5}, target=9"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{2,5,6,7}, 20),
                true,
                "{2,5,6,7}, target=20"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{2,5,6}, 13),
                false,
                "{2,5,6}, target=13"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{2,5,6}, 8),
                false,
                "{2,5,6}, target=8"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{1,2,3,4}, 10),
                true,
                "{1,2,3,4}, target=10"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{1,2,3,4}, 6),
                false,
                "{1,2,3,4}, target=6"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{1,2,3,4}, 7),
                true,
                "{1,2,3,4}, target=7"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{1,2,3,4}, 5),
                true,
                "{1,2,3,4}, target=5"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{2,2,3,3}, 10),
                true,
                "{2,2,3,3}, target=10"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{2,2,3,3}, 7),
                false,
                "{2,2,3,3}, target=7"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{2,2,2,3}, 9),
                false,
                "{2,2,2,3}, target=9"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{5,7,2,4}, 18),
                true,
                "{5,7,2,4}, target=18"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{5,7,2,4}, 12),
                false,
                "{5,7,2,4}, target=12"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{5,7,2,4}, 9),
                true,
                "{5,7,2,4}, target=9"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{8,6,5,3}, 22),
                true,
                "{8,6,5,3}, target=22"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{8,6,5,3}, 14),
                false,
                "{8,6,5,3}, target=14"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{2,4,1,3}, 10),
                true,
                "{2,4,1,3}, target=10"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{2,4,1,3}, 7),
                true,
                "{2,4,1,3}, target=7"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{2,4,1,3}, 6),
                false,
                "{2,4,1,3}, target=6"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{2,5,1,6,2}, 10),
                true,
                "{2,5,1,6,2}, target=10"
        );

        check(
                sol.subsetSumEqualEvenOdd(new int[]{}, 0),
        true,
                "Empty array, target=0"
);
    }
}
