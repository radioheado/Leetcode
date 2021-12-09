class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()){
            int i = q.poll();
            // if arr[i] is the 0 valued number
            if(arr[i] == 0){
                return true;
            }
            
            // if current node is not visited
            if(arr[i] > 0){
                if((i+arr[i]) < arr.length){
                    q.offer(i+arr[i]);
                }
                if((i-arr[i]) >= 0){
                    q.offer(i-arr[i]);
                }
                
                arr[i] *= -1;
            }
            
        }
        
        return false;
    }
}