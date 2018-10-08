//dynamic programming solution
class Solution {
 public int longestPalindromeSubseq(String s) {
  //sanity check 
  if (s.length() == 0) {
   return (0);
  }
  if (s.length() == 1) {
   return (1);
  }
  int len = s.length();
  int arrayLen[][] = new int[len][len];
  // fill diagonal entries with 1
  for (int k = 0; k < len; k++) {
   arrayLen[k][k] = 1;
  }
  //fill all other entries in a bottom up manner
  for (int i = 1; i < len; i++) {
   for (int j = i - 1; j >= 0; j--) {
    if (s.charAt(i) == s.charAt(j)) {
     arrayLen[j][i] = 2 + arrayLen[j + 1][i - 1];
    } else {
     arrayLen[j][i] = Math.max(arrayLen[j][i - 1], arrayLen[j + 1][i]);
    }
   }
  }
  return (arrayLen[0][len - 1]);
 }
}