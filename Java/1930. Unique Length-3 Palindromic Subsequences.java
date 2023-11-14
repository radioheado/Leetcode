class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        Arrays.fill(first, -1);
        int[] last = new int[26];
        Arrays.fill(last, -1);
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int j = c - 'a';
            if (first[j] == -1) {
                first[j] = i;
            }
            last[j] = i;
        }

        Set<Character> between = new HashSet();
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) {
                continue;
            }

            between.clear();
            for (int j = first[i] + 1; j < last[i]; j++) {
                between.add(s.charAt(j));
            }

            ans += between.size();
        }

        return ans;
    }
}