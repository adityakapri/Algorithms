class Solution {
 public double largestSumOfAverages(int[] A, int K) {
  //table to store calculated values in bottm up manner from k = 0 to k = k and from last element towards first in array 
  double[][] dp = new double[A.length][K];
  double ans = 0;
  //fill the rows in. bottm up manner
  for (int i = A.length - 1; i >= 0; i--) {
   //fill the column from left to right
   for (int j = 0; j < K; j++) {
    //handle cells which does not make sense
    if (((A.length) - i) - K < 0) {
     if (j >= (A.length - i)) {
      System.out.println(i + " , " + j);
      System.out.println("-1");
      dp[i][j] = -1;
      continue;
     }

    }
    //Max( avg[i:] , avg[i:j-1] + dp[j,k-1] )
    //find the second term
    double max = 0;
    for (int m = i + 1; m < A.length; m++) {
     if (j == 0)
      continue;
     //avg(i to m -1 ) + dp[m][k-1] 
     else {
      if (max < (returnAverage(A, i, m) + dp[m][j - 1]))
       max = (returnAverage(A, i, m) + dp[m][j - 1]);
     }
    }
    dp[i][j] = Math.max(returnAverage(A, i, A.length), max);
    System.out.println(i + " , " + j);
    System.out.println(dp[i][j]);

   }


  }
  //return the largest element in the first row
  for (int k = 0; k < K; k++) {
   if (dp[0][k] > ans)
    ans = dp[0][k];
  }
  return (ans);
 }
 //returns average from index i to index j
 private double returnAverage(int[] A, int i, int j) {
  double sum = 0;
  double average = 0;
  for (int k = i; k < j; k++) {
   sum += A[k];
  }
  average = sum / (j - i);
  return (average);
 }
}