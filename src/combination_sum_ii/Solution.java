package combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    //Sort the array
    //base => if target == 0
    //traverse the array for i = index to length of array for pick and nonpick
    //Avoid repetation => 2 conditions
    //combinationSum2(index, target, candidates, List<List<Integer>> ans, List<Integer> arr)
    //After the recursive call remove the last element from the arr


    public void combinationSum2(
            int index,
            int target,
            int[] candidates,
            List<List<Integer>> ans,
            List<Integer> arr) {

        if (target == 0) {
            ans.add(new ArrayList<>(arr));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            arr.add(candidates[i]);
            combinationSum2(i + 1, target - candidates[i], candidates, ans, arr);
            arr.remove(arr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(0, target, candidates, ans, new ArrayList<>());
        return ans;
    }
}
