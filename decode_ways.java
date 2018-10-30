class Solution {
 public int numDecodings(String s) {
  int totalWays = 0;
  int number = 0;
  //convert String to integer
  try {
   number = Integer.parseInt(s);
  } catch (NumberFormatException e) {
   System.out.println("not a number");
   System.out.println(s);
  }
  // if leftmost is 0
  if ((number / (Math.pow(10, (s.length() - 1)))) == 0) {
   System.out.println("11111");
   return 0;
  }
  if (number <= 0)
   return (0);
  //if number is one digit there is only one way to decode it
  if (number < 10 && s.length() == 1)
   return (1);
  //extracts rightmost digit   
  int units = number % 10;
  //if rightmost digit == 0 thein second from right either 1 or 2
  if (units == 0) {
   //extract second from right
   int tens = (number % 100) / 10;
   if (tens == 1 || tens == 2)
    totalWays = numDecodings(Integer.toString(number / 100));
   else
    return (0);
  } else {
   //no of ways is equal to numDecodings(s-1)
   totalWays = totalWays + numDecodings(Integer.toString(number / 10));
  }


  //if last two digits of number is greater than 
  if (number % 100 < 27) {
   //if tens digit is 0
   if ((number / 10) % 10 == 0) {
    totalWays = totalWays;
   }
   // number is a two digit no
   else if (number < 27) {
    totalWays = totalWays + 1;
   } else {
    if (number % 10 != 0) {
     totalWays = totalWays + numDecodings(Integer.toString(number / 100));
    }

   }
  }




  return (totalWays);

 }
}