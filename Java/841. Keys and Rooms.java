class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty()){
            List<Integer> keys = rooms.get(q.poll());
            for(int key: keys){
                // System.out.println(key);
                if(!visited.contains(key)){
                    visited.add(key);
                    q.offer(key);
                }
            }
        }
        
        return visited.size() == rooms.size();
    }
}