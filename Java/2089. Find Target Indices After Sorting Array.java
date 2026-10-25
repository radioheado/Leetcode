class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int smaller = 0, occur = 0;
        for (int n: nums) {
            if (n < target) {
                smaller++;
            } else if (n == target) {
                occur++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = smaller; i < smaller + occur; i++) {
            ans.add(i);
        }
        return ans;
    }
}