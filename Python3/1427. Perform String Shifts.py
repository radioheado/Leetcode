class Solution:
    def stringShift(self, s: str, shift: List[List[int]]) -> str:
        shifts = 0
        S = len(s)

        for direction, amount in shift:
            # left: increase
            if direction == 0:
                shifts += amount

            # right: decrease
            else:
                shifts -= amount

        shifts %= S
        # shift left
        if shifts > 0:
            s = s[shifts:] + s[:shifts]
        elif shifts < 0:
            s = s[S + shifts:] + s[:S + shifts]

        return s