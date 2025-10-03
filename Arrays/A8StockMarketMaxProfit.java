public class A8StockMarketMaxProfit {

    public static int maxProfit(int[] arr) {
        int maxProfit = 0;
        int buy = 0;
        for (int sell = 1; sell < arr.length; sell++) {
            if (arr[sell] <= arr[buy]) {
                buy = sell;
            } else {
                maxProfit = Math.max(maxProfit, arr[sell] - arr[buy]);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stockPrices = { 4, 3, 10, 6, 3, 4, 5, 2, 3 };
        System.out.println("Max profit is " + maxProfit(stockPrices));
    }
}