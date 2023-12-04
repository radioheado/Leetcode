class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];

        for (char c: chars.toCharArray()) {
            count[c - 'a']++;
        }

        int ans = 0;
        for (String w: words) {
            int[] word = new int[26];
            boolean flag = true;
            for (char c: w.toCharArray()) {
                word[c - 'a']++;
                if (word[c - 'a'] > count[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans += w.length();
            }
        }

        return ans;
    }
}