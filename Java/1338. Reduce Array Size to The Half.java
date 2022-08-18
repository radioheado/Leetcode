class Solution {
    public int minSetSize(int[] arr) {
        int N = arr.length, max_v = 0;
        Map<Integer, Integer> counts = new HashMap();
        
        // count the occurrences of each number
        for (int n: arr) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
            max_v = Math.max(max_v, counts.get(n));
        }
        
        int[] buckets = new int[max_v + 1];
        Arrays.fill(buckets, 0);
        for (int n: counts.values()) {
            buckets[n]++;
        }
        
        int target = N/2, bneed, actual, ans = 0;
        while (target > 0) {
            bneed = target / max_v;
            if (target % max_v != 0) {
                bneed++;
            }
            actual = Math.min(bneed, buckets[max_v]);
            ans += actual;
            target -= actual * max_v;
            max_v--;
        }
        
        return ans;
    }
}