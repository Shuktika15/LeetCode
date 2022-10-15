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

    /*
    s = a, b, c
    0, 0, 0 -> 0
    1, 1, 1 -> 7 = 2^n - 1
    ans = []

    str = 'a'
    ans = ['', 'a']
    i = 1
    binary = [0, 0, 1].rev // bit wise operation to check if in a binary number a bit in a particular index is 1 or not
    j = 0
    digit = 1


    for (i = 0 -> 2^n - 1)
        binary = binary(i)
        check which bits are 1 through a for loop
        str = ''
        for (j in binary.length) {
            digit = binary[j] // digit (0/1) of index j
            if (j == 1) str += s[j]
        }
        answer.add(str)

    5 -> [1, 0, 1]
     210
     101 - 5
    &001 2 ^ 0
    ----
    001 = 1 != 0, at j = 0, bit is set
    1 = 2^0, 10 = 2^1, 100 = 2^2
    for (j = 0 -> 2)
        1 << j = 2^j
        i & (1 << j) != 0 str += string[j]


     */
}
