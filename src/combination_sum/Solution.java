package combination_sum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * [1, 2, 3, 6, 7]
 * target = 7
 * <p>
 * [7]
 * [[2, 2, 2, 3], [7]]
 * <p>
 * sum > target
 * index >= arr.size
 * <p>
 * index = 0 -> n - 1 / recrusion
 * index = 0
 * <p>
 * stack(2, 2, 3) sum= 7
 * <p>
 * <p>
 * [2, 3, 6, 7]
 * answer = [[2, 2, 3], [7]]
 * stack = [7]
 * index = 4
 * sum = 7
 * <p>
 * <p>
 * combinationSum(index = 0, sum = 0, arr, answer, stack)
 * if (index >= arr.size)
 * if (sum == target) answer.add(stack)
 * return
 * <p>
 * if (sum + arr[index] <= target) { // sum = 7 + arr[3]  > target
 * stack.add(arr[index])
 * combinationSum(index, sum + arr[index], arr, answer, stack)
 * stack.pop()
 * }
 * combinationSum(index + 1, sum, arr, answer, stack)
 */
class Solution {
    private void combinationSum(
            int index,
            int sum,
            int target,
            int[] arr,
            List<List<Integer>> answer,
            Stack<Integer> stack
    ) {
        if (index == arr.length) {
            if (sum == target) {
                answer.add(new ArrayList<>(stack));
            }
            return;
        }
        if (sum + arr[index] <= target) {
            stack.push(arr[index]);
            combinationSum(index, sum + arr[index], target, arr, answer, stack);
            stack.pop();
        }
        combinationSum(index + 1, sum, target, arr, answer, stack);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        combinationSum(0, 0, target, candidates, answer, new Stack<>());
        return answer;
    }
}