class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        count = Counter(chars)
        ans = 0

        for w in words:
            word = Counter()
            flag = True
            for c in w:
                word[c] += 1
                if word[c] > count[c]:
                    flag = False
                    break
                
            if flag:
                ans += len(w)

        return ans