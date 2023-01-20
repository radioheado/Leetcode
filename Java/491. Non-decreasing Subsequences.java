class Solution {
    Set<List<Integer>> ans;

    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new HashSet();
        backtrack(nums, 0, new ArrayList());
        return new ArrayList(ans);
    }

    private void backtrack(int[] nums, int i, List<Integer> path) {
        if (i == nums.length) {
            if (path.size() >= 2) {
                ans.add(new ArrayList(path));
            }
            return;
        }

        if (path.isEmpty() || path.get(path.size() - 1) <= nums[i]) {
            path.add(nums[i]);
            backtrack(nums, i + 1, path);
            path.remove(path.size() - 1);
        }

        backtrack(nums, i + 1, path);
    }
}