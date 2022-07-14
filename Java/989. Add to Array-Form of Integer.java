class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int carry = 0, sum, rem;
        List<Integer> ans = new LinkedList<>();
        
        for(int i=num.length-1; i>=0; i--) {
            sum = num[i] + k % 10 + carry;
            carry = sum / 10;
            rem = sum % 10;
            k /= 10;
            ans.add(0, rem);
        }
        
        while (carry > 0 || k > 0) {
            sum = k % 10 + carry;
            carry = sum / 10;
            rem = sum % 10;
            k /= 10;
            ans.add(0, rem);
        }
        
        return ans;
    }
}