class Codec:
    def encode(self, strs: List[str]) -> str:
        """Encodes a list of strings to a single string.
        """
        encoded = ''
        for s in strs:
            l = len(s)
            encoded += str(l) + '/:' + s
        return encoded        

    def decode(self, s: str) -> List[str]:
        """Decodes a single string to a list of strings.
        """
        decoded = []
        i = 0

        while i < len(s):
            delim = s.find('/:', i)
            
            # length of the current string
            l = int(s[i: delim])
            cur = s[delim + 2: delim + 2 + l]
            decoded.append(cur)
            i = delim + 2 + l

        return decoded


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))