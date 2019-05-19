class Solution {
    public int sumSubarrayMins(int[] A) {
        int[] next = new int[A.length];
        int[] prev = new int[A.length];
        int MOD = (int) Math.pow(10, 9) + 7;
        int sum = 0;
        //first element on right of each element smaller then that element
        Stack < Integer > stack = new Stack < > ();
        for (int i = 0; i < A.length; i++) {
            if (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                    next[stack.pop()] = i - 1;
                }
            }
            stack.push(i);
        }
        //handle remaning elements
        while (!stack.isEmpty()) {
            next[stack.pop()] = A.length - 1;
        }
        //first element on left of each element smaller then that element
        stack = new Stack < > ();
        for (int i = A.length - 1; i >= 0; i--) {
            if (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                    prev[stack.pop()] = i + 1;
                }
            }
            stack.push(i);
        }
        //handle remaning elements
        while (!stack.isEmpty()) {
            prev[stack.pop()] = 0;
        }
        // for(int i = 0;i < prev.length;i++){
        //     System.out.println(next[i]);
        // }
        //calculate
        for (int i = 0; i < A.length; i++) {
            sum = (sum % MOD) + ((A[i] % MOD) * ((next[i] - i + 1) % MOD) * ((i - prev[i] + 1)) % MOD);
        }
        return (sum);
    }
}
