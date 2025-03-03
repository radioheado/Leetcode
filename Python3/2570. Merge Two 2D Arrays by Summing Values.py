class Solution:
    def mergeArrays(self, nums1: List[List[int]], nums2: List[List[int]]) -> List[List[int]]:
        ans = []
        i1 = i2 = 0
        N1, N2 = len(nums1), len(nums2)

        while i1 < N1 and i2 < N2:
            id1, n1 = nums1[i1]
            id2, n2 = nums2[i2]

            if id1 < id2:
                ans.append([id1, n1])
                i1 += 1
            elif id1 > id2:
                ans.append([id2, n2])
                i2 += 1
            else:
                ans.append([id1, n1 + n2])
                i1 += 1
                i2 += 1

        if i1 < N1:
            ans.extend(nums1[i1:])
        elif i2 < N2:
            ans.extend(nums2[i2:])

        return ans