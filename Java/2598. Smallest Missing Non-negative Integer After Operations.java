class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] mods = new int[value];
        for (int n: nums) {
            int num = (n % value + value) % value;
            mods[num]++;
        }

        for (int n = 0; n < nums.length; n++) {
            if (mods[n % value] <= 0) {
                return n;
            }
            mods[n % value]--;
        }

        return nums.length;
    }
}