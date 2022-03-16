class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        # push nums in popped to stack s2
        s2 = deque(reversed(popped))
        s1 = deque()
        
        # push nums in pushed to stack s1
        # if no more nums to be pushed, and s1 != s2
        # return False
        for n in pushed:
            s1.append(n)
            while s1 and s2 and s1[-1] == s2[-1]:
                s1.pop()
                s2.pop()
        
        return s1 == s2
        
        