class Solution:
    def maximumSwap(self, num: int) -> int:
        nums = [n for n in str(num)]
        
        for i in range(len(nums)):
            index, value = self.restMax(nums, i)
            
            # find the rightmost max value, swap
            if value != nums[i]:
                nums[i], nums[index] = nums[index], nums[i]
                break
                
        return int(''.join(nums))
    
    def restMax(self, num, cur):
        m = cur
        
        # update the index who has the max value
        for i in range(cur+1, len(num)):
            if num[i] >= num[m]:
                m = i
                
        return m, num[m]