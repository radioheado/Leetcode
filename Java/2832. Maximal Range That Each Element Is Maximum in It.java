class Solution {
    public int[] maximumLengthOfRanges(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int N = nums.length;
        int[] left = new int[N], right = new int[N];

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? N : stack.peek();
            stack.push(i);
        }

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = right[i] - left[i] - 1;
        }

        return ans;
    }
}