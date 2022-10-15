package permutation_sequence;

class Solution {
    private int fact(int n) {
        if (n == 0 || n == 1) return 1;
        int f = 1;

        for (int i = 2; i <= n; ++i) {
            f *= i;
        }

        return f;
    }


    public String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder();
        List<Integer> lst = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            lst.add(i);
        }

        int f = fact(n - 1);
        k--;

        while(n > 0) {
            int index = k / f;
            str.append(String.valueOf(lst.get(index)));
            int ignore = lst.remove(index);
            k %= f;
            f  = n == 1 ? 1 : f / (n - 1);
            --n;
        }

        return str.toString();
    }
}