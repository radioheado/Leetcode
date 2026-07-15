class Solution:
    def earliestFinishTime(self, landStartTime: List[int], landDuration: List[int], waterStartTime: List[int], waterDuration: List[int]) -> int:

        def solve(start1: List[int], duration1: List[int], start2: List[int], duration2: List[int]) -> int:
            finish1 = inf
            for i in range(len(start1)):
                finish1 = min(finish1, start1[i] + duration1[i])
            finish2 = inf
            for i in range(len(start2)):
                finish2 = min(finish2, max(start2[i], finish1) + duration2[i])
            return finish2

        return min(solve(landStartTime, landDuration, waterStartTime, waterDuration),
                   solve(waterStartTime, waterDuration, landStartTime, landDuration))
