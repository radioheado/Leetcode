class Solution:
    def minMovesToSeat(self, seats: List[int], students: List[int]) -> int:
        seats.sort()
        students.sort()
        ans = 0

        for i, s in enumerate(seats):
            ans += abs(s - students[i])

        return ans