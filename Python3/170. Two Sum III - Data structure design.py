class TwoSum:

    def __init__(self):
        self.nums = collections.defaultdict(int)

    def add(self, number: int) -> None:
        self.nums[number] += 1
        
    def find(self, value: int) -> bool:
        for num, idx in self.nums.items():
            if value-num in self.nums:
                # if value-num == num, there must be 2 or more num
                if value-num == num:
                    if self.nums[num] >= 2:
                        return True
                    
                else:
                    return True
                
        return False


# Your TwoSum object will be instantiated and called as such:
# obj = TwoSum()
# obj.add(number)
# param_2 = obj.find(value)