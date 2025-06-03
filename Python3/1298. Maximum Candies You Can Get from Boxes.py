class Solution:
    def maxCandies(self, status: List[int], candies: List[int], keys: List[List[int]], containedBoxes: List[List[int]], initialBoxes: List[int]) -> int:
        ans = 0
        boxes_found = set()
        keys_found = set()
        queue = deque()

        # Initially, only push the box at hand & opened to the queue
        for box in initialBoxes:
            if status[box] == 1:
                queue.append(box)
            else:
                boxes_found.add(box)

        while queue:
            cur = queue.popleft()
            ans += candies[cur]

            for key in keys[cur]:
                # If the box has already been found
                # Push it to the queue
                if key in boxes_found:
                    queue.append(key)
                    boxes_found.discard(key)
                else:
                    keys_found.add(key)

            for box in containedBoxes[cur]:
                # If the key has already been found or
                # if the box is open already
                # Push the box to the queue
                if box in keys_found or status[box] == 1:
                    queue.append(box)
                    keys_found.discard(box)
                else:
                    boxes_found.add(box)

        return ans
