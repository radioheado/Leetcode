class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        int max_freq = 0;

        for (int n: arr) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
            max_freq = Math.max(max_freq, counts.get(n));
        }
        
        int[] freqs = new int[max_freq + 1];
        for (int v: counts.values()) {
            freqs[v]++;
        }

        int total = counts.size();
        for (int i = 1; i <= max_freq; i++) {
            int n = freqs[i], remove = Math.min(n, k / i);
            k -= i * remove;
            total -= remove;

            if (k < i) {
                return total;
            }
        }

        return total;
    }
}