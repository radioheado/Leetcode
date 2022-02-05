class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # avoid: the points if avoid the current num
        # using: the points if using the current num
        # prev : the previous num 
        # logic:
        #        if prev = cur-1, if avoid cur, update avoid to max(avoid, using)
        #                         if using cur, update using to cur*count + avoid
        #                         because we cannot use previous number
        #        if prev != cur-1, avoid = max(avoid, using)
        #                         using = cur*count + max(avoid, using)
        #                         because we can still use previous number
        
        count = collections.Counter(nums)
        prev = None
        avoid = using = 0
        
        for cur in sorted(count):
            if cur-1 != prev:
                avoid, using = max(avoid, using), cur*count[cur] + max(avoid, using)
            else:
                avoid, using = max(avoid, using), cur*count[cur] + avoid
            prev = cur
        
        return max(avoid, using)