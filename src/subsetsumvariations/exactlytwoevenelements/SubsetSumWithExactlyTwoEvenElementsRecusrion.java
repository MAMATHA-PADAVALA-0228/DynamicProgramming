package subsetsumvariations.exactlytwoevenelements;



class Solution {

    public boolean find(int index, int[] nums, int target, int evenCount) {

        if(index==nums.length){
            if(target==0)
                return evenCount==2;
            return false;
        }


        boolean pick = false;

        if(nums[index]<=target)
            pick = find(index+1,nums,target-nums[index],nums[index]%2==0 ?evenCount+1:evenCount);

        boolean notPick = find(index+1,nums,target,evenCount);

        return pick || notPick;
    }

    public boolean subsetSumExactlyTwoEven(int[] nums, int target) {

        return find(0, nums, target, 0);
    }
}

public class SubsetSumWithExactlyTwoEvenElementsRecusrion {

    static void check(boolean result, boolean expected, String label) {
        String status = result == expected
                ? "PASS"
                : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        check(
                sol.subsetSumExactlyTwoEven(new int[]{2, 4, 3}, 9),
                true,
                "{2,4,3}, target=9"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{2, 4, 6}, 6),
                true,
                "{2,4,6}, target=6"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{2, 4}, 6),
                true,
                "{2,4}, target=6"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{2, 4, 6}, 12),
                false,
                "{2,4,6}, target=12"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{1, 3, 5}, 9),
                false,
                "{1,3,5}, target=9"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{2, 3, 5}, 10),
                false,
                "{2,3,5}, target=10"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{2, 4, 5}, 11),
                true,
                "{2,4,5}, target=11"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{2, 2, 3}, 7),
                true,
                "{2,2,3}, target=7"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{2, 2, 2}, 4),
                true,
                "{2,2,2}, target=4"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{2, 2, 2}, 6),
                false,
                "{2,2,2}, target=6"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{8}, 8),
                false,
                "Single even"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{1, 2, 4, 7}, 13),
                true,
                "{1,2,4,7}, target=13"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{1, 2, 4, 7}, 11),
                false,
                "{1,2,4,7}, target=11"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{2, 6, 1, 5}, 14),
                true,
                "{2,6,1,5}, target=14"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{2, 6, 8}, 16),
                false,
                "{2,6,8}, target=16"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{1, 1, 2, 4, 1}, 8),
                true,
                "{1,1,2,4,1}, target=8"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{1, 1, 2, 1}, 4),
                false,
                "{1,1,2,1}, target=4"
        );

        check(
                sol.subsetSumExactlyTwoEven(new int[]{4}, 5),
                false,
                "Target not achievable"
        );
    }
}