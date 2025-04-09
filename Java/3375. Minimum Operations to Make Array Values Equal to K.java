class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> count = new HashSet<>();
        for (int n: nums) {
            if (n < k) {
                return -1;
            } else if (n > k) {
                count.add(n);
            }
        }
        return count.size();
    }
}