class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        mapping = {}
        
        for i in range(len(order)):
            mapping[order[i]] = i
        
        #print(mapping)
        #a = ord('a')
        
        for i in range(1, len(words)):
            prev = words[i-1]
            cur = words[i]
            
            for j in range(len(prev)):
                
                # if compared to the end of cur
                # which means prev is longer than cur
                # and they have the same prefix
                # thus, return false
                if j >= len(cur):
                    return False
                
                #print(prev[j], cur[j])
                # only do the checks if the two chars are not identical
                if prev[j] != cur[j]:
                    if mapping[prev[j]] > mapping[cur[j]]:
                        return False
                    # now we find the first different chars
                    # and they are lexicographical
                    # the prev, cur pair satisfies the requirement
                    # so move on to the next pair
                    break
        
        return True