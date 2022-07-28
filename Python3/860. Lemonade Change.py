class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        have = { 5: 0,
                10: 0}
        for b in bills:
            if b == 5:
                have[5] += 1
            elif b == 10:
                if have[5] > 0:
                    have[5] -= 1
                else:
                    return False
                have[10] += 1
            else:
                if have[10] > 0 and have[5] > 0:
                    have[10] -= 1
                    have[5]  -= 1
                elif have[5] > 2:
                    have[5] -= 3
                else:
                    return False
        return True