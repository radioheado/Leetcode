class Solution:
    def sumZero(self, n: int) -> List[int]:
        ans = []
        for cur in range(1, n // 2 + 1):
            ans.extend([cur, -cur])

        if n % 2:
            ans.append(0)
        
        return ans
