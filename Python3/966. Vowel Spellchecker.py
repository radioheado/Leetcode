class Solution:
    def spellchecker(self, wordlist: List[str], queries: List[str]) -> List[str]:
        
        def devowel(s: str) -> str:
            res = []
            for c in s.lower():
                if c in 'aeiou':
                    res.append('*')
                else:
                    res.append(c)
            return ''.join(res)

        ans = []
        exact_matches = set(wordlist)
        cap_matches = {}
        vowel_matches = {}

        for i, word in enumerate(wordlist):
            if word.lower() not in cap_matches:
                cap_matches[word.lower()] = i

            dw = devowel(word)
            if dw not in vowel_matches:
                vowel_matches[dw] = i

        for query in queries:
            if query in exact_matches:
                ans.append(query)
                continue

            query = query.lower()
            if query in cap_matches:
                ans.append(wordlist[cap_matches[query]])
                continue

            query = devowel(query)
            if query in vowel_matches:
                ans.append(wordlist[vowel_matches[query]])
                continue

            ans.append('')

        return ans