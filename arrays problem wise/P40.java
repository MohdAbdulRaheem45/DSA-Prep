public class P40 { // buy and sell stock
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int minprice = Integer.MAX_VALUE;  // Initialize to a large value
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            }
            int profit = prices[i] - minprice;
            if (profit > maxprofit) {
                maxprofit = profit;
            }
        }
        System.out.println(maxprofit);
    }
}
