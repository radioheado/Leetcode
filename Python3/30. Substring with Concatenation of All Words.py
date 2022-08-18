class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        # length of each word
        diff = len(words[0])
        W = len(words)
        total_len = diff * W
        S = len(s)
        
        words = Counter(words)
        ans = []
        
        def window(left):
            # keep track of the sliding window
            curs = Counter()
            
            # keep track of how many words used 
            used = 0
            
            for right in range(left, S - diff + 1, diff):
                # current word
                sub = s[right: right + diff]
                
                # case 1: current word doesn't match, 
                #         reset the window
                if sub not in words:
                    curs.clear()
                    used = 0
                    
                    # start a new window
                    left = right + diff
                else:
                    # record the current word that matched
                    curs[sub] += 1
                    used += 1
                    
                    # case 2: reach max window size
                    # case 3: current word exceeds 
                    #         move the window
                    while right - left > total_len or curs[sub] > words[sub]:
                        left_word = s[left: left + diff]
                        # move the left pointer
                        left += diff
                        curs[left_word] -= 1
                        used -= 1
                        
                    if used == W:
                        ans.append(left)
                        
                
        for left in range(diff):
            window(left)
            
        return ans