class Solution:
    def checkPowersOfThree(self, n: int) -> bool:
        while n:
            n, mod = divmod(n, 3)
            if mod == 2:
                return False
        
        return True