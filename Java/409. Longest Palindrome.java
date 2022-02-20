class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        for(char c: s.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0)+1);
        }
        
        int count = 0;
        for(int c: chars.values()) {
            if(c%2 == 0) {
                count += c;
            } else if(c > 1) {
                count += c-1;
            }
        }
        
        return count < s.length() ? count+1 : count;
    }
}