class Solution {
 public boolean wordBreak(String s, List < String > wordDict) {
  // base condition of recursion if string is empty
  if (s.isEmpty()) {
   return (true);
  }
  boolean answer = false;
  String prefix = null;
  String suffix = null;
  for (int i = 0; i < s.length(); i++) {
   prefix = s.substring(0, i + 1);
   //if prefix is present in list recurse over substring 
   if (wordDict.contains(prefix)) {
    System.out.println("match " + prefix);
    suffix = s.substring(i + 1);
    answer = wordBreak(suffix, wordDict);
    if (answer == true) {
     return (true);
    }
   }

  }
  return (false);

 }

}
