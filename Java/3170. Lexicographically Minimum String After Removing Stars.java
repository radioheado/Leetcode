class Solution {
    public String clearStars(String s) {
        PriorityQueue<Pair> heap = new PriorityQueue<>(
            (p1, p2) -> {
                if (p1.ch != p2.ch) {
                    return Character.compare(p1.ch, p2.ch);  // lex smallest
                } else {
                    return Integer.compare(p2.index, p1.index);  // negated index for descending
                }
            }
        );

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '*') {
                Pair pair = heap.poll();
                arr[pair.index] = ' ';
                arr[i] = ' ';
            } else {
                heap.add(new Pair(arr[i], i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c: arr) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Helper class to hold char and index
    static class Pair {
        char ch;
        int index;

        Pair(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }
}