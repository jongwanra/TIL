// Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

package best_time_to_buy_and_sell_stock;
import java.util.*;
public class Solution230926 {
	public int maxProfit(int[] prices) {
		int profit = 0;
		int buy = prices[0];

		for(int sellIdx = 1; sellIdx < prices.length; sellIdx++) {
			buy = Math.min(buy, prices[sellIdx - 1]); // 항상 최저로 stock을 산 값을 구한다.
			profit = Math.max(profit, prices[sellIdx] - buy); // 항상 최대 이윤을 구한다.
		}

		return profit;
	}
}
