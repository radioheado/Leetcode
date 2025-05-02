class Solution {
    public String pushDominoes(String dominoes) {
        int N = dominoes.length();
        int[] forces = new int[N];

        int force = 0;
        for (int i = 0; i < N; i++) {
            if (dominoes.charAt(i) == 'R') force = N;
            else if (dominoes.charAt(i) == 'L') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] += force;
        }

        force = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') force = N;
            else if (dominoes.charAt(i) == 'R') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] -= force;
        }

        StringBuilder sb = new StringBuilder();
        for (int f: forces) {
            if (f > 0) sb.append('R');
            else if (f < 0) sb.append('L');
            else sb.append('.');
        }
        return sb.toString();
    }
}