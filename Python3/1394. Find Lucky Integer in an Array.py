class Solution:
    def findLucky(self, arr: List[int]) -> int:
        count = Counter(arr)
        num = -1

        for key, val in count.items():
            if key == val:
                num = max(num, key)

        return num