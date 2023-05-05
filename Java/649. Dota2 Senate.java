class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> q = new LinkedList();
        int rCount = 0, dCount = 0, rBan = 0, dBan = 0;

        for (char c: senate.toCharArray()) {
            q.add(c);
            if (c == 'R') {
                rCount++;
            } else {
                dCount++;
            }
        }

        while (rCount > 0 && dCount > 0) {
            char cur = q.poll();

            if (cur == 'D') {
                if (dBan > 0) {
                    dBan--;
                    dCount--;
                } else {
                    rBan++;
                    q.offer('D');
                }
            } else {
                if (rBan > 0) {
                    rBan--;
                    rCount--;
                } else {
                    dBan++;
                    q.offer('R');
                }
            }
        }

        return rCount > 0 ? "Radiant" : "Dire";
    }
}