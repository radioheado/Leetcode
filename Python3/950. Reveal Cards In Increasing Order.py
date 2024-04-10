class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        deck.sort()
        d = a = 0
        N = len(deck)
        ans = [0] * N
        skip = False

        while d < N:
            # an available spot
            if ans[a] == 0:
                # it's turn to add a card
                if not skip:
                    ans[a] = deck[d]
                    d += 1
                
                skip = not skip

            a = (a + 1) % N

        return ans
