class Solution:
    def smallestChair(self, times: List[List[int]], targetFriend: int) -> int:
        times = [[a, l, i] for i, [a, l] in enumerate(times)]
        times.sort()

        # A heap that stores the leave time and the seat it takes
        leave_seat = []
        seats = []
        nxt_seat = 0

        for a, l, i in times:
            seat = nxt_seat

            # The current arrival time should release some of the taken seats
            while leave_seat and leave_seat[0][0] <= a:
                leave, seat = heappop(leave_seat)

                # Push the freed seat to the seats heap
                heappush(seats, seat)

            # Pick the smallest seat from the heap if it's not empty
            if seats:
                seat = heappop(seats)
                heappush(leave_seat, (l, seat))
            else:
                heappush(leave_seat, (l, nxt_seat))
                nxt_seat += 1

            if i == targetFriend:
                return seat

        return nxt_seat
