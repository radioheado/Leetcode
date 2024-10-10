class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int N = nums.length, ans = 0;
        for (int i = 0; i < N; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        for (int r = N - 1; r >= 0; r--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[r]) {
                ans = Math.max(ans, r - stack.pop());
            }
            if (r <= ans) {
                break;
            }
        }

        return ans;
    }
}