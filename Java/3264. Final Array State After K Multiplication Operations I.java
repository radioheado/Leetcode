class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            int value = Integer.compare(a[0], b[0]);
            if (value == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return value;
        });

        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[] {nums[i], i});
        }

        while (k-- > 0) {
            int[] cur = heap.poll();
            int n = cur[0], i = cur[1];
            nums[i] *= multiplier;
            heap.offer(new int[] {nums[i], i});
        }

        return nums;
    }
}