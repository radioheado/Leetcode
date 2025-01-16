class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }

        int[] chars = new int[26];
        for (char c: s.toCharArray()) {
            chars[c - 'a']++;
        }

        int odd = 0;
        for (int v: chars) {
            odd += v % 2;
        }

        return odd <= k;
    }
}