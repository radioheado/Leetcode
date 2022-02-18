class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0, p1 = num1.length()-1, p2 = num2.length()-1;
        
        while(p1 >= 0 || p2 >= 0) {
            int n1 = p1 >= 0 ? num1.charAt(p1)-'0' : 0;
            int n2 = p2 >= 0 ? num2.charAt(p2)-'0' : 0;
            int rem = (n1+n2+carry)%10;
            carry = (n1+n2+carry)/10;
            res.append(rem);
            p1--;
            p2--;
        }
        
        if(carry > 0) {
            res.append(carry);
        }
        
        return res.reverse().toString();
    }
}