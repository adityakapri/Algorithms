class Solution {
 public int rob(int[] nums) {
  //sanity check
  if (nums.length == 0) {
   return (0);
  }
  if (nums.length == 1) {
   return (nums[0]);
  }
  if (nums.length == 2) {
   return (Math.max(nums[0], nums[1]));
  }
  int maxRob = Math.max(nums[0], nums[1]);
  int sumIfPrevIncluded = nums[1];
  int sumIfPrevNotIncluded = nums[0];
  int sumIfCurrentIncuded = 0;
  int sumIfNotCurrentIncuded = 0;
  for (int i = 2; i < nums.length; i++) {
   sumIfCurrentIncuded = sumIfPrevNotIncluded + nums[i];
   sumIfNotCurrentIncuded = maxRob;
   //max is maximum of maxRob ,sumIfCurrentIncuded and sumIfNotCurrentIncuded
   maxRob = Math.max(sumIfCurrentIncuded, sumIfNotCurrentIncuded);
   sumIfPrevIncluded = sumIfCurrentIncuded;
   sumIfPrevNotIncluded = sumIfNotCurrentIncuded;
  }
  return (maxRob);

 }
}