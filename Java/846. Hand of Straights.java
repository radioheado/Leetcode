class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> cards = new HashMap<>();
        for (int h: hand) {
            cards.put(h, cards.getOrDefault(h, 0) + 1);
        }

        for (int h: hand) {
            int start_card = h;
            // Find the start of this chain of sequence
            while (cards.getOrDefault(start_card - 1, 0) != 0) {
                start_card--;
            }

            // Process the sequence starting from start_card
            while (start_card <= h) {
                while (cards.get(start_card) > 0) {
                    for (int next_card = start_card; next_card < start_card + groupSize; next_card++) {
                        if (cards.getOrDefault(next_card, 0) == 0) {
                            return false;
                        }
                        cards.put(next_card, cards.get(next_card) - 1);
                    }
                }
                start_card++;
            }
        }
        return true;
    }
}