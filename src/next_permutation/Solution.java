package next_permutation;

class Solution {
    public void nextPermutation(int[] nums) {

        int len = nums.length;
        int i = len - 2, j = len - 1;
        for (; i >= 0 && nums[i] >= nums[i + 1]; i--) ;
        if (i >= 0) {
            for (; j > i && nums[j] <= nums[i]; j--) ;

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        i++;
        int len1 = len - i;
        len--;
        for (int k = i; k < i + len1 / 2; k++, len--) {
            int temp1 = nums[k];
            nums[k] = nums[len];
            nums[len] = temp1;
        }
    }
}
