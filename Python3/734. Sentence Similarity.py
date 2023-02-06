class Solution:
    def areSentencesSimilar(self, sentence1: List[str], sentence2: List[str], similarPairs: List[List[str]]) -> bool:
        if len(sentence1) != len(sentence2):
            return False

        pairs = collections.defaultdict(set)

        for s, t in similarPairs:
            pairs[s].add(t)
            pairs[t].add(s)

        for s, t in zip(sentence1, sentence2):
            if s != t:
                if s not in pairs[t]:
                    return False

        return True