class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        for (int sell : prices) {
            if (sell > buy) {
                maxProfit = Math.max(maxProfit, sell - buy);
            } else {
                buy = sell;
            }
        }
        return maxProfit;
    }
}