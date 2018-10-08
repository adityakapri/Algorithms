class Solution {
 public int findLength(int[] A, int[] B) {
  ArrayList < Integer > listA = new ArrayList < Integer > ();
  ArrayList < Integer > listB = new ArrayList < Integer > ();
  listA = createArrayList(A);
  listB = createArrayList(B);
  int maxLength = 0;
  int currentLength = 0;
  //arraylist to store maximum length subarray
  ArrayList < Integer > maximumLengthSubarray = new ArrayList < Integer > ();
  //iterate over the first list A
  for (int i = 0; i < listA.size(); i++) {
   //if list B contains the current element then iterate over it
   if (listB.contains(listA.get(i))) {
    int ptr1, ptr2;
    for (int j = 0; j < listB.size(); j++) {
     currentLength = 0;
     ptr1 = i;
     ptr2 = j;
     while (listA.get(ptr1) == listB.get(ptr2)) {
      currentLength++;
      if (ptr1 < listA.size() - 1 && ptr2 < listB.size() - 1) {
       ptr1++;
       ptr2++;
      } else {
       break;
      }

     }
     //update maximumLength
     if (currentLength > maxLength)
      maxLength = currentLength;
     //update maximumLengthSubarray if you have to return that
    }
   }
  }
  return maxLength;
 }



 public ArrayList < Integer > createArrayList(int[] arr) {
  ArrayList < Integer > listToReturn = new ArrayList < Integer > ();
  for (int i: arr) {
   listToReturn.add(i);
  }
  return listToReturn;
 }
}