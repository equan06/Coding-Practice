class Solution:
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False
        chars = {} # mappings of chars from s to chars from t
        mapped = {} # whether a char in t has been mapped to already
        for pair in zip(s, t):
            a = pair[0]
            b = pair[1]
            if a not in chars:
                chars[a] = b
                if b not in mapped:
                    mapped[b] = True
                else:
                    return False # case 2: b mapped to already by some other c
            else:
                if chars[a] != b: # case 1: a maps to two values
                    return False 
        return True
