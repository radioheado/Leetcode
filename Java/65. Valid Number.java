class Solution {
    public boolean isNumber(String s) {
        boolean hasDigit = false, hasEe = false, hasDot = false;
        char c;
        
        for (int i=0; i<s.length(); i++) {
            c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            
            else if (c == '+' || c == '-') {
                // signs can only present at 0-th position
                // and right after 'e' or 'E'
                if (i > 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E') {
                    return false;
                }
            }
            
            else if (c == 'e' || c == 'E') {
                // exponent must be surrounded with digits
                if (hasEe || !hasDigit) {
                    return false;
                }
                hasEe = true;
                hasDigit = false;
            }
            
            else if (c == '.') {
                // can only have one dot and must be before the exponent if applicable
                if (hasDot || hasEe) {
                    return false;
                }
                hasDot = true;
            }
            
            else {
                // all other characters are invalid
                return false;
            }
        }
        return hasDigit;
    }
}