class Solution:
    def minMoves(self, nums: list[int]) -> int:
        # k: elements, s: original sum, moves: minimum moves
        # val: the final value of all elements
        # k - 1: each round adds to the sum
        # s + (k - 1) * moves = k * val
        # mnm: the minimum element in the list, and will be added moves times
        # mnm + moves = val
        # moves = s - k * mnm
        moves, mnm = 0, inf
        for num in nums:
            moves += num
            mnm = min(mnm, num)

        return moves - mnm * len(nums)
