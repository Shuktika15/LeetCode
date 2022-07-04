package house_robber;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<Integer, Integer> map = new HashMap<>();

    public int rob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (map.get(index) != null) {
            return map.get(index);
        }
        int sum1 = nums[index];
        sum1 += rob(nums, index + 2);
        int sum2 = rob(nums, index + 1);
        map.put(index, Math.max(sum1, sum2));
        return map.get(index);
    }

    public int rob(int[] nums) {
        return rob(nums, 0);
    }
}
