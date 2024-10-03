class Solution {
    public int minIncrementForUnique(int[] nums) {
        int max_num = 0;
        
        for (int n: nums) {
            max_num = Math.max(max_num, n);
        }

        int[] count = new int[nums.length + max_num];
        for (int n: nums) {
            count[n]++;
        }

        int ans = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] <= 1) {
                continue;
            }

            int dups = count[i] - 1;
            count[i + 1] += dups;
            ans += dups;
        }

        return ans;
    }
}