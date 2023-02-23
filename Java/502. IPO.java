class Solution {

    class Project implements Comparable<Project> {
        int capital, profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        public int compareTo(Project project) {
            return capital - project.capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int P = profits.length;
        Project[] projects = new Project[P];

        for (int i = 0; i < P; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projects);

        PriorityQueue<Integer> heap = new PriorityQueue(P, Collections.reverseOrder());

        int ptr = 0;
        for (int i = 0; i < k; i++) {
            while (ptr < P && projects[ptr].capital <= w) {
                heap.add(projects[ptr++].profit);
            }

            if (heap.isEmpty()) {
                break;
            }

            w += heap.poll();
        }

        return w;
    }
}