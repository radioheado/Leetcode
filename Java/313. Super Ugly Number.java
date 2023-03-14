class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] nums = new long[n];
        nums[0] = 1;
        int N = primes.length;
        int[] ptr = new int[N];
        Arrays.fill(ptr, 0);

        for (int o=1; o<n; o++) {
            long next_num = Integer.MAX_VALUE;
            for (int i=0; i<N; i++) {
                next_num = Math.min(next_num, nums[ptr[i]] * primes[i]);
            }
            for (int i=0; i<N; i++) {
                if (nums[ptr[i]] * primes[i] == next_num) {
                    ptr[i]++;
                }
            }
            nums[o] = next_num;
        }

        return (int)nums[n-1];
    }
}