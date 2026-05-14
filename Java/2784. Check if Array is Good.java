class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        int[] count = new int[n + 1];

        for (int num: nums) {
            if (num < 1 || num > n) {
                return false;
            } else if (num < n) {
                if (count[num] > 0) {
                    return false;
                }
                count[num]++;
            } else {
                count[num]++;
            }
        }

        return count[n] == 2;
    }
}