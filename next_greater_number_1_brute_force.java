class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
     int[] answer = new int[nums1.length];
     for(int i = 0; i < nums1.length;i ++){
         answer[i] = -1;
     }
     for(int i = 0; i < nums1.length; i++){
         int index = getIndex(nums2, nums1[i]);
         for(int j = index + 1; j < nums2.length; j++){
             if(nums2[j] > nums1[i]){
                 answer[i] = nums2[j];
                 break;
             }
         }
     }
     return(answer);
    }
    public int getIndex(int[] nums2,int n){
        for(int i = 0; i < nums2.length;i++){
            if(nums2[i] == n)
                return(i);
        }
        return(-1);
    }
}
