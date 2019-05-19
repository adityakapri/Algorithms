class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack < Integer > stack = new Stack < > ();
        //store indexes in both keys and values
        HashMap < Integer, Integer > map = new HashMap();
        int[] soln = new int[nums.length];
        //part 1
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                        map.put(stack.pop(), i);
                    }
                    stack.push(i);
                }
            }
        }
        //part 2 : handle circular part
        for (int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    map.put(stack.pop(), i);
                }
            }
        }
        // part 3 : handle leftovers
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        //fil the soln array
        for (int i = 0; i < soln.length; i++) {
            if (map.get(i) != -1)
                soln[i] = nums[map.get(i)];
            else
                soln[i] = -1;
        }
        return (soln);
    }

}
