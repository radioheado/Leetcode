class Solution:
    def maxScore(self, nums1: List[int], nums2: List[int], k: int) -> int:
        pairs = [(a, b) for a, b in zip(nums1, nums2)]
        # sort decreasingly on nums2
        pairs.sort(key = lambda x: -x[1])

        # use a min heap to maintain the k largest numbers
        heap = [x[0] for x in pairs[:k]]
        cur_sum = sum(heap)
        heapq.heapify(heap)
        ans = cur_sum * pairs[k - 1][1]

        for n1, n2 in pairs[k:]:
            # remove the smallest integer from the previous k largest numbers
            # and push the current i-th number from nums1
            cur_sum -= heapq.heappop(heap)
            cur_sum += n1
            heapq.heappush(heap, n1)
            ans = max(ans, cur_sum * n2)

        return ans