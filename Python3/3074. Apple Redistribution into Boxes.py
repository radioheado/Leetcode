class Solution:
    def minimumBoxes(self, apple: List[int], capacity: List[int]) -> int:
        ans = 0
        boxes = [-c for c in capacity]
        heapify(boxes)
        apples = sum(apple)

        while boxes and apples > 0:
            apples += heappop(boxes)
            ans += 1

        return ans