class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        ans = []
        words.sort(key=lambda x: len(x))
        N = len(words)
        
        for i, word in enumerate(words):
            for j in range(i + 1, N):
                if words[j].find(word) > -1:
                    ans.append(word)
                    break

        return ans