class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
                                                          
        int l = 0, r = tokens.length - 1;
        int score = 0, ans = 0;
        
        while (l <= r) {
            if (tokens[l] <= power) {
                power -= tokens[l++];
                score++;
                ans = Math.max(ans, score);
            } else if (score > 0) {
                power += tokens[r--];
                score--;
            } else {
                break;
            }
        }
        
        return ans;
    }
}