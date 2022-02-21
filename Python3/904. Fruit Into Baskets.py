class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        # [fruit, count]
        b1 = []
        b2 = []
        left = right = 0
        ans = 0
        
        while right < len(fruits):
            cur = fruits[right]
            
            if not b1:
                b1 = [cur, 1]
            
            elif not b2 and cur != b1[0]:
                b2 = [cur, 1]
                
            elif cur != b1[0] and cur != b2[0]:
                # we have to go over all b1 fruit
                while b1[1] > 0 and b2[1] > 0:
                    # left points to b1
                    if fruits[left] == b1[0]:
                        b1[1] -= 1
                    # left points to b2
                    elif fruits[left] == b2[0]:
                        b2[1] -= 1
                    # increment left pointer    
                    left += 1
                    
                # now left points to a valid fruit, either b1 or b2
                if b1[1] == 0:
                    b1 = b2
                b2 = [cur, 1]
                
            elif cur == b1[0]:
                b1[1] += 1
            
            elif cur == b2[0]:
                b2[1] += 1
            
            right += 1
            ans = max(ans, right - left)
            #print("left = %s, right = %s, b1 = %s, b2 = %s, cur = %s, ans = %s" %(left, right, b1, b2, cur, ans))
            
        return ans
            
            
                    
                