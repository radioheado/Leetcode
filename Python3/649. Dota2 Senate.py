class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        queue = deque(senate)
        rCount = senate.count('R')
        dCount = len(senate) - rCount

        rBan = dBan = 0

        while rCount and dCount:
            cur = queue.popleft()

            if cur == 'D':
                if dBan:
                    dBan -= 1
                    dCount -= 1

                else:
                    rBan += 1
                    queue.append('D')

            else:
                if rBan:
                    rBan -= 1
                    rCount -= 1

                else:
                    dBan += 1
                    queue.append('R')

        return 'Radiant' if rCount else 'Dire'
            