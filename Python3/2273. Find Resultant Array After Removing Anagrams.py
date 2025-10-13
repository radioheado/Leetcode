class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        last = Counter(words[0])
        ans = [words[0]]

        for word in words[1:]:
            temp = Counter(word)
            if temp != last:
                ans.append(word)
                last = temp

        return ans