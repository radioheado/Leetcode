class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        loses = [-1] * 100001
        
        for w, l in matches:
            if loses[w] == -1:
                loses[w] = 0
            if loses[l] == -1:
                loses[l] = 1
            else:
                loses[l] += 1
                
        a1 = []
        a2 = []
        for i, l in enumerate(loses):
            if l == 0:
                a1.append(i)
            elif l == 1:
                a2.append(i)
                
        return [a1, a2]