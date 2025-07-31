class Solution:
    def subarrayBitwiseORs(self, arr: List[int]) -> int:
        prev_set = set()
        glob_set = set()

        for n in arr:
            curr_set = {n}
            for p in prev_set:
                curr_set.add(n | p)

            glob_set |= curr_set
            prev_set = curr_set

        return len(glob_set)