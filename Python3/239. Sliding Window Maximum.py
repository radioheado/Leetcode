class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        N = len(nums)

        # special cases
        if N * k == 0:
            return []

        if k == 1:
            return nums

        deq = deque()

        def clean_deq(i: int) -> None:
            # pop the old index that's beyond ithe k-window
            if deq and deq[0] == i - k:
                deq.popleft()

            # pop the indices that are within the k-window but is smaller than the current number
            while deq and nums[i] > nums[deq[-1]]:
                deq.pop()

        ans = []
        max_k = nums[0]

        for i in range(k):
            clean_deq(i)
            deq.append(i)
            # find the max number in the first window
            max_k = max(max_k, nums[i])

        ans.append(max_k)  
        for i in range(k, N):
            clean_deq(i)
            deq.append(i)
            ans.append(nums[deq[0]])

        return ans  