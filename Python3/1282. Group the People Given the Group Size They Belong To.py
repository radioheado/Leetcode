class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        count = collections.defaultdict(list)

        for i, g in enumerate(groupSizes):
            count[g].append(i)
        ans = []

        for g, value in count.items():
            for i in range(0, len(value), g):
                ans.append(value[i: i+g])

        return ans