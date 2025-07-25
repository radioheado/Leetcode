class Solution {
    public int maxSum(int[] nums) {
        boolean[] uniq = new boolean[201];
        int sum = 0, max_num = -101;

        for (int n: nums) {
            if (!uniq[n + 100]) {
                uniq[n + 100] = true;
                max_num = Math.max(max_num, n);
                sum += n > 0 ? n : 0;
            }
        }

        return max_num > 0 ? sum : max_num;
    }
}