class Solution:
    def countPartitions(self, nums: List[int], k: int) -> int:
        MOD = 10 ** 9 + 7
        n = len(nums)

        # dp[i] = number of ways to partition nums[0..i-1]
        # dp[0] = 1 means: "one way to partition an empty prefix"
        dp = [0] * (n + 1)
        dp[0] = 1

        # pre[i] = dp[0] + dp[1] + ... + dp[i]  (prefix sum of dp)
        # pre[0] = dp[0]
        pre = [0] * (n + 1)
        pre[0] = dp[0]

        # dq_max will store indices of nums in decreasing order of their values.
        # The front of dq_max will always be the index of the maximum value
        # in the current sliding window [L .. r-1].
        dq_max = deque()

        # dq_min will store indices of nums in increasing order of their values.
        # The front of dq_min will always be the index of the minimum value
        # in the current sliding window [L .. r-1].
        dq_min = deque()

        # L is the LEFT boundary (0-based) of the current valid window.
        # For each r, we maintain that [L .. r-1] is the LONGEST valid segment
        # ending at r-1 such that max(nums[L..r-1]) - min(nums[L..r-1]) <= k.
        L = 0

        # We will iterate r from 1 to n (inclusive).
        # r is 1-based "prefix length" for dp.
        # The actual array index we add is i = r - 1.
        for r in range(1, n + 1):
            i = r - 1  # 0-based index in nums

            # ===========================
            # 1) Extend the window to the right by including index i
            # ===========================

            # Update dq_max:
            # - We want dq_max to be decreasing in value.
            # - While the new value nums[i] is >= the value at the back,
            #   we pop from the back, because those indices can never be max
            #   if a later index has a larger (or equal) value.
            while dq_max and nums[dq_max[-1]] <= nums[i]:
                dq_max.pop()
            dq_max.append(i)

            # Update dq_min:
            # - We want dq_min to be increasing in value.
            # - While the new value nums[i] is <= the value at the back,
            #   we pop from the back, because those indices can never be min
            #   if a later index has a smaller (or equal) value.
            while dq_min and nums[dq_min[-1]] >= nums[i]:
                dq_min.pop()
            dq_min.append(i)

            # ===========================
            # 2) Shrink the window from the left (move L) until it is valid
            #    We require:
            #       max(nums[L..r-1]) - min(nums[L..r-1]) <= k
            #    The max is nums[dq_max[0]], min is nums[dq_min[0]]
            # ===========================
            # While the current window is invalid, move L to the right.
            # IMPORTANT:
            # - Whenever L passes an index that is at the front of dq_max or dq_min,
            #   we must remove it from that deque because it is no longer in the window.
            while nums[dq_max[0]] - nums[dq_min[0]] > k:
                if dq_max[0] == L:
                    dq_max.popleft()
                if dq_min[0] == L:
                    dq_min.popleft()
                L += 1

            # ===========================
            # 3) Now [L .. r-1] is the LONGEST valid window ending at r-1.
            #    That means:
            #       any segment [l .. r-1] with l in [L, L+1, ..., r-1]
            #    is valid.
            #    So for dp:
            #       dp[r] = sum(dp[l] for l in [L .. r-1])
            # ===========================

            # Using prefix sums:
            # pre[i] = dp[0] + dp[1] + ... + dp[i]
            # sum(dp[L .. r-1]) = pre[r-1] - pre[L-1]   (if L > 0)
            # sum(dp[0 .. r-1]) = pre[r-1]             (if L == 0)
            if L == 0:
                dp[r] = pre[r - 1] % MOD
            else:
                dp[r] = (pre[r - 1] - pre[L - 1]) % MOD

            # After dp[r] is computed, update the prefix sum:
            pre[r] = (pre[r - 1] + dp[r]) % MOD


        # dp[n] is the number of ways to partition the entire array nums[0..n-1].
        return dp[n] % MOD
