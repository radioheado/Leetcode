class Solution {
    public int partitionString(String s) {
        int ans = 0, l = 0;
        int[] seen = new int[26];

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (seen[c - 'a'] > 0) {
                while (l < i) {
                    seen[s.charAt(l++) - 'a']--;
                }
                ans++;
            }
            seen[c - 'a']++;
        }

        return ++ans;
    }
}