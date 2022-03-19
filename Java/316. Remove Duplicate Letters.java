class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> last_seen = new HashMap<>();
        
        for (int i=0; i<s.length(); i++) {
            last_seen.put(s.charAt(i), i);
        }
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!seen.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && last_seen.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c: stack) {
            sb.append(c.charValue());
        }
        return sb.toString();
    }
}