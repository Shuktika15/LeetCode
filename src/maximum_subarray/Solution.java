package maximum_subarray;

class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxSubArray(int[] nums) {
        int maxsofar = 0;
        for (int num : nums) {
            maxsofar += num;
            if (maxsofar > max)
                max = maxsofar;
            if (maxsofar < 0)
                maxsofar = 0;
        }
        return max;
    }

}
