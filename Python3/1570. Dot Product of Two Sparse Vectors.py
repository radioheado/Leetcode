class SparseVector:
    def __init__(self, nums: List[int]):
        self.vector = []
        for i, n in enumerate(nums):
            if n != 0:
                self.vector.append((i, n))
        self.length = len(self.vector)

    # Return the dotProduct of two sparse vectors
    def dotProduct(self, vec: 'SparseVector') -> int:
        product = 0
        v1, v2 = 0, 0
        
        while v1<self.length and v2<vec.length:
            i1, val1 = self.vector[v1]
            i2, val2 = vec.vector[v2]
            
            # only do val1*val2 when the two indexes are identical
            if i1 < i2:
                v1 += 1
            elif i1 > i2:
                v2 += 1
            else:
                product += val1 * val2
                v1 += 1
                v2 += 1
                
        return product
        

# Your SparseVector object will be instantiated and called as such:
# v1 = SparseVector(nums1)
# v2 = SparseVector(nums2)
# ans = v1.dotProduct(v2)