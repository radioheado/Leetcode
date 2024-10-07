class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        Deque<String> words1 = new ArrayDeque<>(Arrays.asList(sentence1.split(" ")));
        Deque<String> words2 = new ArrayDeque<>(Arrays.asList(sentence2.split(" ")));

        while (!words1.isEmpty() && !words2.isEmpty() &&
                words1.peek().equals(words2.peek())) {
                    words1.poll();
                    words2.poll();
                }

        while (!words1.isEmpty() && !words2.isEmpty() &&
                words1.peekLast().equals(words2.peekLast())) {
                    words1.pollLast();
                    words2.pollLast();
                }

        return words1.isEmpty() || words2.isEmpty();
    }
}