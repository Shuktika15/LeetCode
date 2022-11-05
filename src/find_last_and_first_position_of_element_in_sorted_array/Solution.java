package find_last_and_first_position_of_element_in_sorted_array;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int mid = nums.length / 2;
        for (int start = 0, end = nums.length - 1; start <= end; ) {
            if (target == nums[mid]) {
                int s = mid, e = mid;
                while (s >= 0 && target == nums[s]) {
                    s--;
                }
                s++;
                while (e < nums.length && target == nums[e]) {
                    e++;
                }
                e--;
                return new int[]{s, e};
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return new int[]{-1, -1};
    }
}
