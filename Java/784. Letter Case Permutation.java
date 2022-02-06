class Solution {
    List<String> ans;
    
    public List<String> letterCasePermutation(String s) {
        ans = new ArrayList<>();
        backtrack(0, s, new StringBuilder());
        return ans;
    }
    
    private void backtrack(int start, String s, StringBuilder cur){
        if(cur.length() == s.length()){
            ans.add(cur.toString());
        }
        if(start >= s.length()){
            return;
        }
        
        if(Character.isDigit(s.charAt(start))){
            cur.append(s.charAt(start));
            backtrack(start+1, s, cur);
            cur.deleteCharAt(cur.length()-1);
        }else{
            cur.append(Character.toUpperCase(s.charAt(start)));
            backtrack(start+1, s, cur);
            cur.deleteCharAt(cur.length()-1);
            cur.append(Character.toLowerCase(s.charAt(start)));
            backtrack(start+1, s, cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}