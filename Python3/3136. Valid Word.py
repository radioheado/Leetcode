class Solution:
    def isValid(self, word: str) -> bool:
        if len(word) < 3:
            return False

        vowel = cons = False
        for c in word:
            if c in 'aeiouAEIOU':
                vowel = True
            elif c.isalpha():
                cons = True
            elif c.isdigit():
                continue
            else:
                return False

        return vowel and cons