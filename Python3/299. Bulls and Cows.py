class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        # bulls: number of correct digits
        # cows:  number of digits in the wrong position
        # xA:    number of bulls
        # yB:    number of cows
        smap = defaultdict(int)
        gmap = defaultdict(int)
        
        bulls = cows  = 0
        for s, g in zip(secret, guess):
            # found a bull
            if s == g:
                bulls += 1
            else:
                smap[s] += 1
                gmap[g] += 1
                
        # count for cows
        for s, c in smap.items():
            cows += min(c, gmap.get(s, 0))
            
        return "{}A{}B".format(bulls, cows)