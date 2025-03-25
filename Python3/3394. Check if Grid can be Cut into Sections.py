class Solution:
    def checkValidCuts(self, n: int, rectangles: List[List[int]]) -> bool:
        rectangles.sort(key = lambda x: x[0])
        h_cuts = 0
        farthest = rectangles[0][2]

        for s, _, e, _ in rectangles[1:]:
            if farthest <= s:
                h_cuts += 1
            farthest = max(farthest, e)

        if h_cuts >= 2:
            return True

        rectangles.sort(key = lambda x: x[1])
        v_cuts = 0
        farthest = rectangles[0][3]

        for _, s, _, e in rectangles[1:]:
            if farthest <= s:
                v_cuts += 1
            farthest = max(farthest, e)

        return v_cuts >= 2