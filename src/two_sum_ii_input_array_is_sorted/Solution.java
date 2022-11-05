package two_sum_ii_input_array_is_sorted;

class Solution {
    /*
    [1, 2, 7, 11, 15, 18.20] target = 13

    for (i = 0 -> n) //
     for (j = i + 1 -> n) //
        if (arr[i] + arr[j] == target)
            return {arr[i], arr[j]}
    // Time = O(N^2) space = O(1)

    sorted
    for (i -> n)
        2, (13 - 2) = 11 (right side of the element that I'm currently in)
        in order to find 11 binary search (arr, i + 1, n - 1)
    O(NlogN) at most least (logN) O(1)



    */
    public int[] twoSum(int[] arr, int target) {
        int j = arr.length - 1;
        for (int i = 0; i < j; ) {
            int sum = arr[i] + arr[j];
            if (sum == target) return new int[]{i + 1, j + 1};
            if (sum > target) --j;
            else ++i;
        }
        return null;
    }
}
