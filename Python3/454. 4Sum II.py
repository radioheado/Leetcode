class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        twoSum1 = self.twoSumCount(nums1, nums2)
        twoSum2 = self.twoSumCount(nums3, nums4)
        
        ans = 0
        for n, c in twoSum1.items():
            if -n in twoSum2:
                ans += c * twoSum2[-n]
                
        return ans
        
    def twoSumCount(self, nums1: List[int], nums2: List[int]):
        counts = collections.defaultdict(int)
        
        for n in nums2:
            counts[n] += 1
            
        twoSum = collections.defaultdict(int)
        
        for n in nums1:
            for num, count in counts.items():
                twoSum[num+n] += count
                
        return twoSum
            
            