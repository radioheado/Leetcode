class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        if len(s) % 2:
            return False

        left = deque()
        unlocked = deque()
        for i, c in enumerate(s):
            if locked[i] == '0':
                unlocked.append(i)
                continue

            if c == '(':
                left.append(i)

            elif c == ')':
                if not left and not unlocked:
                    return False

                if left:
                    left.pop()
                else:
                    unlocked.pop()

        while left and unlocked and left[-1] < unlocked[-1]:
            left.pop()
            unlocked.pop()

        if left:
            return False
            
        return True