class Solution {
    public int takeCharacters(String s, int k) {
        int[] count = new int[3];
        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int c: count) {
            if (c < k) {
                return -1;
            }
        }

        int ans = 0, l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            count[c - 'a']--;
            while (l <= r && count[c - 'a'] < k) {
                count[s.charAt(l++) - 'a']++;
            }
            if (count[c - 'a'] >= k) {
                ans = Math.max(ans, r - l + 1);
            }
        }

        return s.length() - ans;
    }
}