package search_insert_position;

class Solution {
    private int searchInsert(int[] nums, int target, int start, int end) {
        int mid = (start + end) / 2;
        if (start <= end) {
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                return searchInsert(nums, target, start, mid - 1);
            } else {
                return searchInsert(nums, target, mid + 1, end);
            }
        }
        return start;
    }

    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }
}

/*
class Solution {
    public int searchInsert(int[] nums, int target) {''
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (end + start) / 2;
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) end = mid - 1;
            else start = mid + 1;
        }

        return start;
    }
}
*/
