class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> seen = new HashSet<>();
        seen.add("0000");
        
        Set<String> dead = new HashSet<>();
        for(String d: deadends){
            dead.add(d);
        }
        
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        Queue<Integer> m = new LinkedList<>();
        m.offer(0);
        
        while(!q.isEmpty()){
            String node = q.poll();
            int move = m.poll();
            
            if(node.equals(target)){
                return move;
            }
            
            if(dead.contains(node)){
                continue;  
            }
            
            for(String nei: neighbors(node)){
                if(!seen.contains(nei)){
                    // System.out.println(nei);
                    seen.add(nei);
                    q.offer(nei);
                    m.offer(move+1);
                }
            }
            
        }
        
        return -1;
        
    }
    
    private String[] neighbors(String node){
        String[] neis = new String[8];
        int c = 0;
        
        for(int i=0; i<4; i++){
            int x = node.charAt(i)-'0';
            for(int j=-1; j<=1; j+=2){
                int y = (x+j+10)%10;
                neis[c] = node.substring(0,i)+String.valueOf(y)+node.substring(i+1);
                c++;
            }
        }
        return neis;
    }
}