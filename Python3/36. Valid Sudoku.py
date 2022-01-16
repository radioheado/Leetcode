class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        # firstly, check all rows
        for b in board:
            if not self.isValid(b):
                return False
            
        # secondly, check all columns
        for j in range(len(board)):
            nums = []
            for i in range(len(board[0])):
                nums.append(board[i][j])
            #print(nums)
            if not self.isValid(nums):
                return False
            
        # thirdly, check all boxes
        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                if not self.validBox(i, j, board):
                    return False
        
        return True
        
    # a helper function to check 1-9 no duplicates
    def isValid(self, nums: List[str]) -> bool:
        seen = set()
        
        for n in nums:
            if n.isdigit():
                if n in seen:
                    return False
                seen.add(n)
                
        return True
        
    # a helper function to check sub-boxes
    def validBox(self, i: int, j: int, board: List[List[str]]) -> bool:
        nums = []
        
        for row in range(3):
            for col in range(3):
                nums.append(board[row+i][col+j])
        
        return self.isValid(nums)
        