class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        transform = collections.defaultdict(list)
        
        # all words have the same length
        L = len(beginWord)
        
        # group up words which have only one different letter
        for w in wordList:
            for i in range(L):
                transform[w[:i] + '*' + w[i+1:]].append(w)
                
        # use a queue to perform BFS
        # and a set to mark visited words
        q = deque([(beginWord, 1)])
        visited = set(beginWord)
        
        while q:
            cur, dis = q.popleft()
            for i in range(L):
                trans = cur[:i] + '*' + cur[i+1:]
                for w in transform[trans]:
                    # goal reached
                    if w == endWord:
                        return dis+1
                    
                    # otherwise, add it to the queue
                    if w not in visited:
                        q.append((w, dis+1))
                        visited.add(w)
                # mark this transformation as null so we won't check again
                transform[trans] = []
                
        return 0
                