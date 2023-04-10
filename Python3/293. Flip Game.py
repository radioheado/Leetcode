class Solution:
    def generatePossibleNextMoves(self, currentState: str) -> List[str]:
        ans = []

        for i in range(len(currentState) - 1):
            if currentState[i:i+2] == '++':
                ans.append(currentState[:i] + '--' + currentState[i+2:])

        return ans