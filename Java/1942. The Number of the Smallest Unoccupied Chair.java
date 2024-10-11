class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        List<int[]> events = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            events.add(new int[] {times[i][0], times[i][1], i});
        }

        Collections.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> seats = new PriorityQueue<>();
        PriorityQueue<int[]> leave_seat = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int next_seat = 0;
        for (int[] event: events) {
            int arrival = event[0], leave = event[1], friend = event[2], seat = next_seat;
            while (!leave_seat.isEmpty() && leave_seat.peek()[0] <= arrival) {
                seats.add(leave_seat.poll()[1]);
            }

            if (seats.isEmpty()) {
                leave_seat.add(new int[] {leave, next_seat++});
            } else {
                seat = seats.poll();
                leave_seat.add(new int[] {leave, seat});
            }

            if (friend == targetFriend) {
                return seat;
            }
        }

        return next_seat;
    }
}