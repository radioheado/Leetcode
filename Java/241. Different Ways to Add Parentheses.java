class Solution {
    
    private Map<String, List<Integer>> memo = new HashMap();
        
    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        
        List<Integer> res = new ArrayList();
        
        /* base case */
        if (isNumeric(expression)) {
            res.add(Integer.parseInt(expression));
            return res;
        }
        
        for (int i=0; i<expression.length(); i++) {
            if (isOperand(expression.charAt(i))) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                
                for (int l: left) {
                    for (int r: right) {
                        res.add(operands(expression.charAt(i), l, r));
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
    
    private int operands(char op, int x, int y) {
        if (op == '+') {
            return x + y;
        } else if (op == '-') {
            return x - y;
        } else if (op == '*') {
            return x * y;
        }
        return 0;
    }
    
    private boolean isOperand(char op) {
        return op == '+' || op == '-' || op == '*';
    }
}