class Solution:
    def wordsAbbreviation(self, words: List[str]) -> List[str]:
        groups = collections.defaultdict(list)
        # group the words with initially same abbr together 
        for i, w in enumerate(words):
            groups[len(w), w[0], w[-1]].append((w, i))
            
        ans = [None] * len(words)
        Trie = lambda: collections.defaultdict(Trie)
        COUNT = False
        
        for group in groups.values():
            trie = Trie()
            for w, _ in group:
                cur = trie
                
                # count fhow many words left in each char
                for c in w[1:]:
                    cur[COUNT] = cur.get(COUNT, 0) + 1
                    cur = cur[c]
            
            # update abbr for each word in this group
            for word, index in group:
                cur = trie
                for i, c in enumerate(word[1:], 1):
                    # only one left at this char, stop now
                    if cur[COUNT] == 1:
                        break
                    cur = cur[c]
                
                # still can be abbr.ed
                if len(word) - i - 1 > 1:
                    ans[index] = word[:i] + str(len(word) - i - 1) + word[-1]
                # keep the whole word
                else:
                    ans[index] = word
        
        return ans