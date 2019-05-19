class Solution {
    public int sumSubarrayMins(int[] A) {
     int sum = 0;
     for(int i = 0; i < A.length;i++){
         for(int j = i; j < A.length;j++){
             sum += ( finMin(A,i,j));
         }

     }
     return(sum  % ( (int)Math.pow(10,9) + 7 ));
    }
    private int finMin(int[] A, int i, int j){
        int min = A[i];
        while(++i <= j){
            min = Math.min(A[i],min);
        }f
        return(min);
    }
}
