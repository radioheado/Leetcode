class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int N = difficulty.length;
        Pair[] pairs = new Pair[N];
        for (int i=0; i<N; i++) {
            pairs[i] = new Pair(difficulty[i], profit[i]);
        }
        Arrays.sort(pairs, (a, b) -> (int) a.getKey() - (int) b.getKey());
        Arrays.sort(worker);

        int ans = 0, i = 0, best = 0;
        for (int w: worker) {
            while (i < N && w >= (int) pairs[i].getKey()) {
                best = Math.max(best, (int) pairs[i++].getValue());
            }
            ans += best;
        }

        return ans;
    }
}