class Solution {
    public int romanToInt(String s) {
        // put all key-value pairs into the HashMap
        HashMap<Character, Integer> value = new HashMap<Character, Integer>();
        value.put('I', 1);
        value.put('V', 5);
        value.put('X', 10);
        value.put('L', 50);
        value.put('C', 100);
        value.put('D', 500);
        value.put('M', 1000);
        
        int ans = 0;
        int i = 0;
        
        while(i < s.length()){
            if(i < s.length()-1 && value.get(s.charAt(i)) < value.get(s.charAt(i+1))){
                ans += value.get(s.charAt(i+1)) - value.get(s.charAt(i));
                i += 2;
            }else{
                ans += value.get(s.charAt(i));
                i++;
            }
        }
        
        return ans;
    }
}


       