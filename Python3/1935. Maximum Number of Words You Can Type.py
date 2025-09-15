class Solution:
    def canBeTypedWords(self, text: str, brokenLetters: str) -> int:
        broken = set(brokenLetters)
        ans = 0

        for word in text.split(' '):
            flag = False
            for c in word:
                if c in broken:
                    flag = True
                    break
            
            if not flag:
                ans += 1

        return ans