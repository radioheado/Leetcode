class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        ans = s = t = 0
        S, T = len(source), len(target)
        chars = set(source)

        while t < T:
            # char not in source
            if target[t] not in chars:
                return -1

            # different chars, continue searching on source
            if source[s] != target[t]:
                s += 1

            # same char, go to the next char in target
            else:
                s += 1
                t += 1
            
            # reach to the end of source
            # go back to the start of source
            if s == S or t == T:
                s = 0
                ans += 1

        return ans
