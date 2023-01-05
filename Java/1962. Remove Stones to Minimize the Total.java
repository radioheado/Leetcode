class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(
                Collections.reverseOrder());
        int total = 0, pile;

        for (int p: piles) {
            q.add(p);
            total += p;
        }

        while (k > 0 && !q.isEmpty()) {
            pile = q.poll();
            k--;
            total -= Math.floor(pile / 2);

            if (pile % 2 == 0) {
                pile /= 2;
            } else {
                pile = pile / 2 + 1;
            }

            if (pile > 1) {
                q.add(pile);
            }
        }

        return total;
    }
}