class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        heap = [(n, i) for i, n in enumerate(nums)]
        k = len(nums) - k
        heapq.heapify(heap)

        while k:
            heapq.heappop(heap)
            k -= 1

        heap.sort(key = lambda x: x[1])
        return [x[0] for x in heap]