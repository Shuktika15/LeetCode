package two_sum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; map.put(nums[i],i),i++){
            int j = target-nums[i];
            if(map.containsKey(j) && map.get(j)!=i)
                return new int[]{i,map.get(j)};
        }
        return new int[]{};
    }
}
