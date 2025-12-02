class Solution {
    public int countTrapezoids(int[][] points) {
        long MOD = 1_000_000_007L;
        Map<Integer, Integer> y_groups = new HashMap<>();

        for (int[] point: points) {
            int y = point[1];
            y_groups.put(y, y_groups.getOrDefault(y, 0) + 1);
        }

        long ans = 0, prefix = 0;
        for (int v: y_groups.values()) {
            long segments = (long) (v - 1) * v / 2;
            ans = (ans + segments * prefix) % MOD;
            prefix = (prefix + segments) % MOD;
        }

        return (int) ans;
    }
}