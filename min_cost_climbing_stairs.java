class Solution {
 public int minCostClimbingStairs(int[] cost) {
  //sanity test 
  if (cost.length == 0) {
   return (0);
  }
  if (cost.length == 1) {
   return (cost[0]);
  }
  if (cost.length == 2) {
   //return minimum of both 
   return (Math.min(cost[0], cost[1]));
  }
  int lowestCostToCurrent = 0;
  int lowestCostToPrevious = cost[1];
  int lowestCostToOneBeforePrevious = cost[0];
  //now loop form the third element to the last element
  for (int i = 2; i < cost.length; i++) {
   lowestCostToCurrent = Math.min(lowestCostToPrevious + cost[i], lowestCostToOneBeforePrevious + cost[i]);
   lowestCostToOneBeforePrevious = lowestCostToPrevious;
   lowestCostToPrevious = lowestCostToCurrent;
  }
  //pick minimum of the last two to get the answer
  return Math.min(lowestCostToOneBeforePrevious, lowestCostToPrevious);
 }
}