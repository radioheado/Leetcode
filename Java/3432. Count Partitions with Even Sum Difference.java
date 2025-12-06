class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for (int n: nums) {
            sum = (sum + n) % 2;
        }

        return sum % 2 == 0 ? nums.length - 1 : 0;
    }
}