package palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    private void partition(String s, Stack<String> stack, List<List<String>> result, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                stack.add(s.substring(start, i + 1));
                partition(s, stack, result, i + 1);
                stack.pop();
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        partition(s, new Stack<>(), result, 0);

        return result;
    }
}
