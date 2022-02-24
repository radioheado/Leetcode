class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        p1 = p2 = 0
        ans = []
        
        while p1 < len(firstList) and p2 < len(secondList):
            left = max(firstList[p1][0], secondList[p2][0])
            right = min(firstList[p1][1], secondList[p2][1])
            
            if left <= right:
                ans.append([left, right])
            
            # keep the later one
            if firstList[p1][1] < secondList[p2][1]:
                p1 += 1
            else:
                p2 += 1
                    
        return ans