class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        ans = sum(gifts)
        gifts = [-g for g in gifts]
        heapq.heapify(gifts)
        
        for _ in range(k):
            cur = -heapq.heappop(gifts)
            root = floor(sqrt(cur))
            ans -= cur - root
            heapq.heappush(gifts, -root)

        return ans