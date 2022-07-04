package append_k_integers_with_minimal_sum;

import java.util.HashSet;

class Solution {
    public long minimalKSum(int[] nums, int k) {
        long count = k;
        HashSet<Integer> set = new HashSet<>();
        long sum = (long) k * ((long) k + 1) / 2L;

        for (int i : nums) {
            set.add(i);
        }

        for (int i : set) {
            if (i <= k) {
                sum -= i;
                --count;
            }
        }

        int i = k;

        while (count < (long) k) {
            if (!set.contains(++i)) {
                sum += i;
                ++count;
            }
        }

        return sum;
    }
}