class ValidWordAbbr:

    def __init__(self, dictionary: List[str]):
        self.dict = collections.defaultdict(set)
        
        for word in dictionary:
            abbr = self.getAbbr(word)
            self.dict[abbr].add(word)

    def isUnique(self, word: str) -> bool:
        abbr = self.getAbbr(word)
        
        # There is no word in dictionary whose abbreviation is equal to word's abbreviation 
        if abbr not in self.dict:
            return True
        else:
            words = self.dict[abbr]
            
            if len(words) >= 2:
                return False
            
            elif len(words) == 1:
                return True if word in words else False
            
               
    
    def getAbbr(self, word: str) -> str:
        if len(word) == 1 or len(word) == 2:
            return word
        
        return word[0] + str(len(word)-2) + word[-1]

# Your ValidWordAbbr object will be instantiated and called as such:
# obj = ValidWordAbbr(dictionary)
# param_1 = obj.isUnique(word)