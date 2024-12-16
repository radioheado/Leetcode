class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        heap = [(n, i) for i, n in enumerate(nums)]
        heapify(heap)

        for _ in range(k):
            n, i = heappop(heap)
            nums[i] = n * multiplier
            heappush(heap, (nums[i], i))

        return nums