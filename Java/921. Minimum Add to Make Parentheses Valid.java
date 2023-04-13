class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack();
        int ans = 0;

        for (char c: s.toCharArray()) {
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    ans++;
                }
            } else {
                stack.push(c);
            }
        }

        return ans + stack.size();
    }
}