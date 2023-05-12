class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] count = new int[26];

        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        int prev = -1;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                continue;
            }
            if (prev == -1) {
                prev = count[i];
            }
            if (count[i] != prev) {
                return false;
            }
        }

        return true;
    }
}