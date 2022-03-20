class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        # denote total valid occurrence of a num
        # and the times it appears in the tops and bottoms
        nums = {}
        for n in range(1, 7):
            nums[n] = [0, 0, 0]
            
        N = len(tops)
        
        for i in range(N):
            n1 = tops[i]
            n2 = bottoms[i]
            
            # equal, only count one to total
            if n1 == n2:
                nums[n1][0] += 1
                nums[n1][1] += 1
                nums[n1][2] += 1
                
            else:
                nums[n1][0] += 1
                nums[n1][1] += 1
                nums[n2][0] += 1
                nums[n2][2] += 1
                
        #print(nums)    
            
        ans = inf
        for num in nums.values():
            #print(n)
            # total is less than N
            if num[0] < N:
                continue
            
            ans = min(ans, min(N-num[1], N-num[2]))
            
        return ans if ans != inf else -1
            
            
        
        
        
        