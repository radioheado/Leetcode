class Solution:
    def divideString(self, s: str, k: int, fill: str) -> List[str]:
        ans = []
        length = len(s)

        for i in range(0, length, k):
            if i + k <= length:
                ans.append(s[i: i + k])
            else:
                size = length - i
                tmp = s[i:] + fill * (k - size % k)
                ans.append(tmp)

        return ans