class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        chars = collections.Counter(arr)
        # total amount of numbers
        total = len(chars)

        # frequency list used for counting sort
        freqs = [0] * (len(arr) + 1)
        for v in chars.values():
            freqs[v] += 1

        for i, n in enumerate(freqs[1:], 1):
            # total amount of unique numbers to remove with frequency i
            remove = min(n, k // i)

            # update the remaining k removals
            k -= i * remove

            # remove the given amount of unique numbers from total
            total -= remove

            # can no longer remove any numbers if updated k i less than current frequency
            if k < i:
                return total

        return total