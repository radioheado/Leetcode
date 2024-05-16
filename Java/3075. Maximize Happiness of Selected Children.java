class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        Arrays.sort(happiness);
        int N = happiness.length - 1;

        for (int i = 0; i < k; i++) {
            ans += Math.max(0, happiness[N - i] - i);
        }

        return ans;
    }
}