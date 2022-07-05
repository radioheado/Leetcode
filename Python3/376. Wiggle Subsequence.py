class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        pos = neg = 1
        for i, n in enumerate(nums[1:], 1):
            #print(i)
            if nums[i-1] < n:
                pos = neg + 1
            elif nums[i-1] > n:
                neg = pos + 1
        
        return max(pos, neg)