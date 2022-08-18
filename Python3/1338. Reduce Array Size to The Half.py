class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        N = len(arr)
        arr = Counter(arr)
        max_v = max(arr.values()) 
        
        buckets = [0] * (max_v + 1)
        for c in arr.values():
            buckets[c] += 1
        
        target = N//2
        ans = 0
        b = max_v
        
        while target > 0:
            buckets_needed = math.ceil(target / b)
            actually_have  = min(buckets_needed, buckets[b])
            ans += actually_have
            target -= actually_have * b
            b -= 1
                
        return ans