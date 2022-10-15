package subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public final class Solution {
    private void subsets(int index, int[] nums, Stack<Integer> stack, ArrayList<List<Integer>> answer) {
        answer.add(new ArrayList<>(stack));

        for (int i = index; i < nums.length; ++i) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            stack.push(nums[i]);
            this.subsets(i + 1, nums, stack, answer);
            stack.pop();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> answer = new ArrayList<>();
        this.subsets(0, nums, new Stack<>(), answer);
        return answer;
    }
}
