class Solution:
    def smallestRange(self, nums: List[List[int]]) -> List[int]:
        heap = [(num[0], i, 0) for i, num in enumerate(nums)]
        heapq.heapify(heap)

        ans = -inf, inf
        right = max(row[0] for row in heap)

        while heap:
            left, row, idx = heapq.heappop(heap)
            if right - left < ans[1] - ans[0]:
                ans = left, right
            
            idx += 1
            if idx == len(nums[row]):
                return ans

            v = nums[row][idx]
            heapq.heappush(heap, (v, row, idx))
            right = max(right, v)
