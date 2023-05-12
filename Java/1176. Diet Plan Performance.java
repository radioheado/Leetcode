class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int total = 0, score = 0;

        for (int i = 0; i < calories.length; i++) {
            total += calories[i];
            
            if (i >= k) {
                total -= calories[i - k];
            } else if (i < k - 1) {
                continue;
            }
            
            if (total < lower) {
                score--;
            } else if (total > upper) {
                score++;
            }
        }

        return score;
    }
}