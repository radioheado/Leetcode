class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(count.containsKey(s.charAt(i))){
                count.put(s.charAt(i), count.get(s.charAt(i))+1);
            }else{
                count.put(s.charAt(i), 1);
            }
        }
        
        for(int i=0; i<s.length(); i++){
            if(count.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}