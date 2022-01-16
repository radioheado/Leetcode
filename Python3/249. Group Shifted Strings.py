class Solution:
    def groupStrings(self, strings: List[str]) -> List[List[str]]:
        patterns = collections.defaultdict(list)
        
        # each char minus a
        a = ord('a')
        
        for string in strings:
            
            # we'll use this diff to compute the base pattern of this kind of string
            diff = ord(string[0]) - a
            
            temp = ''
            #print(diff)
            for char in string:
                temp += chr((ord(char)-diff)%26)
                
            patterns[temp].append(string)
            
        return list(patterns.values())