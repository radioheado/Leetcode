class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        digits = Counter(str(n))
        L = len(str(n))
        num = power = 1
        
        while power < 31:
            # only do the check when the two numbers have the same length
            if len(str(num)) == L:
                count = Counter(str(num))
                if digits == count:
                    return True
                
            # no need to continue
            elif len(str(num)) > L:
                return False
            
            # haven't reached to the correct length
            power += 1
            num *= 2
                
        return False