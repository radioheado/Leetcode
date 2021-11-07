class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        
        StringBuilder n1 = new StringBuilder(num1);
        StringBuilder n2 = new StringBuilder(num2);
        
        // reverse the num strings
        n1.reverse();
        n2.reverse();
        
        ArrayList<Integer> product = new ArrayList<>();
        product.add(0);
        int zeros = 0;
        
        // result is reversed
        for(int i=0; i<n2.length(); ++i){
            int carry = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            
            for(int j=0; j<n1.length(); ++j){
                // System.out.println("i = "+ i);
                // System.out.println("j = "+ j);
                int p = (n2.charAt(i)-'0')*(n1.charAt(j)-'0')+carry;
                carry = p/10;
                int res = p%10;
                temp.add(res);
            }
            
            if(carry > 0){
                temp.add(carry);
            }
              
            for(int k=0; k<zeros; k++){
                temp.add(0, 0);
            }
            
            product = addStrings(product, temp);
            
            zeros++;
            
        }
            
        StringBuilder answer = new StringBuilder();
        for(int i=product.size()-1; i>=0; i--){
            answer.append(product.get(i));
        }
        
        return answer.toString();
        
    }
    
    private ArrayList<Integer> addStrings(ArrayList<Integer> x, ArrayList<Integer> y) {
        ArrayList<Integer> ans = new ArrayList<>();
        int c = 0;
        int i = 0;
        
        while(i<x.size() || i<y.size()){
            int res;
            if(i >= x.size()){
                int p = y.get(i) + c;
                c = p/10;
                res = p%10;
            }
            else if(i >= y.size()){
                int p = x.get(i) + c;
                c = p/10;
                res = p%10;
            }
            else{
                int p = x.get(i) + y.get(i) + c;
                c = p/10;
                res = p%10;
            }
            
            ans.add(res);
            i++;
        }
        
        if(c > 0){
            ans.add(c);
        }
        
        return ans;
    }
}
        