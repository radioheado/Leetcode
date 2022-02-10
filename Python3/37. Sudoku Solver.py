class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxs = [set() for _ in range(9)]
        
        # add existing numbers to the sets
        for r in range(9):
            for c in range(9):
                cur = board[r][c]
                if cur != '.':
                    cur = int(cur)
                    rows[r].add(cur)
                    cols[c].add(cur)
                    boxs[(r//3)*3 + c//3].add(cur)
        
        
        def backtrack(row, col):
            
            if row == 8 and col == 9:
                return True
            
            # finish a row, continue to the next row
            elif col == 9:
                col = 0
                row += 1
            
            cur = board[row][col] 
            box = (row//3)*3 + col//3
            
            # cur is a number, continue
            if cur != '.':
                return backtrack(row, col+1)
            
            else:
                for n in range(1, 10):
                    
                    # this number is not violating rules
                    if n not in rows[row] and n not in cols[col] and n not in boxs[box]:
                        board[row][col] = str(n)
                        rows[row].add(n)
                        cols[col].add(n)
                        boxs[box].add(n)
                        
                        if backtrack(row, col+1):
                            return True
                        
                        board[row][col] = '.'
                        rows[row].remove(n)
                        cols[col].remove(n)
                        boxs[box].remove(n)
                        
            return False
        
        backtrack(0, 0)
   