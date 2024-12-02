class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        words = sentence.split(' ')
        for i, word in enumerate(words):
            flag = True
            for j, c in enumerate(searchWord):
                if j >= len(word) or c != word[j]:
                    flag = False
                    break
            if flag:
                return i + 1

        return -1