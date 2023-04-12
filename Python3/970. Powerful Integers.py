class Solution:
    def powerfulIntegers(self, x: int, y: int, bound: int) -> List[int]:
        if bound == 0:
            return []
            
        xbound = bound if x == 1 else int(math.log(bound, x))
        ybound = bound if y == 1 else int(math.log(bound, y))
        ans = set()

        for i in range(xbound + 1):
            for j in range(ybound + 1):
                val = x**i + y**j
                if val <= bound:
                    ans.add(val)
                if y == 1:
                    break
            if x == 1:
                break

        return list(ans)