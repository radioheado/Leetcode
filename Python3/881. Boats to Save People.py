class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        left, right = 0, len(people)-1
        ans = 0
        
        while left <= right:
            # left and right pointers take a boat together
            if people[left] + people[right] <= limit:
                left += 1
            ans += 1
            right -= 1
            
        
        return ans
            
                
                
        