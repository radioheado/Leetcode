class Solution:
    def canChange(self, start: str, target: str) -> bool:
        p1 = p2 = 0
        size = len(start)

        while p1 < size or p2 < size:
            # Situations where one of them is space
            while p1 < size and start[p1] == '_':
                p1 += 1

            while p2 < size and target[p2] == '_':
                p2 += 1

            # Both pointers should end at the same time
            if p1 == size or p2 == size:
                return p1 == size and p2 == size

            # Skipped all the spaces, the two chars should at least be the same
            if start[p1] != target[p2]:
                return False

            # Although the chars are the same, they might not be able to get moved correctly
            if p1 > p2 and start[p1] == 'R':
                return False
            
            if p1 < p2 and start[p1] == 'L':
                return False

            p1 += 1
            p2 += 1

        return True