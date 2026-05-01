class Solution:
    def furthestDistanceFromOrigin(self, moves: str) -> int:
        LR = ans = 0
        for move in moves:
            ans += move == '_'
            LR += move == 'L'
            LR -= move == 'R'

        return ans + abs(LR)