class Solution {
 public int maxProfit(int[] prices) {
  //check if null array is passed
  if (prices.length == 0) {
   return (0);
  }
  int maxProfit = 0;
  int immediateProfit;
  int bestBuyingPrice = prices[0];
  for (int i = 1; i < prices.length; i++) {
   //immediateProfit : if stock is sold on present day and buy before
   immediateProfit = prices[i] - bestBuyingPrice;
   if (immediateProfit > maxProfit) {
    maxProfit = immediateProfit;
   }
   if (immediateProfit < 0) {
    //update bestBuyingPrice to current price 
    bestBuyingPrice = prices[i];
   }
  }
  return (maxProfit);
 }
}