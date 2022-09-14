class Solution:
    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:
        if not tokens:
            return 0
        
        tokens.sort()
        l, r = 0, len(tokens)-1
        score = 0
        
        while l < r:
            if tokens[l] <= power:
                power -= tokens[l]
                score += 1
                l += 1
                
            elif score > 0:
                power += tokens[r]
                score -= 1
                r -= 1
                
            else:
                break
        
        if tokens[l] <= power:
            score += 1
        
        return score