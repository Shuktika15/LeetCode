package best_time_to_buy_and_sell_stock;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int diff = 0;
        int max = prices[0];
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            diff = Integer.max(diff, prices[i] - min);
            if (prices[i] < min)
                min = prices[i];
        }
        return diff;
    }
}