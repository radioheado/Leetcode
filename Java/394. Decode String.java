class Solution {
    public String decodeString(String s) {
        Stack<Integer> times = new Stack<>();
        Stack<StringBuilder> chars = new Stack<>();
        
        // use a int to store the multiplying number
        int number = 0;
        
        // use a string builder to construct the substring
        StringBuilder string = new StringBuilder();
        
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                number = number*10+c-'0';
            }else if(c == '['){
                times.push(number);
                chars.push(string);
                string = new StringBuilder();
                number = 0;
            }else if(c == ']'){
                // pop the string for decoding
                StringBuilder temp = chars.pop();
                
                for(int k=times.pop(); k>0; k--){
                    temp.append(string);
                }
                string = temp;
                
            }else{
                string.append(c);
            }
        }
        
        return string.toString();
    }
}