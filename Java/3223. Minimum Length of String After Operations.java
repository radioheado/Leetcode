class Solution {
    public int minimumLength(String s) {
        int[] chars = new int[26];
        for (char c: s.toCharArray()) {
            chars[c - 'a']++;
        }

        int ans = 0;
        for (int v: chars) {
            if (v > 0) {
                ans += (2 - v % 2);
            }    
        }

        return ans;
    }
}