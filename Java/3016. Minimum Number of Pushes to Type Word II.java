class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        for (char c: word.toCharArray()) {
            count[c - 'a']--;
        }
        Arrays.sort(count);

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                break;
            }
            ans += (i / 8 + 1) * (-count[i]);
        }

        return ans;
    }
}