package add_binary;

class Solution {
    public String addBinary(String a, String b) {
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int i = c1.length - 1;
        int j = c2.length - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? Character.getNumericValue(c1[i--]) : 0;
            int n2 = j >= 0 ? Character.getNumericValue(c2[j--]) : 0;
            int num = n1 + n2 + carry;
            carry = num / 2;
            sb.append(num % 2);
        }

        if (carry != 0) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}
