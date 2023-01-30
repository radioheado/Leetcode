class Solution {
    private LinkedList<Integer> deq;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int max_k = nums[0], N = nums.length;
        if (N * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        deq = new LinkedList();
        for (int i=0; i<k; i++) {
            cleanDeq(nums, i, k);
            deq.addLast(i);
            max_k = Math.max(max_k, nums[i]);
        }
        int[] ans = new int[N - k + 1];
        ans[0] = max_k;
        
        for (int i=k; i<N; i++) {
            cleanDeq(nums, i, k);
            deq.addLast(i);
            ans[i - k + 1] = nums[deq.getFirst()];
        }

        return ans;
    }

    private void cleanDeq(int[] nums, int i, int k) {
        // pop the index that's beyond the k-window
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.pollFirst();
        }

        // pop the indices that are smaller than the current number
        while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
            deq.pollLast();
        }
    }
}