class SnapshotArray:

    def __init__(self, length: int):
        self.snapshot = {0: {}}
        self.id = 0

    def set(self, index: int, val: int) -> None:
        self.snapshot[self.id][index] = val

    def snap(self) -> int:
        self.snapshot[self.id+1] = self.snapshot[self.id].copy()
        self.id += 1
        return self.id-1

    def get(self, index: int, snap_id: int) -> int:
        return self.snapshot[snap_id][index] if index in self.snapshot[snap_id] else 0


# Your SnapshotArray object will be instantiated and called as such:
# obj = SnapshotArray(length)
# obj.set(index,val)
# param_2 = obj.snap()
# param_3 = obj.get(index,snap_id)