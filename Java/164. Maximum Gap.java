class Solution {
    static class Bucket {
        public boolean taken = false;
        public int minval = Integer.MAX_VALUE;
        public int maxval = Integer.MIN_VALUE;
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int mmin = Arrays.stream(nums).min().getAsInt(), 
            mmax = Arrays.stream(nums).max().getAsInt();

        int bucket_size = Math.max(1, (mmax - mmin) / (nums.length - 1));
        int bucket_num = (mmax - mmin) / bucket_size + 1;
        Bucket[] buckets = new Bucket[bucket_num];

        for (int n: nums) {
            int i = (n - mmin) / bucket_size;
            if (buckets[i] == null) {
                buckets[i] = new Bucket();
            }
            buckets[i].taken = true;
            buckets[i].minval = Math.min(buckets[i].minval, n);
            buckets[i].maxval = Math.max(buckets[i].maxval, n);
        }

        int pre_max = mmin, ans = 0;
        for (Bucket bucket: buckets) {
            if (bucket == null || !bucket.taken) {
                continue;
            }
            ans = Math.max(ans, bucket.minval - pre_max);
            pre_max = bucket.maxval;
        }

        return ans;
    }
}