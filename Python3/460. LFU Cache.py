class LFUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity

        # key: [value, frequency]
        self.keyValue = {}

        # frequency: {keys that have this frequency}
        self.freqKey = {}
        self.size = 0
        self.minFreq  = 0

    def get(self, key: int) -> int:
        val = -1
        if key in self.keyValue:
            val, old_freq = self.keyValue[key]
            self.keyValue[key][1] += 1

            # update the frequency OrderedDict
            del self.freqKey[old_freq][key]

            # insert the key into the new frequency dict
            new_freq = self.keyValue[key][1]
            self._updateCacheCountDict(key, val, new_freq)

            # update the min frequency
            if self.minFreq == old_freq and len(self.freqKey[old_freq]) == 0:
                self.minFreq = new_freq

        return val

    def put(self, key: int, value: int) -> None:
        if self.capacity <= 0:
            return
            
        if key not in self.keyValue:

            # insert this new key-value pair and update self.minFreq
            if self.size < self.capacity:
                self.size += 1
                
            # need to pop one 
            else:
                rm_key, rm_val = self.freqKey[self.minFreq].popitem(0)
                # remove key in the key dict
                del self.keyValue[rm_key]

            # add new key value pair
            self.keyValue[key] = [value, 1]
            self._updateCacheCountDict(key, value, 1)
            self.minFreq = 1

        else:
            self.keyValue[key][0] = value
            old_freq = self.keyValue[key][1]
            self.keyValue[key][1] += 1
            new_freq = old_freq + 1

            # update the frequency OrderedDict
            del self.freqKey[old_freq][key]
            self._updateCacheCountDict(key, value, new_freq)

            # update the min frequency
            if self.minFreq == old_freq and len(self.freqKey[old_freq]) == 0:
                self.minFreq = new_freq

    def _updateCacheCountDict(self, key, value, new_cnt):
        if new_cnt not in self.freqKey:
            self.freqKey[new_cnt] = OrderedDict()
        self.freqKey[new_cnt][key] = value
        self.freqKey[new_cnt].move_to_end(key)

# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)