class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        _set = set()
        for n in nums:
            if n in _set:
                _set.discard(n)
            else:
                _set.add(n)

        return not _set