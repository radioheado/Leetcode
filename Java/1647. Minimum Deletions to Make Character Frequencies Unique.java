class Solution {
    public int minDeletions(String s) {
        int[] chars = new int[26];
        for (char c: s.toCharArray()) {
            chars[c - 'a']++;
        }
        Arrays.sort(chars);
        
        int ans = 0, allowed = s.length();
        for (int i = 25; i >= 0; i--) {
            if (chars[i] > allowed) {
                ans += chars[i] - allowed;
                chars[i] = allowed;
            }
            allowed = Math.max(0, chars[i] - 1);
        }
        
        return ans;
    }
}