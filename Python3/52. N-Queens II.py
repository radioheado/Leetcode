class Solution:
    def totalNQueens(self, n: int) -> int:
        self.ans = 0
        
        def backtrack(row: int, cols: set, diag: set, anti: set):
            if row == n:
                self.ans += 1
                return
            
            for col in range(n):
                cur_diag = row-col
                cur_anti = row+col
                
                # the queen is not placeable
                if (col in cols or
                    cur_diag in diag or
                    cur_anti in anti):
                    continue
                    
                # place the queen    
                cols.add(col)
                diag.add(cur_diag)
                anti.add(cur_anti)
                
                backtrack(row+1, cols, diag, anti)
                
                # reset the state    
                cols.remove(col)
                diag.remove(cur_diag)
                anti.remove(cur_anti)
                
        backtrack(0, set(), set(), set())
        return self.ans
                
                