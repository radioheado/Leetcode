class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        # edge case
        if target >= letters[-1]:
            return letters[0]
        
        left, right = 0, len(letters)-1
        
        while left < right:
            mid = (right-left)//2+left
            
            if letters[mid] <= target:
                left = mid+1
            else:
                right = mid
                
        return letters[left]
        