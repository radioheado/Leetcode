class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int N = nums.length;
        int[] pos = new int[31], ans = new int[N];
        Arrays.fill(pos, -1);

        for (int i = N - 1; i >= 0; i--) {
            int num = nums[i], j = i;
            for (int bit = 0; bit < 31; bit++) {
                if ((num & (1 << bit)) == 0) {
                    if (pos[bit] != -1) {
                        j = Math.max(j, pos[bit]);
                    }
                } else {
                    pos[bit] = i;
                }
            }
            ans[i] = j - i + 1;
        }

        return ans;
    }
}