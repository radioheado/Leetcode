class Solution {
    List<String> ans = new ArrayList<>();
    Stack<String> stack = new Stack<>();
    
    public String[] expand(String s) {
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            
            /* add contents inside the {} brackets */
            if (c == '{') {
                i++;
                
                /* add content inside the {} to the stack */
                int[] temp = new int[26];
                while (s.charAt(i) != '}') {
                    
                    /* skip the ',' */
                    if (s.charAt(i) != ',') {
                        temp[s.charAt(i) - 'a'] = 1;
                    } 
                    i++;
                }
                
                /* skip the '}' */
                i++;
                
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<26; j++) {
                    if (temp[j] == 1) {
                        sb.append((char)(j + 'a'));
                    }
                }
                //System.out.println("temp:\t" + sb.toString());
                stack.add(sb.toString());
            }
            else {
                stack.add(Character.toString(s.charAt(i)));
                i++;
            }
            //System.out.println("stack:\t" + stack);
        }
        
        backtrack(0, new StringBuilder());
        String[] result = new String[ans.size()];
        i = 0;
        for (String str: ans) {
            result[i++] = str;
        }
        return result;
    }
    
    private void backtrack(int start, StringBuilder cur) {
        if (cur.length() == stack.size()) {
            //System.out.println(cur.toString());
            ans.add(cur.toString());
            return;
        }
        
        for (int i=start; i<stack.size(); i++) {
            for (char c: stack.get(i).toCharArray()) {
                cur.append(c);
                backtrack(i+1, cur);
                cur.delete(cur.length()-1, cur.length());
            }
        }
    }
}