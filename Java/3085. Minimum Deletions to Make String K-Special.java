class Solution {
    public int minimumDeletions(String word, int k) {
        int[] chars  = new int[26];
        for (char c: word.toCharArray()) {
            chars[c - 'a']++;
        }

        int ans = Integer.MAX_VALUE;
        for (int freq: chars) {
            if (freq == 0) {
                continue;
            }

            int deleted = 0;
            for (int cur: chars) {
                if (cur < freq) {
                    deleted += cur;
                } else if (cur > freq + k) {
                    deleted += cur - freq - k;
                }

                if (deleted > ans) {
                    break;
                }
            }
            ans = Math.min(ans, deleted);
        }
        return ans;
    }
}