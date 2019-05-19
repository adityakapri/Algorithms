class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack < Integer > stack = new Stack < Integer > ();
        HashMap < Integer, Integer > map = new HashMap < Integer, Integer > ();
        int[] soln = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            if (stack.isEmpty()) {
                stack.push(nums2[i]);
            } else {
                if (stack.peek() > nums2[i]) {
                    stack.push(nums2[i]);
                } else {
                    while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                        map.put(stack.pop(), nums2[i]);
                    }
                    stack.push(stack.push(nums2[i])); //crucial step
                }
            }
        }
        //handle remaning elemensts
        if (stack.size() != 0) {
            while (stack.size() != 0) {
                map.put(stack.pop(), -1);
            }
        }
        //fill soln array
        for (int i = 0; i < soln.length; i++) {
            soln[i] = map.get(nums1[i]);
        }
        return (soln);
    }


}
