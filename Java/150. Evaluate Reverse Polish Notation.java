class Solution {
    
    private static final Map<String, BiFunction<Integer, Integer, Integer>> Operands = new HashMap<>();
    
    static{
        Operands.put("+", (a, b) -> a + b);
        Operands.put("-", (a, b) -> a - b);
        Operands.put("/", (a, b) -> a / b);
        Operands.put("*", (a, b) -> a * b);
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String token: tokens){
            if(Operands.containsKey(token)){
                int second = stack.pop();
                int first = stack.pop();
                BiFunction<Integer, Integer, Integer> operand = Operands.get(token);
                int result = operand.apply(first, second);
                stack.push(result);
            }else{
                stack.push(Integer.valueOf(token));
            }
        }
        
        return stack.pop();
    }
}