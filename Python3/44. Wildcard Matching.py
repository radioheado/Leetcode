class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        # s index, p index
        si = pi = 0

        # s length
        sl = len(s)

        # p length
        pl = len(p)

        # * index, temp * index
        star = temp = -1

        while si < sl:
            # match pattern: same char or '?'
            if pi < pl and p[pi] in ('?', s[si]):
                si += 1
                pi += 1
            
            # match pattern: '*'
            elif pi < pl and p[pi] == '*':
                star = pi
                temp = si
                pi += 1

            # no more patterns or '*'
            elif star == -1:
                return False

            #no more patterns but has star
            else:
                pi = star + 1
                si = temp + 1
                temp = si

        # remaining chars in p should all be '*'
        return all(p[i] == '*' for i in range(pi, pl))