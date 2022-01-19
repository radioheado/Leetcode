class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        if len(nums) <= 1:
            return nums
        
        mid = len(nums)//2
        left = self.sortArray(nums[:mid])
        right = self.sortArray(nums[mid:])
        return self.merge(left, right)
        
        
    def merge(self, n1: List[int], n2: List[int]) -> List[int]:
        i1, i2 = 0, 0
        ans = []
        
        while i1 < len(n1) and i2 < len(n2):
            if n1[i1] <= n2[i2]:
                ans.append(n1[i1])
                i1 += 1
            else:
                ans.append(n2[i2])
                i2 += 1
                
        
        ans.extend(n1[i1:])
        ans.extend(n2[i2:])
            
        return ans