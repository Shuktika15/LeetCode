package remove_duplicates_from_sorted_array;

class Solution {
    public int removeDuplicates(int[] arr) {
        int j = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] != arr[j]) {
                arr[++j] = arr[i];
            }
        }
        return j + 1;
    }
}