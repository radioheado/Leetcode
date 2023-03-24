class LockingTree:

    def __init__(self, parent: List[int]):
        self.parent = parent
        self.tree = collections.defaultdict(list)
        for child, p in enumerate(parent):
            if p != -1:
                self.tree[p].append(child)

        self.locked = {}
    
    def lock(self, num: int, user: int) -> bool:
        if num in self.locked:
            return False
        self.locked[num] = user
        return True

    def unlock(self, num: int, user: int) -> bool:
        if num not in self.locked or self.locked[num] != user:
            return False
        self.locked.pop(num)
        return True

    def upgrade(self, num: int, user: int) -> bool:
        cur = num

        # check num's anscestors
        while cur != -1:
            # num itself or its anscestors are locked
            if cur in self.locked:
                return False
            cur = self.parent[cur]

        # check num's descendents
        stack = deque([num])
        des = []

        while stack:
            cur = stack.pop()

            for child in self.tree[cur]:
                # only add child to des list if it's locked
                if child in self.locked:
                    des.append(child)
                stack.append(child)

        # if there's a node locked, unlock them and return True
        if des:
            self.locked[num] = user
            for child in des:
                self.locked.pop(child)
            return True

        return False


# Your LockingTree object will be instantiated and called as such:
# obj = LockingTree(parent)
# param_1 = obj.lock(num,user)
# param_2 = obj.unlock(num,user)
# param_3 = obj.upgrade(num,user)