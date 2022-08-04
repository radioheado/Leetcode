class Solution:
    def mirrorReflection(self, p: int, q: int) -> int:
        y = 0
        left = True
        
        while True:
            y += q
            # reflect on the vertical walls each round
            left = not left
            
            # we hit a corner
            if y % p == 0:
                even = (y//p) % 2 == 0
                
                # we hit corner 2
                if left:
                    return 2
                
                else:
                    return 0 if even else 1