class Solution:
    def doesAliceWin(self, s: str) -> bool:
        count = 0
        for c in s:
            if c in 'aeiou':
                count += 1

        # No vowels in the string, Alice loses
        if count == 0:
            return False

        # Odd number of vowels in the string, 
        # Alice removes the whole string and wins
        if count % 2:
            return True

        # The initial number of vowels is even, 
        # Alice removes the substring that contains count - 1 vowels
        # The remaining string has only 1 vowel
        # So Bob loses
        return True