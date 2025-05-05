class SnakeGame:

    def __init__(self, width: int, height: int, food: List[List[int]]):
        self.width = width
        self.height = height
        self.food = food
        self.food_idx = 0
        self.movement = {'U': [-1, 0], 'L': [0, -1], 'R': [0, 1], 'D': [1, 0]}
        self.snake = deque([(0, 0)])
        self.snake_pos = {(0, 0)}

    def move(self, direction: str) -> int:
        head = (self.snake[0][0] + self.movement[direction][0], \
                self.snake[0][1] + self.movement[direction][1])

        # check boundaries
        cross1 = head[0] < 0 or head[0] >= self.height
        cross2 = head[1] < 0 or head[1] >= self.width

        # check if the snake bites self
        bites = head in self.snake_pos and head != self.snake[-1]

        if cross1 or cross2 or bites:
            return -1

        next_food = self.food[self.food_idx] if self.food_idx < len(self.food) else None

        if self.food_idx < len(self.food) and \
            [next_food[0], next_food[1]] == [head[0], head[1]]:
            self.food_idx += 1
        else:
            self.snake_pos.remove(self.snake.pop())

        self.snake.appendleft(head)
        self.snake_pos.add(head)

        return len(self.snake) - 1


# Your SnakeGame object will be instantiated and called as such:
# obj = SnakeGame(width, height, food)
# param_1 = obj.move(direction)