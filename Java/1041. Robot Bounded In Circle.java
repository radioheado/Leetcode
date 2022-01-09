class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, d = 0;
        
        for(int i=0; i<instructions.length(); i++){
            if(instructions.charAt(i) == 'L'){
                d = (d+3)%4;
            }else if(instructions.charAt(i) == 'R'){
                d = (d+1)%4;
            }else{
                if(d == 0){
                    y++;
                }else if(d == 1){
                    x++;
                }else if(d == 2){
                    y--;
                }else{
                    x--;
                }
            }
        }
        
        return (x == 0 && y == 0) || (d != 0) ? true : false;
    }
}