class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(char c: num.toCharArray()) {
            while(k>0 && !stack.isEmpty() && stack.peek()>c) {
                stack.pop();
                k--;
            }
            stack.push(c);
            // check leading zero
            if(stack.size() == 1 && stack.peek() == '0') {
                stack.pop();
            }
        }
        
        while(k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        StringBuilder res = new StringBuilder();
        for(char c: stack) {
            res.append(c);
        }
        
        return res.length() > 0 ? res.toString() : "0";
    }
}