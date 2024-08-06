class Solution:
    def canBeEqual(self, target: List[int], arr: List[int]) -> bool:
        tcount = [0] * 1001
        acount = [0] * 1001

        for i in range(len(target)):
            tcount[target[i]] += 1
            acount[arr[i]] += 1

        for i in range(1001):
            if tcount[i] != acount[i]:
                return False

        return True