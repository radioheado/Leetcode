class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long ans = -1, prev = 0;

        for (int n: nums) {
            if (n < prev) {
                ans = n + prev;
            }
            prev += n;
        }

        return ans;
    }
}