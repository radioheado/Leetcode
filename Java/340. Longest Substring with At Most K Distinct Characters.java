class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        HashMap<Character, Integer> window = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int dis = 0;
        int count = 0;
        int m = 0;
        
        while(right < s.length()){
            
            char cur = s.charAt(right);
            //System.out.println(cur);    
            if(!window.containsKey(cur) || window.get(cur) == 0){
                window.put(cur, 1);
                dis++;
            }else{
                window.put(cur, window.get(cur)+1);
            }
            count++;
            
            while(dis>k){
                cur = s.charAt(left);
                //System.out.println(cur);
                window.put(cur, window.get(cur)-1);
                count--;
                if(window.get(cur) == 0){
                    dis--;
                }
                left++;
            }
            
            right++;
            m = Math.max(m, count);
            //System.out.println(right);
        }
        
        return m;
    }
}