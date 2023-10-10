package final_prices_with_a_special_discount_in_a_shop;

public class Solution231010 {
	public int[] finalPrices(int[] prices) {
		int[] discountedPrices = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			int discountPrice = 0;
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[i] >= prices[j]) {
					discountPrice = prices[j];
					break;
				}
			}
			discountedPrices[i] = prices[i] - discountPrice;
		}
		return discountedPrices;

	}
}
