class Solution {
    private List<String> ans = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    
    public List<String> letterCombinations(String digits) {
        backtrack(digits, 0, new StringBuilder());
        return ans;
    }
    
    private void backtrack(String digits, int i, StringBuilder cur) {
        if(digits.length() == cur.length()) {
            // use a check to avoid empty input
            // don't forget to make a deep copy
            if(cur.length() != 0){
                ans.add(cur.toString());
            }
            return;
        }
        
        String ltrs = letters.get(digits.charAt(i));
        for(char l: ltrs.toCharArray()) {
            cur.append(l);
            backtrack(digits, i+1, cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}