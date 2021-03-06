class NumArray {
 int[] nums;
 public NumArray(int[] nums) {
  this.nums = nums;
 }

 public int sumRange(int i, int j) {
  //sanity check
  if (i == j) {
   return (nums[i]);
  }
  int sum = 0;
  for (int a = i; a <= j; a++) {
   sum = sum + nums[a];
  }
  return (sum);
 }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */