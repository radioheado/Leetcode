class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        # save the transform patterns
        transform = defaultdict(list)
        
        # all words share the same length
        W = len(beginWord)
        
        # group the words that differ from only one char
        for w in wordList:
            for i in range(W):
                transform[w[:i] + '*' + w[i+1:]].append(w)
        
        #print(transform)
        ans = []
        visited = set([beginWord])
        q = deque([(beginWord, [beginWord])])
        
        while q:
            level_size = len(q)
            level_visited = set()
            
            for _ in range(level_size):
                word, path = q.popleft()
                if word == endWord:
                    ans.append(path)
                    continue
                
                for i in range(W):
                    trans = word[:i] + '*' + word[i+1:]
                    for w in transform[trans]:
                        if w not in visited:
                            q.append((w, path[:] + [w]))
                            level_visited.add(w)
            
            visited.update(level_visited)
                            
        return ans           