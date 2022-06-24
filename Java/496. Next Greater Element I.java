class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int n: nums2) {
            while (!stack.isEmpty() && n > stack.peek()) {
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }
        
        for (int i=0; i<nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return nums1;
    }
}