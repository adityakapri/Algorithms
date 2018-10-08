class Solution {
 public int climbStairs(int n) {
  //sanity check
  if (n == 0) {
   return (0);
  }
  if (n == 1) {
   return (1);
  }
  if (n == 2) {
   return (2);

  }
  int current = 0;
  // no of ways till second step
  int previous = 2;
  //no of ways till first step
  int oneBeforePrevious = 1;
  for (int i = 2; i < n; i++) {
   current = previous + oneBeforePrevious;
   oneBeforePrevious = previous;
   previous = current;
  }
  return (previous);
 }
}