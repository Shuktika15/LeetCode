package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public int[][] merge(int[][] intervals) {
        //Sort the intervals based on the start value, if equal go for the second value
        //Traverse the list, if the end value of a pair is > than the start value of the next pair then merge them.
        //for the merged pair the second value of the pair would be max(end[i], end[i +1])
        // special care to: last iteration, equal values for start of pair and end of next pair, single pair list
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        List<int[]> nonOverlappingIntervals = new ArrayList<>();
        int startTemp = intervals[0][0];
        int endTemp = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= endTemp) {
                endTemp = Integer.max(endTemp, intervals[i][1]);
            } else {
                nonOverlappingIntervals.add(new int[]{startTemp, endTemp});
                startTemp = intervals[i][0];
                endTemp = intervals[i][1];
            }
        }

        nonOverlappingIntervals.add(new int[]{startTemp, endTemp});
        int[][] result = new int[nonOverlappingIntervals.size()][2];

        for (int i = 0; i < nonOverlappingIntervals.size(); i++) {
            result[i][0] = nonOverlappingIntervals.get(i)[0];
            result[i][1] = nonOverlappingIntervals.get(i)[1];

        }

        return result;

    }
}
