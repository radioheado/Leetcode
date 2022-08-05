class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack();
        int low = Integer.MIN_VALUE;
        
        for (int n: preorder) {
            if (n < low)    return false;
            while (!stack.isEmpty() && n > stack.peek()) {
                low = stack.pop();
            }
            stack.push(n);
        }
            
        return true;
    }
}