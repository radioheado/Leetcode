class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        pre = ans = 0
        for beams in bank:
            cur = beams.count('1')
            if cur > 0:
                ans += pre * cur
                pre = cur
        return ans