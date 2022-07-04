package pascals_triangle;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
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
        return ans;
    }
}