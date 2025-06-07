class Solution {
    public String robotWithString(String s) {
        int[] chars = new int[26];
        for (char c: s.toCharArray()) {
            chars[c - 'a']++;
        }

        char min_char = 'a';
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            stack.push(c);
            chars[c - 'a']--;
            while (min_char != 'z' && chars[min_char - 'a'] == 0) {
                min_char++;
            }

            while (!stack.isEmpty() && stack.peek() <= min_char) {
                ans.append(stack.pop());
            }
        }

        return ans.toString();
    }
}