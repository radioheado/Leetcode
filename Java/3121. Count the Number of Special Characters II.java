class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lower_last = new int[26];
        int[] upper_first = new int[26];

        Arrays.fill(lower_last, -1);
        Arrays.fill(upper_first, -1);

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if ((c - 'a' >= 0) && (c - 'a' < 26)) {
                lower_last[c - 'a'] = i;
            } else {
                if (upper_first[c - 'A'] == -1) {
                    upper_first[c - 'A'] = i;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            int l = lower_last[i], u = upper_first[i];
            if (l != -1 && u != -1 && l < u) {
                ans++;
            }
        }

        return ans;
    }
}