class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        
        for(int r=1; r<=rowIndex; r++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            
            for(int i=1; i<r; i++){
                temp.add(prev.get(i-1) + prev.get(i));
            }
            
            temp.add(1);
            prev = temp;
        }
        
        return prev;
    }
}