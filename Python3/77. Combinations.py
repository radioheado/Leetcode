class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        
        def backtrack(start, cur):
            
            # stop the iteration if current length is larger than k
            if len(cur) > k:
                return
            
            for i in range(start, n+1):
                cur.append(i)
                #print(cur)
                
                backtrack(i+1, cur)
                cur.pop()
                
            # stop the iteration if current length reaches k    
            if len(cur) == k:
                # cur[:] is deep copy of cur
                # using cur here is incorrect!!!
                # it's a shallow copy 
                # As that array is popped and pushed, 
                # creating a shallow copy means you will be copying over the same object multiple times, 
                # rather than the values.
                ans.append(cur[:])
                
        ans = []
        backtrack(1, [])
        return ans