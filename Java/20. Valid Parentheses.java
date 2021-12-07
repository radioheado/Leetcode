class Solution {
    public boolean isValid(String s) {
        
        if(s.length()%2 == 1){
            return false;
        }
        
        Map<Character, Character> valids = new HashMap<>();
        valids.put(')', '(');
        valids.put('}', '{');
        valids.put(']', '[');
        
        if(valids.containsKey(s.charAt(0))){
            return false;
        }
            
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            
            char p = s.charAt(i);
            
            if(!valids.containsKey(p)){
               stack.push(p);
            }else{
                if(stack.isEmpty() || stack.peek() != valids.get(p)){
                    return false;
                }
                stack.pop();
            }
            
        }
        return stack.isEmpty() ? true : false;
    }
}