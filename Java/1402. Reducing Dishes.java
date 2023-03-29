class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int suffix = 0, max_sum = 0;

        for (int i=satisfaction.length-1; i>=0 && suffix+satisfaction[i] > 0; i--) {
            suffix += satisfaction[i];
            max_sum += suffix;
        }

        return max_sum;
    }
}