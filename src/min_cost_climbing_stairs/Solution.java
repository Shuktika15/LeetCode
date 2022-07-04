package min_cost_climbing_stairs;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] arr = new int[cost.length];
        if (cost.length == 1)
            return 0;
        arr[0] = cost[0];
        arr[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {

            arr[i] = cost[i] + Integer.min(arr[i - 1], arr[i - 2]);
        }
        return Integer.min(arr[cost.length - 1], arr[cost.length - 2]);
    }

}
