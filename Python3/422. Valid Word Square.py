class Solution:
    def validWordSquare(self, words: List[str]) -> bool:
        rows= len(words)

        for r, row in enumerate(words):
            for i, c in enumerate(row):
                if i >= rows or r >= len(words[i]) or c != words[i][r]:
                    return False

        return True