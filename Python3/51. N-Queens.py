class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        # a helper function to create the desired format
        def formatter(state):
            board = []
            for row in state:
                board.append(''.join(row))
            return board
        
        # a helper function to backtrack the chess board
        def backtrack(row, cols, diagonals, antis, state):
            # base case: make a solution
            if row == n:
                ans.append(formatter(state))
                return 
            
            # traverse the cols
            for col in range(n):
                cur_diagonal = row - col
                cur_anti     = row + col
                
                # if the queen is not placeable
                if(col in cols or
                   cur_diagonal in diagonals or
                   cur_anti in antis):
                    continue
                    
                # place the queen
                cols.add(col)
                diagonals.add(cur_diagonal)
                antis.add(cur_anti)
                state[row][col] = 'Q'
                
                
                # move on to the next row with updated board
                backtrack(row+1, cols, diagonals, antis, state)
                
                # reset the board
                cols.remove(col)
                diagonals.remove(cur_diagonal)
                antis.remove(cur_anti)
                state[row][col] = '.'
                
        ans = []
        empty = [['.'] *n for _ in range(n)]
        backtrack(0, set(), set(), set(), empty)
        return ans