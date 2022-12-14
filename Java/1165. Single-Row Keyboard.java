class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] indices = new int[26];
        for (int i=0; i<26; i++) {
            indices[keyboard.charAt(i) - 'a'] = i;
        }

        int cur = 0, ans = 0, pos;
        for (char w: word.toCharArray()) {
            pos = indices[w - 'a'];
            ans += Math.abs(pos - cur);
            cur = pos;
        }

        return ans;
    }
}