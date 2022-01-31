class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        richest = 0
        
        for i in range(len(accounts)):
            wealth = 0
            for j in range(len(accounts[0])):
                wealth += accounts[i][j]
            
            richest = max(richest, wealth)
            
        return richest