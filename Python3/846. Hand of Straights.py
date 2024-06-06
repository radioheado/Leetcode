class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize:
            return False

        cards = Counter(hand)
        values = list(cards.keys())
        heapq.heapify(values)

        while values:
            cur = values[0]
            for i in range(cur, cur + groupSize):
                if i not in cards:
                    return False
                cards[i] -= 1

                if cards[i] == 0:
                    del cards[i]
                    if i != heapq.heappop(values):
                        return False

        return True