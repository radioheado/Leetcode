class Solution:
    def countMentions(self, numberOfUsers: int, events: List[List[str]]) -> List[int]:
        events.sort(key=lambda e: (int(e[1]), 0 if e[0] == "OFFLINE" else 1))
        mentions = [0] * numberOfUsers
        offline = deque()
        total = 0

        for event, timestamp, content in events:
            if event == 'OFFLINE':
                user = int(content)
                time = int(timestamp) + 60
                offline.append((user, time))
            else:
                if content == 'ALL':
                    total += 1
                elif content == 'HERE':
                    while offline and offline[0][1] <= int(timestamp):
                        offline.popleft()
                    for user, _ in offline:
                        mentions[user] -= 1
                    total += 1
                else:
                    ids = content.split(' ')
                    for i in ids:
                        i = int(i[2:])
                        mentions[i] += 1

        return [m + total for m in mentions]
