class Solution:
    def checkValidString(self, s: str) -> bool:
        left = collections.deque()
        star = collections.deque()

        for i, c in enumerate(s):
            if c == '(':
                left.append(i)
            elif c == '*':
                star.append(i)
            else:
                # pop from the left stack first
                # if not applicable, pop from the star stack
                # otherwise, return False immediately
                if left:
                    left.pop()
                elif star:
                    star.pop()
                else:
                    return False
        
        while left and star:
            # a left parenthesis is not closed
            if left.pop() > star.pop():
                return False

        # finally, return True if there are no more ('s
        # it's ok to have *'s remaining
        return not left