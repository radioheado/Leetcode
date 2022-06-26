class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int k_sum = 0, N = cardPoints.length;
        for (int i=0; i<k; i++) {
            k_sum += cardPoints[i];
        }
        
        /* special case: obtain all cards */
        if (k == N) return k_sum;
        
        int left = k-1, ans = k_sum;
        for (int right = N-1; right >= N-k; right--) {
            k_sum = k_sum - cardPoints[left--] + cardPoints[right];
            ans = Math.max(ans, k_sum);
        }
        
        return ans;
    }
}