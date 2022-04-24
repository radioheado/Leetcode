# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = deque()
        self.arr = []
        # reach to the leftmost node, its prev node is Null
        while root:
            self.stack.append(root)
            root = root.left
        self.pre = -1    

    def hasNext(self) -> bool:
        return len(self.stack) > 0 or self.pre < len(self.arr)-1

    def next(self) -> int:
        self.pre += 1
        
        # self.arr has been used completely
        if self.pre == len(self.arr):
            node = self.stack.pop()
            self.arr.append(node.val)
            node = node.right
            while node:
                self.stack.append(node)
                node = node.left
        return self.arr[self.pre]

    def hasPrev(self) -> bool:
        return self.pre > 0

    def prev(self) -> int:
        self.pre -= 1
        return self.arr[self.pre]


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.hasNext()
# param_2 = obj.next()
# param_3 = obj.hasPrev()
# param_4 = obj.prev()