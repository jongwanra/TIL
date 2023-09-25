// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// https://sustainable-dev.tistory.com/23

package best_time_to_buy_and_sell_stock;

public class Solution {
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int min = prices[0];

		for(int price: prices) {
			final int profit = price - min;
			maxProfit = Math.max(maxProfit, profit);
			min = Math.min(min, price);
		}

		return maxProfit;
	}
}
