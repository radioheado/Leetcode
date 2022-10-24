class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup = nums[0], i, n = nums.length, sum = (1 + n) * n / 2;
        for (int c: nums) {
            i = Math.abs(c) - 1;
            if (nums[i] < 0) {
                dup = i + 1;
            } else {
                sum -= Math.abs(c);
                nums[i] *= -1;
            }
        }
        
        return new int[]{dup, sum};
    }
}