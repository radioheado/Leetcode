class Solution:
    def earliestFullBloom(self, plantTime: List[int], growTime: List[int]) -> int:
        times = list(zip(plantTime, growTime))
        times.sort(key = lambda x: -x[1])
        
        res = cur = 0
        for plant, grow in times:
            cur += plant
            res = max(res, cur + grow)
            
        return res