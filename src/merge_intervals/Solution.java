package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int j = i + 1;
            int start = intervals[i][0];
            int end = intervals[i][1];

            while (j < n && end >= intervals[j][0]) {
                end = Integer.max(end, intervals[j][1]);
                ++j;
            }

            --j;
            result.add(new int[]{start, end});
            i = j;
        }

        int[][] arr = new int[result.size()][2];
        int j = 0;

        for (int[] i : result) {
            arr[j++] = i;
        }

        return arr;
    }
}
