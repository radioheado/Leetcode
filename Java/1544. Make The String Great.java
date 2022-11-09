class Solution {
    public String makeGood(String s) {
        int diff = 'a' - 'A';
        Stack<Character> stack = new Stack();
        stack.push(s.charAt(0));
        
        for (int i=1; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && Math.abs(c - stack.peek()) == diff) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c: stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}