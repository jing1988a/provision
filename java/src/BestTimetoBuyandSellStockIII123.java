//Say you have an array for which the ith element is the price of a given stock on day i.
//
//        Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
//        Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
//
//        Example 1:
//
//        Input: [3,3,5,0,0,3,1,4]
//        Output: 6
//        Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
//        Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
//        Example 2:
//
//        Input: [1,2,3,4,5]
//        Output: 4
//        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//        Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
//        engaging multiple transactions at the same time. You must sell before buying again.
//        Example 3:
//
//        Input: [7,6,4,3,1]
//        Output: 0
//        Explanation: In this case, no transaction is done, i.e. max profit = 0.


public class BestTimetoBuyandSellStockIII123 {
    public int maxProfit(int[] prices) {
        int l=prices.length;
        if(l<2){return 0;}
        int[] dp1=new int[l];
        int[] dp2=new int[l];
        int curMin=prices[0];
        int curProfit=0;
        for(int i=1; i<l ; i++){
            if(curProfit<prices[i]-curMin){
                curProfit=prices[i]-curMin;
            }
            if(prices[i]<curMin){
                curMin = prices[i];
            }
            dp1[i]=curProfit;
        }
        int curMax=prices[l-1];
        curProfit=0;
        for(int j=l-2 ; j>=0 ; j--){
            if(curMax-prices[j]>curProfit){
                curProfit=curMax-prices[j];
            }
            if(prices[j]>curMax){
                curMax=prices[j];
            }
            dp2[j]=curProfit;
        }
        int ans=0;
        for(int i=0 ; i<l ; i++){
            ans=Math.max(dp1[i]+dp2[i] , ans);
        }
        return ans;
    }
}
