class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        for (int n: nums) {
            while (!stack.isEmpty() && stack.peek() > n) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < n) {
                if (n > 0) {
                    ans++;
                }
                stack.push(n);
            }
        }
        return ans;
    }
}