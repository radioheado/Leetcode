class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        Queue<Integer> q = new LinkedList<>();
        int far = 0;
        q.offer(0);
        
        while(!q.isEmpty()){
            int i = q.poll();
            
            for(int j = Math.max(i+minJump, far+1); j < Math.min((i+maxJump+1), s.length()); j++){
                if(s.charAt(j) == '0'){
                    q.offer(j);
                    if(j == s.length()-1){
                        return true;
                    }
                }
            }
            
            far = i+maxJump;
        }
        
        return false;
    }
}