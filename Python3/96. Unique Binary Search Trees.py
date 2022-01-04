class Solution:
    def numTrees(self, n: int) -> int:
        subTrees = [0] * (n+1)
        
        # base cases: n = 0, the only construction is an empty tree
        #             n = 1, the only construction is the node itself
        subTrees[0], subTrees[1] = 1, 1
        
        # formula: S[n] = sum(S[i-1]*S[n-i])
        for i in range(2, n+1):
            for j in range(1, i+1):
                subTrees[i] += subTrees[j-1]*subTrees[i-j]
        
        return subTrees[n]