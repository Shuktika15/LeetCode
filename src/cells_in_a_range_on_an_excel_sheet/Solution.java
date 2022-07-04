package cells_in_a_range_on_an_excel_sheet;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> cellsInRange(String s) {
        List<String> op = new ArrayList<>();
        int m = Character.getNumericValue(s.charAt(1)), n = Character.getNumericValue(s.charAt(4));
        for (char c = s.charAt(0); c <= s.charAt(3); c++) {
            for (int i = m; i <= n; i++) {
                op.add(String.valueOf(c) + i);
            }
        }
        return op;
    }
}