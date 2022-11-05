package three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] arr) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; ++i) {
            if (arr[i] > 0) {
                break;
            } else if (i == 0 || arr[i] != arr[i - 1]) {
                int target = -arr[i];
                System.out.println(target);
                for (int j = i + 1, k = n - 1; j <= k; ) {
                    if (arr[i] + arr[j] + arr[k] == 0 && i != j && j != k && i != k) {
                        //System.out.println(i + " " + j + " " + k);
                        result.add(Arrays.asList(arr[i], arr[j], arr[k]));
                        while (j + 1 < n && arr[j] == arr[j + 1]) {
                            j++;
                        }
                        j++;
                        while (k - 1 >= 0 && arr[k] == arr[k - 1]) {
                            k--;
                        }
                        k--;
                    } else if (target < arr[j] + arr[k]) {
                        --k;
                    } else {
                        ++j;
                    }
                }
            }

        }

        return result;
    }
}
