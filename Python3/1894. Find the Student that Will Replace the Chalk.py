class Solution:
    def chalkReplacer(self, chalk: List[int], k: int) -> int:
        prefix = []
        pref = 0

        for c in chalk:
            pref += c
            prefix.append(pref)

        k %= pref
        return bisect_right(prefix, k)