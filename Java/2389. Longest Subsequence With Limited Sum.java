class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        int[] ans = new int[queries.length];
        int i = 0;
        for (int q: queries) {
            int idx = bisectRight(nums, q);
            ans[i++] = idx;
        }

        return ans;
    }

    private int bisectRight(int[] nums, int sum) {
        int l = 0, r = nums.length - 1, mid;
        while (l < r) {
            mid = (r - l) / 2 + l;
            if (nums[mid] == sum) {
                return mid + 1;
            } else if (nums[mid] < sum) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l] > sum ? l : l + 1;
    }
}