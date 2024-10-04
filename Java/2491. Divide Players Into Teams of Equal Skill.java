class Solution {
    public long dividePlayers(int[] skill) {
        int[] buckets = new int[1001];
        int min = 1001, max = 0;

        for (int s: skill) {
            min = Math.min(min, s);
            max = Math.max(max, s);
            buckets[s]++;
        }

        int sum = min + max;
        long ans = 0;

        for (int s: skill) {
            int partner = sum - s;

            if (buckets[partner] == 0) {
                return -1;
            }

            ans += s * partner;
            buckets[partner]--;
        }

        // Each element is counted twice
        return ans / 2;
    }
}