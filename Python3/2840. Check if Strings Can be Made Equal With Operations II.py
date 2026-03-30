class Solution:
    def checkStrings(self, s1: str, s2: str) -> bool:
        even1, odd1 = [0] * 26, [0] * 26
        even2, odd2 = [0] * 26, [0] * 26

        for i, (c1, c2) in enumerate(zip(s1, s2)):
            if i % 2:
                odd1[ord(c1) - ord('a')] += 1
                odd2[ord(c2) - ord('a')] += 1
            else:
                even1[ord(c1) - ord('a')] += 1
                even2[ord(c2) - ord('a')] += 1

        return even1 == even2 and odd1 == odd2