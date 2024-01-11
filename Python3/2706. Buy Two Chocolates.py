class Solution:
    def buyChoco(self, prices: List[int], money: int) -> int:
        top = sec = 101
        for p in prices:
            if p <= top:
                sec = top
                top = p
            elif p < sec:
                sec = p

        return money - top - sec if top + sec <= money else money