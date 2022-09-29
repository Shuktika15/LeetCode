package minimum_number_of_increments_on_subarrays_to_form_a_target_array;

class Solution {
    public int minNumberOperations(int[] target) {
        int counter = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                counter += target[i] - target[i - 1];
            }
        }
        return counter;

    }
}
