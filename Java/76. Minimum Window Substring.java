class Solution {
    public String minWindow(String s, String t) {
        
        // count how many times a character appears in t
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for(int i=0; i<t.length(); i++){
            int c = count.getOrDefault(t.charAt(i), 0);
            count.put(t.charAt(i), c+1);
        }
        // System.out.print(count);
        int required = count.size();
        
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        int satisfied = 0;
        
        int left = 0;
        int right = 0;
        
        int[] ans = {-1, 0, 0};
        
        while(right < s.length()){
            if(count.containsKey(s.charAt(right))){
                int c = window.getOrDefault(s.charAt(right), 0);
                window.put(s.charAt(right), c+1);
                // System.out.println(s.charAt(right) + " = " + window.get(s.charAt(right)));
                if(count.get(s.charAt(right)).intValue() == window.get(s.charAt(right)).intValue()){
                    satisfied++;
                }
                
                while(left <= right && satisfied == required){
                    if(ans[0] == -1 || right-left+1 < ans[0]){
                        ans[0] = right-left+1;
                        ans[1] = left;
                        ans[2] = right;
                    }
                    
                    if(window.containsKey(s.charAt(left))){
                        window.put(s.charAt(left), window.get(s.charAt(left))-1);
                        if(window.get(s.charAt(left)) < count.get(s.charAt(left))){
                            satisfied--;
                        }
                    }
                    
                    left++;
                }      
            }
            right++;
        }
        
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
    }
}