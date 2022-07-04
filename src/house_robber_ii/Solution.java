package house_robber_ii;

class Solution {
    public int rob(int[] nums, int start, int end) {

        int[] arr = new int[end + 1];
        arr[start] = nums[start];
        arr[start + 1] = Integer.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; ++i) {
            arr[i] = Integer.max(nums[i] + arr[i - 2], arr[i - 1]);
        }

        return arr[arr.length - 1];
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Integer.max(nums[0], nums[1]);
        }

        return Integer.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
}