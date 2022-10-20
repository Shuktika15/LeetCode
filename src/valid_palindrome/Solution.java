package valid_palindrome;

class Solution {
    public boolean isPalindrome(String s) {
//         for(int i = 0, j = s.length() - 1; i <= j;) {
//             char a = s.charAt(i);
//             char b = s.charAt(j);
//             if(Character.isLetterOrDigit(a) && Character.isLetterOrDigit(b)) {
//                 if(Character.toLowerCase(a) != Character.toLowerCase(b)) {
//                     return false;
//                 }
//                 i++;
//                 j--;
//             }
//             if(i <= j) {
//                 if(!Character.isLetterOrDigit(a)) i++;
//                 if(!Character.isLetterOrDigit(b)) j--;
//             }

//         }
//         return true;

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char b = Character.toLowerCase(s.charAt(start));
            char e = Character.toLowerCase(s.charAt(end));

            while (start < end && !Character.isLetterOrDigit(b)) {
                b = Character.toLowerCase(s.charAt(++start));
            }

            while (start < end && !Character.isLetterOrDigit(e)) {
                e = Character.toLowerCase(s.charAt(--end));
            }

            if (b != e) return false;

            ++start;
            --end;
        }
        return true;
    }
}

// StringBuilder sb = new StringBuilder();
// for (char ch : s.toCharArray()) {
//     if (Character.isLetter(ch) || Character.isDigit(ch)) {
//         sb.append(Character.toLowerCase(ch));
//     }
// }
// return sb.toString().equals(sb.reverse().toString());
