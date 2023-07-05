class Solution:
    def buddyStrings(self, s: str, goal: str) -> bool:
        if len(s) != len(goal):
            return False

        # if two strings are equal, there must be at least 2 same chars
        if s == goal:
            freq = [0] * 26
            for c in s:
                freq[ord(c) - ord('a')] += 1
                if freq[ord(c) - ord('a')] == 2:
                    return True
            return False

        diff = None
        flag = True

        for a, b in zip(s, goal):
            if a != b:
                if not diff:
                    diff = (a, b)
                else:
                    if not flag or (b, a) != diff:
                        return False
                    
                    flag = False
        
        return not flag