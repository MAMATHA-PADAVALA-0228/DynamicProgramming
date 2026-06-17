package climbingstairsvariations.minCostClimbingStairs;

class Solution {

    public int find(int index,int[] cost){

        if(index==cost.length-1)
            return cost[index];

        if(index==cost.length)
            return 0;


        int left = cost[index] + find(index+1,cost);

        int right = Integer.MAX_VALUE;

        if(index<= cost.length-2)
            right = cost[index] + find(index+2,cost);

        return Math.min(left,right);
    }

    public int minCostClimbingStairs(int[] cost) {
        // Your code here
        return Math.min(find(0,cost),find(1,cost));
    }
}

class Main {
    static void check(int result, int expected, String label) {
        String status = result == expected ? "PASS" : "FAIL (got " + result + ")";
        System.out.println(label + " => " + status + " | expected=" + expected);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        check(sol.minCostClimbingStairs(new int[]{10,15,20}),                      15, "cost=[10,15,20]");
        check(sol.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}),      6, "zigzag");
        check(sol.minCostClimbingStairs(new int[]{0,0}),                             0, "zero cost");
        check(sol.minCostClimbingStairs(new int[]{1,2}),                             1, "pick cheaper");
        check(sol.minCostClimbingStairs(new int[]{10,15}),                          10, "single hop");
    }
}
