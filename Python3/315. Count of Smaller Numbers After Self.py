class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        def update(index, value, tree, size):
            # shift the index to the correct position in the tree
            index += size
            tree[index] += value
            while index > 1:
                index //= 2
                tree[index] = tree[index * 2] + tree[index * 2 + 1]

        def query(left, right, tree, size):
            res = 0
            left += size
            right += size
            while left < right:
                if left % 2:
                    res += tree[left]
                    left += 1
                left //= 2

                if right % 2:
                    right -= 1
                    res += tree[right]
                right //= 2

            return res

        offset = 10 ** 4
        size = 2 * offset + 1
        tree = [0] * (2 * size)
        ans = []

        for num in reversed(nums):
            count = query(0, num + offset, tree, size)
            ans.append(count)
            update(num + offset, 1, tree, size)
        
        return list(reversed(ans))