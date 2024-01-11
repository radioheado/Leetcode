class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        chars = Counter()
        for w in words:
            for c in w:
                chars[c] += 1

        total = len(words)
        for count in chars.values():
            if count % total:
                return False

        return True