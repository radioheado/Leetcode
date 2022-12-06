class Solution {
    public int minimumAverageDifference(int[] nums) {
        int N = nums.length, idx = 0;
        long  avg1, avg2, avg, diff = Integer.MAX_VALUE;
        long sum = 0, prefix = 0;
        for (int n: nums) {
            sum += n;
        }
        
        for (int i = 0; i < N; i++) {
            prefix += nums[i];
            avg1 = prefix / (i + 1);
            avg2 = N > i + 1 ? (sum - prefix) / (N - i - 1) : 0;
            avg  = Math.abs(avg1 - avg2);
            if (avg < diff) {
                diff = avg;
                idx = i;
            }
        }
        
        return idx;
    }
}