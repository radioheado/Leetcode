class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        R = len(img1)
        
        # finds all the positions of ones in an image
        def findOnes(arr: List[List[int]]) -> List[int]:
            ans = []
            for r in range(R):
                for c in range(R):
                    if arr[r][c] == 1:
                        ans.append((r, c))
            return ans
        
        # keeps track of how many overlaps a specific move has
        count = defaultdict(int)
        ans = 0
        
        ones1, ones2 = findOnes(img1), findOnes(img2)
        
        # compute the move of transforming a one in img1 to a one in img2
        # increments the count of this move in the dict
        # and update the answer
        for r1, c1 in ones1:
            for r2, c2 in ones2:
                vec = (r1 - r2, c1 - c2)
                count[vec] += 1
                ans = max(ans, count[vec])
                
        return ans