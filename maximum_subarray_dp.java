class Solution {
 public int maxSubArray(int[] nums) {
  //sanity check
  if (nums.length == 0) {
   return (0);
  }
  int sumMaxSubArray = nums[0];
  int sumTillPrevious = nums[0];
  int sumCurrent;
  for (int i = 1; i < nums.length; i++) {
   sumCurrent = sumTillPrevious + nums[i];
   //upate if previous not included
   sumTillPrevious = Math.max(sumCurrent, nums[i]);
   sumMaxSubArray = Math.max(Math.max(sumMaxSubArray, sumCurrent), nums[i]);


  }
  return (sumMaxSubArray);
 }
}