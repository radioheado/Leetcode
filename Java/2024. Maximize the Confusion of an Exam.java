class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int l = 0, t = 0, f = 0, ans = 0;
        for (int r = 0; r < answerKey.length(); r++) {
            char c = answerKey.charAt(r);
            if (c == 'T') {
                t++;
            } else {
                f++;
            }

            while (Math.min(t, f) > k) {
                if (answerKey.charAt(l) == 'T') {
                    t--;
                } else {
                    f--;
                }
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}