class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> pairs = new HashMap();
        pairs.put('0', '0');
        pairs.put('1', '1');
        pairs.put('6', '9');
        pairs.put('8', '8');
        pairs.put('9', '6');
        
        int l = 0, r = num.length() - 1;
        while (l <= r) {
            if (!pairs.containsKey(num.charAt(l)) || !pairs.containsKey(num.charAt(r))) {
                return false;
            }
            
            if (pairs.get(num.charAt(l)) != num.charAt(r)) {
                return false;
            }
            
            l++;
            r--;
        }
        
        return true;
    }
}