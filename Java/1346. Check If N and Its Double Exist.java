class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int zero = 0;
        
        for(int num: arr){
            if(num == 0){
                zero++;
            }
            set.add(num);
        }
        
        for(int num: set){
            if(num == 0){
                if(zero > 1){
                    return true;
                }
            }else if(set.contains(num*2)){
                //System.out.println(num);
                return true;
            }
        }
        
        
        return false;
    }
}