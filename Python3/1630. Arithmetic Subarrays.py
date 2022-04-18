class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        ans = []
        for i, left in enumerate(l):
            right = r[i]
            sub = nums[left: right+1]
            ans.append(self.checkArithmetic(sub))
        return ans
            
    def checkArithmetic(self, arr):
        if len(arr) <= 2:
            return True
        
        arr.sort()
        diff = arr[1] - arr[0]
        for i in range(2, len(arr)):
            if arr[i] - arr[i-1] != diff:
                return False
        return True
            