class AutocompleteSystem:

    def __init__(self, sentences: List[str], times: List[int]):
        
        # building the initial Trie structure
        self.sents = Trie()
        
        for sentence, time in zip(sentences, times):
            # add sentence and times to Trie
            self.sents.insert(sentence, time)
        
        # use a cache to keep track of the user input until receives a '#'
        # if receives a '#', refresh the cache for future inputs
        self.cache = ''       
    
        
    def input(self, c: str) -> List[str]:
        # the user finishes inputs, return [] and store the input cache 
        # along with a hot degree == 1 that will be incremented using the Trie
        if c == '#':
            self.sents.insert(self.cache, 1)
            
            # refresh the cache and return []
            self.cache = ''
            return []
        
        self.cache += c
        
        # search for cache
        cur = self.sents
        for char in self.cache:
            
            # if the current char is not in the Trie object
            # return []
            if char not in cur.children:
                return []
            
            cur = cur.children[char]
        
        res = []
        # a helper function to recursively check for all existing sentences
        # that share the same prefixs
        def get_top(node: Trie, sent: str):
            if node.issent:
                res.append((-node.hot, sent))

            for key, n in node.children.items():
                get_top(n, sent+key)
        
        # call the helper function with the current Trie() root, and cache
        get_top(cur, self.cache)
        res.sort()
        return [ss for deg, ss in res[:3]]
                
                
class Trie:
    def __init__(self):
        self.children = defaultdict(Trie)
        self.hot = 0
        self.issent = False
        
    def insert(self, sentence, times):
        cur = self
        for s in sentence:
            cur = cur.children[s]
        cur.issent = True
        cur.hot += times
        
        
        
        
        
        
    
        