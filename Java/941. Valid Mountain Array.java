class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3){
            return false;
        }
        
        boolean climbing = false, turn = false;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == arr[i+1]){
                return false;
            }else if(arr[i] < arr[i+1]){
                climbing = true;
                if(turn){
                    return false;
                }
            }else{
                turn = true;
            }
        }
        
        return climbing&&turn;
    }
}