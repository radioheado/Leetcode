class Solution {
    public boolean isPossible(int[] target) {
        /* edge case */
        if (target.length == 1) {
            return target[0] == 1;
        }
        
        int total_sum = Arrays.stream(target).sum();
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int num: target) {
            heap.add(num);
        }
        
        int largest, rest_sum, rem;
        while (heap.peek() > 1) {
            largest = heap.poll();
            rest_sum = total_sum - largest;
            
            /* case 1: only two numbers in target */
            if (rest_sum == 1) {
                return true;
            }
            
            rem = largest % rest_sum;
            
            /* case 2: impossible to make current largest*/
            if (rem == 0 || rem == largest) {
                return false;   
            }
            
            heap.add(rem);
            total_sum = rest_sum + rem;
        }
        
        return true;
    }
}