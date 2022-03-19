class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        last_seen = {c: i for i, c in enumerate(s)}
        stack = deque()
        seen = set()
        
        for i, c in enumerate(s):
            if c not in seen:
                # c not in stack and it's smaller than other letters
                # in the stack who appear in the remaining
                while stack and c < stack[-1] and i < last_seen[stack[-1]]:
                    seen.discard(stack.pop())
                seen.add(c)
                stack.append(c)
        
        return ''.join(stack)