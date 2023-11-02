class Solution:
    def findArray(self, pref: List[int]) -> List[int]:
        arr = [pref[0]]

        for i, cur in enumerate(pref[1:], 1):
            arr.append(cur ^ pref[i - 1])

        return arr