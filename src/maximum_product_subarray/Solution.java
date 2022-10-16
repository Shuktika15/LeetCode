package maximum_product_subarray;

class Solution {
    public int maxProduct(int[] arr) {
        //Traverse the arrray keeping max and min value at each step. Update the resultMax

        int resultMax = arr[0];
        int max = arr[0], min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int localMax = max * num;
            int localMin = min * num;
            max = Integer.max(Integer.max(localMax, localMin), num);
            min = Integer.min(Integer.min(localMax, localMin), num);
            resultMax = Integer.max(resultMax, max);
        }

        return resultMax;
    }
}