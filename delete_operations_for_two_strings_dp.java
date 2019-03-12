class Solution {
    public int minDistance(String word1, String word2) {
        //sum of length of both the strings
        int sum = word1.length() + word2.length();
        int lengthLCS = longestCommonSubsequence(word1,word2);
        int ans = sum - (2 * lengthLCS);
        return(ans);
    }
    private int longestCommonSubsequence(String word1, String word2){
        int m = word1.length();
        int n = word2.length();
        if(m == 0 || n == 0)
            return 0;
        int [][] dp = new int [m+1][n + 1];
        for(int i = 0; i < m + 1;i++){
            dp[i][0] = 0;
        }
        for(int j = 1; j < n + 1;j++){
            dp[0][j] = 0;
        }
        for(int a = 1;a < m + 1; a++){
            for(int b = 1;b < n + 1; b++){
                //if last character of both the strings are same
                if(word1.charAt(a - 1) == word2.charAt(b - 1)){
                    dp[a][b] = dp[a - 1][b - 1] + 1;
                }
                //if not same
                else if(dp[a][b - 1] > dp[a - 1][b]){
                    dp[a][b] = dp[a][b - 1];
                }
                else{
                    dp[a][b] = dp[a - 1][b];
                }
            }
        }
        return(dp[m][n]);
    }

}
