class Solution {
    public int countPartitions(int[] nums, int k) {
        final int MOD = 1_000_000_007;
        int n = nums.length;

        // dp[i] = number of ways to partition nums[0..i-1]
        // dp[0] = 1: there is exactly one way to partition an empty prefix
        int[] dp = new int[n + 1];
        dp[0] = 1;

        // pre[i] = dp[0] + dp[1] + ... + dp[i] (mod MOD)
        // used to quickly compute sums of a range of dp values
        int[] pre = new int[n + 1];
        pre[0] = dp[0];

        // Deque for maintaining the maximum in the current window [L..r-1]
        // dqMax will store indices of nums; values at those indices will be
        // in decreasing order: nums[dqMax[0]] is the maximum of the window.
        Deque<Integer> dqMax = new ArrayDeque<>();

        // Deque for maintaining the minimum in the current window [L..r-1]
        // dqMin will store indices of nums; values at those indices will be
        // in increasing order: nums[dqMin[0]] is the minimum of the window.
        Deque<Integer> dqMin = new ArrayDeque<>();

        // L is the left boundary (0-based index in nums) of the current window
        // For each r, we maintain that [L..r-1] is the LONGEST valid window
        // such that max(nums[L..r-1]) - min(nums[L..r-1]) <= k.
        int L = 0;

        // We iterate r from 1 to n (inclusive).
        // r is 1-based for dp: dp[r] = ways for nums[0..r-1].
        for (int r = 1; r <= n; r++) {
            int i = r - 1; // actual index in nums we are adding

            // ===========================
            // 1) Extend the window to the right by including index i
            // ===========================

            // Maintain dqMax:
            // We want dqMax to be decreasing in value.
            // While nums[i] >= nums[dqMax.back()], pop from back,
            // because those indices can never be the maximum again.
            while (!dqMax.isEmpty() && nums[dqMax.peekLast()] <= nums[i]) {
                dqMax.pollLast();
            }
            dqMax.offerLast(i);

            // Maintain dqMin:
            // We want dqMin to be increasing in value.
            // While nums[i] <= nums[dqMin.back()], pop from back,
            // because those indices can never be the minimum again.
            while (!dqMin.isEmpty() && nums[dqMin.peekLast()] >= nums[i]) {
                dqMin.pollLast();
            }
            dqMin.offerLast(i);

            // ===========================
            // 2) Shrink the window from the left while it's invalid
            //    Condition for validity:
            //      max - min <= k
            //    where max = nums[dqMax.front()],
            //          min = nums[dqMin.front()].
            // ===========================
            // While the current window [L..r-1] is invalid, move L to the right.
            // When L moves past an index that is at the front of dqMax or dqMin,
            // we must remove that index from that deque.
            // Be careful: we can only check max-min if deques are not empty.
            // In this algorithm they won't be empty here since i was just added.
            while (!dqMax.isEmpty() && !dqMin.isEmpty() 
                   && (nums[dqMax.peekFirst()] - nums[dqMin.peekFirst()] > k)) {
                if (dqMax.peekFirst() == L) {
                    dqMax.pollFirst();
                }
                if (dqMin.peekFirst() == L) {
                    dqMin.pollFirst();
                }
                L++;
            }

            // ===========================
            // 3) Now [L..r-1] is the LONGEST valid window ending at r-1.
            //    That means any segment [l..r-1] with l in [L..r-1] is valid.
            //
            //    If the last segment starts at index l, then the prefix before that
            //    is nums[0..l-1], which has dp[l] ways to be partitioned.
            //
            //    So:
            //      dp[r] = sum(dp[l]) for l = L..(r-1).
            //
            //    Using prefix sum pre:
            //      pre[x] = dp[0] + dp[1] + ... + dp[x].
            //
            //    If L == 0:
            //      sum(dp[0..r-1]) = pre[r-1].
            //    Else:
            //      sum(dp[L..r-1]) = pre[r-1] - pre[L-1].
            // ===========================
            if (L == 0) {
                dp[r] = pre[r - 1] % MOD;
            } else {
                dp[r] = (pre[r - 1] - pre[L - 1] + MOD) % MOD;
            }

            // ===========================
            // 4) Update prefix sum:
            //    pre[r] = pre[r-1] + dp[r] (mod MOD)
            // ===========================
            pre[r] = (pre[r - 1] + dp[r]) % MOD;
        }

        // dp[n] is the number of ways to partition the entire array nums[0..n-1].
        return dp[n];
    }
}
