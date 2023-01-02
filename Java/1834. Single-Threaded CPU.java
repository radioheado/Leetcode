class Solution {
    public int[] getOrder(int[][] tasks) {
        // heap tuple: (process time, idx)
        PriorityQueue<int[]> enqueuedTasks = new PriorityQueue<int[]>((a, b) -> (a[1] != b[1] ? (a[1] - b[1]) : (a[2] - b[2])));
        int T = tasks.length;
        int[] ans = new int[T];

        // sorted tuple: (enqueue time, process time, idx)
        int[][] sortedTasks = new int[T][3];
        for (int i = 0; i < T; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }

        // sort tasks list byb enqueue time
        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));
        
        long curTime = 0;
        int taskIdx = 0, ansIdx = 0;

        // stop condition: no more tasks in both enqueuedTasks heap and original (sorted) task list
        while (taskIdx < T || !enqueuedTasks.isEmpty()) {
            // increase curTime 
            if (enqueuedTasks.isEmpty() && curTime < sortedTasks[taskIdx][0]) {
                curTime = sortedTasks[taskIdx][0];
            }

            // push all tasks that enqueue before curTime to the heap
            while (taskIdx < T && curTime >= sortedTasks[taskIdx][0]) {
                enqueuedTasks.add(sortedTasks[taskIdx++]);
            }

            int[] task = enqueuedTasks.remove();
            curTime += task[1];
            ans[ansIdx++] = task[2];
        }

        return ans;
    }
}