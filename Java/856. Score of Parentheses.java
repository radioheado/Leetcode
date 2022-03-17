class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.add(0);
            } else {
                int cur = stack.pop();
                int val = stack.pop();
                val += Math.max(cur*2, 1);
                stack.push(val);
            }
        }
        
        return stack.pop();
    }
}