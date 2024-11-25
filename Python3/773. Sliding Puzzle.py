class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        directions = [(1, 3), (0, 2, 4), (1, 5), (0, 4), (1, 3, 5), (2, 4)]

        # Swap two piles
        def _swap(state: str, i: int, j: int) -> str:
            state_list = list(state)
            state_list[i], state_list[j] = state_list[j], state_list[i]
            return ''.join(state_list)

        target = '123450'
        moves = 0
        start = ''.join(str(pile) for row in board for pile in row)
        queue = deque([start])
        visited = set([start])

        while queue:
            size = len(queue)
            for _ in range(size):
                current = queue.popleft()
                if current == target:
                    return moves

                zero_pos = current.index('0')
                for new_pos in directions[zero_pos]:
                    next_state = _swap(current, zero_pos, new_pos)

                    # Skip the next state if it's visited
                    if next_state in visited:
                        continue

                    # Mark the new state
                    visited.add(next_state)
                    queue.append(next_state)

            moves += 1

        return -1