class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counts = collections.Counter(nums)
        
        count_num = []
        
        for n, c in counts.items():
            count_num.append((c, n))
            
        count_num.sort(reverse = True, key = lambda x:x[0])
        
        return [num[1] for num in count_num][:k]