package subsetsumvariations.ifpreviouspickwasevennextpickmustbeodd;


class Solution {

    public boolean find(int index,int[] nums,int target,boolean isPrevEven){

        if(index==nums.length) return target==0;

        boolean pick = false;

        boolean canPick = false;
        if(nums[index]<=target)
        {

            if(isPrevEven){
                if(nums[index]%2!=0)
                    canPick = true;
            }
            else
                canPick = true;

            if(canPick)
                pick = find(index+1,nums,target-nums[index],nums[index]%2==0);

        }

        boolean notPick = find(index+1,nums,target,isPrevEven);

        return pick || notPick;

    }

    public boolean subsetSumEvenThenOdd(int[] nums, int target) {

        return find(0,nums,target,false);
    }

}

public class SubsetSumIfPreviousPickWasEvenNextPickMustBeOddRecursion {

    static void check(boolean result, boolean expected, String label) {
        String status = result == expected
                ? "\u001B[32mPASS\u001B[0m"
                : "\u001B[31mFAIL\u001B[0m (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {

        Solution sol = new Solution();

        check(
                sol.subsetSumEvenThenOdd(new int[]{}, 0),
                true,
                "Empty array, target=0"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{}, 5),
                false,
                "Empty array, target=5"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{2}, 2),
                true,
                "{2}, target=2"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{3}, 3),
                true,
                "{3}, target=3"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{2,4}, 6),
                false,
                "{2,4}, target=6"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{4,3}, 7),
                true,
                "{4,3}, target=7"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{3,4}, 7),
                true,
                "{3,4}, target=7"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{2,3,4}, 9),
                true,
                "{2,3,4}, target=9"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{2,4,3}, 9),
                false,
                "{2,4,3}, target=9"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{2,4,3}, 7),
                true,
                "{2,4,3}, target=7"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{2,2,3}, 7),
                false,
                "{2,2,3}, target=7"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{1,3,5}, 9),
                true,
                "{1,3,5}, target=9"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{2,1,2,1}, 6),
                true,
                "{2,1,2,1}, target=6"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{2,1,2,2}, 7),
                false,
                "{2,1,2,2}, target=7"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{6,5,4}, 15),
                true,
                "{6,5,4}, target=15"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{6,4,5}, 15),
                false,
                "{6,4,5}, target=15"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{5,6,8}, 19),
                false,
                "{5,6,8}, target=19"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{5,6,7,8}, 26),
                true,
                "{5,6,7,8}, target=26"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{8,7,6,5}, 26),
                true,
                "{8,7,6,5}, target=26"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{8,6,5}, 19),
                false,
                "{8,6,5}, target=19"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{2,5,4,7}, 18),
                true,
                "{2,5,4,7}, target=18"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{2,4,5,7}, 18),
                false,
                "{2,4,5,7}, target=18"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{1,2,4,5}, 12),
                false,
                "{1,2,4,5}, target=12"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{1,2,5,4}, 12),
                true,
                "{1,2,5,4}, target=12"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{2,3,5,7}, 17),
                true,
                "{2,3,5,7}, target=17"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{2,6,5,7}, 20),
                false,
                "{2,6,5,7}, target=20"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{4,1,6,3}, 14),
                true,
                "{4,1,6,3}, target=14"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{4,6,1,3}, 14),
                false,
                "{4,6,1,3}, target=14"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{2,1,4,3,6,5}, 21),
                true,
                "{2,1,4,3,6,5}, target=21"
        );

        check(
                sol.subsetSumEvenThenOdd(new int[]{2,4,1,3,6,5}, 21),
                false,
                "{2,4,1,3,6,5}, target=21"
        );
    }
}
