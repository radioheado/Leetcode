class Solution {
    public int maxResult(int[] nums, int k) {
        int L = nums.length;
        int[] score = new int[L];
        score[0] = nums[0];
        Deque<Integer> dq = new LinkedList<>();
        dq.offer(0);
        
        for (int i=1; i<L; i++) {
            // pop the old indices that won't be used anymore
            while (!dq.isEmpty() && dq.peekFirst() < i-k) {
                dq.pollFirst();
            }
            score[i] = score[dq.peek()] + nums[i];
            
            // pop the smaller values that won't be used either
            while (!dq.isEmpty() && score[i] >= score[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        
        return score[L-1];
    }
}