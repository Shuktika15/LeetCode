package pascals_triangle_ii;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= rowIndex + 1; i++) {
            List<Integer> sp = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    sp.add(1);
                } else {
                    int t = ans.get(i - 2).get(j - 1) + ans.get(i - 2).get(j - 2);
                    sp.add(t);
                }
            }
            ans.add(sp);
        }
        return ans.get(rowIndex);

    }
}