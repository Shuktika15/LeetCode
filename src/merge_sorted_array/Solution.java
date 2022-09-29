package merge_sorted_array;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //Gap Method

        for (int i = 0, j = m; i < n; i++, j++) {
            nums1[j] = nums2[i];
        }
        double gap = Math.ceil((n + m) / 2.0);
        boolean flag = true;
        while (gap >= 1 && flag) {
            if (gap == 1) {
                flag = false;
            }
            int start = 0;
            int end = (int) gap;
            while (end < n + m) {
                if (nums1[start] > nums1[end]) {
                    int temp = nums1[start];
                    nums1[start] = nums1[end];
                    nums1[end] = temp;
                }
                end++;
                start++;
            }
            gap = Math.ceil(gap / 2);
        }
    }
}

/**
 * Merge method
 */
class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int[] arr = new int[m + n];

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }

        while (i < m) {
            arr[k++] = nums1[i++];
        }

        while (j < n) {
            arr[k++] = nums2[j++];
        }

        for (i = 0; i < m + n; ++i) {
            nums1[i] = arr[i];
        }
    }
}

class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] > nums2[j]) {
                    int temp = nums1[i];
                    nums1[i] = nums2[j];
                    nums2[j] = temp;
                    for (int k = j; k < n - 1; k++) {
                        if (nums2[k] < nums2[k + 1]) {
                            break;
                        }
                        if (nums2[k] > nums2[k + 1]) {
                            int tem = nums2[k];
                            nums2[k] = nums2[k + 1];
                            nums2[k + 1] = tem;
                        }
                    }
                    break;
                }

            }
        }
        for (int i = 0, j = m; i < n; i++, j++) {
            nums1[j] = nums2[i];
        }
    }
}
