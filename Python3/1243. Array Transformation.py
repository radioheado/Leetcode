class Solution:
    def transformArray(self, arr: List[int]) -> List[int]:
        flag = True
        N = len(arr)
        cur = arr.copy()

        while flag:
            flag = False
            for i in range(1, N - 1):
                if arr[i - 1] > arr[i] and arr[i] < arr[i + 1]:
                    cur[i] = arr[i] + 1
                    flag = True
                elif arr[i - 1] < arr[i] and arr[i] > arr[i + 1]:
                    cur[i] = arr[i] - 1
                    flag = True
                else:
                    cur[i] = arr[i]     
            arr = cur[:]

        return arr