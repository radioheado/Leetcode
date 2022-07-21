class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack();
        int L = nums.length;
        int[] ans = new int[L];
        Arrays.fill(ans, -1);
        
        for (int i=0; i<2*L; i++) {
            while (!stack.isEmpty() && nums[i%L] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[i%L];
            }
            stack.push(i%L);
        }
        
        return ans;
    }
}