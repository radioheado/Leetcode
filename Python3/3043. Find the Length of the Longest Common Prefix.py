class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.isNum = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, x: int):
        node = self.root
        for n in str(x):
            if n not in node.children:
                node.children[n] = TrieNode()
            node = node.children[n]
        node.isNum = True

    def findCommonPrefix(self, x: int):
        count = 0
        node = self.root
        for n in str(x):
            if n not in node.children:
                break
            count += 1
            node = node.children[n]
        return count


class Solution:
    def longestCommonPrefix(self, arr1: List[int], arr2: List[int]) -> int:
        root = Trie()
        for num in arr1:
            root.insert(num)

        ans = 0
        for num in arr2:
            ans = max(ans, root.findCommonPrefix(num))

        return ans