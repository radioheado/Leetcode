class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        // edge case
        if(target >= letters[letters.length-1]){
            return letters[0];
        }
        
        int left = 0, right = letters.length-1;
        
        while(left < right){
            int mid = (right-left)/2 + left;
            
            if(letters[mid] <= target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        
        return letters[left];
    }
}