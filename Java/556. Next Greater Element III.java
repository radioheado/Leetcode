class Solution {
    public int nextGreaterElement(int n) {
        char[] num = ("" + n).toCharArray();
        int i = num.length-2, j = num.length-1;
        
        while (i >= 0 && num[i+1] <= num[i]) {
            i--;
        }
        
        // the number is decreasing, no answer
        if (i < 0)  return -1;
        
        while (j > i && num[j] <= num[i]) {
            j--;
        }
        
        // found the smallest greater digit
        swap(num, i, j);
        reverse(num, i+1);
        
        try {
            return Integer.parseInt(new String(num));
        } catch (Exception e) {
            return -1;
        }
    }
    
    private void swap(char[] n, int i, int j) {
        char temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }
    
    private void reverse(char[] n, int i) {
        int j = n.length-1;
        while (i < j) {
            swap(n, i++, j--);
        }
    }
}