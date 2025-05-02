class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        N = len(dominoes)
        force = [0] * N

        f = 0
        for i, d in enumerate(dominoes):
            if d == 'R':
                f = N
            elif d == 'L':
                f = 0
            else:
                f = max(f - 1, 0)
            force[i] += f

        f = 0
        for i in range(N - 1, -1, -1):
            d = dominoes[i]
            if d == 'L':
                f = N
            elif d == 'R':
                f = 0
            else:
                f = max(f - 1, 0)
            force[i] -= f

        for i, f in enumerate(force):
            if f > 0:
                force[i] = 'R'
            elif f < 0:
                force[i] = 'L'
            else:
                force[i] = '.'
        
        return ''.join(force)           