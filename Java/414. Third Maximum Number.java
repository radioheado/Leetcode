class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> three = new HashSet<>();
        
        for(int num: nums){
            three.add(num);
            
            if(three.size() > 3){
                three.remove(Collections.min(three));
            }
        }
        
        if(three.size() == 3){
            return Collections.min(three);
        }else{
            return Collections.max(three);
        }
    }
}