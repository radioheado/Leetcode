class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> diffs = new PriorityQueue<>();
        int L = ladders;
        
        for(int i=1; i<heights.length; i++){
            if(heights[i] > heights[i-1]){
                int diff = heights[i]-heights[i-1];
                
                // use ladders if available
                if(diffs.size() < L){
                    ladders--;
                    diffs.add(diff);
                }
                else{
                    int brick = diff;
                    
                    // need to replace the top of the heap
                    if(!diffs.isEmpty() && diff > diffs.peek()){
                        brick = diffs.poll();
                        diffs.add(diff);
                    }
                    
                    // deduct bricks and increment ladders
                    if(brick > bricks){
                        return i-1;
                    }
                    else{
                        bricks -= brick;
                        ladders++;
                    }
                }
            }
        }
        
        return heights.length-1;
    }
}