class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        codes = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        
        ans = set()
        a = ord('a')
        
        for w in words:
            trans = ""
            for c in w:
                trans += codes[ord(c) - a]
            ans.add(trans)
            
        return len(ans)