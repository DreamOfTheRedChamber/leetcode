from collections import defaultdict


class RabinKarp:
    def RabinKarp(self, text, winSize, modBase):
        if winSize == 0:
            return True
        h, t, charSetSize = (26 ** (winSize - 1)) % modBase, 0, 26

        dic = defaultdict(list)

        for i in range(winSize):
            t = (charSetSize * t + ord(text[i])) % modBase

        dic[t].append(0)
        for i in range(len(text) - winSize):
            t = (charSetSize * (t - ord(text[i]) * h) + ord(text[i + winSize])) % modBase
            for j in dic[t]:

                # double check to avoid hash collision
                if text[i + 1:i + winSize + 1] == text[j:j + winSize]:
                    return (True, text[j:j + winSize])

            dic[t].append(i + 1)

        # whether found duplicated string, if found then the value
        return (False, "")

    def longestDupSubstring(self, S):
        beg, end = 0, len(S)
        q = (1 << 31) - 1
        Found = ""
        while beg + 1 < end:
            mid = (beg + end) // 2
            isFound, candidate = self.RabinKarp(S, mid, q)
            if isFound:
                beg, Found = mid, candidate
            else:
                end = mid

        return Found