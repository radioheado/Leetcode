class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        left = []
        count = prev = 0
        
        for i, n in enumerate(boxes):
            left.append(prev)
            prev += count
            if n == '1':
                prev += 1
                count += 1

        right = []
        count = prev = 0
        for i in range(len(boxes) - 1, -1, -1):
            right.append(prev)
            prev += count
            if boxes[i] == '1':
                prev += 1
                count += 1
        
        right.reverse()
        return [left[i] + right[i] for i in range(len(boxes))]
