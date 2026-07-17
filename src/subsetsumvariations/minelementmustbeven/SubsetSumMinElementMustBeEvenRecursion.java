package subsetsumvariations.minelementmustbeven;


class Solution {
//    {1,2,3,4}, target=6 => FAIL (got false) | expected=true

    public boolean find(int index, int[] nums, int target, int minPickedIndex) {


        if(index==nums.length){
            if(target == 0 && nums[minPickedIndex] % 2 == 0)
                return true;

            return false;
        }

        boolean pick = false;
        int newIndex = -1;
        if(nums[index]<=target) {
            if(minPickedIndex==-1)
                    newIndex = index;
            else
                newIndex = minPickedIndex;

            pick = find(index + 1, nums, target - nums[index], nums[index] <= nums[newIndex] ? index : newIndex);
        }

        boolean notPick = find(index+1,nums,target,minPickedIndex);

        return pick || notPick;

    }

    public boolean subsetSumMinEven(int[] nums, int target) {

        if(nums.length==0)
            return false;
        return find(0,nums,target,-1);
    }

}

public class SubsetSumMinElementMustBeEvenRecursion {

    static void check(boolean result, boolean expected, String label) {
        String status = result == expected
                ? "\u001B[32mPASS\u001B[0m"
                : "\u001B[31mFAIL\u001B[0m (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        // --- Empty / single-element arrays ---

        check(
                sol.subsetSumMinEven(new int[]{}, 0),
                false,
                "Empty array, target=0"
        );

        check(
                sol.subsetSumMinEven(new int[]{}, 5),
                false,
                "Empty array, target=5"
        );

        check(
                sol.subsetSumMinEven(new int[]{2}, 2),
                true,
                "{2}, target=2"
        );

        check(
                sol.subsetSumMinEven(new int[]{3}, 3),
                false,
                "{3}, target=3"
        );

        // --- Two-element arrays ---

        check(
                sol.subsetSumMinEven(new int[]{2, 3}, 5),
                true,
                "{2,3}, target=5"
        );

        check(
                sol.subsetSumMinEven(new int[]{2, 4}, 6),
                true,
                "{2,4}, target=6"
        );

        check(
                sol.subsetSumMinEven(new int[]{1, 3}, 4),
                false,
                "{1,3}, target=4"
        );

        check(
                sol.subsetSumMinEven(new int[]{3, 5}, 8),
                false,
                "{3,5}, target=8"
        );

        // --- Three-element arrays ---

        check(
                sol.subsetSumMinEven(new int[]{2, 3, 4}, 5),
                true,
                "{2,3,4}, target=5"
        );

        check(
                sol.subsetSumMinEven(new int[]{2, 3, 4}, 9),
                true,
                "{2,3,4}, target=9"
        );

        check(
                sol.subsetSumMinEven(new int[]{2, 4, 6}, 12),
                true,
                "{2,4,6}, target=12"
        );

        check(
                sol.subsetSumMinEven(new int[]{1, 3, 5}, 9),
                false,
                "{1,3,5}, target=9"
        );

        check(
                sol.subsetSumMinEven(new int[]{2, 3, 5}, 10),
                true,
                "{2,3,5}, target=10"
        );

        check(
                sol.subsetSumMinEven(new int[]{4, 6, 3}, 10),
                true,
                "{4,6,3}, target=10"
        );

        // --- Four-element arrays ---

        check(
                sol.subsetSumMinEven(new int[]{2, 5, 6, 7}, 20),
                true,
                "{2,5,6,7}, target=20"
        );

        check(
                sol.subsetSumMinEven(new int[]{1, 2, 3, 4}, 10),
                false,
                "{1,2,3,4}, target=10"
        );

        check(
                sol.subsetSumMinEven(new int[]{1, 2, 3, 4}, 6),
                true,
                "{1,2,3,4}, target=6"
        );

        check(
                sol.subsetSumMinEven(new int[]{1, 2, 3, 4}, 7),
                false,
                "{1,2,3,4}, target=7"
        );

        check(
                sol.subsetSumMinEven(new int[]{1, 2, 3, 4}, 5),
                true,
                "{1,2,3,4}, target=5"
        );

        check(
                sol.subsetSumMinEven(new int[]{5, 7, 2, 4}, 18),
                true,
                "{5,7,2,4}, target=18"
        );

        check(
                sol.subsetSumMinEven(new int[]{5, 7, 2, 4}, 9),
                true,
                "{5,7,2,4}, target=9"
        );

        check(
                sol.subsetSumMinEven(new int[]{8, 6, 5, 3}, 22),
                false,
                "{8,6,5,3}, target=22"
        );

        check(
                sol.subsetSumMinEven(new int[]{8, 6, 5, 3}, 14),
                true,
                "{8,6,5,3}, target=14"
        );

        // --- Arrays with duplicates ---

        check(
                sol.subsetSumMinEven(new int[]{2, 2, 3, 3}, 10),
                true,
                "{2,2,3,3}, target=10"
        );

        check(
                sol.subsetSumMinEven(new int[]{2, 2, 3, 3}, 7),
                true,
                "{2,2,3,3}, target=7"
        );

        check(
                sol.subsetSumMinEven(new int[]{2, 2, 2, 3}, 9),
                true,
                "{2,2,2,3}, target=9"
        );

        // --- Five-element arrays ---

        check(
                sol.subsetSumMinEven(new int[]{2, 5, 1, 6, 2}, 10),
                true,
                "{2,5,1,6,2}, target=10"
        );

        check(
                sol.subsetSumMinEven(new int[]{2, 4, 1, 3}, 10),
                false,
                "{2,4,1,3}, target=10"
        );

        check(
                sol.subsetSumMinEven(new int[]{2, 4, 1, 3}, 7),
                false,
                "{2,4,1,3}, target=7"
        );

        check(
                sol.subsetSumMinEven(new int[]{2, 4, 1, 3}, 6),
                true,
                "{2,4,1,3}, target=6"
        );
    }
}
