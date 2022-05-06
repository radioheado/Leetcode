class Solution {
    public String removeDuplicates(String s, int k) {
        if (s.length() < k) {
            return s;
        }
        
        Stack<StringBuilder> stack = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (stack.isEmpty() || c != stack.peek().charAt(0)) {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                stack.add(sb);
            } else if (c == stack.peek().charAt(0)) {
                stack.peek().append(c);
                if (stack.peek().length() == k) {
                    stack.pop();
                }
            }
        }
        
        return String.join("", stack);
    }
}