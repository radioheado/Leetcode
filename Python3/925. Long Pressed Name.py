class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        n = t = 0
        N, T = len(name), len(typed)

        while n < N and t < T:
            count = 0
            char = name[n]

            # count duplicate chars in name
            while n < N and name[n] == char:
                count += 1
                n += 1

            # find at least count chars in typed
            while t < T and typed[t] == char:
                count -= 1
                t += 1

            # char in typed is less than in name
            if count > 0:
                return False

        return n == N and t == T