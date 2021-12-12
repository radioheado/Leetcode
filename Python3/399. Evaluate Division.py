class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        # mapping between Ai and index
        divisors = {}
        
        def find(cur):
            # initially, every char has itself as divisor and quotient 1
            # if it already exists, get the values
            divisor, quotient = divisors.setdefault(cur, (cur, 1))
            
            # found inconsistency, update all values in chain
            if divisor != cur:
                new_divisor, new_quotient = find(divisor)
                divisors[cur] = (new_divisor, quotient*new_quotient)
            return divisors[cur]
        
        
        def union(dividend, divisor, quotient):
            dividend_root, dividend_quo = find(dividend)
            divisor_root, divisor_quo = find(divisor)
            
            # merge the two groups by attaching the divident group to the divisor's root
            if dividend_root != divisor_root:
                divisors[dividend_root] = (divisor_root, divisor_quo*quotient/dividend_quo)
                
        
        # build the union groups
        for (dividend, divisor), quotient in zip(equations, values):
            union(dividend, divisor, quotient)
            
        results = []
        for dividend, divisor in queries:
            
            # case 1: either one variable did not appear before
            if dividend not in divisors or divisor not in divisors:
                results.append(-1.0)
            
            else:
                dividend_root, dividend_quo = find(dividend)
                divisor_root, divisor_quo = find(divisor)
                
                # case 2: the variables are not in the same dividing chain
                if dividend_root != divisor_root:
                    results.append(-1.0)
                
                # case 3: there is a chain between the variables
                else:
                    results.append(dividend_quo/divisor_quo)
                    
        return results
                
                
                
                
                
                
                
                