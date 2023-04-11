class Solution {
    public int findGCD(int[] nums) {
        int large = -1001, small = 1001;
        for (int n: nums) {
            large = Math.max(large, n);
            small = Math.min(small, n);
        }
        while (small > 0) {
            int temp = large % small;
            large = small;
            small = temp;
        }
        return large;
    }
}