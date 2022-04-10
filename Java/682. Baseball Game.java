class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int top;
        int sec;
        
        for (String c: ops) {
            if (c.equals("C")) {
                stack.pop();
            } else if (c.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (c.equals("+")) {
                top = stack.pop();
                sec = stack.pop();
                stack.push(sec);
                stack.push(top);
                stack.push(top+sec);
            } else {
                stack.push(Integer.valueOf(c));
            }
        }
        
        int ans = 0;
        for (int n: stack) {
            ans += n;
        }
        return ans;
    }
}