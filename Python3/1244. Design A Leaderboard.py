from sortedcontainers import SortedDict
class Leaderboard:

    def __init__(self):
        self.players = {}
        self.scores = SortedDict()

    def addScore(self, playerId: int, score: int) -> None:
        if playerId not in self.players:
            self.players[playerId] = score
            self.scores[-score] = self.scores.get(-score, 0) + 1
        else:
            cur = self.players[playerId]
            count = self.scores[-cur]
            if count == 1:
                del self.scores[-cur]
            else:
                self.scores[-cur] -= 1
            new = score + cur
            self.players[playerId] = new
            self.scores[-new] = self.scores.get(-new, 0) + 1

    def top(self, K: int) -> int:
        ans = count = 0
        for score, times in self.scores.items():
            for _ in range(times):
                ans += -score
                count += 1

                if count == K:
                    return ans

            if count == K:
                return ans

        return ans

    def reset(self, playerId: int) -> None:
        cur = self.players[playerId]
        del self.players[playerId]
        count = self.scores[-cur]
        if count == 1:
            del self.scores[-cur]
        else:
            self.scores[-cur] = count - 1


# Your Leaderboard object will be instantiated and called as such:
# obj = Leaderboard()
# obj.addScore(playerId,score)
# param_2 = obj.top(K)
# obj.reset(playerId)