class Solution {
    public boolean canSortArray(int[] nums) {
        List<int[]> ones = new ArrayList<>();
        int size = 0;

        for (int n: nums) {
            int count = Integer.bitCount(n);
            if (ones.isEmpty() || ones.get(size - 1)[0] != count) {
                ones.add(new int[]{count, n, n});
                size++;
            } else {
                ones.get(size - 1)[1] = Math.min(ones.get(size - 1)[1], n);
                ones.get(size - 1)[2] = Math.max(ones.get(size - 1)[2], n);
            }

            if (size > 1 && ones.get(size - 2)[2] > ones.get(size - 1)[1]) {
                return false;
            }
        }

        return true;
    }
}