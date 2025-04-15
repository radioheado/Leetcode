class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int offset = 10000, size = 2 * offset + 1;
        int[] tree = new int[size * 2];
        List<Integer> ans = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            ans.add(query(0, nums[i] + offset, tree, size));
            update(nums[i] + offset, 1, tree, size);
        }

        Collections.reverse(ans);
        return ans;
    }

    private void update(int index, int value, int[] tree, int size) {
        index += size;
        tree[index] += value;
        while (index > 1) {
            index /= 2;
            tree[index] = tree[index * 2] + tree[index * 2 + 1];
        }
    }

    private int query(int left, int right, int[] tree, int size) {
        int res = 0;
        left += size;
        right += size;

        while (left < right) {
            if (left % 2 == 1) {
                res += tree[left];
                left++;
            }
            left /= 2;

            if (right % 2 == 1) {
                right--;
                res += tree[right];
            }
            right /= 2;
        }
        return res;
    }
}