class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        count = 0
        answer = 0
        
        for num in nums:
            if num != 1:
                answer = max(answer, count)
                count = 0
            else:
                count += 1
                
        return max(answer, count)