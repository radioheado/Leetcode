class Solution:
    def maxFreqSum(self, s: str) -> int:
        vowel_count = cons_count = 0
        count = Counter()

        for c in s:
            count[c] += 1
            if c in 'aeiou':
                vowel_count = max(vowel_count, count[c])
            else:
                cons_count = max(cons_count, count[c])

        return vowel_count + cons_count