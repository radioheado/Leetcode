class MyHashMap:

    def __init__(self):
        self.range = 2069
        self.buckets = [Bucket() for _ in range(self.range)]

    def put(self, key: int, value: int) -> None:
        index = key % self.range
        self.buckets[index].insert(key, value)

    def get(self, key: int) -> int:
        index = key % self.range
        return self.buckets[index].search(key)

    def remove(self, key: int) -> None:
        index = key % self.range
        self.buckets[index].delete(key)


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

class Bucket:
    def __init__(self):
        # basic data structure is a tuple: (key, value)
        self.bucket = []
    
    # insert a (key, value) pair if it doesn't exist
    # otherwise, update the value
    def insert(self, key, val):
        found = False
        for i, pair in enumerate(self.bucket):
            if key == pair[0]:
                found = True
                # update the value
                self.bucket[i] = (key, val)
                break
                
        # if not found, append the (key, val) pair
        if not found:
            self.bucket.append((key, val))
            
    def search(self, key):
        for k, v in self.bucket:
            if k == key:
                return v
        return -1
    
    def delete(self, key):
        for i, pair in enumerate(self.bucket):
            if key == pair[0]:
                del self.bucket[i]
        