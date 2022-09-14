class Solution:
    def maxPerformance(self, n: int, speed: List[int], efficiency: List[int], k: int) -> int:
        MOD = 10**9 + 7
        
        cands = zip(efficiency, speed)
        cands = sorted(cands, key = lambda x: x[0], reverse = True)
        
        speeds = ans = 0
        heap = []
        
        for e, s in cands:
            if len(heap) > k - 1:
                speeds -= heapq.heappop(heap)
            
            heapq.heappush(heap, s)
            speeds += s
            ans = max(ans, speeds * e)
            
        return ans % MOD