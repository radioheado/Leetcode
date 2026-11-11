class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans = 0;
        int took = Math.min(need1, need2);
        ans += (long)Math.min(costBoth, cost1 + cost2) * took;
        ans += (long)Math.min(costBoth, cost1) * (need1 - took) + (long)Math.min(costBoth, cost2) * (need2 - took);

        return ans;
    }
}