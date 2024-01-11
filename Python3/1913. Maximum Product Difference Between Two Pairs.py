class Solution:
    def maxProductDifference(self, nums: List[int]) -> int:
        biggest, secbig = 0, 0
        smallest, secsmall = 10001, 10001

        for n in nums:
            if n >= biggest:
                secbig = biggest
                biggest = n
            elif n > secbig:
                secbig = n

            if n <= smallest:
                secsmall = smallest
                smallest = n
            elif n < secsmall:
                secsmall = n
                
        return biggest * secbig - smallest * secsmall