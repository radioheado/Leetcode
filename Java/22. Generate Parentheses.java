class Solution {
    List<String> ans;
    
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n);
        return ans;
    }
    
    private void backtrack(StringBuilder cur, int open, int close, int max) {
        // finish matching & generating
        if(cur.length() == max*2){
            ans.add(cur.toString());
            return;
        }
        
        if(open < max){
            cur.append("(");
            backtrack(cur, open+1, close, max);
            cur.deleteCharAt(cur.length()-1);
        }
        
        if(close < open){
            cur.append(")");
            backtrack(cur, open, close+1, max);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}