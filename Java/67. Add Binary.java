class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        StringBuilder sa = new StringBuilder(a);
        StringBuilder sb = new StringBuilder(b);
        sa.reverse();
        sb.reverse();
        
        while(i<a.length() || i<b.length()){
            int sum;
            
            if(i >= a.length()){
                sum = sb.charAt(i)-'0' + carry;
            }
            else if(i >= b.length()){
                sum = sa.charAt(i)-'0' + carry;
            }
            else{
                sum = sa.charAt(i)-'0' + sb.charAt(i)-'0' + carry;
            }
            
            carry = sum/2;
            int res = sum%2;
            
            ans.add(res);
            i++;
        }
        
        if(carry > 0){
            ans.add(carry);
        }
        
        StringBuilder res = new StringBuilder();
        for(i=0; i<ans.size(); i++){
            res.append(ans.get(i));
        }
        
        return res.reverse().toString();
    }
}